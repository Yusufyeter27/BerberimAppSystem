package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
public class ProfilimController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bilgilerim;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private ImageView geributon;

    @FXML
    private MenuItem profilim;

    @FXML
    private Label profilimisim;

    @FXML
    private Label profilimkullanici;

    @FXML
    private Label profilimsoyad;

    @FXML
    private Label randevuisimtext;

    @FXML
    private MenuItem randevularim;

    public void setKullaniciAdi(String adSoyad) {
        randevuisimtext.setText(adSoyad);

        KullaniciDepolama depolama = new KullaniciDepolama();
        depolama.dosyadanOku();

        // Baştaki ve sondaki boşlukları temizle
        adSoyad = adSoyad.trim();

        // Boşluklardan böl
        String[] parts = adSoyad.split("\\s+");

        if (parts.length >= 2) {
            // Soyad = son kelime
            String soyad = parts[parts.length - 1];

            // Ad = geri kalan tüm kelimeler
            StringBuilder adBuilder = new StringBuilder();
            for (int i = 0; i < parts.length - 1; i++) {
                adBuilder.append(parts[i]).append(" ");
            }
            String ad = adBuilder.toString().trim();

            // Kullanıcıyı listeden bul
            Kullanici gecici = depolama.getBas();
            while (gecici != null) {
                if (gecici.ad.equalsIgnoreCase(ad) && gecici.soyad.equalsIgnoreCase(soyad)) {
                    profilimisim.setText(gecici.ad);
                    profilimsoyad.setText(gecici.soyad);
                    profilimkullanici.setText(gecici.kullaniciAdi);
                    break;
                }
                gecici = gecici.sonraki;
            }
        }
    }

    @FXML
    void bilgilerimclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/BilgiGuncelle.fxml"));
            Parent root = loader.load();

            // Controller'ı al
            BilgiGuncelleController bilgiController = loader.getController();

            // Kullanıcı ad + soyad bilgisini gönder
            bilgiController.setKullaniciAdi(randevuisimtext.getText());

            // Sahneyi değiştir
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: BilgiGuncelle.fxml yüklenemedi.");
        }
    }
    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("Login.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) profilimisim.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Login.fxml yüklenemedi.");
        }
    }
    @FXML
    void geributonclick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AnaSayfa.fxml"));
            Parent root = loader.load();

            AnaSayfaController anaSayfaController = loader.getController();
            anaSayfaController.setProfilText(randevuisimtext.getText());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: AnaSayfa.fxml yüklenemedi.");
        }
    }

    @FXML
    void profilimclick(ActionEvent event) { }

    @FXML
    void randevularimclick(ActionEvent event) { }

    @FXML
    void initialize() {
        assert bilgilerim != null : "fx:id=\"bilgilerim\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert geributon != null : "fx:id=\"geributon\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert profilimisim != null : "fx:id=\"profilimisim\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert profilimkullanici != null : "fx:id=\"profilimkullanici\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert profilimsoyad != null : "fx:id=\"profilimsoyad\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert randevuisimtext != null : "fx:id=\"randevuisimtext\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'Profilim.fxml'.";
    }
}