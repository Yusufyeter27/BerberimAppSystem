package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class AnaSayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private MenuItem profilim;

    @FXML
    private Label profiltext;
    public void setProfilText(String adSoyad) {
        profiltext.setText(adSoyad);
    }

    @FXML
    private Button randevuAlTiklandi;

    @FXML
    private MenuItem randevularim;

    @FXML
    private Label sac;

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) profiltext.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Çıkış Yapılamadı.");
        }
    }


    @FXML
    void profilimclick(ActionEvent event) {

    }

    @FXML
    void randevuAlTiklandi(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Randevu.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: randevulara giris Yapılamadı.");
        }
    }

    @FXML
    void randevularimclick(ActionEvent event) {

    }


    @FXML
    void initialize() {
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert profiltext != null : "fx:id=\"profiltext\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert randevuAlTiklandi != null : "fx:id=\"randevuAlTiklandi\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert sac != null : "fx:id=\"sac\" was not injected: check your FXML file 'AnaSayfa.fxml'.";

    }

}
