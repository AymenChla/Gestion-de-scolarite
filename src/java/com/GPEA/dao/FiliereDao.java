package com.GPEA.dao;

import com.GPEA.beans.Filiere;
import java.util.ArrayList;

public interface FiliereDao {

    public ArrayList<Filiere> AfficherLesFiliere() throws DAOException;
    public Filiere getFiliereEtudiant(Long idSemester) throws DAOException;
}
