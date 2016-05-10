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
        <form method="POST" action="loginServlet">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Iniciar sesion</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nickname</td>
                        <td><input type="text" name="nickname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="login" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">¿Aun no te has registrado?<a href="registro.jsp">Registrate aqui</a></td>
                    </tr>
                    <tr>
                        <td colspan="2"><a href="recuperarContrasena.jsp">Recuperar contraseña</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
        
        <center>
            <form method="post" action="recuperarContrasenaServlet">
                
            </form>
            <b><a style="color:red"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a></b>
            <b><a style="color:green"><%= request.getParameter("registroOK") != null ? request.getParameter("registroOK") : ""%></a></b>
        </center>
        <%--<form method="post" action="registro.jsp">
            <input type="submit" value="Registrarse"/>
        </form>--%>
    </body>
</html>
