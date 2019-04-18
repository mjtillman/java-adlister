import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//   Ensure that users can only visit the /profile page if they are logged in.
//        System.out.println("In ViewProfileServlet:");
//        System.out.println("Logged in: " + request.getSession().getAttribute("loggedIn"));
//
//        System.out.println(request.getSession().getAttribute("loggedIn"));

        boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");

        if (loggedIn) {
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
//
//
//        System.out.println(request.getSession().getAttribute("user"));


    }
}
