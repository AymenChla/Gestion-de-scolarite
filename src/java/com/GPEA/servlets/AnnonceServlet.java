
package com.GPEA.servlets;

import com.GPEA.beans.Annonce;
import com.GPEA.dao.AnnonceDao;
import com.GPEA.dao.DAOFactory;
import com.GPEA.forms.GestionAnnonces;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AnnonceServlet extends HttpServlet {


    public static final String CONF_DAO_FACTORY = "daofactory";

    private  AnnonceDao annonceDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
       this.annonceDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getAnnonceDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
            
            HttpSession session = request.getSession();
             if(session.getAttribute("sessionProf") != null)
            {
                int page = 1;
                int maxAnnonces=5;
                int nbrAnnonces=0;
                int maxPage = 0;
                
                if(request.getParameter("page") != null)
                    page = Integer.parseInt(request.getParameter("page"));
                
                int offset = (page-1) * maxAnnonces;
                GestionAnnonces gestionAnnonces = new GestionAnnonces(annonceDao);
                ArrayList<Annonce> annonces = gestionAnnonces.getAnnonces(offset,maxAnnonces);
                nbrAnnonces = gestionAnnonces.getNbrAnnoncesEnseignants();
                maxPage = nbrAnnonces/maxAnnonces + 1;
                
                request.setAttribute("annonces",annonces);
                request.setAttribute("page", page);
                request.setAttribute("maxPage",maxPage);
                
               this.getServletContext().getRequestDispatcher("/WEB-INF/Prof/Annonce_Prof.jsp").forward(request,response);
            }
            else if(session.getAttribute("sessionEtudiant") != null)
            {
                
            }
            else   this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
      
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }

 
}
