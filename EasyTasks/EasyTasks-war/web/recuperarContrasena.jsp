<%-- 
    Document   : recuperarContrasena
    Created on : 10-may-2016, 0:23:48
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de recuperación de contraseña</title>
    </head>
    <body>
        <form method="POST" action="recuperarContrasenaServlet">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Recuperar contraseña</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="recuperar" /></td>
                    </tr>
                    <tr>
                        <b><a style="color:red"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a></b>
                        <td colspan="2">¿Ya estas registrado? <a href="login.jsp">Login</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>
