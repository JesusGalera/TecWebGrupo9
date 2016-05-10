<%-- 
    Document   : NuevoProyecto
    Created on : 09-may-2016, 23:59:24
    Author     : jesus
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Usuario> usuarios =(List<Usuario>) request.getAttribute("usuarios");%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear un nuevo Proyecto</title>
    </head>
    <body>
        <h1>¡Comencemos con un nuevo proyecto!</h1>
        <form method="post" action="GuardarProyectoServlet">
            Nombre: <input type="text" name="nombre" value="" /><br/>
            Descripcion: <input type="text" name="descripcion" value="" /><br/>
            <% for(Usuario u : usuarios){
            %> <input type="checkbox" name="usuarioSelecionado" value="<%=u.getNickname()%>"> <%=u.getNickname()%> <br/> <%
            }%>
            <input type="submit" value="Crear" />
            <%--<input type="submit" value="Guardar" /> <a href="verProyectoServlet?idProyecto=<%=idProyecto%>"></a>
            <%--<a href="crearTareaServlet?idProyecto=<%=idProyecto%>">Guardar</a>--%>
       </form>
    </body>
</html>
