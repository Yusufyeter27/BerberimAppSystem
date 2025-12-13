package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
import java.io.File;
import java.util.Scanner;

public class Berber3Controller {

    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private Button arabuton;
    @FXML private Label berber3isimtext;

    @FXML private Label labelhizmet, labelhizmet1, labelhizmet2, labelhizmet3, labelhizmet4, labelhizmet5;
    @FXML private Label labelmusteri, labelmusteri1, labelmusteri2, labelmusteri3, labelmusteri4, labelmusteri5;
    @FXML private Label labelsaat, labelsaat1, labelsaat2, labelsaat3, labelsaat4, labelsaat5;
    @FXML private Label labeltarih, labeltarih1, labeltarih2, labeltarih3, labeltarih4, labeltarih5;

    @FXML private MenuItem cikisyap;
    @FXML private ImageView geributon;
    @FXML private MenuItem profilim;
    @FXML private MenuItem randevularim;
    @FXML private DatePicker takvim;


    // =====================================================
    //                   LABEL TEMİZLEME
    // =====================================================
    private void clearLabels() {
        Label[] musteriArr = {labelmusteri, labelmusteri1, labelmusteri2, labelmusteri3, labelmusteri4, labelmusteri5};
        Label[] tarihArr   = {labeltarih, labeltarih1, labeltarih2, labeltarih3, labeltarih4, labeltarih5};
        Label[] saatArr    = {labelsaat, labelsaat1, labelsaat2, labelsaat3, labelsaat4, labelsaat5};
        Label[] hizmetArr  = {labelhizmet, labelhizmet1, labelhizmet2, labelhizmet3, labelhizmet4, labelhizmet5};

        for (int i = 0; i < 6; i++) {
            musteriArr[i].setText("");
            tarihArr[i].setText("");
            saatArr[i].setText("");
            hizmetArr[i].setText("");
        }
    }

    // =====================================================
    //                 TÜM RANDEVULARI ÇEKME
    // =====================================================
    private void loadRandevu() {

        File file = new File("randevular.txt");

        try (Scanner scan = new Scanner(file)) {

            int index = 0;

            while (scan.hasNextLine() && index < 6) {

                String line = scan.nextLine();
                String[] data = line.split(",");

                if (data.length < 5) continue;

                String musteri = data[0];
                String tarih = data[1];
                String saat = data[2];
                String hizmet = data[3];
                String berber = data[4];

                if (!berber.equals("Kadir Atan")) continue;

                switch (index) {
                    case 0 -> { labelmusteri.setText(musteri); labeltarih.setText(tarih); labelsaat.setText(saat); labelhizmet.setText(hizmet); }
                    case 1 -> { labelmusteri1.setText(musteri); labeltarih1.setText(tarih); labelsaat1.setText(saat); labelhizmet1.setText(hizmet); }
                    case 2 -> { labelmusteri2.setText(musteri); labeltarih2.setText(tarih); labelsaat2.setText(saat); labelhizmet2.setText(hizmet); }
                    case 3 -> { labelmusteri3.setText(musteri); labeltarih3.setText(tarih); labelsaat3.setText(saat); labelhizmet3.setText(hizmet); }
                    case 4 -> { labelmusteri4.setText(musteri); labeltarih4.setText(tarih); labelsaat4.setText(saat); labelhizmet4.setText(hizmet); }
                    case 5 -> { labelmusteri5.setText(musteri); labeltarih5.setText(tarih); labelsaat5.setText(saat); labelhizmet5.setText(hizmet); }
                }

                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =====================================================
    //                 *** ARAMA BUTONU ***
    // =====================================================
    @FXML
    void arabutonclick(ActionEvent event) {

        clearLabels();

        // ❗ Tarih seçili değilse → tüm randevuları getir
        if (takvim.getValue() == null) {
            loadRandevu();
            return;
        }

        String arananTarih = takvim.getValue().toString();

        File file = new File("randevular.txt");

        try (Scanner scan = new Scanner(file)) {

            int index = 0;

            // ❗ HATA DÜZELTİLDİ → 6 olacak
            while (scan.hasNextLine() && index < 6) {

                String line = scan.nextLine();
                String[] data = line.split(",");

                if (data.length < 5) continue;

                String musteri = data[0];
                String tarih = data[1];
                String saat = data[2];
                String hizmet = data[3];
                String berber = data[4];

                if (!tarih.equals(arananTarih)) continue;
                if (!berber.equals("Kadir Atan")) continue;

                switch (index) {
                    case 0 -> { labelmusteri.setText(musteri); labeltarih.setText(tarih); labelsaat.setText(saat); labelhizmet.setText(hizmet); }
                    case 1 -> { labelmusteri1.setText(musteri); labeltarih1.setText(tarih); labelsaat1.setText(saat); labelhizmet1.setText(hizmet); }
                    case 2 -> { labelmusteri2.setText(musteri); labeltarih2.setText(tarih); labelsaat2.setText(saat); labelhizmet2.setText(hizmet); }
                    case 3 -> { labelmusteri3.setText(musteri); labeltarih3.setText(tarih); labelsaat3.setText(saat); labelhizmet3.setText(hizmet); }
                    case 4 -> { labelmusteri4.setText(musteri); labeltarih4.setText(tarih); labelsaat4.setText(saat); labelhizmet4.setText(hizmet); }
                    case 5 -> { labelmusteri5.setText(musteri); labeltarih5.setText(tarih); labelsaat5.setText(saat); labelhizmet5.setText(hizmet); }
                }

                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =====================================================
    //                      MENÜLER
    // =====================================================

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) cikisyap.getParentPopup().getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    void geributonclick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/BarberRandevu.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    void profilimclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/BerberProfilim.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) profilim.getParentPopup().getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    void randevularimclick(ActionEvent event) {}

    @FXML
    void initialize() {
        clearLabels();
        loadRandevu();

        // ENTER ile arama çalışsın
        takvim.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER")) {
                arabuton.fire();
            }
        });
    }
}
