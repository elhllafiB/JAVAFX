package org.example.demo3.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.demo3.Entity.Utilisateur;
import org.example.demo3.Service.UtilisateurService;

import java.io.IOException;

public class LoginController {

    private UtilisateurService utilisateurService;

    public LoginController() {
        this.utilisateurService = new UtilisateurService();
    }

    @FXML
    private TextField nomUtilisateur;

    @FXML
    private PasswordField motDePasse;

    @FXML
    private ComboBox<String> roleSelector;

    @FXML
    private Button btnConnexion;

    @FXML
    public void handleLoginButtonAction() {
        String username = nomUtilisateur.getText();
        String password = motDePasse.getText();
        String role = roleSelector.getValue();

        // Validation des champs
        if (username.isEmpty() || password.isEmpty() || role == null || role.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs.");
            return;
        }

        // Création de l'objet utilisateur
        Utilisateur utilisateur = new Utilisateur(username, password, role);

        // Appeler le service pour vérifier les informations de connexion
        String result = utilisateurService.loging(utilisateur);

        // Gestion du résultat
        if (result.equals("utilisateur existe")) {
//            showAlert("Succès", "Connexion réussie !");

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/demo3/hello-view.fxml"));
                Scene newScene = new Scene(fxmlLoader.load());

                // Obtenir le Stage actuel et changer la scène
                Stage currentStage = (Stage) btnConnexion.getScene().getWindow();
                currentStage.setScene(newScene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            showAlert("Erreur", "Nom d'utilisateur, mot de passe ou rôle incorrect.");
        }

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}