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
        try {
            // FXML yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/BerberProfilim.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) profilim.getParentPopup().getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("Profilim menüsü BerberProfilim sayfasına yönlendirdi.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("HATA: BerberProfilim.fxml yüklenemedi: " + e.getMessage());
        }
    }



    @FXML
    void randevularimclick(ActionEvent event) {
    }

    @FXML
    void emrebutonclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Berber2.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            System.out.println("Emre butonu Berber2 sayfasına yönlendirdi.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("HATA: Berber2.fxml yüklenemedi: " + e.getMessage());
        }
    }

    @FXML
    void kadirbutonclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Berber3.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            System.out.println("Kadir butonu Berber3 sayfasına yönlendirdi.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("HATA: Berber3.fxml yüklenemedi: " + e.getMessage());
        }
    }

    @FXML
    void yusufbutonclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Berber1.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println("Yusuf butonu Berber1 sayfasına yönlendirdi."); 

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("HATA: Berber1.fxml yüklenemedi: " + e.getMessage()); 
        }
    }
    

    @FXML
    void initialize() {
        assert cikisyap != null : "fx:id=\"cikisyap\" FXML ile bağlanmamış!";
        assert profilim != null : "fx:id=\"profilim\" FXML ile bağlanmamış!";
        assert randevularim != null : "fx:id=\"randevularim\" FXML ile bağlanmamış!";
    }

}