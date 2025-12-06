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
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.scene.control.Button; // Button sınıfını kullanmak için ekledik

public class RandevuController {

    // ... (Mevcut Alanlar)
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Text RandevuIsmi;
    @FXML private MenuItem cikisyap;
    @FXML private ToggleGroup personelgrup;
    @FXML private MenuItem profilim;
    @FXML private DatePicker randevuTarihi;
    @FXML private Label randevuisimtext;
    @FXML private MenuItem randevularim;
    
    // Yeni Eklenen Alan: Randevu Onayla Butonu (FXML'den bağlı olmalı)
    // Eğer FXML'de fx:id'si 'randevuOnaylaButton' olan bir butonunuz varsa.
    @FXML private Button randevuOnaylaButton; 

    // Yeni Eklenen Alan: Seçilen saati tutar
    private String secilenSaat = null;

    // ... (setRandevuIsmi ve setKullaniciAdi metotları aynı)

    public void setRandevuIsmi(String islemAdi) {
        RandevuIsmi.setText(islemAdi);
        RandevuIsmi.setAccessibleText(islemAdi);
    }
    
    public void setKullaniciAdi(String adSoyad) {
        randevuisimtext.setText(adSoyad);
    }
    
    // ... (cikisyapclick metodu aynı)

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
            Parent root = loader.load();
            
            // MenuItem'ın bağlı olduğu pencereyi bulma yöntemi (daha güvenli)
            Stage stage = (Stage) ((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
            
            // Eğer üstteki kod hata verirse, aşağıdaki yedeği kullanabilirsiniz:
            // Stage stage = (Stage) randevuisimtext.getScene().getWindow();
            
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // ... (randevuSayfasiAc metodu aynı)
    
    public void randevuSayfasiAc(String kullaniciAdi) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Randevu.fxml"));
            Parent root = loader.load();
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
    void randevuonaylabutonclick(ActionEvent event) {
        // Randevu onaylama mantığı buraya gelecek
        if (secilenSaat == null || randevuTarihi.getValue() == null) {
            System.out.println("HATA: Lütfen tarih ve saat seçin.");
            return;
        }
        
        String tarih = randevuTarihi.getValue().toString();
        // Örneğin: RandevuyuDepola(tarih, secilenSaat);
        System.out.println("Randevu Onaylandı: Tarih: " + tarih + ", Saat: " + secilenSaat);
    }
    
    @FXML
    void geributonclick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/AnaSayfa.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: AnaSayfa.fxml yüklenemedi.");
        }
    }

    @FXML
    void saatTiklandi(ActionEvent event) {
        // Tıklanan öğeyi Button olarak al
        Button tiklananSaatButonu = (Button) event.getSource();

        // Butonun üzerindeki metni (saat dilimini) al
        String yeniSaat = tiklananSaatButonu.getText();
        
        // Eğer daha önce bir saat seçilmişse, eski butonu görsel olarak sıfırlama (isteğe bağlı)
        // Eğer her saat butonu farklı bir ID'ye sahipse bu zor olabilir.
        // FXML'de CSS sınıflarını veya ToggleButton kullanmak görsel geri bildirim için daha iyidir.

        // Yeni saati kaydet ve görsel geri bildirim ver
        secilenSaat = yeniSaat;
        System.out.println("Seçilen randevu saati güncellendi: " + secilenSaat);
        
        // Butonun seçili olduğunu görsel olarak belirtmek için CSS sınıfı ekleyebiliriz (Örn: tiklananSaatButonu.setStyle("-fx-background-color: #4CAF50;");)

        // Randevu onayı için gerekli tüm verilerin olup olmadığını kontrol et
        if (randevuTarihi.getValue() != null && secilenSaat != null && randevuOnaylaButton != null) {
             randevuOnaylaButton.setDisable(false);
        }
    } 
    
    @FXML
    void profilimclick(ActionEvent event) {
    }

    @FXML
    void randevularimclick(ActionEvent event) {
    }
    
    // ... (initialize metodu eksik olduğu için varsayımsal olarak eklenmemiştir, ancak FXML bağlantılarını kontrol eder)
}