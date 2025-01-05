package org.example.demo3.Entity;




public class Professeur {

    private int id;
    private String nom;
    private String prenom;
    private String specialite;


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
