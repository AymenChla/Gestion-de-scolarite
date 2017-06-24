package com.GPEA.dao;

import com.GPEA.beans.Filiere;
import java.util.ArrayList;

public interface FiliereDao {

    public ArrayList<Filiere> AfficherLesFiliere() throws DAOException;

}
