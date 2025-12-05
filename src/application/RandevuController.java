package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
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
    private ToggleGroup personelgrup;

    @FXML
    private MenuItem profilim;

    @FXML
    private DatePicker randevuTarihi;

    @FXML
    private MenuItem randevularim;

    @FXML
    void cikisyapclick(ActionEvent event) {

    }

    @FXML
    void profilimclick(ActionEvent event) {

    }

    @FXML
    void randevularimclick(ActionEvent event) {

    }
    public void initialize(URL location, ResourceBundle resources) {
         //UNUTMA EMOŞŞ TARİH SEÇİM KISMINI
    }
}


