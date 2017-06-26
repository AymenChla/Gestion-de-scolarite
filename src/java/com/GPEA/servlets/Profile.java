/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.servlets;

import com.GPEA.beans.Module;
import com.GPEA.beans.Enseignant;
import com.GPEA.dao.DAOFactory;
import com.GPEA.dao.EnseignantDao;
import com.GPEA.forms.GestionEnseignant;
import static com.GPEA.servlets.Authentification.CONF_DAO_FACTORY;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.GPEA.dao.ModuleDao;


public class Profile extends HttpServlet {
    private EnseignantDao   enseignantDao;
    private ModuleDao moduleDao;
    public static final String VUE_PROFILE = "/WEB-INF/Prof/Profile_Prof.jsp";
    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.enseignantDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getEnseignantDao();
        this.moduleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getModuleDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession session = request.getSession();
       
       Long idEnseignant = (Long)session.getAttribute("sessionProf");
       if(idEnseignant != null){
           
           GestionEnseignant gestionProfileEnseignant = new GestionEnseignant(enseignantDao,moduleDao);
           //recuperer l'enseignant
           Enseignant enseignant = gestionProfileEnseignant.getEnseignant(idEnseignant);
           
           request.setAttribute("enseignant", enseignant);
           
           //recuperer les modules de l'enseignant
           ArrayList<Module> modules = gestionProfileEnseignant.getModules(idEnseignant);
           
            //recuperer les modules de l'enseignant avec les filieres des modules
           HashMap<Module,String> mapFiliereElement = gestionProfileEnseignant.getMapFiliereModule(modules);
           System.out.println(mapFiliereElement.size());
           request.setAttribute("mapFiliereModule", mapFiliereElement);
           
           this.getServletContext().getRequestDispatcher(VUE_PROFILE).forward(request, response);
           
       }else if(session.getAttribute("sessionEtudiant") != null)
       {
           
       }
       else this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
       
    }
    

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        Long id_enseignant = (Long) session.getAttribute("sessionProf");
        if(id_enseignant != null)
        {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String adresse = request.getParameter("adresse");
            String tel = request.getParameter("tel");
            String specialites = request.getParameter("specialites");
            String departement = request.getParameter("departement");

            Enseignant enseignant = new Enseignant(id_enseignant,nom,prenom,tel,email,adresse,specialites,departement);
            this.enseignantDao.modifier(enseignant);

            doGet(request,response);
        }
        else this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        
    }

   

}
