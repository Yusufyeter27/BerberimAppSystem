package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarberRandevuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private MenuItem profilim;

    @FXML
    private MenuItem randevularim;

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            // Login ekranını aç
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Giriş Yap");
            newStage.show();

            // Mevcut pencereyi kapatmak için MenuItem bağlı Stage'i bul
            MenuItem source = (MenuItem) event.getSource();
            Stage currentStage = (Stage) cikisyap.getParentPopup().getOwnerWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Login.fxml dosyası yüklenemedi: " + e.getMessage());
        }
    }


    @FXML
    void profilimclick(ActionEvent event) {
        // Profilim tıklama işlemleri buraya
    }

    @FXML
    void randevularimclick(ActionEvent event) {
        // Randevularım tıklama işlemleri buraya
    }

    @FXML
    void emrebutonclick(ActionEvent event) {
        // Emre buton işlemleri buraya
    }

    @FXML
    void kadirbutonclick(ActionEvent event) {
        // Kadir buton işlemleri buraya
    }

    @FXML
    void yusufbutonclick(ActionEvent event) {
        // Yusuf buton işlemleri buraya
    }

    @FXML
    void initialize() {
        assert cikisyap != null : "fx:id=\"cikisyap\" FXML ile bağlanmamış!";
        assert profilim != null : "fx:id=\"profilim\" FXML ile bağlanmamış!";
        assert randevularim != null : "fx:id=\"randevularim\" FXML ile bağlanmamış!";
    }

}
