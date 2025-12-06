package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class RandevuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text RandevuIsmi;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private ImageView geributon;

    @FXML
    private ToggleGroup personelgrup;

    @FXML
    private MenuItem profilim;

    @FXML
    private DatePicker randevuTarihi;

    @FXML
    private Label randevuisimtext;

    @FXML
    private MenuItem randevularim;

    @FXML
    private Button randevuonaylabuton;

    @FXML
    void cikisyapclick(ActionEvent event) {

    }

    @FXML
    void geributonclick(MouseEvent event) {

    }

    @FXML
    void profilimclick(ActionEvent event) {

    }

    @FXML
    void randevularimclick(ActionEvent event) {

    }

    @FXML
    void randevuonaylabutonclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert RandevuIsmi != null : "fx:id=\"RandevuIsmi\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert geributon != null : "fx:id=\"geributon\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert personelgrup != null : "fx:id=\"personelgrup\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert randevuTarihi != null : "fx:id=\"randevuTarihi\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert randevuisimtext != null : "fx:id=\"randevuisimtext\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'Randevu.fxml'.";
        assert randevuonaylabuton != null : "fx:id=\"randevuonaylabuton\" was not injected: check your FXML file 'Randevu.fxml'.";

    }

}
