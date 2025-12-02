package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AnaSayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button randevuAlTiklandi;

    @FXML
    void randevuAlTiklandi(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert randevuAlTiklandi != null : "fx:id=\"randevuAlTiklandi\" was not injected: check your FXML file 'AnaSayfa.fxml'.";

    }

}
