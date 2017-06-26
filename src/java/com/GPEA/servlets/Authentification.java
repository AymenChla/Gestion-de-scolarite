/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.servlets;

import com.GPEA.beans.Annonce;
import com.GPEA.beans.Etudiant;
import com.GPEA.beans.Enseignant;
import com.GPEA.dao.AnnonceDao;
import com.GPEA.dao.DAOFactory;
import com.GPEA.dao.EtudiantDao;
import  com.GPEA.dao.EnseignantDao;
import com.GPEA.forms.GestionAuthentification;
import com.GPEA.forms.GestionAnnonces;
import static com.GPEA.servlets.index.VUE_Enseignant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Authentification extends HttpServlet {

    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String ATT_USER         = "etudiant";
    public static final String VUE_Etudiant              = "/WEB-INF/Etudiant/Accueil_Prof.jsp";
    public static final String VUE_Enseignant            = "/WEB-INF/Prof/Accueil_Prof.jsp";
    
    private EtudiantDao     etudiantDao;
    private EnseignantDao   enseignantDao;
    private  AnnonceDao annonceDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.etudiantDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getEtudiantDao();
        this.enseignantDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getEnseignantDao();
          this.annonceDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getAnnonceDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession();
             if(session.getAttribute("sessionProf") != null)
            {
                GestionAnnonces gestionAnnonces = new GestionAnnonces(annonceDao);
                ArrayList<Annonce> annonces = gestionAnnonces.getAnnonces(0,2);
                request.setAttribute("annonces",annonces);
                
                
                this.getServletContext().getRequestDispatcher(VUE_Enseignant).forward(request, response);
            }
            else if(session.getAttribute("sessionEtudiant") != null)
            {
                //
            }
            else   this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        
    }

 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            HttpSession session = request.getSession();

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            
            GestionAuthentification authentificationForm = new GestionAuthentification(etudiantDao);
            Etudiant etudiant = authentificationForm.AuthentificateEtudiant(email,password);              
            
            if(etudiant != null){
             
                session.setAttribute("sessionEtudiant", etudiant.getCne());
                this.getServletContext().getRequestDispatcher(VUE_Etudiant).forward(request, response);
            }

            

           authentificationForm = new GestionAuthentification(enseignantDao);
           Enseignant enseignant = authentificationForm.AuthentificateEnseignant(email,password);
           
            if(enseignant != null){
             session.setAttribute("sessionProf", enseignant.getIdEnseignant());
             request.setAttribute("enseignant",enseignant);
             doGet(request,response);
            }
             
             
            else this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
             
             
    }

   
}
