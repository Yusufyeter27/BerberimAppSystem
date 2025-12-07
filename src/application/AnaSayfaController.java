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
    private void randevuAlTiklandi(ActionEvent event) {
        Button tiklananButon = (Button) event.getSource();
        String randevuIsmi = tiklananButon.getAccessibleText();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Randevu.fxml"));
            Parent root = loader.load();

            RandevuController randevuController = loader.getController();
            randevuController.setRandevuIsmi(randevuIsmi);

            String kullaniciAdiSoyadi = profiltext.getText();
            randevuController.setKullaniciAdi(kullaniciAdiSoyadi);

            // Sahneyi değiştir
            Stage stage = (Stage) tiklananButon.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void profilimclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profilim.fxml"));
            Parent root = loader.load();

            ProfilimController profilimController = loader.getController();
            profilimController.setKullaniciAdi(profiltext.getText());
            Stage stage = (Stage) profiltext.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Profilim.fxml yüklenemedi.");
        }
    }

    @FXML
    void randevularimclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Randevularim.fxml"));
            Parent root = loader.load();
            RandevularimController controller = loader.getController();
            String adSoyad = profiltext.getText();
            controller.setKullaniciAdi(adSoyad);
            Stage stage = (Stage) profiltext.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("AnaSayfa → Randevularım sayfasına geçildi.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Randevularim.fxml yüklenemedi.");
        }
    }
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
    void initialize() {
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert profiltext != null : "fx:id=\"profiltext\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert randevuAlTiklandi != null : "fx:id=\"randevuAlTiklandi\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert sac != null : "fx:id=\"sac\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
    }
}