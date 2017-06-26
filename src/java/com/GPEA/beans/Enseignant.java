package com.GPEA.beans;



import java.io.InputStream;
import java.util.*;

/** @pdOid 24780a32-15be-4d7a-94aa-41a938002147 */
public class Enseignant {

    

   private Long idEnseignant;
   /** @pdOid 2edb3c92-643c-470f-ad66-453d69c1b64c */
   private java.lang.String nomEnseignant;
   /** @pdOid 69e254bd-66d1-4ac1-b6f4-8f4b0476c17f */
   private java.lang.String prenomEnseignant;
   /** @pdOid 41e43077-5ea9-4f2e-aa1b-a62c1f3c381d */
   private java.util.Date dateDeNaissance;
   /** @pdOid 09381db6-23b0-4e57-8e0c-0f70175c5752 */
   private java.lang.String emailEnseignant;
   /** @pdOid 60b64776-20e9-4ad4-86c5-9f9558ecc3c3 */
   private java.lang.String mdpEnseignat;
   /** @pdOid 78b0db24-8694-4773-8ab4-70d3f776d9f0 */
   private java.lang.String departementEnseignant;
   /** @pdOid 831b1495-a25a-490f-b714-1951295e5f55 */
   private InputStream photoEnseignant;

   private java.lang.String adresseEnseignant;
   private java.lang.String TelEnseignant;
   private java.lang.String SpecialiteEnseignant;
   
   public Enseignant()
   {
       
   }
   public Enseignant(Long id,String nom,String prenom,String tel,String email,String adresse,String specialites , String departement)
   {
       this.idEnseignant = id;
       this.nomEnseignant = nom;
       this.prenomEnseignant = prenom;
       this.TelEnseignant = tel;
       this.emailEnseignant = email;
       this.SpecialiteEnseignant = specialites;
       this.departementEnseignant = departement;
       this.adresseEnseignant = adresse;
   }
   
    public Enseignant(String nom,String prenom,String email,String password,String tel,Date date,String adresse,String specialites , String departement, InputStream photo)
   {
       this.nomEnseignant = nom;
       this.prenomEnseignant = prenom;
       this.TelEnseignant = tel;
       this.emailEnseignant = email;
       this.SpecialiteEnseignant = specialites;
       this.dateDeNaissance = date;
       this.departementEnseignant = departement;
       this.adresseEnseignant = adresse;
       this.photoEnseignant = photo;
       this.mdpEnseignat = password;
   }
    
    public String getSpecialiteEnseignant() {
        return SpecialiteEnseignant;
    }

    public void setSpecialiteEnseignant(String SpecialiteEnseignant) {
        this.SpecialiteEnseignant = SpecialiteEnseignant;
    }
   
    public String getTelEnseignant() {
        return TelEnseignant;
    }

    public void setTelEnseignant(String TelEnseignant) {
        this.TelEnseignant = TelEnseignant;
    }
   
   
    public String getAdresseEnseignant() {
        return adresseEnseignant;
    }

    public void setAdresseEnseignant(String adresseEnseignant) {
        this.adresseEnseignant = adresseEnseignant;
    }
   

   
   
   public Long getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public String getPrenomEnseignant() {
        return prenomEnseignant;
    }

    public void setPrenomEnseignant(String prenomEnseignant) {
        this.prenomEnseignant = prenomEnseignant;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmailEnseignant() {
        return emailEnseignant;
    }

    public void setEmailEnseignant(String emailEnseignant) {
        this.emailEnseignant = emailEnseignant;
    }

    public String getMdpEnseignat() {
        return mdpEnseignat;
    }

    public void setMdpEnseignat(String mdpEnseignat) {
        this.mdpEnseignat = mdpEnseignat;
    }

    public String getDepartementEnseignant() {
        return departementEnseignant;
    }

    public void setDepartementEnseignant(String departementEnseignant) {
        this.departementEnseignant = departementEnseignant;
    }

    public InputStream getPhotoEnseignant() {
        return photoEnseignant;
    }

    /** @pdOid de91cc7c-66d7-4bae-bb7a-54d3b5ae5e08 */
    public void setPhotoEnseignant(InputStream photoEnseignant) {
        this.photoEnseignant = photoEnseignant;
    }

   
  
}