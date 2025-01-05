package org.example.demo3.Service;

import org.example.demo3.DAO.ProfesseurDao;
import org.example.demo3.Entity.Professeur;

import java.util.List;

public class ProfesseurService {


    private ProfesseurDao professeurDao;

    public void setProfesseurDao(ProfesseurDao professeurDao) {
        this.professeurDao = professeurDao;
    }

    public boolean addArticle(Professeur article) {
        // Additional business logic can be added here
        return professeurDao.create(article);
    }

    public List<Professeur> getAllArticles() {
        return professeurDao.getAll();
    }

    public boolean updateArticle(Professeur article) {
        return professeurDao.update(article);
    }

    public boolean deleteArticle(Professeur article) {
        return professeurDao.delete(article);
    }










}
