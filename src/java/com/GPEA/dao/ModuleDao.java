
package com.GPEA.dao;

import com.GPEA.beans.Module;
import java.util.ArrayList;

public interface ModuleDao {
    
    ArrayList<Module>  getModulesEnseignant( Long idEnseignant ) throws DAOException;
    public String getNomFiliere(Long idEnseignant, String nomModule);
}
