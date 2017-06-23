package com.GPEA.beans;



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
   private java.lang.String photoEnseignant;
   
   
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

    public String getPhotoEnseignant() {
        return photoEnseignant;
    }

    /** @pdOid de91cc7c-66d7-4bae-bb7a-54d3b5ae5e08 */
    public void setPhotoEnseignant(String photoEnseignant) {
        this.photoEnseignant = photoEnseignant;
    }

   
  
}