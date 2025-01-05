package org.example.demo3.Service;
import org.example.demo3.DAO.UtilisateurDao;
import org.example.demo3.DAO.UtilisateurImp;
import org.example.demo3.Entity.Utilisateur;

public class UtilisateurService {

    private UtilisateurDao utilisateurDao;

    // Constructeur pour initialiser utilisateurDao
    public UtilisateurService() {
        this.utilisateurDao = new UtilisateurImp();
    }

    public String loging(Utilisateur utilisateur) {
        // Récupérer les informations de l'utilisateur
        String username = utilisateur.getUsername();
        String password = utilisateur.getPassword();
        String role = utilisateur.getRole();
        // Vérifier les informations de connexion
        String result = utilisateurDao.getByNameandPass(username, password, role);
        // Retourner le résultat pour gestion dans le contrôleur
        return result;
    }

}
