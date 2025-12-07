package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;

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

    private static KullaniciDepolama depo = new KullaniciDepolama();

    private boolean berberMi = false;

    @FXML
    void initialize() {

        // müşteri girişini seç
        musterigirisi.setSelected(true);
        berbergirisi.setSelected(false);

        kayitolbutton.setVisible(true);
        berberMi = false;

        depo.setDosyaAdi("kullanicilar.txt");
        depo.dosyadanOku();

        // SADECE BU KISIM ENTER İÇİN DOĞRU VE HATASIZ
        girisbutton.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(event -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        girisbutton.fire();
                    }
                });
            }
        });
    }



    @FXML
    void berbergirisiClick(ActionEvent event) {
        kayitolbutton.setVisible(false);

        depo.setDosyaAdi("berber.txt");
        depo.dosyadanOku();

        berberMi = true;

        File file = new File("berber.txt");
        if (!file.exists()) {
            System.out.println("UYARI: berber.txt bulunamadı!");
        }
    }

    @FXML
    void musterigirisiClick(ActionEvent event) {
        kayitolbutton.setVisible(true);

        depo.setDosyaAdi("kullanicilar.txt");
        depo.dosyadanOku();

        berberMi = false;

        File file = new File("kullanicilar.txt");
        if (!file.exists()) {
            System.out.println("UYARI: kullanicilar.txt bulunamadı!");
        }
    }

    @FXML
    void girisYapClick(ActionEvent event) {
        String kullaniciAdi = giriskullaniciadi.getText();
        String sifre = girissifre.getText();

        depo.dosyadanOku();

        if (depo.girisYap(kullaniciAdi, sifre)) {
            System.out.println("Giriş başarılı.");

            try {
                Parent root;
                FXMLLoader loader;

                if (berberMi) {
                    // *** DÜZELTİLEN SATIR ***
                    loader = new FXMLLoader(getClass().getResource("/application/BarberRandevu.fxml"));
                    root = loader.load();

                } else {
                    loader = new FXMLLoader(getClass().getResource("/application/AnaSayfa.fxml"));
                    root = loader.load();

                    AnaSayfaController anaSayfaController = loader.getController();

                    Kullanici girisYapan = depo.getKullanici(kullaniciAdi);
                    if (girisYapan != null) {
                        anaSayfaController.setProfilText(girisYapan.ad + " " + girisYapan.soyad);
                    }
                }

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("HATA: Sayfa yüklenemedi!");
            }

        } else {
            System.out.println("Hatalı kullanıcı adı veya şifre!");
        }
    }

    @FXML
    void kayıtOlClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/application/kayıt.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println("Kayıt ol sayfasına yönlendirildi.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Sayfa yüklenemedi!");
        }
    }
}