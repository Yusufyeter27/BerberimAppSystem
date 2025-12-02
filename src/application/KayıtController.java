package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class KayıtController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adTextField;

    @FXML
    private TextField kullanıcı2TextField;

    @FXML
    private TextField soyadTextField;

    @FXML
    private PasswordField şifre2TextField;

    @FXML
    void kayıtOlClick2(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert adTextField != null : "fx:id=\"adTextField\" was not injected: check your FXML file 'kayıt.fxml'.";
        assert kullanıcı2TextField != null : "fx:id=\"kullanıcı2TextField\" was not injected: check your FXML file 'kayıt.fxml'.";
        assert soyadTextField != null : "fx:id=\"soyadTextField\" was not injected: check your FXML file 'kayıt.fxml'.";
        assert şifre2TextField != null : "fx:id=\"şifre2TextField\" was not injected: check your FXML file 'kayıt.fxml'.";

    }

}

