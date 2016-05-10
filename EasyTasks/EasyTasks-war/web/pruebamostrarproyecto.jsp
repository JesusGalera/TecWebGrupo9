<%-- 
    Document   : pruebamostrarproyecto
    Created on : 09-may-2016, 14:07:55
    Author     : Victor
--%>

<%@page import="entity.Usuario"%>
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
                Tarea toDoTarea = new Tarea();
                Tarea inProgTarea = new Tarea();
                Tarea doneTarea = new Tarea();
                while(iteratorToDo.hasNext() || iteratorInProg.hasNext() || iteratorDone.hasNext()){
                    toDoString = "";
                    inProgString = "";
                    doneString = "";
                    if(iteratorToDo.hasNext()){
                        toDoTarea = iteratorToDo.next();
                        toDoString = toDoTarea.getDescripcion();
                    }
                    if(iteratorInProg.hasNext()){
                        inProgTarea = iteratorInProg.next();
                        inProgString = inProgTarea.getDescripcion();
                    }
                    if(iteratorDone.hasNext()){
                        doneTarea = iteratorDone.next();
                        doneString = doneTarea.getDescripcion();
                    }
            %>
            <tr>
                <td><a href="editarTareaServlet?idTarea=<%=toDoTarea.getId()%>"><%= toDoString %></a></td>
                <td><a href="editarTareaServlet?idTarea=<%=inProgTarea.getId()%>"><%= inProgString %></a></td>
                <td><a href="editarTareaServlet?idTarea=<%=doneTarea.getId()%>"><%= doneString %></a></td>
            </tr>
            <%
                }
            %>
			</table>
            <br/>
            <a href="crearTarea.jsp?idProyecto=<%=proyecto.getId()%>">Crear Nueva Tarea</a>
            <br/>
            <a href="principalServlet">Volver al Menú Principal</a>
            
            
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
