package com.GPEA.beans;

import java.io.InputStream;
import java.util.*;

/** @pdOid d8ba2ca9-8360-4cef-b1c2-e0e3cf0dac2c */
public class Etudiant{
   /** @pdOid f6fb50d4-daa1-4ef1-9854-7e73cc0331ba */
   public Long cne;
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
   public Long codeApoge;
   /** @pdOid 4a19a31a-5cdf-4a86-b7d4-c5aa6b888d5e */
   public InputStream photoEtudiant;
   public Long idSemester;
   public String telEtudiant;
   public String adresseEtudiant;
  

    public Etudiant(Long cne,String nomEtudiant, String prenomEtudiant, Date dateDeNaissance,String tel,String adresse, String emailEtudiant, String mdpEtudiant, Long codeApoge, Long idSemester,InputStream photo) {
        this.cne = cne;
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.dateDeNaissance = dateDeNaissance;
        this.telEtudiant = tel;
        this.emailEtudiant = emailEtudiant;
        this.mdpEtudiant = mdpEtudiant;
        this.codeApoge = codeApoge;
        this.idSemester = idSemester;
        this.photoEtudiant = photo;
        this.adresseEtudiant = adresse;
    }

    public String getAdresseEtudiant() {
        return adresseEtudiant;
    }

    public void setAdresseEtudiant(String adresseEtudiant) {
        this.adresseEtudiant = adresseEtudiant;
    }
    
    public Etudiant(long cne, String nomEtudiant, String prenomEtudiant, Date dateDeNaissance, String emailEtudiant, String mdpEtudiant, Long codeApoge, Long idSemester) {
        this.cne = cne;
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.dateDeNaissance = dateDeNaissance;
        this.emailEtudiant = emailEtudiant;
        this.mdpEtudiant = mdpEtudiant;
        this.codeApoge = codeApoge;
        this.idSemester = idSemester;
    }
    
    

    public Etudiant( ) {
        
    }

    public Long getCne() {
        return cne;
    }

    public void setCne(Long cne) {
        this.cne = cne;
    }

    public Long getCodeApoge() {
        return codeApoge;
    }

    public void setCodeApoge(Long codeApoge) {
        this.codeApoge = codeApoge;
    }

    public Long getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(Long idSemester) {
        this.idSemester = idSemester;
    }

    public String getTelEtudiant() {
        return telEtudiant;
    }

    public void setTelEtudiant(String telEtudiant) {
        this.telEtudiant = telEtudiant;
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

    

    public InputStream getPhotoEtudiant() {
        return photoEtudiant;
    }

    public void setPhotoEtudiant(InputStream photoEtudiant) {
        this.photoEtudiant = photoEtudiant;
    }

   
   
   
   

}