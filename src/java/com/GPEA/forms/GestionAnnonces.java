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
    
    public int getNbrAnnonces()
    {
        return this.annonceDao.getNombreAnnonces();
    }
    
    public int getNbrPostes(Long idEnseignant)
    {
        return this.annonceDao.getNombrePostes(idEnseignant);
    }
    
    public ArrayList<Annonce> getAnnonces(int offset,int max){
    
        return this.annonceDao.afficherAnnonceEnseignant(offset,max);
        
    }
    public void setAnnonceEnseignantToFilier(Long idEnseignant, String semester,String filiere,String toute, String titreAnnonce, String annonce){
        
        this.annonceDao.posterAnnonceEnseignantToFiliere(idEnseignant, semester, filiere, toute, titreAnnonce, annonce);
    
    }
    
    public ArrayList<Annonce> getAnnoncesPosterProf(Long idEnseignant, int offset, int maxPostes){
        
        return this.annonceDao.afficherAnnoncePoster(idEnseignant, offset, maxPostes);
    
    }
    
    public ArrayList<Filiere>  getFilierePosterProf(Long idEnseignant,int offset, int maxPostes){
    
        return this.annonceDao.afficherFilierePoster(idEnseignant, offset,  maxPostes);
    }
    
}
