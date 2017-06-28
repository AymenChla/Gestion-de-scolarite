/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.dao;

import static com.GPEA.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.GPEA.dao.DAOUtilitaire.initialisationRequetePreparee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Youssef
 */
public class CompteDaoImpl implements CompteDao{

         private DAOFactory          daoFactory;

   CompteDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    private static final String SQL_ID_COMPTE_ENSEIGNANT = "SELECT ID_COMPTE FROM COMPTE WHERE ID_ENSEIGNANT=? ;";
   
    
    
    
    @Override
    public Long getIdCompteEnseignant(Long idEnseignant) {
        
        Long idCompte=null;
        
        Connection connexion = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement= null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_ID_COMPTE_ENSEIGNANT, false, idEnseignant);
            resultSet = preparedStatement.executeQuery();
          
            if(resultSet.next()) {
                idCompte = (Long)resultSet.getLong("ID_COMPTE");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet,preparedStatement, connexion);
        }

        return idCompte;
   
        
    }

    
     private static final String SQL_ID_COMPTE_ETUDIANT = "SELECT ID_COMPTE FROM COMPTE WHERE CNE=? ;"; 
    @Override
    public Long getIdCompteEtudiant(Long cne) {
        
          Long idCompte=null;
        
        Connection connexion = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement= null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_ID_COMPTE_ETUDIANT, false, cne);
            resultSet = preparedStatement.executeQuery();
          
            if(resultSet.next()) {
                idCompte = (Long)resultSet.getLong("ID_COMPTE");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet,preparedStatement, connexion);
        }

        return idCompte;
   
       
   }
    
}
