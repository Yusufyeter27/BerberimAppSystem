package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RandevuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text RandevuIsmi;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private ToggleGroup personelgrup;

    @FXML
    private MenuItem profilim;

    @FXML
    private DatePicker randevuTarihi;

    @FXML
    private Label randevuisimtext;

    public void setRandevuIsmi(String islemAdi) { //RandevuController
        RandevuIsmi.setText(islemAdi); // Görselde göster
        RandevuIsmi.setAccessibleText(islemAdi); // Erişilebilirlik için
    }
    @FXML
    private MenuItem randevularim;

    // Kullanıcı adını set etmek için metod
    public void setKullaniciAdi(String adSoyad) {
        randevuisimtext.setText(adSoyad);
    }

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            // Login sayfasına geçiş
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((MenuItem)event.getSource())
                    .getParentPopup().getOwnerWindow();

            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Randevu sayfasını açarken kullanıcı adı gönderen metot
    public void randevuSayfasiAc(String kullaniciAdi) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Randevu.fxml"));
            Parent root = loader.load();

            // Controller'ı al ve kullanıcı adını gönder
            RandevuController randevuController = loader.getController();
            randevuController.setKullaniciAdi(kullaniciAdi);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void profilimclick(ActionEvent event) {
        // Profilim tıklandığında yapılacaklar
    }

    @FXML
    void randevularimclick(ActionEvent event) {
        // Randevularım tıklandığında yapılacaklar
    }

    @FXML
    void initialize() {
        assert RandevuIsmi != null : "fx:id=\"RandevuIsmi\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert personelgrup != null : "fx:id=\"personelgrup\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert randevuTarihi != null : "fx:id=\"randevuTarihi\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert randevuisimtext != null : "fx:id=\"randevuisimtext\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'Randevu.fxml'.";
    }
}