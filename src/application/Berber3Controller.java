package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class Berber3Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button arabuton;

    @FXML
    private Label berber3isimtext;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private ImageView geributon;

    @FXML
    private MenuItem profilim;

    @FXML
    private MenuItem randevularim;

    @FXML
    private DatePicker takvim;

    @FXML
    void arabutonclick(ActionEvent event) {
        // Arama işlevi buraya gelecek
    }

    @FXML
    void cikisyapclick(ActionEvent event) {
        // Çıkış Yap -> Login.fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
            Parent root = loader.load();

            // MenuItem'ın ait olduğu pencereyi (Stage) bul
            Stage stage = (Stage) ((MenuItem)event.getSource())
                    .getParentPopup().getOwnerWindow();

            // Sahneyi değiştir
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            System.out.println("Başarıyla çıkış yapıldı ve Login ekranına yönlendirildi.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("HATA: Login ekranına geçiş yapılamadı: " + e.getMessage());
        }
    }

    @FXML
    void geributonclick(MouseEvent event) {
        // Geri Butonu -> BarberRandevu.fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/BarberRandevu.fxml"));
            Parent root = loader.load();

            // Mevcut pencereyi (Stage) butondan (Node) yola çıkarak bul
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Sahneyi değiştir
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            System.out.println("Geri butonuna tıklandı ve BarberRandevu ekranına yönlendirildi.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("HATA: BarberRandevu.fxml yüklenemedi: " + e.getMessage());
        }
    }

    @FXML
    void profilimclick(ActionEvent event) {
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/BerberProfilim.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((MenuItem) event.getSource())
                    .getParentPopup().getOwnerWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("Profilim sayfasına geçildi.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("HATA: BerberProfilimController.fxml yüklenemedi: " + e.getMessage());
        }
    }

    @FXML
    void randevularimclick(ActionEvent event) {
        // Randevularım işlevi buraya gelecek
    }

    @FXML
    void initialize() {
        assert arabuton != null : "fx:id=\"arabuton\" was not injected: check your FXML file 'Berber3.fxml'.";
        assert berber3isimtext != null : "fx:id=\"berber3isimtext\" was not injected: check your FXML file 'Berber3.fxml'.";
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'Berber3.fxml'.";
        assert geributon != null : "fx:id=\"geributon\" was not injected: check your FXML file 'Berber3.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'Berber3.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'Berber3.fxml'.";
        assert takvim != null : "fx:id=\"takvim\" was not injected: check your FXML file 'Berber3.fxml'.";

    }

}