
package com.GPEA.servlets;

import com.GPEA.beans.Annonce;
import com.GPEA.beans.Filiere;
import com.GPEA.dao.AnnonceDao;
import com.GPEA.dao.DAOFactory;
import com.GPEA.forms.GestionAnnonces;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PosterServlet extends HttpServlet {
    
   public static final String CONF_DAO_FACTORY = "daofactory";

    
    private AnnonceDao annonceDao;
  
    
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
                ArrayList<Annonce> annonceList = new ArrayList<Annonce>();
                ArrayList<Filiere> filiereList = new ArrayList<Filiere>();
                
               GestionAnnonces gestionAnnonces =new GestionAnnonces(annonceDao);
               annonceList = gestionAnnonces.getAnnoncesPosterProf((Long)session.getAttribute("sessionProf"));
               filiereList = gestionAnnonces.getFilierePosterProf((Long)session.getAttribute("sessionProf"));
               
               //System.out.println("sadsdas"+filiereList.get(0).getSemester());
               request.setAttribute("filiereList",filiereList);
               request.setAttribute("annonceList",annonceList);
               this.getServletContext().getRequestDispatcher("/WEB-INF/Prof/Poster_Prof.jsp").forward(request,response);
            }
            else if(session.getAttribute("sessionEtudiant") != null)
            {
                
            }
            else   this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
      
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            HttpSession session = request.getSession();
             if(session.getAttribute("sessionProf") != null){
           
            GestionAnnonces gestionAnnonce = new GestionAnnonces(annonceDao);
            gestionAnnonce.setAnnonceEnseignantToFilier((Long)session.getAttribute("sessionProf"), request.getParameter("semester"), request.getParameter("filiere"), request.getParameter("toute"), request.getParameter("titreAnnonce"), request.getParameter("annonce"));
       
            response.sendRedirect("Poster");
           
           
       
       
       
            }else this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        
  
        
       
        
    }

 
}
