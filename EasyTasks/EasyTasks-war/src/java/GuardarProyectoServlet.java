/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Entrada;
import entity.Proyecto;
import entity.Tarea;
import entity.Usuario;
import facade.ProyectoFacade;
import facade.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name="GuardarProyectoServlet",urlPatterns = {"/GuardarProyectoServlet"})
public class GuardarProyectoServlet extends HttpServlet {
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private ProyectoFacade proyectoFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Proyecto proyecto = new Proyecto();
        Usuario usuario = (Usuario) sesion.getAttribute("Usuario");
        String nombre =  request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String [] nickNames = (String []) request.getParameterValues("usuarioSelecionado");
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario);
        
        for(String nickname : nickNames){
            usuarios.add(usuarioFacade.findByNickname(nickname));
        }
        
        proyecto.setNombre(nombre);
        proyecto.setDescripcion(descripcion);
        proyecto.setUsuarioId(usuario);
        proyecto.setUsuarioCollection(usuarios);
        proyecto.setEntradaCollection(new ArrayList<Entrada>());
        proyecto.setFechacreacion(Date.from(Instant.now()));
        proyecto.setTareaCollection(new ArrayList<Tarea>());
        
        BigDecimal clave = this.proyectoFacade.findMaxProyectoId();
        
        proyecto.setId(clave.add(new BigDecimal("1")));
        
        this.proyectoFacade.create(proyecto);
       
        for(Usuario u : usuarios){
        Collection proyectoCollection = u.getProyectoCollection();
        proyectoCollection.add(proyecto);
        u.setProyectoCollection(proyectoCollection);
        this.usuarioFacade.edit(u);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("principalServlet");               
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
