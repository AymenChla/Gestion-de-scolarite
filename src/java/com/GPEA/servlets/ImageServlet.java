/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.servlets;

import com.GPEA.dao.AdministrationDao;
import com.GPEA.dao.DAOFactory;
import com.GPEA.dao.EnseignantDao;
import static com.GPEA.servlets.Authentification.CONF_DAO_FACTORY;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus pro
 */

public class ImageServlet extends HttpServlet {

     private EnseignantDao   enseignantDao;
     private AdministrationDao administrationDao;
     
     public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.enseignantDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getEnseignantDao();
        this.administrationDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getAdministrationDao();
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            HttpSession session = request.getSession();
            
            if(request.getParameter("role").equals("enseignant" ))
            {
                Long id = (Long) session.getAttribute("sessionProf");
                if(id != null)
                {

                     Blob blob = this.enseignantDao.getImageBlob(id);
                     if(blob != null)
                     {
                        try {
                            byte[] bytes = blob.getBytes(1, (int)blob.length());
                            OutputStream output = response.getOutputStream();
                            response.setContentType("image/jpg");
                            output.write(bytes);
                            output.flush();
                            output.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(ImageServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                             //put here an unknown image
                    }
                

                }
                else this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
            else if(request.getParameter("role").equals("admin"))
            {
                Long id = (Long) session.getAttribute("sessionAdmin");
                if(id != null)
                {

                     Blob blob = this.administrationDao.getImageBlob(id);
                     if(blob != null)
                     {
                        try {
                            byte[] bytes = blob.getBytes(1, (int)blob.length());
                            OutputStream output = response.getOutputStream();
                            response.setContentType("image/jpg");
                            output.write(bytes);
                            output.flush();
                            output.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(ImageServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                             //put here an unknown image
                    }
                

                }
                else this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
            
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
       
    }

    
}
