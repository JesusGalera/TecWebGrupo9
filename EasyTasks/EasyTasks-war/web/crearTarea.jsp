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
       <form name= "tareanueva" method="post" action="crearTareaServlet">
        <div>
            <input type="hidden" name="idProyecto" value="<%= idProyecto%>" />
            <input type="text" name="textoTareaNueva" value="" /><br/>
            <select name="estadoTarea">
                <option value="todo">To Do</option>
                <option value="inprogress">In Progress</option>
                <option value="done">Done</option>
            </select>
            <a href="crearTareaServlet">Guardar</a>
        </div>
       </form>
            <a href="verProyectoServlet"> Volver al proyecto </a>
    </body>
</html>
