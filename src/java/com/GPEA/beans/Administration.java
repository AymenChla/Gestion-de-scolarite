package com.GPEA.beans;

import java.util.*;
import com.GPEA.dao.EtudiantDao;

/** @pdOid b22d5320-5fc5-4a60-8792-3dfadc9d7574 */
public class Administration {
   /** @pdOid 8e128075-4361-4a70-9815-2014210071c3 */
   public Long idAdmin;
   /** @pdOid 63268aac-958a-4411-982e-4ad72ebaa39e */
   public java.lang.String nomAdmin;
   /** @pdOid 89ff0ca0-5e90-4bb0-96aa-2a5920f2bee6 */
   public java.lang.String prenomAdmin;
   /** @pdOid b5912242-529c-4cd1-97d9-bdada2827678 */
   public java.lang.String emailAdmin;
   /** @pdOid ac115935-fb04-413a-a3cc-ce335f911ef3 */
   public java.lang.String mdpAdmin;
   /** @pdOid 25a49ba9-58d2-4d18-977b-c68f54cb684c */
   public java.lang.String photoAdmin;
    
    private EtudiantDao adminDAO;

    public Administration(EtudiantDao adminDAO) {
        this.adminDAO = adminDAO;
    }
    
    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getMdpAdmin() {
        return mdpAdmin;
    }

    public void setMdpAdmin(String mdpAdmin) {
        this.mdpAdmin = mdpAdmin;
    }

    public String getPhotoAdmin() {
        return photoAdmin;
    }

    public void setPhotoAdmin(String photoAdmin) {
        this.photoAdmin = photoAdmin;
    }
   
  

}