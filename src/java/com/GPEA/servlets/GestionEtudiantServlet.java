/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.servlets;


import com.GPEA.beans.Etudiant;
import com.GPEA.beans.Filiere;
import com.GPEA.dao.DAOFactory;
import com.GPEA.dao.EtudiantDao;
import com.GPEA.dao.FiliereDao;
import com.GPEA.forms.GestionEtudiant;
import com.GPEA.forms.GestionFiliere;
import static com.GPEA.servlets.Authentification.CONF_DAO_FACTORY;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author asus pro
 */
@MultipartConfig(maxFileSize = 16177215)
public class GestionEtudiantServlet extends HttpServlet {

    public static final String CONF_DAO_FACTORY = "daofactory";
    private FiliereDao filiereDao;
    private EtudiantDao   etudiantDao;
    
    public static final String VUE_INFOS = "/WEB-INF/Administration/etudiants.jsp";
    public static final String VUE_INSERER = "/WEB-INF/Administration/ajout_etudiants_man.jsp";
    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.etudiantDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getEtudiantDao();
        this.filiereDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getFiliereDao();
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Long id_admin = (Long) session.getAttribute("sessionAdmin");
        if(id_admin != null)
        {
            GestionEtudiant gestionEtudiant = new GestionEtudiant(this.etudiantDao);
            GestionFiliere gestionFiliere = new GestionFiliere(this.filiereDao);
            
            String page = null;
            if(request.getParameter("page") == null)
                response.sendRedirect("Etudiant?page=info");
            
            else{
                page = request.getParameter("page");

                //page d'information enseignant
                if (page.equals("info")) {
                    ArrayList<Etudiant> etudiants = gestionEtudiant.getAllEtudiant();
                    ArrayList<Filiere> filieres = gestionFiliere.getFilieresEtudiants(etudiants);

                    request.setAttribute("filieres", filieres);
                    request.setAttribute("etudiants", etudiants);

                    this.getServletContext().getRequestDispatcher(VUE_INFOS).forward(request, response);
                } else if (page.equals("insert")) {
                    ArrayList<Filiere> filieres = gestionFiliere.getFilieres();
                    request.setAttribute("filieres", filieres);

                    this.getServletContext().getRequestDispatcher(VUE_INSERER).forward(request, response);
                }
            }
             
        }
        else  response.sendRedirect("LoginAdmin");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Long id_admin = (Long) session.getAttribute("sessionAdmin");
        if(id_admin != null)
        {
            GestionEtudiant gestionEtudiant = new GestionEtudiant(this.etudiantDao);
            
            String page = null;
            if(request.getParameter("page") == null)
                response.sendRedirect("Etudiant?page=info");
            
            else{
                page = request.getParameter("page");
            
                //insertion manuelle
                if(page.equals("insert"))
                {
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    Date date=null;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
                    } catch (ParseException ex) {
                        Logger.getLogger(gestionEnseignantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String email = request.getParameter("email");
                    String tel = request.getParameter("tel");
                    String adresse = request.getParameter("adresse");
                    Long cne = Long.parseLong(request.getParameter("cne"));
                    Long codeApoge = Long.parseLong(request.getParameter("codeApoge"));
                    Long idSemester = Long.parseLong(request.getParameter("idSemester"));
                    String password = request.getParameter("password");
                    InputStream inputStream = null; // input stream of the upload file

                    // obtains the upload file part in this multipart request
                    Part filePart = request.getPart("photo");
                    if (filePart != null) {
                        // obtains input stream of the upload file
                        inputStream = filePart.getInputStream();
                    }

                    Etudiant etudiant = new Etudiant( cne, nom,  prenom,  date, tel,adresse,  email,  password,  codeApoge,  idSemester, inputStream);

                    gestionEtudiant.insererEtudiant(etudiant);

                    response.sendRedirect("Etudiant?page=info");
                }
            }
        }
        else  response.sendRedirect("LoginAdmin");
    }

    
  

}
