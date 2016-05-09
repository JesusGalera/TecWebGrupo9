<%-- 
    Document   : pruebamostrarproyecto
    Created on : 09-may-2016, 14:07:55
    Author     : Victor
--%>

<%@page import="entity.Entrada"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.Tarea"%>
<%@page import="entity.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Proyecto proyecto =(Proyecto) request.getAttribute("Proyecto");
   List<Tarea> toDo, inProg, done;
   toDo = (ArrayList<Tarea>) request.getAttribute("ToDo");
   Iterator<Tarea> iteratorToDo = toDo.iterator();
   inProg = (ArrayList<Tarea>) request.getAttribute("InProg");
   Iterator<Tarea> iteratorInProg = inProg.iterator();
   done = (ArrayList<Tarea>) request.getAttribute("Done");
   Iterator<Tarea> iteratorDone = done.iterator();
   List<Entrada> Chat = (List<Entrada>) request.getAttribute("Chat");
   String mensaje="";
%>
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
            <% 
                String toDoString, inProgString, doneString;
                while(iteratorToDo.hasNext() || iteratorInProg.hasNext() || iteratorDone.hasNext()){
                    toDoString = "";
                    inProgString = "";
                    doneString = "";
                    if(iteratorToDo.hasNext()){
                        toDoString = iteratorToDo.next().getDescripcion();
                    }
                    if(iteratorInProg.hasNext()){
                        inProgString = iteratorInProg.next().getDescripcion();
                    }
                    if(iteratorDone.hasNext()){
                        doneString = iteratorDone.next().getDescripcion();
                    }
            %>
            <tr>
                <td><%= toDoString %></td>
                <td><%= inProgString %></td>
                <td><%= doneString %></td>
            </tr>
            <%
                }
            %>
            
            <a href="crearTarea.jsp?idProyecto=<%=proyecto.getId()%>">Crear Nueva Tarea</a>
            
            
            <table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#000000">
                <tr>
                    </br>
                    </br>
                    <th>Chat</th>
                </tr>
                <% for(Entrada e : Chat){
                    %>
                    <tr>
                        <td>
                            <h5><%=e.getUsuarioId().getNickname()%> </h5>
                            <%=e.getTexto()%></br>
                        </td>
                    </tr>
                <%
                }
                    %>
            </table>
            
            <form method="post" action="enviarMensajeServlet?idProyecto=<%= proyecto.getId()%>">
            <input type="text" name="textoChat" value="" /><br/>
            <input type="submit" value="Enviar" />
            <%--<input type="submit" value="Guardar" /> <a href="verProyectoServlet?idProyecto=<%=idProyecto%>"></a>
            <%--<a href="crearTareaServlet?idProyecto=<%=idProyecto%>">Guardar</a>--%>
       </form>
           
                
    </body>
</html>
