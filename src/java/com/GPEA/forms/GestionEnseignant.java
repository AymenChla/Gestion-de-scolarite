
package com.GPEA.forms;

import com.GPEA.beans.Module;
import com.GPEA.beans.Enseignant;
import com.GPEA.dao.EnseignantDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.GPEA.dao.ModuleDao;





public class GestionEnseignant {
     private EnseignantDao enseignantDao;
     private ModuleDao moduleDao;
       
    public GestionEnseignant(EnseignantDao enseignantDao)
    {
        this.enseignantDao = enseignantDao;
    }
    
     public GestionEnseignant( EnseignantDao enseignantDao, ModuleDao moduleDao) {
        this.enseignantDao = enseignantDao;
        this.moduleDao = moduleDao;
    }
     
     public ArrayList<Enseignant> getAllEnseignant()
     {
        return this.enseignantDao.getAllEnseignant();
     }
     
     public Enseignant getEnseignant(Long idEnseignant)
     {
         return this.enseignantDao.trouver(idEnseignant);
     }
     
     public ArrayList<Module> getModules(Long idEnseignant)
     {
         return this.moduleDao.getModulesEnseignant(idEnseignant);
     }
     
     public HashMap<Module,String> getMapFiliereModule(ArrayList<Module> modules)
     {
        HashMap<Module,String> mapFiliereModule = new HashMap<Module,String>();
       
        for(Module module : modules)
        {
            mapFiliereModule.put(module,this.moduleDao.getNomFiliere(module.getIdEnseignant(),module.getNomModule()));
        }
       
        return mapFiliereModule;
     }
     
     public void insererEnseignant(Enseignant enseignant)
     {
         this.enseignantDao.inserer(enseignant);
     }
}
