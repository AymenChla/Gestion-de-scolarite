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
public class MessageDaoImpl implements MessageDao{

    private DAOFactory          daoFactory;

    MessageDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    private static final String SQL_INSERT_MSG = "insert into messages Values(?,0,?,0,NOW(),?)";
    @Override
    public void envoyerMsgProfToAdmin(Long idCompteSource, String msg, String objetMsg){
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_MSG, false, idCompteSource, objetMsg , msg);
            preparedStatement.executeUpdate();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
           
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        

        
 
    }

    @Override
    public void envoyerMsgEtudToAdmin(Long idCompteSource, String msg, String objetMsg){
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_MSG, false, idCompteSource, objetMsg , msg);
            preparedStatement.executeUpdate();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
           
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        

        
 
    }
    
    
    
    
    
    
}


   

 