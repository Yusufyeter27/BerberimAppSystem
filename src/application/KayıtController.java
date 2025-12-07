package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class KayıtController {

    @FXML public TextField adTextField;
    @FXML public TextField soyadTextField;
    @FXML public TextField kullanıcı2TextField;
    @FXML public PasswordField şifre2TextField;
    @FXML public Button kayitolbutton;

    private static KullaniciDepolama depo = new KullaniciDepolama();
    @FXML
    public void kayıtOlClick2(ActionEvent event) {
        String ad = adTextField.getText();
        String soyad = soyadTextField.getText();
        String kullaniciAdi = kullanıcı2TextField.getText();
        String sifre = şifre2TextField.getText();

        if (ad.isBlank() || soyad.isBlank() || kullaniciAdi.isBlank() || sifre.isBlank()) {
            System.out.println("Tüm alanlar zorunludur.");
            return;
        }
        if (sifre.length() < 7) {
            System.out.println("Şifre en az 7 karakter olmalı!");
            return;
        }

        Kullanici yeni = new Kullanici(ad, soyad, kullaniciAdi, sifre);
        depo.ekle(yeni);    
        depo.dosyayaEkle(yeni);
        
        System.out.println("Kullanıcı başarıyla kaydedildi!");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println("Login ekranına yönlendirildi.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Login ekranı yüklenemedi!");
        }
    }

}