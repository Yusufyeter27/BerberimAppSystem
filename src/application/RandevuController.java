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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import java.time.LocalDate;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.time.format.DateTimeFormatter;

public class RandevuController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private Text RandevuIsmi;
    @FXML private MenuItem cikisyap;
    @FXML private ToggleGroup personelgrup;
    @FXML private MenuItem profilim;
    @FXML private DatePicker randevuTarihi;
    @FXML private Label randevuisimtext;
    @FXML private MenuItem randevularim;

    @FXML private Button randevuonaylabuton;

    @FXML private Button saat9, saat10, saat11, saat12, saat13, saat14,
                        saat15, saat16, saat17, saat18, saat19, saat20;

    private String secilenSaat;

    public void setRandevuIsmi(String islemAdi) {
        RandevuIsmi.setText(islemAdi);
        RandevuIsmi.setAccessibleText(islemAdi);
    }

    public void setKullaniciAdi(String adSoyad) {
        randevuisimtext.setText(adSoyad);
    }

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) randevuisimtext.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        try {
            // PERSONEL KONTROLÜ
            RadioButton secilenPersonel = (RadioButton) personelgrup.getSelectedToggle();
            if (secilenPersonel == null) {
                System.out.println("HATA: Personel seçilmedi!");
                return;
            }
            String personelAdi = secilenPersonel.getAccessibleText();

            // TARİH KONTROLÜ
            LocalDate secilenTarih = randevuTarihi.getValue();
            if (secilenTarih == null) {
                System.out.println("HATA: Tarih seçilmedi!");
                return;
            }
            String tarihStr = secilenTarih.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            // SAAT KONTROLÜ
            if (secilenSaat == null) {
                System.out.println("HATA: Saat seçilmedi!");
                return;
            }
            String saatStr = secilenSaat;

            // HİZMET ADI
            String hizmetAdi = RandevuIsmi.getText();

            // RANDEVUYU KAYDET
            kaydetRandevu(randevuisimtext.getText(), hizmetAdi, personelAdi, tarihStr, saatStr);

            // ANA SAYFAYA DÖN
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/AnaSayfa.fxml"));
            Parent root = loader.load();

            AnaSayfaController anaSayfaController = loader.getController();
            anaSayfaController.setProfilText(randevuisimtext.getText());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void kaydetRandevu(String kullaniciAdi, String hizmet, String personel, String tarih, String saat) {
        try {
            File file = new File("randevular.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // append mode
            writer.write(kullaniciAdi+","
                    + tarih+","
                   +saat+","
                  +hizmet+","
                  + personel );
            writer.newLine();
            writer.close();
            System.out.println("Randevu dosyaya kaydedildi.");
        } catch (IOException e) {
            e.printStackTrace();
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
    void saatTiklandi(ActionEvent event) {
        Button tiklananButon = (Button) event.getSource();
        this.secilenSaat = tiklananButon.getText();
        System.out.println("Seçilen saat: " + this.secilenSaat);
    }
    @FXML
    void profilimclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Profilim.fxml"));
            Parent root = loader.load();

            ProfilimController profilimController = loader.getController();
            profilimController.setKullaniciAdi(randevuisimtext.getText());
            Stage stage = (Stage) randevuisimtext.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Profilim.fxml yüklenemedi.");
        }
    }
    @FXML
    void randevularimclick(ActionEvent event) {
        System.out.println("Randevularım menüsü tıklandı.");
    }
}