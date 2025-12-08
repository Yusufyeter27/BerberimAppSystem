package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
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

public class Berber1Controller {

    // KALDANMIŞTIR: Hata veren Label'lar (Bu Label'lar FXML'de bağlı değilse NullPointerException verir)
    /* @FXML private Label musteriLabel; 
    @FXML private Label tarihLabel; 
    @FXML private Label saatLabel; 
    @FXML private Label hizmetLabel; 
    */

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
    private Label labelhizmet;

    @FXML
    private Label labelhizmet1;

    @FXML
    private Label labelhizmet2;

    @FXML
    private Label labelhizmet3;

    @FXML
    private Label labelhizmet4;

    @FXML
    private Label labelmusteri;

    @FXML
    private Label labelmusteri1;

    @FXML
    private Label labelmusteri2;

    @FXML
    private Label labelmusteri3;

    @FXML
    private Label labelmusteri4;

    @FXML
    private Label labelsaat;

    @FXML
    private Label labelsaat1;

    @FXML
    private Label labelsaat2;

    @FXML
    private Label labelsaat3;

    @FXML
    private Label labelsaat4;

    @FXML
    private Label labeltarih;

    @FXML
    private Label labeltarih1;

    @FXML
    private Label labeltarih2;

    @FXML
    private Label labeltarih3;

    @FXML
    private Label labeltarih4;

    @FXML
    private MenuItem randevularim;

    @FXML
    private DatePicker takvim;

    
    // HATA VEREN METOT KISMI YORUM SATIRI YAPILDI / KALDIRILDI
    /*
    private void loadRandevu() {
        // ... (Bu metot içindeki musteriLabel.setText(data[0]); gibi satırlar null olduğu için hata veriyordu.)
    }
    */


    // BUTONLAR
    @FXML
    void arabutonclick(ActionEvent event) {
        // Arama işlevi sonra eklenecek
    }

    @FXML
    void geributonclick(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/BarberRandevu.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("Geri butonuna tıklandı ve BarberRandevu ekranına geçildi.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("HATA: BarberRandevu.fxml yüklenemedi: " + e.getMessage());
        }
    }

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((MenuItem) event.getSource())
                    .getParentPopup().getOwnerWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("Başarıyla çıkış yapıldı.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("HATA: Login ekranına geçilemedi: " + e.getMessage());
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
        // Randevular sayfası sonra eklenecek
    }


    // === JAVA FX INITIALIZE ===
    @FXML
    void initialize() {

        // HATA VEREN loadRandevu() çağrısı kaldırıldı.
        // loadRandevu(); 

        assert arabuton != null : "fx:id=\"arabuton\" was not injected.";
        assert berber1isimtext != null : "fx:id=\"berber1isimtext\" was not injected.";
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected.";
        assert profilim != null : "fx:id=\"profilim\" was not injected.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected.";
        assert takvim != null : "fx:id=\"takvim\" was not injected.";
    }

}