package application;

import java.io.*;
import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class BerberBilgiGuncelleController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private TextField adguncelle;
    @FXML private MenuItem cikisyap;
    @FXML private ImageView geributon;
    @FXML private TextField kullaniciguncelle;
    @FXML private Button onaylabuton;
    @FXML private MenuItem profilim;
    @FXML private Label randevuisimtext;
    @FXML private MenuItem randevularim;
    @FXML private PasswordField sifreguncelle;
    @FXML private PasswordField sifreguncelle2;
    @FXML private TextField soyadguncelle;

    private String eskiKullaniciAdi;
    private String eskiAd;
    private String eskiSoyad;

    // Profilim’den gelen ad+soyadı alıp textfield’ları doldurur
    public void setKullaniciAdi(String adSoyad) {
        randevuisimtext.setText(adSoyad);

        try (BufferedReader reader = new BufferedReader(new FileReader("kullanicilar.txt"))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                String[] parcalar = satir.split(",");
                if (parcalar.length >= 4) {
                    String ad = parcalar[0];
                    String soyad = parcalar[1];
                    String kullaniciAdi = parcalar[2];
                    String sifre = parcalar[3];

                    if ((ad + " " + soyad).equals(adSoyad)) {
                        adguncelle.setText(ad);
                        soyadguncelle.setText(soyad);
                        kullaniciguncelle.setText(kullaniciAdi);
                        sifreguncelle.setText(sifre);
                        sifreguncelle2.setText(sifre);

                        eskiKullaniciAdi = kullaniciAdi;
                        eskiAd = ad;
                        eskiSoyad = soyad;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TextField event’leri (boş bırakılabilir)
    @FXML void adguncelleclick(ActionEvent event) {}
    @FXML void soyadguncelleclick(ActionEvent event) {}
    @FXML void kullaniciguncelleclick(ActionEvent event) {}
    @FXML void sifreguncelleclick(ActionEvent event) {}
    @FXML void sifreguncelle2click(ActionEvent event) {}

    // Onayla → dosya güncelleme
    @FXML
    void onaylabutonclick(ActionEvent event) {
        String yeniAd = adguncelle.getText();
        String yeniSoyad = soyadguncelle.getText();
        String yeniKullaniciAdi = kullaniciguncelle.getText();
        String yeniSifre = sifreguncelle.getText();
        String yeniSifre2 = sifreguncelle2.getText();

        if (!yeniSifre.equals(yeniSifre2)) {
            System.out.println("HATA: Şifreler uyuşmuyor!");
            return;
        }

        try {
            // --- kullanicilar.txt GÜNCELLE ---
            File file = new File("kullanicilar.txt");
            List<String> satirlar = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String satir;
                while ((satir = reader.readLine()) != null) {
                    String[] parcalar = satir.split(",");
                    if (parcalar.length >= 4 && parcalar[2].equals(eskiKullaniciAdi)) {
                        satirlar.add(yeniAd + "," + yeniSoyad + "," + yeniKullaniciAdi + "," + yeniSifre);
                    } else {
                        satirlar.add(satir);
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
                for (String s : satirlar) {
                    writer.write(s);
                    writer.newLine();
                }
            }

            System.out.println("Kullanıcı bilgileri güncellendi.");

            // --- randevular.txt GÜNCELLE ---
            File randevuFile = new File("randevular.txt");
            List<String> randevuSatirlar = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(randevuFile))) {
                String satir;
                while ((satir = reader.readLine()) != null) {
                    String[] parcalar = satir.split(",");
                    if (parcalar.length == 5) {
                        if (parcalar[0].equals(eskiAd + " " + eskiSoyad)) {
                            randevuSatirlar.add(
                                yeniAd + " " + yeniSoyad + "," + parcalar[1] + "," + parcalar[2] + "," + parcalar[3] + "," + parcalar[4]
                            );
                        } else {
                            randevuSatirlar.add(satir);
                        }
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(randevuFile, false))) {
                for (String s : randevuSatirlar) {
                    writer.write(s);
                    writer.newLine();
                }
            }

            System.out.println("Randevular güncellendi.");

            // Eski değerleri yeniyle senkronla
            eskiAd = yeniAd;
            eskiSoyad = yeniSoyad;
            eskiKullaniciAdi = yeniKullaniciAdi;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Menü event’leri
    @FXML
    void profilimclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Profilim.fxml"));
            Parent root = loader.load();
            ProfilimController profilimController = loader.getController();
            String yeniAdSoyad = adguncelle.getText() + " " + soyadguncelle.getText();
            profilimController.setKullaniciAdi(yeniAdSoyad);
            Stage stage = (Stage) randevuisimtext.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Profilim menüsüne basıldı, Profilim.fxml'e dönüldü.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Profilim.fxml yüklenemedi.");
        }
    }

   

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) randevuisimtext.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Çıkış yapıldı.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Login.fxml yüklenemedi.");
        }
    }

    @FXML
    void geributonclick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Profilim.fxml"));
            Parent root = loader.load();
            ProfilimController profilimController = loader.getController();
            String yeniAdSoyad = adguncelle.getText() + " " + soyadguncelle.getText();
            profilimController.setKullaniciAdi(yeniAdSoyad);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Geri butonuna basıldı, Profilim.fxml'e dönüldü.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: Profilim.fxml yüklenemedi.");
        }
    }
}