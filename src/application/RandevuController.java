package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;

public class RandevuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker randevuTarihi;

    public void initialize(URL location, ResourceBundle resources) {
        // Bugünden önceki tarihleri kapatma ayarı
        randevuTarihi.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                // Eğer tarih bugünden önceyse pasif yap
                setDisable(empty || date.compareTo(LocalDate.now()) < 0);
            }
        });
    }

}
