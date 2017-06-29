package com.GPEA.dao;

import com.GPEA.beans.Etudiant;
import static com.GPEA.dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EtudiantDaoImpl implements EtudiantDao {
    
     private DAOFactory          daoFactory;

    EtudiantDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    
    public static Etudiant map(ResultSet resultSet) throws SQLException {
        
        Etudiant etutiant = new Etudiant();
        etutiant.setCne(resultSet.getLong("CNE"));
        etutiant.setCodeApoge(resultSet.getLong("CODE_APOGE"));
        etutiant.setNomEtudiant(resultSet.getString("NOM_ETUDIANT"));
        etutiant.setPrenomEtudiant(resultSet.getString("PRENOM_ETUDIANT"));
        etutiant.setEmailEtudiant(resultSet.getString("EMAIL_ETUDIANT"));
        etutiant.setTelEtudiant(resultSet.getString("TEL_ETUDIANT"));
        etutiant.setAdresseEtudiant(resultSet.getString("ADRESSE_ETUDIANT"));
        etutiant.setPhotoEtudiant(resultSet.getBinaryStream("PHOTO_ETUDIANT"));
        etutiant.setDateDeNaissance(resultSet.getDate("DATE_DE_NAISSANCE"));
        etutiant.setIdSemester(resultSet.getLong("ID_SEMESTER"));
        
        return etutiant;
    }
    

    private static final String SQL_SELECT_PAR_EMAIL_PASSWORD = "SELECT CNE, ID_SEMESTER, NOM_ETUDIANT, PRENOM_ETUDIANT, DATE_DE_NAISSANCE,EMAIL_ETUDIANT,MDP_ETUDIANT,CODE_APOGE,TEL_ETUDIANT,PHOTO_ETUDIANT,ADRESSE_ETUDIANT FROM etudiant WHERE email_etudiant = ? and mdp_etudiant = ?";

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
    
    public static final String SQL_SELECT_ALL_ETUDIANT = "select * from etudiant";
    @Override
    public ArrayList<Etudiant> getAllEtudiant() throws DAOException
    {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL_ETUDIANT);
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while (resultSet.next()) {
                etudiants.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, statement, connexion);
        }

        return etudiants;
    }
    
    public static final String SQL_INSERT_Etudiant = "insert into etudiant( `CNE`, `ID_SEMESTER`, `NOM_ETUDIANT`, `PRENOM_ETUDIANT`, `DATE_DE_NAISSANCE`, `EMAIL_ETUDIANT`, `MDP_ETUDIANT`, `CODE_APOGE`,`TEL_ETUDIANT`, `PHOTO_ETUDIANT` ,`ADRESSE_ETUDIANT`)  values(?,?,?,?,?,?,?,?,?,?,?)";
    public void inserer(Etudiant e) throws DAOException
    {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_Etudiant, false,e.getCne(),e.getIdSemester(),e.getNomEtudiant(),e.getPrenomEtudiant(),e.getDateDeNaissance(),e.getEmailEtudiant(),e.getMdpEtudiant(),e.getCodeApoge(),e.getTelEtudiant(),e.getPhotoEtudiant(),e.getAdresseEtudiant());
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            fermeturesSilencieuses(preparedStatement, connexion);
        }

    }
}