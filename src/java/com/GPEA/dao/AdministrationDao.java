
package com.GPEA.dao;

import com.GPEA.beans.Administration;
import java.sql.Blob;




public interface AdministrationDao{
    
    Administration trouver(String email,String password);
    Blob getImageBlob(Long id_admin);

}
