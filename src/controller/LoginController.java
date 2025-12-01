package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;

import java.awt.TextField;
import java.io.IOException;
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
    private ToggleGroup loginGroup;
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField textField;

    @FXML
    void girisYapClick(ActionEvent event) {
    	try {
            // 1. Yeni FXML dosyasını yükle
            // Dosya yoluna dikkat: /fxml/AnaSayfa.fxml (Senin klasör yapına göre)
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AnaSayfa.fxml"));
            
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
    void initialize() {
        assert loginGroup != null : "fx:id=\"loginGroup\" was not injected: check your FXML file 'Login.fxml'.";

    }

}

