package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RandevuItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelhizmet;

    @FXML
    private Label labelpersonel;

    @FXML
    private Label labelsaat;

    @FXML
    private Label labeltarih;

    @FXML
    private Button silmebutonu;

    @FXML
    void silmebutonuclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert labelhizmet != null : "fx:id=\"labelhizmet\" was not injected: check your FXML file 'RandevuItem.fxml'.";
        assert labelpersonel != null : "fx:id=\"labelpersonel\" was not injected: check your FXML file 'RandevuItem.fxml'.";
        assert labelsaat != null : "fx:id=\"labelsaat\" was not injected: check your FXML file 'RandevuItem.fxml'.";
        assert labeltarih != null : "fx:id=\"labeltarih\" was not injected: check your FXML file 'RandevuItem.fxml'.";
        assert silmebutonu != null : "fx:id=\"silmebutonu\" was not injected: check your FXML file 'RandevuItem.fxml'.";

    }

}
