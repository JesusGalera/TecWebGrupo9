<%-- 
    Document   : verProyecto
    Created on : 08-may-2016, 17:38:47
    Author     : Victor
--%>

<%@page import="entity.Entrada"%>
<%@page import="entity.Tarea"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Proyecto proyecto =(Proyecto) request.getAttribute("Proyecto");
   List<Tarea> toDo, inProg, done;
   toDo =(List<Tarea>) request.getAttribute("ToDo");
   inProg =(List<Tarea>) request.getAttribute("InProg");
   done =(List<Tarea>) request.getAttribute("Done");
  // List<Entrada> Chat = (List<Entrada>) request.getAttribute("Chat");
   int tamTabla = Math.max(done.size(), Math.max(toDo.size(), inProg.size()));
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=proyecto.getNombre()%></title>
    </head>
    <body>
        
        <h1><%=proyecto.getNombre()%></h1>
        
        <table>
            <tr>
                <th>To do</th>
                <th>In Progress</th>
                <th>Done</th>
            </tr>
            <%
                for(int i=0;i<tamTabla;i++){
                    if(i<toDo.size()){
            %>
            <tr>
                <
                
                
                
                
            </tr>
        </table>
        <br/>
        <input type="text" maxlength="20" name="idTarea" value="ID">
        <a href="EditarTareaServlet?idTarea=<%=proyecto%>"></a>
        <input type="submit" name="editar" value="Button 1" /><br/> 
        <input type="submit" name="nueva" value="Nueva Tarea" />
        
    </body>
</html>
