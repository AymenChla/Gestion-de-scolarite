package com.GPEA.forms;


import com.GPEA.beans.Enseignant;
import com.GPEA.beans.Etudiant;
import com.GPEA.dao.EnseignantDao;
import com.GPEA.dao.EtudiantDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus pro
 */
public class AuthentificationForm {
    
    private EtudiantDao      etudiantDao;
    private EnseignantDao    enseignantDao;

    public AuthentificationForm( EtudiantDao etudiantDao ) {
        this.etudiantDao = etudiantDao;
    }
    
    public AuthentificationForm( EnseignantDao enseignantDao ) {
        this.enseignantDao = enseignantDao;
    }
    
    
    
    public Etudiant AuthentificateEtudiant(String email, String password)
    {
        return etudiantDao.trouver(email,password);
    }
    public Enseignant AuthentificateEnseignant(String email, String password)
    {
        return enseignantDao.trouver(email,password);
    }
}
