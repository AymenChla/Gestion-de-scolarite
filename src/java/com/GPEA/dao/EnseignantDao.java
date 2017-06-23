package com.GPEA.dao;

import com.GPEA.beans.Enseignant;


public interface EnseignantDao {

    //void creer( Enseignant admin ) throws DAOException;

    Enseignant trouver( String email ) throws DAOException;
    
    Enseignant trouver(String email,String password);
    
    Long getIdCompte(Long idEnseignant);
    
}