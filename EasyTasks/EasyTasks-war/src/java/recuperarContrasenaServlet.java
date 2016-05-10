/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Usuario;
import facade.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;
import javax.ejb.EJB;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Victor
 */
@WebServlet(name="recuperarContrasenaServlet",urlPatterns = {"/recuperarContrasenaServlet"})
public class recuperarContrasenaServlet extends HttpServlet {
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
        
        final String username = "tecwebgrupo9@gmail.com";
	final String password = "tecweb2016";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,
		new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
		});
        String toEmail = "";
        Usuario usuario = new Usuario();
        try {
                toEmail = request.getParameter("email");
                System.out.println(toEmail);
                usuario = this.usuarioFacade.findByEmail(toEmail);
        } catch (Exception e){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/recuperarContrasena.jsp?msg=El email introducido no se encuentra en nuestra base de datos.");
                dispatcher.forward(request, response);
        }
	try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("tecwebgrupo9@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(toEmail));
		message.setSubject("Recuperar contraseña");
		message.setText("Tu contraseña es: " + usuario.getContrasena());

		Transport.send(message);

		System.out.println("Mensaje de recuperación de contraseña enviado a " + toEmail);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/login.jsp?registroOK=Mensaje enviado correctamente.");
                rd.forward(request, response);
	} catch (MessagingException e) {
		throw new RuntimeException(e);
	} catch (NoResultException e){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/recuperarContrasena.jsp?msg=El email introducido no se encuentra en nuestra base de datos.");
                dispatcher.forward(request, response);
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
