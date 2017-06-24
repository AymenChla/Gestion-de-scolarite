
package com.GPEA.servlets;

import static com.GPEA.servlets.Authentification.VUE_Enseignant;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class index extends HttpServlet {

   public static final String VUE_Enseignant            = "/WEB-INF/Prof/Accueil_Prof.jsp";
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            HttpSession session = request.getSession();
           
            if(session.getAttribute("sessionProf") != null)
            {
                response.sendRedirect("http://localhost:8080/GPEA/home");
            }
            else if(session.getAttribute("sessionEtudiant") != null)
            {
                //
            }
            else   this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
    
  
        
        
        
    }
    


