/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.forms;

import com.GPEA.beans.Annonce;
import com.GPEA.beans.Filiere;
import com.GPEA.dao.AnnonceDao;
import java.util.ArrayList;
import java.util.Map;



public class GestionAnnonces {
    
     private AnnonceDao    annonceDao;

    public GestionAnnonces( AnnonceDao annonceDao ) {
        
        this.annonceDao = annonceDao;
    }
    public ArrayList<Annonce> getAnnonces(){
    
        return this.annonceDao.afficherAnnonceEnseignant();
        
    }
    public void setAnnonceEnseignantToFilier(Long idEnseignant, String semester,String filiere,String toute, String titreAnnonce, String annonce){
        
        this.annonceDao.posterAnnonceEnseignantToFiliere(idEnseignant, semester, filiere, toute, titreAnnonce, annonce);
    
    }
    
    public ArrayList<Annonce> getAnnoncesPosterProf(Long idEnseignant){
        
        return this.annonceDao.afficherAnnoncePoster(idEnseignant);
    
    }
    
    public ArrayList<Filiere>  getFilierePosterProf(Long idEnseignant){
    
        return this.annonceDao.afficherFilierePoster(idEnseignant);
    }
    
}
