/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GPEA.forms;

import com.GPEA.dao.EnseignantDao;
import com.GPEA.dao.EtudiantDao;
import com.GPEA.dao.MessageDao;

/**
 *
 * @author Youssef
 */
public class GestionMessage {
    
    private EtudiantDao etudiantDao;
    private MessageDao messageDao;
    private EnseignantDao enseignantDao;
    
     public GestionMessage( MessageDao messageDao ,EnseignantDao enseignantDao) {
        this.enseignantDao = enseignantDao;
        this.messageDao = messageDao;
    }
     public GestionMessage(MessageDao messageDao ,EtudiantDao etudiantDao){
         
         this.etudiantDao = etudiantDao;
         this.messageDao = messageDao;
     }
     
    
     public void envoyerMessageProfToAdmin(Long idEnseignant,String msg ,String objetMessage){
         
        
         
         this.messageDao.envoyerMsgProfToAdmin(idEnseignant, msg, objetMessage);
 
     }
}
