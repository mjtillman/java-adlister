import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello World");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            //        Cookie loginCookie = new Cookie("login", null);

//   In your LoginServlet, when a user successfully logs in, set a key named "user" in the session.
            request.getSession().setAttribute("user", username);
            request.getSession().setAttribute("loggedIn", true);
            System.out.println(request.getSession().getAttribute("user"));
            System.out.println("Logged in: " + request.getSession().getAttribute("loggedIn"));
            response.sendRedirect("/profile");
        } else {
            request.getSession().setAttribute("loggedIn", false);
            System.out.println("Logged in: " + request.getSession().getAttribute("loggedIn"));
            System.out.println("Do not pass Go, do not collect $200");
            response.sendRedirect("/login");
        }
    }
}
