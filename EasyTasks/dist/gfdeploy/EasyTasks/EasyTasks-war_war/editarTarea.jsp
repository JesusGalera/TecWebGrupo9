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
    BigDecimal tId = (BigDecimal)request.getAttribute("id");
    String texto = (String)request.getAttribute("texto");
    String estado = (String)request.getAttribute("actual");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar tarea</title>
    </head>
    <body>
        <form name= "tareamodificar" method="post" action="guardarTareaServlet">
        <input type="text" name="textoEditadoTarea" value="<%=texto%>"/><br/>
        <select name="estadoTarea" value="<%=estado%>">
            <option value="todo">To Do</option>
            <option value="inprog">In Progress</option>
            <option value="done">Done</option>
            <td><a href="guardarTareaServletid?id=<%=tId%>">Guardar</a></td>
        </select>
            <td><a href="eliminarTareaServlet?id=<%=tId%>">Eliminar</a></td>
            
        </form>
    </body>
</html>
