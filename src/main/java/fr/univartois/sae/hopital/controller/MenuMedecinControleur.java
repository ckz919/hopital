package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe qui représente le contrôleur du menu médecins.
 */
public class MenuMedecinControleur implements IHopitalControleur {
    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * Composant représentant le bouton d'ajout de médecin.
     */
    @FXML
    private Button boutonAfficherMedecin;

    /**
     * Permet de définir l'hôpital contrôlé.
     *
     * @param hopital L'hôpital contrôlé.
     */
    @Override
    public void setHopital(Hopital hopital) {
        this.hopital = hopital;

        boutonAfficherMedecin.disableProperty().bind(hopital.getNbMedecins().isEqualTo(0));
    }

    /**
     * Permet de définir la fenêtre de l'application.
     *
     * @param stage La fenêtre de l'application.
     */
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Renvoie l'utilisateur sur le menu d'affichages des médecins.
     *
     * @throws IOException Si le fichier FXML n'est pas trouvé.
     */
    @FXML
    void onAfficherMedecinsButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-selection-medecin.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuSelectionnerMedecinControleur menuAfficherMedecinControleur = fxmlLoader.getController();
        menuAfficherMedecinControleur.setStage(stage);
        menuAfficherMedecinControleur.setHopital(hopital);
        menuAfficherMedecinControleur.setListeMedecins();

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    /**
     * Renvoie l'utilisateur sur le menu d'ajout de médecin.
     *
     * @throws IOException Si le fichier FXML n'est pas trouvé.
     */
    @FXML
    void onAjouterMedecinButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-ajouter-medecin.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuAjouterMedecinControleur menuAjoutMedecinControleur = fxmlLoader.getController();
        menuAjoutMedecinControleur.setStage(stage);
        menuAjoutMedecinControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    /**
     * Renvoie l'utilisateur sur le menu principal.
     */
    @FXML
    void onRetourButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-principal.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuPrincipalControleur menuPrincipalControleur = fxmlLoader.getController();
        menuPrincipalControleur.setStage(stage);
        menuPrincipalControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }
}
