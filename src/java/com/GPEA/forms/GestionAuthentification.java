package com.GPEA.forms;


import com.GPEA.beans.Administration;
import com.GPEA.beans.Enseignant;
import com.GPEA.beans.Etudiant;
import com.GPEA.dao.AdministrationDao;
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
public class GestionAuthentification {
    
    private AdministrationDao administrationDao;
    private EtudiantDao      etudiantDao;
    private EnseignantDao    enseignantDao;

    public GestionAuthentification( EtudiantDao etudiantDao ) {
        this.etudiantDao = etudiantDao;
    }
    
    public GestionAuthentification( EnseignantDao enseignantDao ) {
        this.enseignantDao = enseignantDao;
    }
    
    public GestionAuthentification( AdministrationDao administrationDao ) {
        this.administrationDao = administrationDao;
    }
    
    
    public Etudiant AuthentificateEtudiant(String email, String password)
    {
        return etudiantDao.trouver(email,password);
    }
    public Enseignant AuthentificateEnseignant(String email, String password)
    {
        return enseignantDao.trouver(email,password);
    }
    public Administration AuthentificateAdministration(String email, String password) 
    {
        return administrationDao.trouver(email,password);
    }
}
