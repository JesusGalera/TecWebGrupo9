<%-- 
    Document   : UsuarioRegistrar
    Created on : 07-may-2016, 0:14:35
    Author     : winnielean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
    </head>
    <body>
        <form method="POST" action="registrarServlet">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Introduzca sus datos</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nickname</td>
                        <td><input type="text" name="nickname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="apellidos" value="" /></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Registrar" /></td>
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
