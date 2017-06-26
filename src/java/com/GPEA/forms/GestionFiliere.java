/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.forms;

import com.GPEA.beans.Etudiant;
import com.GPEA.beans.Filiere;
import com.GPEA.dao.EtudiantDao;
import com.GPEA.dao.FiliereDao;
import java.util.ArrayList;

/**
 *
 * @author Youssef
 */
public class GestionFiliere {
    
    private FiliereDao filiereDao;
    private EtudiantDao etudiantDao;
    
    public GestionFiliere(FiliereDao filiereDao,EtudiantDao etudiantDao){
    
        this.filiereDao = filiereDao;
        this.etudiantDao =  etudiantDao;
    }
    
    public GestionFiliere(FiliereDao filiereDao){
    
        this.filiereDao = filiereDao;
    }
   
    
    public ArrayList<Filiere> getFilieres(){
    
        return this.filiereDao.AfficherLesFiliere();
    
    }
    
    public ArrayList<Filiere> getFilieresEtudiants(ArrayList<Etudiant> etudiants){
        
        ArrayList<Filiere> filieres = new ArrayList<Filiere>();
        for(Etudiant e : etudiants)
        {
            filieres.add(this.filiereDao.getFiliereEtudiant(e.getIdSemester()));
        }
        
        return filieres;
    }
    
}
