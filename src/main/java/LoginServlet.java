import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//<%
//    if (request.getMethod().equalsIgnoreCase("post")) {
//    String username = request.getParameter("username");
//    String password = request.getParameter("password");
//    if (username.equals("admin") && password.equals("password")) {
//    response.sendRedirect("/profile");
//    }
//    }
//    %>

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    System.out.println("Hello Login Java File: GET");
    request.getRequestDispatcher("/login.jsp").forward(request, response);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

        System.out.println("Hello Login Java File: POST");

    if (request.getMethod().equalsIgnoreCase("post")) {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      if (username.equals("admin") && password.equals("password")) {
        System.out.println("Congratulations for logging in");
        response.sendRedirect("/profile");
      }
    }
  }
}