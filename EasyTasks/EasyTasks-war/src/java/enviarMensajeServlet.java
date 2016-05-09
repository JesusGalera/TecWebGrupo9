/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Entrada;
import entity.Proyecto;
import entity.Usuario;
import facade.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
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
@WebServlet(name = "enviarMensajeServlet",urlPatterns = {"/enviarMensajeServlet"})
public class enviarMensajeServlet extends HttpServlet {
    @EJB
    private EntradaFacade entradaFacade;
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
        String idProyecto = request.getParameter("idProyecto");
        Proyecto proyecto = this.proyectoFacade.find(new BigDecimal(idProyecto));
        Usuario usuario = (Usuario) sesion.getAttribute("Usuario");
        
        Entrada entrada = new Entrada();
        entrada.setProyectoId(proyecto);
        entrada.setUsuarioId(usuario);
        String texto = (String) request.getParameter("textoChat");
        entrada.setTexto(texto);
        Date fecha = Date.from(Instant.now());
        entrada.setFechacreacion(fecha);
        BigDecimal clave = this.entradaFacade.findMaxEntradaId();
       
        entrada.setId(clave.add(new BigDecimal("1")));
        
        Collection entradaCollection = proyecto.getEntradaCollection();
        entradaCollection.add(entrada);
        
        proyecto.setEntradaCollection(entradaCollection);
        
        this.entradaFacade.create(entrada);
        this.proyectoFacade.edit(proyecto);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/verProyectoServlet?idProyecto="+idProyecto);
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
