/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.forms;

import com.GPEA.dao.CompteDao;
import com.GPEA.dao.EnseignantDao;
import com.GPEA.dao.EtudiantDao;

/**
 *
 * @author Youssef
 */
public class GestionCompte {
    private CompteDao compteDao;
  
    public GestionCompte(CompteDao compteDao){
    
    this.compteDao = compteDao;
    }
    
    public Long getIdCompteEnseignant(Long idEnseignant){
    
    return this.compteDao.getIdCompteEnseignant(idEnseignant);
    
    }
   
    public Long getIdCompteEtudiant(Long cne){
    
    return this.compteDao.getIdCompteEtudiant(cne);
        
    }
    
}
