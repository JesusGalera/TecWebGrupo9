<%-- 
    Document   : crearTarea
    Created on : 07-may-2016, 13:15:26
    Author     : winnielean
--%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Tarea"%>

<!DOCTYPE html>
<%  
    String idTarea = (String)request.getAttribute("idTarea");
    String texto = (String)request.getAttribute("texto");
    String estado = (String)request.getAttribute("estadoActual");
    
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar tarea</title>
    </head>
    <body>
        <form method="post" action="guardarTareaServlet?idTarea=<%=idTarea%>">
        <input type="text" name="textoEditadoTarea" value="<%=texto%>"/><br/>
        <select name="estadoTarea">
            <option value="todo">To Do</option>
            <option value="inprog">In Progress</option>
            <option value="done">Done</option>
            <input type="submit" value="Guardar"/>
        </select>
            <td><a href="eliminarTareaServlet?idTarea=<%=idTarea%>">Eliminar</a></td>
            
        </form>
    </body>
</html>