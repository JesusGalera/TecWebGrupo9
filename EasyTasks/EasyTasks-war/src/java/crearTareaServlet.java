
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Proyecto;
import entity.Tarea;
import facade.ProyectoFacade;
import facade.TareaFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author winnielean
 */
@WebServlet(name="crearTareaServlet",urlPatterns = {"/crearTareaServlet"})
public class crearTareaServlet extends HttpServlet {
    @EJB
    private TareaFacade tareaFacade;
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
        Tarea tarea = new Tarea ();
        HttpSession session = request.getSession();
        BigDecimal idProyecto = new BigDecimal(request.getParameter("idProyecto"));
        //System.out.println(this.proyectoFacade.find(new BigDecimal(idP)).toString());
        Proyecto proyecto = this.proyectoFacade.find(idProyecto);
       
        tarea.setProyectoId(proyecto);
        
        String s = (String)request.getParameter("textoTareaNueva");
        tarea.setDescripcion(s);
        s = (String)request.getParameter("estadoTarea");
        tarea.setEstado(s);
        BigDecimal clave;
        try{
            clave = this.tareaFacade.findMaxTareaId();
            tarea.setId(clave.add(new BigDecimal("1")));
        } catch (Exception e){
            clave = new BigDecimal("1");
            tarea.setId(clave);
        }
        this.tareaFacade.create(tarea);
        Collection tareaCollection = proyecto.getTareaCollection();
        tareaCollection.add(tarea);
        proyecto.setTareaCollection(tareaCollection);
        this.proyectoFacade.edit(proyecto);
        //request.setAttribute("idProyecto", idProyecto);
        response.sendRedirect("verProyectoServlet?idProyecto="+idProyecto);
        //RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/verProyectoServlet?idProyecto="+idProyecto);
        //rd.forward(request, response);
        //request.setAttribute("idProyecto", idProyecto);
        //response.sendRedirect("verProyectoServlet?idProyecto="+idProyecto);
        //rd = request.getRequestDispatcher("verProyectoServlet");
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
