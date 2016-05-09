<%-- 
    Document   : login
    Created on : 04-may-2016, 17:05:16
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="post" action="loginServlet">
        Nickname:<input type="text" name="nickname" /><br/>
        Password:<input type="text" name="password" /><br/>
        <input type="submit" value="login" />
        </form>
        <b><a style="color:red"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a></b>
    </body>
</html>
