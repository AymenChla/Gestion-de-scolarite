
package com.GPEA.dao;
import com.GPEA.beans.Annonce;
import com.GPEA.beans.Filiere;
import java.util.ArrayList;
import java.util.Map;



public interface AnnonceDao{
    
        public ArrayList<Annonce> afficherAnnonceEnseignant();
        public void posterAnnonceEnseignantToFiliere(Long idEnseignant, String semester,String filiere,String toute, String titreAnnonce, String annonce);
        public ArrayList<Annonce> afficherAnnoncePoster(Long idEnseignant)throws DAOException;
        public ArrayList<Filiere> afficherFilierePoster(Long idEnseignant)throws DAOException;
}
