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

public class Berber2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button arabuton;
    @FXML
    private ImageView geributon;

    @FXML
    private Label berber2isimtext;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private MenuItem profilim;

    @FXML
    private MenuItem randevularim;

    @FXML
    private DatePicker takvim;

    @FXML
    void arabutonclick(ActionEvent event) {

    }
    @FXML
    void geributonclick(MouseEvent event) {

    }

    @FXML
    void cikisyapclick(ActionEvent event) {

    }

    @FXML
    void profilimclick(ActionEvent event) {

    }

    @FXML
    void randevularimclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert arabuton != null : "fx:id=\"arabuton\" was not injected: check your FXML file 'Berber2.fxml'.";
        assert berber2isimtext != null : "fx:id=\"berber2isimtext\" was not injected: check your FXML file 'Berber2.fxml'.";
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'Berber2.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'Berber2.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'Berber2.fxml'.";
        assert takvim != null : "fx:id=\"takvim\" was not injected: check your FXML file 'Berber2.fxml'.";

    }

}
