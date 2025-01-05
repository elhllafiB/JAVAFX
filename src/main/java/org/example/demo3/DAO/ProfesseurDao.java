package org.example.demo3.DAO;

import org.example.demo3.Entity.Professeur;

import java.util.List;

public interface ProfesseurDao {



    boolean create(Professeur t);
    boolean update(Professeur t);
    boolean delete(Professeur t);
    List<Professeur> getAll();
    Professeur getById(int id);
}

