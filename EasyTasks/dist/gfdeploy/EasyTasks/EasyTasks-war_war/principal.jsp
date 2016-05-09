<%-- 
    Document   : principal
    Created on : 08-may-2016, 16:21:51
    Author     : Fabian
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Proyecto> listaProyectos = (List<Proyecto>)request.getAttribute("listaProyectos");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis proyectos</title>
    </head>
    <body>
        <h1>Mis proyectos</h1>
        <div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                </tr>
                <%
                    for(Proyecto proyecto : listaProyectos){
                %>
                <tr>
                    <td><a href="verProyectoServlet?idProyecto=<%= proyecto.getId() %>"><%= proyecto.getId() %></a></td>
                    <td><%= proyecto.getNombre() %></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
