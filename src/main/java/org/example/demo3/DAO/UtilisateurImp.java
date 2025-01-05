package org.example.demo3.DAO;

import org.example.demo3.Entity.Professeur;
import org.example.demo3.Entity.Utilisateur;
import org.example.demo3.Utils.DataBaseConnection;

import java.sql.*;
import java.util.List;

public class UtilisateurImp implements UtilisateurDao {

    private Connection myConnection = DataBaseConnection.getInstance().getConnection();

    @Override
    public String getByNameandPass(String nom, String pass, String roleA) {
        try {
            String req = "SELECT * FROM utilisateurs WHERE username = ? AND password = ? AND role = ?";
            PreparedStatement pr = myConnection.prepareStatement(req);
            pr.setString(1, nom);
            pr.setString(2, pass);
            pr.setString(3, roleA);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return "utilisateur existe";
            } else {
                return "n existe pas";
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            throw new RuntimeException("Erreur lors de la vérification des informations d'utilisateur.", e);
        }
    }
}
