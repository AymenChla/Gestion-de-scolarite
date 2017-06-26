
package com.GPEA.dao;

import com.GPEA.beans.Administration;
import com.GPEA.beans.Enseignant;
import static com.GPEA.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.GPEA.dao.DAOUtilitaire.initialisationRequetePreparee;
import static com.GPEA.dao.EnseignantDaoImpl.map;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministrationDaoImpl implements AdministrationDao{
    
    private DAOFactory          daoFactory;

    AdministrationDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
   
    public static final String SQL_SELECT_AUTHENTIFICATION = "SELECT * from administration where email_admin = ? and mdp_admin = ?";
    @Override
    public Administration trouver(String email,String password)throws DAOException
    {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Administration admin = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_AUTHENTIFICATION, false, email,password);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                admin = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return admin;
    }
    
     public static Administration map(ResultSet resultSet) throws SQLException {
        
        Administration administration = new Administration();
        administration.setIdAdmin(resultSet.getLong("Id_ADMIN"));
        administration.setNomAdmin(resultSet.getString("NOM_ADMIN"));
        administration.setPrenomAdmin(resultSet.getString("PRENOM_ADMIN"));
        administration.setEmailAdmin(resultSet.getString("EMAIL_ADMIN"));
      
        return administration;
    }
     
    public static final String SQL_SELECT_IMAGE = "select photo_admin from administration where id_admin=?";
    public Blob getImageBlob(Long id_admin)
    {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Blob blob = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_IMAGE, false,id_admin);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                blob = resultSet.getBlob("photo_admin");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return blob;
    }
}
