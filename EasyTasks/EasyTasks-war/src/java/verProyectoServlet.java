/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Entrada;
import entity.Proyecto;
import entity.Tarea;
import entity.Usuario;

import facade.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesus
 */
@WebServlet(name = "verProyectoServlet", urlPatterns = {"/verProyectoServlet"})
public class verProyectoServlet extends HttpServlet {
@EJB
private EntradaFacade entradaFacade;
@EJB
private TareaFacade tareaFacade;
@EJB
private UsuarioFacade usuarioFacade;
@EJB
private ProyectoFacade proyectoFacade;



private List<Tarea> toDo = new ArrayList<Tarea>(), inProg =  new ArrayList<Tarea>(), done = new ArrayList<Tarea>();
private List<Entrada> chat = new ArrayList<Entrada>();
private Usuario usuario;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    private void ClasificarListas(String idProyecto){
        Proyecto proyecto = this.proyectoFacade.find(new BigDecimal(idProyecto));
        toDo.clear();
        inProg.clear();
        done.clear();
        for(Tarea t : proyecto.getTareaCollection()){
            if(t.getEstado().equalsIgnoreCase("ToDo")){
                toDo.add(t);
            }else if (t.getEstado().equalsIgnoreCase("InProg")){
                inProg.add(t);
            } else if (t.getEstado().equalsIgnoreCase("Done")){
                done.add(t);
            }
            
        }
    }
    private void GenerarChat(Proyecto proyecto){
        chat.clear();
        for(Entrada e : entradaFacade.findByProyectoIdOrderByFecha(proyecto)){
                chat.add(e);
        }
        System.out.println(Arrays.toString(entradaFacade.findAll().toArray()));
    }
    
    public void init (ServletConfig config) throws ServletException{
        super.init(config);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String idProyecto = request.getParameter("idProyecto");
        Proyecto proyecto = this.proyectoFacade.find(new BigDecimal(idProyecto));
        usuario = (Usuario) sesion.getAttribute("Usuario");
        sesion.setAttribute("proyectoActual", proyecto);

        this.ClasificarListas(idProyecto);
        request.setAttribute("ToDo", toDo);
        request.setAttribute("InProg", inProg);
        request.setAttribute("Done", done);
        this.GenerarChat(proyecto);
        request.setAttribute("Chat", chat);
        request.setAttribute("Proyecto",proyecto);
        List<Usuario> noUsuarios = usuarioFacade.findAll();
        for(Usuario u : proyecto.getUsuarioCollection()){
            noUsuarios.remove(u);
        }
        request.setAttribute("noUsuarios", noUsuarios);
        RequestDispatcher rd;
        if(proyecto.getUsuarioId().equals(usuario)){
         rd = this.getServletContext().getRequestDispatcher("/verProyectoAdmin.jsp");
        }else{
         rd = this.getServletContext().getRequestDispatcher("/verProyecto.jsp");
        }
        
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

}
