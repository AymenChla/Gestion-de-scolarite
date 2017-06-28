package com.GPEA.dao;

import com.GPEA.beans.Etudiant;
import java.util.ArrayList;


public interface EtudiantDao {


    
    Etudiant trouver(String email,String password) throws DAOException;
    
    void inserer(Etudiant etudiant) throws DAOException;
    
    ArrayList<Etudiant> getAllEtudiant() throws DAOException;
}