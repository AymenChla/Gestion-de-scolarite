
package com.GPEA.servlets;

import com.GPEA.dao.CompteDao;
import com.GPEA.dao.DAOFactory;
import com.GPEA.dao.EnseignantDao;
import com.GPEA.dao.EtudiantDao;
import com.GPEA.dao.MessageDao;
import com.GPEA.forms.GestionCompte;
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
     
    private CompteDao compteDao;
    private EtudiantDao etudiantDao;
    private MessageDao messageDao;
    private EnseignantDao enseignantDao;
    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        
          this.etudiantDao =( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getEtudiantDao();
          this.enseignantDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getEnseignantDao();
          this.messageDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getMessageDao();
          this.compteDao =( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getCompteDao();
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
           Long idCompteProf =null;
            GestionMessage gestionMessage = new GestionMessage(messageDao, enseignantDao);
            GestionCompte gestionCompte = new GestionCompte(compteDao);
            idCompteProf = (Long)gestionCompte.getIdCompteEnseignant((Long)session.getAttribute("sessionProf"));
            gestionMessage.envoyerMessageProfToAdmin(idCompteProf, request.getParameter("msg"),request.getParameter("objet"));
            response.sendRedirect("home");
           
           
       
       
       
       }else{
       
       if(session.getAttribute("sessionEtudiant") != null){
           Long idCompteEtud = null;
             GestionMessage gestionMessage = new GestionMessage(messageDao,etudiantDao);
              GestionCompte gestionCompte = new GestionCompte(compteDao);
            idCompteEtud = (Long)gestionCompte.getIdCompteEtudiant((Long)session.getAttribute("sessionEtudiant"));
            gestionMessage.envoyerMessageProfToAdmin(idCompteEtud, request.getParameter("msg"),request.getParameter("objet"));
            response.sendRedirect("home");
       
       
       }else this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
       } 
       
        
        
        
        
        
        
        
    }
}
