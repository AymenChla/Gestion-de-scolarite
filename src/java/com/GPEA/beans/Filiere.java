package com.GPEA.beans;
import java.util.*;

/** @pdOid 294d6713-0bad-4f2b-8b8f-a44896ae16b2 */
public class Filiere {
   /** @pdOid cdbca634-b410-412f-a99b-ca9381612063 */
   public Long idSemester;
   /** @pdOid 4a83c493-a6bd-42fa-9551-d24bc0029437 */
    public Long idEmplois;
    
   public java.lang.String nomFiliere;
   /** @pdOid a838f9e3-0119-4523-a2c5-db7c7ff93e8c */
   public java.lang.String nomFormation;
   /** @pdOid c9b8c8e3-5a0a-41a1-b346-4b82e8daf5c9 */
  
   /** @pdOid 58729887-6f30-4d63-a12d-f701b6933ffd */
   public java.lang.String semester;
   /** @pdOid d5b02eb6-0e31-4da2-b8ce-0e6a29900599 */
   public Long chefDeFiliere;
   
   /** @pdRoleInfo migr=no name=Etudiant assc=comporte coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Etudiant> etudiant;
   /** @pdRoleInfo migr=no name=Module assc=avoir coll=java.util.Collection impl=java.util.HashSet mult=1..* side=A */
   public java.util.Collection<Module> module;

    public Long getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(Long idSemester) {
        this.idSemester = idSemester;
    }
    
    public Long getIdEmplois(){
        return idEmplois;
    }
    public void setIdEmplois(Long idEmplois) {
        this.idEmplois= idEmplois;
    }
    

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }



    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public long getChefDeFiliere() {
        return chefDeFiliere;
    }

    public void setChefDeFiliere(long chefDeFiliere) {
        this.chefDeFiliere = chefDeFiliere;
    }

    public Collection<Etudiant> getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Collection<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

    public Collection<Module> getModule() {
        return module;
    }

    public void setModule(Collection<Module> module) {
        this.module = module;
    }
   
  
}