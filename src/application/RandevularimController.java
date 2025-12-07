package application;

import java.io.*;
import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RandevularimController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private MenuItem cikisyap;
    @FXML private ImageView geributon;

    @FXML private Label lblHizmet, lblHizmet1, lblHizmet2, lblHizmet3, lblHizmet4, lblHizmet5;
    @FXML private Label lblPersonel, lblPersonel1, lblPersonel2, lblPersonel3, lblPersonel4, lblPersonel5;
    @FXML private Label lblSaat, lblSaat1, lblSaat2, lblSaat3, lblSaat4, lblSaat5;
    @FXML private Label lblTarih, lblTarih1, lblTarih2, lblTarih3, lblTarih4, lblTarih5;

    @FXML private MenuItem profilim;
    @FXML private Label randevuisimtext;
    @FXML private MenuItem randevularim;

    private String aktifKullanici;
    private List<String[]> aktifRandevular = new ArrayList<>();

    public void setKullaniciAdi(String adSoyad) {
        aktifKullanici = adSoyad;
        randevuisimtext.setText(adSoyad);
        randevulariYukle();
    }

    private void randevulariYukle() {
        aktifRandevular.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("randevular.txt"))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                String[] parcalar = satir.split(",");
                if (parcalar.length == 5 && parcalar[0].equals(aktifKullanici)) {
                    aktifRandevular.add(parcalar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Label’lara yaz
        Label[] tarihLabels = {lblTarih, lblTarih1, lblTarih2, lblTarih3, lblTarih4, lblTarih5};
        Label[] saatLabels = {lblSaat, lblSaat1, lblSaat2, lblSaat3, lblSaat4, lblSaat5};
        Label[] hizmetLabels = {lblHizmet, lblHizmet1, lblHizmet2, lblHizmet3, lblHizmet4, lblHizmet5};
        Label[] personelLabels = {lblPersonel, lblPersonel1, lblPersonel2, lblPersonel3, lblPersonel4, lblPersonel5};

        for (int i = 0; i < tarihLabels.length; i++) {
            if (i < aktifRandevular.size()) {
                String[] r = aktifRandevular.get(i);
                tarihLabels[i].setText(r[1]);
                saatLabels[i].setText(r[2]);
                hizmetLabels[i].setText(r[3]);
                personelLabels[i].setText(r[4]);
            } else {
                tarihLabels[i].setText("");
                saatLabels[i].setText("");
                hizmetLabels[i].setText("");
                personelLabels[i].setText("");
            }
        }
    }

    private void randevuSil(int index) {
        if (index >= aktifRandevular.size()) return;
        String[] silinecek = aktifRandevular.get(index);

        try {
            File file = new File("randevular.txt");
            List<String> satirlar = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String satir;
                while ((satir = reader.readLine()) != null) {
                    if (!satir.equals(String.join(",", silinecek))) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        randevulariYukle();
    }

    @FXML void btnSil1(ActionEvent e) { randevuSil(0); }
    @FXML void btnSil2(ActionEvent e) { randevuSil(1); }
    @FXML void btnSil3(ActionEvent e) { randevuSil(2); }
    @FXML void btnSil4(ActionEvent e) { randevuSil(3); }
    @FXML void btnSil5(ActionEvent e) { randevuSil(4); }
    @FXML void btnSil6(ActionEvent e) { randevuSil(5); }

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) randevuisimtext.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    void geributonclick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/AnaSayfa.fxml"));
            Parent root = loader.load();

            AnaSayfaController controller = loader.getController();
            controller.setProfilText(aktifKullanici);

            Stage stage = (Stage) randevuisimtext.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("Randevularım → AnaSayfa'ya dönüldü.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("HATA: AnaSayfa.fxml yüklenemedi.");
        }
    }

    @FXML
    void profilimclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Profilim.fxml"));
            Parent root = loader.load();
            ProfilimController controller = loader.getController();
            controller.setKullaniciAdi(aktifKullanici);
            Stage stage = (Stage) randevuisimtext.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    void randevularimclick(ActionEvent event) {
        // Aynı sayfadayız, gerek yok ama refresh yapabiliriz
        randevulariYukle();
    }

    @FXML
    void initialize() {
        // assert’ler zaten var
    }
}