
package com.GPEA.dao;
import com.GPEA.beans.Annonce;
import com.GPEA.beans.Filiere;
import java.util.ArrayList;
import java.util.Map;



public interface AnnonceDao{
    
        public ArrayList<Annonce> afficherAnnonceEnseignant(int offset,int max);
        public void posterAnnonceEnseignantToFiliere(Long idEnseignant, String semester,String filiere,String toute, String titreAnnonce, String annonce);
        public ArrayList<Annonce> afficherAnnoncePoster(Long idEnseignant,int offset,int maxPostes)throws DAOException;
        public ArrayList<Filiere> afficherFilierePoster(Long idEnseignant, int offset, int maxPostes)throws DAOException;
        public int getNombreAnnoncesEnseignants()throws DAOException;
        public int getNombrePostes(Long idEnseignant)throws DAOException;
        public ArrayList<Annonce> getAnnoncesAdmintoProf(Long idAdmin) throws DAOException;
        public ArrayList<Annonce> getAnnoncesAdmintoEtudiants(Long idAdmin) throws DAOException;
}
