/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.forms;

import com.GPEA.beans.Etudiant;
import com.GPEA.dao.EtudiantDao;
import java.util.ArrayList;

/**
 *
 * @author asus pro
 */
public class GestionEtudiant {
    
    private EtudiantDao etudiantDao;
    
    
   
    public GestionEtudiant(EtudiantDao etudiantDao)
    {
        this.etudiantDao = etudiantDao;
    }
    
    public ArrayList<Etudiant> getAllEtudiant()
    {
       return this.etudiantDao.getAllEtudiant();
    }
    
    
    public void insererEtudiant(Etudiant etudiant)
    {
        this.etudiantDao.inserer(etudiant);
    }
}
