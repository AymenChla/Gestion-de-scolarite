package com.GPEA.beans;

import java.util.*;

/** @pdOid d8ba2ca9-8360-4cef-b1c2-e0e3cf0dac2c */
public class Etudiant{
   /** @pdOid f6fb50d4-daa1-4ef1-9854-7e73cc0331ba */
   public long cne;
   /** @pdOid e4348753-96ab-4762-a432-205229dab8ed */
   public java.lang.String nomEtudiant;
   /** @pdOid 670db404-c631-4977-adde-0d29c56daa2d */
   public java.lang.String prenomEtudiant;
   /** @pdOid 7773c539-6e00-44fd-a677-16b4abe94f61 */
   public java.util.Date dateDeNaissance;
   /** @pdOid 9603c45f-2f1f-4748-85d7-322002e998ed */
   public java.lang.String emailEtudiant;
   /** @pdOid 1aa16c09-efad-4bdd-a1e3-0296d115b440 */
   public java.lang.String mdpEtudiant;
   /** @pdOid 62735eb7-2f6f-4b7d-924c-2c39a23a0b30 */
   public long codeApoge;
   /** @pdOid 4a19a31a-5cdf-4a86-b7d4-c5aa6b888d5e */
   public java.lang.String photoEtudiant;


    public Etudiant(long cne, String nomEtudiant, String prenomEtudiant, Date dateDeNaissance, String emailEtudiant, String mdpEtudiant, long codeApoge, long idFiliere) {
        this.cne = cne;
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.dateDeNaissance = dateDeNaissance;
        this.emailEtudiant = emailEtudiant;
        this.mdpEtudiant = mdpEtudiant;
        this.codeApoge = codeApoge;
        this.idFiliere = idFiliere;
    }
    
    

    public Etudiant( ) {
        
    }
    public long getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }
   
   public long idFiliere;
   
    public long getCne() {
        return cne;
    }

    public void setCne(long cne) {
        this.cne = cne;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmailEtudiant() {
        return emailEtudiant;
    }

    public void setEmailEtudiant(String emailEtudiant) {
        this.emailEtudiant = emailEtudiant;
    }

    public String getMdpEtudiant() {
        return mdpEtudiant;
    }

    public void setMdpEtudiant(String mdpEtudiant) {
        this.mdpEtudiant = mdpEtudiant;
    }

    public long getCodeApoge() {
        return codeApoge;
    }

    public void setCodeApoge(long codeApoge) {
        this.codeApoge = codeApoge;
    }

    public String getPhotoEtudiant() {
        return photoEtudiant;
    }

    public void setPhotoEtudiant(String photoEtudiant) {
        this.photoEtudiant = photoEtudiant;
    }

   
   
   
   

}