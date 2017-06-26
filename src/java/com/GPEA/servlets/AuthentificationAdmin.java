/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.servlets;

import com.GPEA.beans.Administration;
import com.GPEA.beans.Annonce;
import com.GPEA.beans.Enseignant;
import com.GPEA.beans.Etudiant;
import com.GPEA.dao.AdministrationDao;
import com.GPEA.dao.AnnonceDao;
import com.GPEA.dao.DAOFactory;
import com.GPEA.forms.GestionAuthentification;
import com.GPEA.forms.GestionAnnonces;
import static com.GPEA.servlets.Authentification.CONF_DAO_FACTORY;
import static com.GPEA.servlets.Authentification.VUE_Enseignant;
import static com.GPEA.servlets.Authentification.VUE_Etudiant;
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
public class AuthentificationAdmin extends HttpServlet {
    
    
     private  AdministrationDao administrationDao;
     
     public static final String VUE_INDEX = "/WEB-INF/Administration/index.jsp";
     
    public void init() throws ServletException {
        this.administrationDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getAdministrationDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            HttpSession session = request.getSession();
            if(session.getAttribute("sessionAdmin") != null)
            {
                this.getServletContext().getRequestDispatcher(VUE_INDEX).forward(request, response);
            }
            else   response.sendRedirect("LoginAdmin");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
            HttpSession session = request.getSession();

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Administration admin = null;
            
            GestionAuthentification authetificationForm = new GestionAuthentification(this.administrationDao);
            admin = authetificationForm.AuthentificateAdministration(email, password);
            if(admin != null)
            {
                session.setAttribute("sessionAdmin", admin.getIdAdmin());
                request.setAttribute("admin", admin);
                doGet(request,response);
            }
            else this.getServletContext().getRequestDispatcher("/WEB-INF/Administration/login.jsp").forward(request, response);
            
    }

   

}
