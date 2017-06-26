package com.GPEA.dao;



import com.GPEA.beans.Filiere;
import static com.GPEA.dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
;


public class FiliereDaoImpl implements FiliereDao {
     
     private DAOFactory          daoFactory;

    FiliereDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    private static final String SQL_SELECT_FILIERE = "SELECT * FROM Filiere";

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    
    @Override
    public ArrayList<Filiere> AfficherLesFiliere() throws DAOException {
        
        Connection connexion = null;
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Filiere> filiereList = new ArrayList<Filiere>();

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultSet =statement.executeQuery(SQL_SELECT_FILIERE);
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while(resultSet.next()) {
                filiereList.add(mapFiliere(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet,statement, connexion);
        }

        return filiereList;
    }
       public static Filiere mapFiliere(ResultSet resultSet)throws SQLException{
    
        Filiere filiere = new Filiere();
        filiere.setIdSemester(resultSet.getLong("ID_SEMESTER"));
        filiere.setIdEmplois(resultSet.getLong("ID_EMPLOIS"));
        filiere.setNomFiliere(resultSet.getString("NOM_FILIERE"));
        filiere.setNomFormation(resultSet.getString("NOM_FORMATION"));
        filiere.setSemester(resultSet.getString("SEMESTER"));
        filiere.setChefDeFiliere(resultSet.getLong("CHEF_DE_FILIERE"));
        
        return filiere;
    }

    private static final String SQL_SELECT_FILIERE_ETUDIANT = "SELECT * FROM Filiere where ID_SEMESTER = ?";
    public Filiere getFiliereEtudiant(Long idSemester) throws DAOException
    {
        Connection connexion = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Filiere filiere = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_FILIERE_ETUDIANT, false, idSemester);
            resultSet =preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if(resultSet.next()) {
                filiere = mapFiliere(resultSet);
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet,preparedStatement, connexion);
        }

        return filiere;
    }
}