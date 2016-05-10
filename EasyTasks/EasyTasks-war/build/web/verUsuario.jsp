<%-- 
    Document   : verUsuario
    Created on : 10-may-2016, 2:11:41
    Author     : winnielean
--%>

<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario = (Usuario)request.getAttribute("usuario");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil usuario</title>
    </head>
    <body>
        <h1>Mi perfil</h1>
        
        <b>Nickname: <%=usuario.getNickname()%> </b><br/>
        <b>Email: <%=usuario.getEmail() %></b><br/>
        <b>Nombre: <%=usuario.getNombre() %></b><br/>
        <b>Apellidos: <%=usuario.getApellidos() %> </b>
        <br/>
        <a href="principalServlet">Volver al Menú Principal</a>
    </body>
</html>
