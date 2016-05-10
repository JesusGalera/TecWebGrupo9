/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Usuario;
import facade.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author winnielean
 */
@WebServlet(name="registrarServlet",urlPatterns = {"/registrarServlet"})
public class registrarServlet extends HttpServlet {
    @EJB
    private UsuarioFacade usuarioFacade;

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
        Usuario usuario = new Usuario ();
        String str;
        
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String password = request.getParameter("password");
        Boolean camposOK = false;
        if (nickname!=null && !nickname.equals("")){
            if (email!=null && !email.equals("")){
                if (password!=null && !password.equals("")){
                    camposOK = true;
                }
            }
        }
        try{
            Usuario existe = this.usuarioFacade.findByNicknameOrEmail(nickname,email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/registro.jsp?msg=El nickname o el email ya existen en el sistema");
            dispatcher.forward(request, response);
        } catch (Exception e){
            if(camposOK){
                usuario.setNickname(nickname);
                usuario.setEmail(email);
                if(password.length()<6){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/registro.jsp?msg=La contraseña debe contener al menos 6 carácteres");
                    dispatcher.forward(request, response);
                } else {
                usuario.setContrasena(password);
                usuario.setNickname(nickname);
                usuario.setEmail(email);
                usuario.setNombre(nombre);
                usuario.setApellidos(apellidos);
                BigDecimal clave = this.usuarioFacade.findMaxUsuarioId().add(new BigDecimal("1"));
                usuario.setId(clave);
                this.usuarioFacade.create(usuario);
        
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/login.jsp?registroOK=El registro se ha realizado con exito.");
                rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/registro.jsp?msg=Los campos Usuario, Email y Contraseña deben estar completos.");
                rd.forward(request, response);
            }
}
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
