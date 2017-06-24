package com.GPEA.dao;


import com.GPEA.beans.Enseignant;
import static com.GPEA.dao.DAOUtilitaire.*;
import java.io.InputStream;
import java.sql.Blob;

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
    
     private static final String SQL_SELECT_PAR_ID = "SELECT * FROM ENSEIGNANT WHERE ID_ENSEIGNANT = ?";
    public Enseignant trouver(Long idEnseignant) throws DAOException {
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Enseignant enseignant = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ID, false, idEnseignant);
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
        enseignant.setAdresseEnseignant(resultSet.getString("ADRESSE_ENSEIGNANT"));
        enseignant.setTelEnseignant(resultSet.getString("TEL_ENSEIGNANT"));
        enseignant.setSpecialiteEnseignant(resultSet.getString("SPECIALITE_ENSEIGNANT"));
        
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
    
    public static final String SQL_MODIFIER_ENSEIGNANT = "UPDATE enseignant set nom_enseignant=? , prenom_enseignant=?, tel_enseignant=?, email_enseignant=?, adresse_enseignant=? ,specialite_enseignant=?, departement_enseignant=? where id_enseignant = ?";
    public void modifier(Enseignant enseignant) throws DAOException
    {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
     
        

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_MODIFIER_ENSEIGNANT, false, enseignant.getNomEnseignant(),enseignant.getPrenomEnseignant(),enseignant.getTelEnseignant(),enseignant.getEmailEnseignant(),enseignant.getAdresseEnseignant(),enseignant.getSpecialiteEnseignant(),enseignant.getDepartementEnseignant(),enseignant.getIdEnseignant());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion);
        }
    }
    
    public static final String SQL_SELECT_IMAGE = "select photo_enseignant from enseignant where id_enseignant=?";
    public Blob getImageBlob(Long id_enseignant)
    {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Blob blob = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_IMAGE, false,id_enseignant);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                blob = resultSet.getBlob("photo_ENSEIGNANT");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return blob;
    }
    
}




        