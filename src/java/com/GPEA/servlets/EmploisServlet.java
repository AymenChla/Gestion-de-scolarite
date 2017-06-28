
package com.GPEA.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EmploisServlet extends HttpServlet {

  


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
            
            HttpSession session = request.getSession();
             if(session.getAttribute("sessionProf") != null)
            {
                
               this.getServletContext().getRequestDispatcher("/WEB-INF/Prof/Emplois_Prof.jsp").forward(request,response);
            }
            else if(session.getAttribute("sessionEtudiant") != null)
            {
                
               this.getServletContext().getRequestDispatcher("/WEB-INF/Etudiant/Emplois_Etud.jsp").forward(request,response);
                
            }
            else   this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
      
       
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }


}
