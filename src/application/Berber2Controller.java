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

public class Berber2Controller {

    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private Button arabuton;
    @FXML private Label berber2isimtext;

    @FXML private Label labelhizmet, labelhizmet1, labelhizmet2, labelhizmet3, labelhizmet4, labelhizmet5;
    @FXML private Label labelmusteri, labelmusteri1, labelmusteri2, labelmusteri3, labelmusteri4, labelmusteri5;
    @FXML private Label labelsaat, labelsaat1, labelsaat2, labelsaat3, labelsaat4, labelsaat5;
    @FXML private Label labeltarih, labeltarih1, labeltarih2, labeltarih3, labeltarih4, labeltarih5;

    @FXML private MenuItem cikisyap;
    @FXML private ImageView geributon;
    @FXML private MenuItem profilim;
    @FXML private MenuItem randevularim;
    @FXML private DatePicker takvim;

   
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
    private void fillLabels(int index, String m, String t, String s, String h) {
        switch (index) {
            case 0 -> { labelmusteri.setText(m); labeltarih.setText(t); labelsaat.setText(s); labelhizmet.setText(h); }
            case 1 -> { labelmusteri1.setText(m); labeltarih1.setText(t); labelsaat1.setText(s); labelhizmet1.setText(h); }
            case 2 -> { labelmusteri2.setText(m); labeltarih2.setText(t); labelsaat2.setText(s); labelhizmet2.setText(h); }
            case 3 -> { labelmusteri3.setText(m); labeltarih3.setText(t); labelsaat3.setText(s); labelhizmet3.setText(h); }
            case 4 -> { labelmusteri4.setText(m); labeltarih4.setText(t); labelsaat4.setText(s); labelhizmet4.setText(h); }
            case 5 -> { labelmusteri5.setText(m); labeltarih5.setText(t); labelsaat5.setText(s); labelhizmet5.setText(h); }
        }
    }
    private void loadRandevu() {

        File file = new File("randevular.txt");

        try (Scanner scan = new Scanner(file)) {

            int index = 0;

            while (scan.hasNextLine() && index < 6) {

                String[] data = scan.nextLine().split(",");

                if (data.length < 5) continue;

                String musteri = data[0];
                String tarih = data[1];
                String saat = data[2];
                String hizmet = data[3];
                String berber = data[4];

                if (!berber.equals("Emre Turğut")) continue;

                fillLabels(index, musteri, tarih, saat, hizmet);
                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void arabutonclick(ActionEvent event) {

        clearLabels();
        if (takvim.getValue() == null) {
            loadRandevu();
            return;
        }

        String arananTarih = takvim.getValue().format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        File file = new File("randevular.txt");

        try (Scanner scan = new Scanner(file)) {

            int index = 0;

            while (scan.hasNextLine()) {

                String[] data = scan.nextLine().split(",");

                if (data.length < 5) continue;

                String musteri = data[0];
                String tarih = data[1];
                String saat = data[2];
                String hizmet = data[3];
                String berber = data[4];

                if (!tarih.equals(arananTarih)) continue;
                if (!berber.equals("Emre Turğut")) continue;

                if (index < 6) fillLabels(index, musteri, tarih, saat, hizmet);
                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void randevularimclick(ActionEvent event) {
        // Boş olabilir, yeter ki FXML çağırdığında bulsun.
        System.out.println("randevularimclick çalıştı.");
    }
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
