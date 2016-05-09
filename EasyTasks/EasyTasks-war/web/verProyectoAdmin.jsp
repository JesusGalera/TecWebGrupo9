<%-- 
    Document   : verProyectoAdmin
    Created on : 04-may-2016, 18:29:29
    Author     : jesus
--%>


<%@page import="entity.Entrada"%>
<%@page import="entity.Tarea"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Proyecto proyecto =(Proyecto) request.getAttribute("Proyecto");
   List<Tarea> toDo= new ArrayList<Tarea>(), inProg= new ArrayList<Tarea>(), done = new ArrayList<Tarea>();
   toDo =(ArrayList<Tarea>) request.getAttribute("ToDo");
   inProg =(ArrayList<Tarea>) request.getAttribute("InProg");
   done =(ArrayList<Tarea>) request.getAttribute("Done");
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
        
        <table border="1">
            <caption>Tareas</caption>
            <tr>
                <th>To do</th>
                <th>In progress</th>
                <th>Done</th>
            </tr>
            <% for(int i=0;i<tamTabla;i++){
                if(i<toDo.size()&&i<inProg.size()&&i<done.size()){
                     %>
                    <tr>
                        <td><%=toDo.get(i).getDescripcion() %></td>
                        <td><%=inProg.get(i).getDescripcion() %></td>
                        <td><%= done.get(i).getDescripcion() %></td>
                    </tr>
                    <%
                }else if(i>=toDo.size()&&i<inProg.size()&&i<done.size()){
                    
                    %>
                    <tr>
                        <td></td>
                        <td><%=inProg.get(i).getDescripcion() %></td>
                        <td><%= done.get(i).getDescripcion() %></td>
                    </tr>
                    <%
                }else if(i<toDo.size()&&i>=inProg.size()&&i<done.size()){
                    %>
                    <tr>
                        <td><%=toDo.get(i).getDescripcion() %></td>
                        <td></td>
                        <td><%= done.get(i).getDescripcion() %></td>
                    </tr>
                    <%
                }else if(i<toDo.size()&&i<inProg.size()&&i>=done.size()){
                    %>
                    <tr>
                        <td><%=toDo.get(i).getDescripcion() %></td>
                        <td><%= inProg.get(i).getDescripcion() %></td>
                        <td></td>
                    </tr>
                    <%
                }else if(i<toDo.size()&&i>=inProg.size()&&i>=done.size()){ 
                    %>
                    <tr>
                        <td><%=toDo.get(i).getDescripcion() %></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <%
                }else if(i>=toDo.size()&&i<inProg.size()&&i>=done.size()){ 
                    %>
                    <tr>
                        <td></td>
                        <td><%=inProg.get(i).getDescripcion() %></td>
                        <td></td>
                    </tr>
                    <%
                }else if(i>=toDo.size()&&i>=inProg.size()&&i<done.size()){ 
                    %>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><%=done.get(i).getDescripcion() %></td>
                    </tr>
                    <%
                }          

            }%>
        </table>
        <br/>
       
        <%--<a href="editarTareaServlet?idTarea=<%=proyecto%>"></a> --%>
        <a href="crearTarea.jsp?idProyecto=<%=proyecto.getId()%>">Crear Nueva Tarea</a>
    </body>
</html>

