
package com.GPEA.servlets;

import com.GPEA.dao.DAOFactory;
import com.GPEA.dao.EnseignantDao;
import com.GPEA.dao.MessageDao;
import com.GPEA.forms.GestionMessage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MessageProfToAdmin extends HttpServlet {
     public static final String CONF_DAO_FACTORY = "daofactory";

    
    private MessageDao messageDao;
    private EnseignantDao enseignantDao;
    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
           this.enseignantDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getEnseignantDao();
          this.messageDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getMessageDao();
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       HttpSession session = request.getSession();
       if(session.getAttribute("sessionProf") != null){
           
            GestionMessage gestionMessage = new GestionMessage(messageDao, enseignantDao);
            gestionMessage.envoyerMessageProfToAdmin((Long)session.getAttribute("sessionProf"), request.getParameter("msg"),request.getParameter("objet"));
            response.sendRedirect("home");
           
           
       
       
       
       }else this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        
       
        
        
        
        
        
        
        
    }
}
