package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class BarberRandevuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private MenuItem profilim;

    @FXML
    private MenuItem randevularim;

    @FXML
    void cikisyapclick(ActionEvent event) {

    }

    @FXML
    void emrebutonclick(ActionEvent event) {

    }

    @FXML
    void kadirbutonclick(ActionEvent event) {

    }

    @FXML
    void profilimclick(ActionEvent event) {

    }

    @FXML
    void randevularimclick(ActionEvent event) {

    }

    @FXML
    void yusufbutonclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'BarberRandevu.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'BarberRandevu.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'BarberRandevu.fxml'.";

    }

}
