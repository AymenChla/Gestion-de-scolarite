
package com.GPEA.servlets;

import com.GPEA.beans.Filiere;
import com.GPEA.dao.DAOFactory;
import com.GPEA.dao.FiliereDao;
import com.GPEA.forms.GestionFiliere;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FiliereServlet extends HttpServlet {
    
    public static final String CONF_DAO_FACTORY = "daofactory";
    private FiliereDao filiereDao;
    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
       this.filiereDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getFiliereDao();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             HttpSession session = request.getSession();
              
             if(session.getAttribute("sessionProf") != null)
            {
                GestionFiliere gestionFiliere = new GestionFiliere(filiereDao);
                ArrayList<Filiere> filiereList = gestionFiliere.getFilieres();
                request.setAttribute("filiereList", filiereList);
                
 
               this.getServletContext().getRequestDispatcher("/WEB-INF/Prof/Filier_Prof.jsp").forward(request,response);
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
