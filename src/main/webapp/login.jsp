<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h3>Login</h3>

    <form method="POST" action="login.jsp">
        <label for="username">Username</label>
        <input id="username" name="username" type="text" />
        <br />

        <label for="password">Password</label>
        <input id="password" name="password" type="password" />
        <br />

        <input type="submit" value="Submit" />
    </form>
    <%
        if (username != null && password != null) {
            if (username.equals("username") && password.equals("password")) {
                System.out.println("Hello World");
                response.sendRedirect("http://localhost:8080/profile.jsp");
            } else {
                response.sendRedirect("http://localhost:8080/login.jsp");
            }
        }
    %>

</body>
</html>