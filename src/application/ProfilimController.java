package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProfilimController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bilgilerim;

    @FXML
    private MenuItem cikisyap;

    @FXML
    private ImageView geributon;

    @FXML
    private MenuItem profilim;

    @FXML
    private Label profilimisim;

    @FXML
    private Label profilimkullanici;

    @FXML
    private Label profilimsoyad;

    @FXML
    private Label randevuisimtext;

    @FXML
    private MenuItem randevularim;

    @FXML
    void bilgilerimclick(ActionEvent event) {

    }

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
    void initialize() {
        assert bilgilerim != null : "fx:id=\"bilgilerim\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert geributon != null : "fx:id=\"geributon\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert profilimisim != null : "fx:id=\"profilimisim\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert profilimkullanici != null : "fx:id=\"profilimkullanici\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert profilimsoyad != null : "fx:id=\"profilimsoyad\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert randevuisimtext != null : "fx:id=\"randevuisimtext\" was not injected: check your FXML file 'Profilim.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'Profilim.fxml'.";

    }

}
