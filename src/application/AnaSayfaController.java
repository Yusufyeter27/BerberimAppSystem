package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class AnaSayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private MenuItem profilim;

    @FXML
    private Label profiltext;

    @FXML
    private Button randevuAlTiklandi;

    @FXML
    private MenuItem randevularim;

    @FXML
    private Label sac;

    @FXML
    void cikisyapclick(ActionEvent event) {

    }

    @FXML
    void profilimclick(ActionEvent event) {

    }

    @FXML
    void randevuAlTiklandi(ActionEvent event) {

    }

    @FXML
    void randevularimclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert profiltext != null : "fx:id=\"profiltext\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert randevuAlTiklandi != null : "fx:id=\"randevuAlTiklandi\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'AnaSayfa.fxml'.";
        assert sac != null : "fx:id=\"sac\" was not injected: check your FXML file 'AnaSayfa.fxml'.";

    }

}
