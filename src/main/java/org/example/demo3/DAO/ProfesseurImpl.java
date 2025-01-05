package org.example.demo3.DAO;

import org.example.demo3.Entity.Professeur;
import org.example.demo3.Utils.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesseurImpl implements ProfesseurDao {

    private Connection myConnection = DataBaseConnection.getInstance().getConnection();

    @Override
    public boolean create(Professeur professeur) {
        String req = "INSERT INTO professeurs (nom, prenom, specialite) VALUES (?, ?, ?)";
        try (PreparedStatement pr = myConnection.prepareStatement(req)) {
            pr.setString(1, professeur.getNom());
            pr.setString(2, professeur.getPrenom());
            pr.setString(3, professeur.getSpecialite());
            int rowsInserted = pr.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Professeur professeur) {
        String req = "UPDATE professeurs SET nom = ?, prenom = ?, specialite = ? WHERE id = ?";
        try (PreparedStatement pr = myConnection.prepareStatement(req)) {
            pr.setString(1, professeur.getNom());
            pr.setString(2, professeur.getPrenom());
            pr.setString(3, professeur.getSpecialite());
            pr.setInt(4, professeur.getId());
            int rowsUpdated = pr.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Professeur professeur) {
        String req = "DELETE FROM professeurs WHERE id = ?";
        try (PreparedStatement pr = myConnection.prepareStatement(req)) {
            pr.setInt(1, professeur.getId());
            int rowsDeleted = pr.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Professeur> getAll() {
        List<Professeur> professeurs = new ArrayList<>();
        String req = "SELECT * FROM professeurs";
        try (Statement stmt = myConnection.createStatement();
             ResultSet rs = stmt.executeQuery(req)) {
            while (rs.next()) {
                Professeur professeur = new Professeur();
                professeur.setId(rs.getInt("id"));
                professeur.setNom(rs.getString("nom"));
                professeur.setPrenom(rs.getString("prenom"));
                professeur.setSpecialite(rs.getString("specialite"));
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public Professeur getById(int id) {
        String req = "SELECT * FROM professeurs WHERE id = ?";
        try (PreparedStatement pr = myConnection.prepareStatement(req)) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                Professeur professeur = new Professeur();
                professeur.setId(rs.getInt("id"));
                professeur.setNom(rs.getString("nom"));
                professeur.setPrenom(rs.getString("prenom"));
                professeur.setSpecialite(rs.getString("specialite"));
                return professeur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
