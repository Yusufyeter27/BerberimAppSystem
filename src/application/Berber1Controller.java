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
import javafx.fxml.FXMLLoader; // FXML yükleyici
import javafx.scene.Parent;   // Yüklenen FXML kök öğesi
import javafx.scene.Scene;    // Sahneyi değiştirmek için
import javafx.stage.Stage;    // Pencereyi (Stage) bulmak için
import java.io.IOException;   // Hata yakalama (try/catch) için
import javafx.scene.Node;     // event.getSource() öğesini dönüştürmek için

public class Berber1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView geributon;

    @FXML
    private Button arabuton;

    @FXML
    private Label berber1isimtext;

    @FXML
    private MenuItem cikisyap;

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
    void geributonclick(MouseEvent event) {
        // Geri butonu (ImageView) tıklandığında BarberRandevu.fxml sayfasına yönlendirme
        try {
            // BarberRandevu.fxml dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/BarberRandevu.fxml"));
            Parent root = loader.load();

            // Mevcut pencereyi (Stage) butondan (Node) yola çıkarak bul
            // MouseEvent'in kaynağı ImageView olduğu için Node'a cast ediyoruz.
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
    void cikisyapclick(ActionEvent event) {
        try {
            // Login.fxml dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
            Parent root = loader.load();

            // MenuItem bir MenuButton'a bağlı olduğu için, Stage'i bu şekilde bulmalıyız.
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
    void profilimclick(ActionEvent event) {

    }

    @FXML
    void randevularimclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert arabuton != null : "fx:id=\"arabuton\" was not injected: check your FXML file 'Berber1.fxml'.";
        assert berber1isimtext != null : "fx:id=\"berber1isimtext\" was not injected: check your FXML file 'Berber1.fxml'.";
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'Berber1.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'Berber1.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'Berber1.fxml'.";
        assert takvim != null : "fx:id=\"takvim\" was not injected: check your FXML file 'Berber1.fxml'.";
    }

}