package com.GPEA.dao;

import com.GPEA.beans.Etudiant;


public interface EtudiantDao {

    void creer( Etudiant etudiant ) throws DAOException;

    Etudiant trouver( String email ) throws DAOException;
    
    Etudiant trouver(String email,String password) throws DAOException;
}