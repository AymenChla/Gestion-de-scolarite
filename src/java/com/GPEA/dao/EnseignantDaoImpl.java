package com.GPEA.dao;


import com.GPEA.beans.Enseignant;
import static com.GPEA.dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EnseignantDaoImpl implements EnseignantDao {
    
     private DAOFactory          daoFactory;

    EnseignantDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM ENSEIGNANT WHERE email_ENSEIGNANT = ?";

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public Enseignant trouver(String email) throws DAOException {
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Enseignant enseignant = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_EMAIL, false, email);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                enseignant = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return enseignant;
    }
    
    
  
    public static Enseignant map(ResultSet resultSet) throws SQLException {
        
        Enseignant enseignant = new Enseignant();
        enseignant.setIdEnseignant(resultSet.getLong("Id_ENSEIGNANT"));
        enseignant.setNomEnseignant(resultSet.getString("NOM_ENSEIGNANT"));
        enseignant.setPrenomEnseignant(resultSet.getString("PRENOM_ENSEIGNANT"));
        enseignant.setEmailEnseignant(resultSet.getString("EMAIL_ENSEIGNANT"));
        enseignant.setDepartementEnseignant(resultSet.getString("DEPARTEMENT_ENSEIGNANT"));
        enseignant.setPhotoEnseignant(resultSet.getString("PHOTO_ENSEIGNANT"));
             
        return enseignant;
    }
    
    private static final String SQL_SELECT_PAR_EMAIL_PASSWORD = "SELECT * FROM enseignant WHERE email_enseignant = ? and mdp_enseignant = ?";
    
    
     @Override
    public Enseignant trouver(String email,String password) throws DAOException {
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Enseignant enseignant = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_EMAIL_PASSWORD, false, email,password);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                enseignant = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return enseignant;
    }
    private static final String SQL_GET_ID_COMPTE = "SELECT ID_COMPTE FROM COMPTE WHERE ID_ENSEIGNANT = ?";

    @Override
    public Long getIdCompte(Long idEnseignant)throws DAOException {
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Long idCompte = null ;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_GET_ID_COMPTE, false,idEnseignant);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                idCompte = resultSet.getLong("ID_COMPTE") ;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return idCompte;
       
    }
    
    
    
}




        