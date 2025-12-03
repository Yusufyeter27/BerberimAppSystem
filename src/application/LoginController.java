package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleButton berbergirisi;

    @FXML
    private Button girisbutton;

    @FXML
    private TextField giriskullaniciadi;

    @FXML
    private PasswordField girissifre;

    @FXML
    private Button kayitolbutton;

    @FXML
    private ToggleGroup loginGroup;

    @FXML
    private ToggleButton musterigirisi;

    @FXML
    void berbergirisiClick(ActionEvent event) {

    }

    @FXML
    void girisYapClick(ActionEvent event) {
    	try {
            // 1. Yeni FXML dosyasını yükle
            // Dosya yoluna dikkat: /fxml/AnaSayfa.fxml (Senin klasör yapına göre)
            Parent root = FXMLLoader.load(getClass().getResource("/application/AnaSayfa.fxml"));
            
            // 2. Şu anki Sahneyi (Stage) al
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // 3. Yeni sahneyi oluştur ve pencereye koy
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            System.out.println("Giriş başarılı, ana sayfaya yönlendirildi.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Sayfa yüklenemedi! Dosya yolunu kontrol et.");
        }

    }

    @FXML
    void kayıtOlClick(ActionEvent event) {
    	try {
            // 1. Yeni FXML dosyasını yükle
            // Dosya yoluna dikkat: /fxml/AnaSayfa.fxml (Senin klasör yapına göre)
            Parent root = FXMLLoader.load(getClass().getResource("/application/kayıt.fxml"));
            
            // 2. Şu anki Sahneyi (Stage) al
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // 3. Yeni sahneyi oluştur ve pencereye koy
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            System.out.println("Kayıt ol sayfasına yönlendirildi.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Sayfa yüklenemedi! Dosya yolunu kontrol et.");
        }

    }


    @FXML
    void musterigirisiClick(ActionEvent event) {

    }

}
