<%-- 
    Document   : crearTarea
    Created on : 07-may-2016, 13:15:26
    Author     : winnielean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String idProyecto = request.getParameter("idProyecto");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear tarea</title>
    </head>
        <body>
       <form method="post" action="crearTareaServlet?idProyecto=<%= idProyecto%>">
            <input type="text" name="textoTareaNueva" value="" /><br/>
            <select name="estadoTarea">
                <option value="toDo" selected>To Do</option>
                <option value="inProg">In Progress</option>
                <option value="done">Done</option>
            </select>
            <input type="submit" value="Guardar" />
            <%--<input type="submit" value="Guardar" /> <a href="verProyectoServlet?idProyecto=<%=idProyecto%>"></a>
            <%--<a href="crearTareaServlet?idProyecto=<%=idProyecto%>">Guardar</a>--%>
       </form>
            <a href="verProyectoAdmin.jsp?idProyecto=<%=idProyecto%>"> Volver al proyecto </a>
    </body>
</html>
