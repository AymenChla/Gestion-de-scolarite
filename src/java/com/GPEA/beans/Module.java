
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asus pro
 */
public class Module {
      public Long idModule;
   public Long idEnseignant;
   public Long idSemester;
   

   /** @pdOid 8f086821-08c0-4fad-99d5-2e2d168c5c01 */
   public java.lang.String nomModule;
   /** @pdOid 28daaccc-42eb-4f44-b448-31e6dce0f444 */
   public int nombreD_heure;

   public Date debutEnseignement;
   public int nombreElement;

    public int getNombreElement() {
        return nombreElement;
    }

    public void setNombreElement(int nombre_element) {
        this.nombreElement = nombre_element;
    }
   
    public String getYear(){
        SimpleDateFormat f =  new SimpleDateFormat("YYYY");
        return f.format(this.debutEnseignement);
    
    }

    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public Long getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Long getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(Long idSemester) {
        this.idSemester = idSemester;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public int getNombreD_heure() {
        return nombreD_heure;
    }

    public void setNombreD_heure(int nombreD_heure) {
        this.nombreD_heure = nombreD_heure;
    }

    public Date getDebutEnseignement() {
        return debutEnseignement;
    }

    public void setDebutEnseignement(Date debutEnseignement) {
        this.debutEnseignement = debutEnseignement;
    }
}

