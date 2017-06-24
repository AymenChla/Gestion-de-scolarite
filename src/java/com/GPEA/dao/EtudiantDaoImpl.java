package com.GPEA.dao;

import com.GPEA.beans.Etudiant;
import static com.GPEA.dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtudiantDaoImpl implements EtudiantDao {
    
     private DAOFactory          daoFactory;

    EtudiantDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT id, email, nom, mot_de_passe, date_inscription FROM Utilisateur WHERE email = ?";

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public Etudiant trouver(String email) throws DAOException {
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Etudiant etudiant = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_EMAIL, false, email);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                etudiant = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return etudiant;
    }
    
    
    private static final String SQL_INSERT = "INSERT INTO etudiant (CNE,ID_COMPTE,ID_FILIERE,NOM_ETUDIANT,PRENOM_ETUDIANT,DATE_DE_NAISSANCE, EMAIl_ETUDIANT, MDP_ETUDIANT, CODE_APOGE) VALUES (?, ?, ?,?,?,?,?,?,?)";

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public void creer(Etudiant etudiant) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,etudiant.getCne(),etudiant.getIdFiliere(),etudiant.getNomEtudiant(),etudiant.getPrenomEtudiant() ,etudiant.getDateDeNaissance(),etudiant.getEmailEtudiant(), etudiant.getMdpEtudiant(),etudiant.getCodeApoge());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                //etudiant.set(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    }
    
       /*
 * Simple méthode utilitaire permettant de faire la correspondance (le
 * mapping) entre une ligne issue de la table des utilisateurs (un
 * ResultSet) et un bean Utilisateur.
     */
    public static Etudiant map(ResultSet resultSet) throws SQLException {
        
        Etudiant etutiant = new Etudiant();
        etutiant.setCne(resultSet.getLong("CNE"));
        etutiant.setCodeApoge(resultSet.getLong("CODE_APOGE"));
        etutiant.setNomEtudiant(resultSet.getString("NOM_ETUDIANT"));
        
        return etutiant;
    }
    
    private static final String SQL_SELECT_PAR_EMAIL_PASSWORD = "SELECT cne, id_filiere, nom_etudiant, prenom_etudiant, date_de_naissance,email_etudiant,mdp_etudiant,code_apoge,photo_etudiant FROM etudiant WHERE email_etudiant = ? and mdp_etudiant = ?";
    
    
     @Override
    public Etudiant trouver(String email,String password) throws DAOException {
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Etudiant etudiant = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_EMAIL_PASSWORD, false, email,password);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                etudiant = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return etudiant;
    }
}