/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.servlets;

import com.GPEA.beans.Annonce;
import com.GPEA.dao.AnnonceDao;
import com.GPEA.dao.DAOFactory;
import com.GPEA.forms.GestionAnnonces;
import static com.GPEA.servlets.Authentification.CONF_DAO_FACTORY;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus pro
 */
public class PosterAdminServlet extends HttpServlet {

    private AnnonceDao   annonceDao;
    
    public static final String VUE_INFOS = "/WEB-INF/Administration/annonces.jsp";
    public static final String VUE_INSERER = "/WEB-INF/Administration/ajout_enseignants_man.jsp";
    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.annonceDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getAnnonceDao();
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Long id_admin = (Long) session.getAttribute("sessionAdmin");
        if(id_admin != null)
        {
            GestionAnnonces gestionAnnonces = new GestionAnnonces(this.annonceDao);
            
            String page = null;
            if(request.getParameter("page") == null)
                response.sendRedirect("PosterAdmin?page=VoirPosteProf");
            
            else{
                page = request.getParameter("page");
                //page d'information enseignant
                if(page.equals("VoirPosteProf"))
                {
                    ArrayList<Annonce> annonces = gestionAnnonces.getAnnoncesAdmintoProf(id_admin);

                    request.setAttribute("annonces", annonces);

                    this.getServletContext().getRequestDispatcher(VUE_INFOS).forward(request, response);
                }
                else if(page.equals("VoirPosteEtudiant"))
                {
                    ArrayList<Annonce> annonces = gestionAnnonces.getAnnoncesAdmintoEtudiants(id_admin);

                    request.setAttribute("annonces", annonces);

                    this.getServletContext().getRequestDispatcher(VUE_INFOS).forward(request, response);
                }
            }
        }
        else  response.sendRedirect("LoginAdmin");
    }


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    

}
