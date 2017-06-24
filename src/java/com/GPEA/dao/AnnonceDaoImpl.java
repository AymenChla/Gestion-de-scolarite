package com.GPEA.dao;


import com.GPEA.beans.Annonce;
import com.GPEA.beans.Enseignant;
import com.GPEA.beans.Filiere;
import static com.GPEA.dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AnnonceDaoImpl implements AnnonceDao {
    
     private DAOFactory          daoFactory;

    AnnonceDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    private static final String SQL_SELECT_LES_ANNONCES = "SELECT * FROM annonce WHERE Destination = 'enseignant' ORDER BY  DATE_ANNONCE DESC";

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public ArrayList<Annonce> afficherAnnonceEnseignant() throws DAOException {
        
        Connection connexion = null;
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Annonce> annonce = new ArrayList<Annonce>();

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultSet =statement.executeQuery(SQL_SELECT_LES_ANNONCES);
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while(resultSet.next()) {
                annonce.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet,statement, connexion);
        }

        return annonce;
    }
    
    public static Annonce map(ResultSet resultSet) throws SQLException {
        
        Annonce annonce = new Annonce();
        annonce.setIdAnnonce(resultSet.getLong("ID_ANNONCE"));
        annonce.setTitreAnnonce(resultSet.getString("TITRE_ANNONCE"));
        annonce.setDateAnnonce(resultSet.getTimestamp("DATE_ANNONCE"));
        annonce.setAnnonce(resultSet.getString("ANNONCE"));
  
        return annonce;
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

    
    private static final String SQL_PUBLIER_ANNONCE_PROF = "INSERT INTO ANNONCE (ID_ADMIN,ID_ENSEIGNANT,TITRE_ANNONCE,DATE_ANNONCE,ANNONCE,DESTINATION) VALUES (NULL,?,?,NOW(),?,'etudiant')";
    private static final String SQL_DERNIER_ANNONCE = "SELECT ID_ANNONCE FROM ANNONCE ORDER BY ID_ANNONCE DESC";
    private static final String SQL_ID_SEMESTER = "SELECT ID_SEMESTER FROM FILIERE WHERE SEMESTER = ? AND NOM_FILIERE = ?";
    private static final String SQL_INSERT_PUBLIER = "INSERT INTO PUBLIER VALUES(?,?)";
    
    public void posterAnnonceEnseignantToFiliere(Long idEnseignant, String semester,String filiere,String toute, String titreAnnonce, String annonce)throws DAOException{
       
       
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String SQL_PUBLIER = null;
        Long idAnnonce=null;
        Long semester1= null;
        Long idSemester = null;
        
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_PUBLIER_ANNONCE_PROF, false, idEnseignant, titreAnnonce , annonce);
            preparedStatement.executeUpdate();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            preparedStatement = initialisationRequetePreparee(connexion, SQL_DERNIER_ANNONCE, false);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                idAnnonce= resultSet.getLong("ID_ANNONCE") ;
            }
            
            if( toute.equals("yes") ){
                
                SQL_PUBLIER = "INSERT INTO PUBLIER VALUES (?,0)";
                preparedStatement = initialisationRequetePreparee(connexion, SQL_PUBLIER, false,idAnnonce);
                preparedStatement.executeUpdate();
                
            } else {
                
                semester1 = Long.parseLong(semester);
                
                
                preparedStatement = initialisationRequetePreparee(connexion, SQL_ID_SEMESTER, false,semester1,filiere);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {     
                idSemester = resultSet.getLong("ID_SEMESTER") ;
                }
                
                preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_PUBLIER , false, idAnnonce, idSemester);
                preparedStatement.executeUpdate();
                             
            }
               
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

    
        
    }
  private static final String SQL_AFFICHER_ANNONCES_POSTER = "SELECT * FROM ANNONCE WHERE ID_ENSEIGNANT = ? ORDER BY DATE_ANNONCE DESC";
  private static final String SQL_AFFICHRE_FILIERE_POSTER = "SELECT ID_SEMESTER FROM PUBLIER WHERE ID_ANNONCE=?";
  private static final String SQL_AFFICHER_FILIERE = "SELECT * FROM FILIERE WHERE ID_SEMESTER = ?";
  
     @Override
    public ArrayList<Annonce> afficherAnnoncePoster(Long idEnseignant)throws DAOException {
        
        
        Connection connexion = null;
        ResultSet resultSet = null,resultSetNew=null,resultSetNew1=null;
        
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Annonce annonce=null;
        Long idAnnonce=null,idSemester=null;
       // ArrayList<Filiere> filiereList = new ArrayList<Filiere>();
        ArrayList<Annonce> annonceList = new ArrayList<Annonce>();


        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_AFFICHER_ANNONCES_POSTER, false,idEnseignant);
            resultSet = preparedStatement.executeQuery();
            
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
          while(resultSet.next()){

            annonceList.add(map(resultSet));

           }
          
     
   
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet,statement, connexion);
        }

        return annonceList;
        
    }

    @Override
    public ArrayList<Filiere> afficherFilierePoster(Long idEnseignant) throws DAOException {
        
        Connection connexion = null;
        ResultSet resultSet = null,resultSetNew=null,resultSetNew1=null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Annonce annonce=null;
        Long idAnnonce=null,idSemester=null;
       
       ArrayList<Filiere> filiereList = new ArrayList<Filiere>();

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_AFFICHER_ANNONCES_POSTER, false,idEnseignant);
            resultSet = preparedStatement.executeQuery();
            
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
          while(resultSet.next()){
              
            idAnnonce = resultSet.getLong("ID_ANNONCE") ;
            preparedStatement = initialisationRequetePreparee(connexion, SQL_AFFICHRE_FILIERE_POSTER, false,idAnnonce);
            resultSetNew = preparedStatement.executeQuery();
            
            if(resultSetNew.next()){

                idSemester = resultSetNew.getLong("ID_SEMESTER");

                if(idSemester == 0){

                  filiereList.add(null);

                }else{

                    preparedStatement = initialisationRequetePreparee(connexion, SQL_AFFICHER_FILIERE, false,idSemester );
                    resultSetNew1 = preparedStatement.executeQuery();
                    
                        if(resultSetNew1.next()){
                         filiereList.add(mapFiliere(resultSetNew1));
                        }

                }
            }
        }
   
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet,statement, connexion);
        }

        return filiereList;
          
    }
    
        
        
    }
    
   
 
