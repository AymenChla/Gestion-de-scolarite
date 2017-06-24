
package com.GPEA.dao;


import com.GPEA.beans.Module;
import static com.GPEA.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.GPEA.dao.DAOUtilitaire.initialisationRequetePreparee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ModuleDaoImpl implements ModuleDao{
    
    private DAOFactory          daoFactory;

    ModuleDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    private static final String SQL_SELECT_MODULE_PROF = "SELECT * FROM module WHERE id_enseignant = ?";
    public ArrayList<Module>  getModulesEnseignant( Long idEnseignant ) throws DAOException{
        
        
        Connection connexion = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Module> modules = new ArrayList<Module>();
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion,SQL_SELECT_MODULE_PROF,false,idEnseignant);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while(resultSet.next()) {
                modules.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet,preparedStatement , connexion);
        }

        return modules;
        
    }
    
    public static Module map(ResultSet resultSet) throws SQLException {
        
        Module module = new Module();
        module.setIdModule(resultSet.getLong("ID_MODULE"));
        module.setIdEnseignant(resultSet.getLong("ID_ENSEIGNANT"));
        module.setIdSemester(resultSet.getLong("ID_SEMESTER"));
        module.setNomModule(resultSet.getString("NOM_MODULE"));
        module.setNombreElement(resultSet.getInt("NOMBRE_ELEMENT"));
        module.setDebutEnseignement(resultSet.getDate("DEBUT_ENSEIGNEMENT"));
        
        return module;
    }
    
    
    private static final String SQL_SELECT_NOM_FILIERE = "SELECT DISTINCT NOM_FILIERE FROM filiere f,module m WHERE f.id_semester = m.id_semester and m.id_enseignant = ? and m.nom_module=?;";
    //put this in filiereDao when created
    public String getNomFiliere(Long idEnseignant, String nomModule)
    {
        Connection connexion = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String nom_filiere = "";
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion,SQL_SELECT_NOM_FILIERE,false,idEnseignant,nomModule);
            resultSet = preparedStatement.executeQuery();
            
            //just for look ex: iwim-gl
            if(resultSet.next())
                nom_filiere =  resultSet.getString("NOM_FILIERE");
            while(resultSet.next()) {
                nom_filiere =  nom_filiere + "-" + resultSet.getString("NOM_FILIERE")   ;
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet,preparedStatement , connexion);
        }

        return nom_filiere;
    }
    
}
