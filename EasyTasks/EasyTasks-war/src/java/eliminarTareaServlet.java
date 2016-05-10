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
import java.util.Collection;
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
 * @author winnielean
 */
@WebServlet(name="eliminarTareaServlet",urlPatterns = {"/eliminarTareaServlet"})
public class eliminarTareaServlet extends HttpServlet {
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
        HttpSession sesion = request.getSession();
        Tarea tarea;
        String idTareaString = request.getParameter("idTarea");
        //System.out.println(idTareaString);
        BigDecimal idTarea = new BigDecimal(idTareaString);
        tarea = this.tareaFacade.find(idTarea);
        Proyecto proyecto = (Proyecto)sesion.getAttribute("proyectoActual");

        this.tareaFacade.remove(tarea);
        Collection collectionTarea = proyecto.getTareaCollection();
        collectionTarea.remove(tarea);
        proyecto.setTareaCollection(collectionTarea);
        this.proyectoFacade.edit(proyecto);
        response.sendRedirect("verProyectoServlet?idProyecto="+proyecto.getId());
        //RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/verProyectoServlet?idProyecto="+proyecto.getId());
        //rd.forward(request, response);
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
