package com.GPEA.beans;
import java.text.SimpleDateFormat;


import java.util.*;

/** @pdOid b16a9065-e275-4eae-9f7c-bef49caa6388 */
public class Annonce {
   /** @pdOid 41ac75dc-024a-4373-8d26-1786de6a1b25 */
   public Long idAnnonce;
   /** @pdOid 5a50bb68-6da9-4869-9064-7dd897de1395 */
   public java.lang.String titreAnnonce;
   /** @pdOid 5b5a7bba-2c80-438a-beca-7fed5340b24d */
   public java.util.Date dateAnnonce;
   /** @pdOid f24f4f08-d628-4151-a85d-567cdc6a3157 */
   public java.lang.String annonce;
   
   /** @pdRoleInfo migr=no name=Filiere assc=publier coll=java.util.Collection impl=java.util.HashSet mult=1..* side=A */
   public java.util.Collection<Filiere> filiere;

    public long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getTitreAnnonce() {
        return titreAnnonce;
    }

    public void setTitreAnnonce(String titreAnnonce) {
        this.titreAnnonce = titreAnnonce;
    }

    public Date getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Date dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

    public String getAnnonce() {
        return annonce;
    }

    public void setAnnonce(String annonce) {
        this.annonce = annonce;
    }

    public Collection<Filiere> getFiliere() {
        return filiere;
    }

    public void setFiliere(Collection<Filiere> filiere) {
        this.filiere = filiere;
    }
    
    public String getMonthName(){
        
       SimpleDateFormat f = new SimpleDateFormat("MMMM");
       return f.format(this.getDateAnnonce());
               
    }
    
    public String getDay(){
        
        SimpleDateFormat f =  new SimpleDateFormat("dd");
        return f.format(this.getDateAnnonce());
    
    }
    public String getYear(){
        SimpleDateFormat f =  new SimpleDateFormat("YYYY");
        return f.format(this.getDateAnnonce());
    
    }
    
    public String getTime(){
        SimpleDateFormat f =  new SimpleDateFormat("H");
        SimpleDateFormat f1 = new SimpleDateFormat("m");
        SimpleDateFormat f2 = new SimpleDateFormat("s");
        
        return f.format(this.getDateAnnonce())+":"+f1.format(this.getDateAnnonce())+":"+f2.format(this.getDateAnnonce());
    
    }
    public String getFullDate(){
    
        return getDay()+"-"+getMonthName()+"-"+getYear()+" "+getTime();
    }
   
   
   
}