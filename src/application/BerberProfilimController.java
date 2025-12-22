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

public class BerberProfilimController {
    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private Button berberbilgilerim;
    @FXML private Label berberprofilimisim;
    @FXML private Label berberprofilimkullanici;
    @FXML private Label berberprofilimsoyad;
    @FXML private MenuItem cikisyap;
    @FXML private ImageView geributon;
    @FXML private MenuItem profilim;
    @FXML private Label randevuisimtext;
    @FXML private MenuItem randevularim;

    public void setKullaniciAdi(String adSoyad) {
        randevuisimtext.setText(adSoyad);
    }

    @FXML
    void berberbilgilerimclick(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(
                    getClass().getResource("/application/BerberBilgiGuncelle.fxml")
            );

            javafx.scene.Parent root = loader.load();
            try {
                BerberBilgiGuncelleController ctrl = loader.getController();
                if (ctrl != null) {
                    String mevcut = (berberprofilimisim.getText() + " " + berberprofilimsoyad.getText()).trim();
                    if (!mevcut.isEmpty()) ctrl.setKullaniciAdi(mevcut);
                }
            } catch (Exception ex) {
                
            }

            javafx.stage.Stage stage = (javafx.stage.Stage) berberbilgilerim.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("BerberBilgiGuncelle ekranına geçerken hata oluştu.");
        }
    }

    @FXML
    void profilimclick(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/application/BerberProfilim.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) profilim.getParentPopup().getOwnerWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Profilim ekranına geçerken hata oluştu.");
        }
    }

    @FXML
    void cikisyapclick(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/application/Login.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) berberbilgilerim.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Sahneyi değiştirirken hata oluştu.");
        }
    }

    @FXML
    void geributonclick(MouseEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/application/BarberRandevu.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) geributon.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Geri giderken hata oluştu.");
        }
    }

    @FXML
    void randevularimclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert berberbilgilerim != null : "fx:id=\"berberbilgilerim\" was not injected: check your FXML file 'BerberProfilim.fxml'.";
        assert berberprofilimisim != null : "fx:id=\"berberprofilimisim\" was not injected: check your FXML file 'BerberProfilim.fxml'.";
        assert berberprofilimkullanici != null : "fx:id=\"berberprofilimkullanici\" was not injected: check your FXML file 'BerberProfilim.fxml'.";
        assert berberprofilimsoyad != null : "fx:id=\"berberprofilimsoyad\" was not injected: check your FXML file 'BerberProfilim.fxml'.";
        assert cikisyap != null : "fx:id=\"cikisyap\" was not injected: check your FXML file 'BerberProfilim.fxml'.";
        assert geributon != null : "fx:id=\"geributon\" was not injected: check your FXML file 'BerberProfilim.fxml'.";
        assert profilim != null : "fx:id=\"profilim\" was not injected: check your FXML file 'BerberProfilim.fxml'.";
        assert randevuisimtext != null : "fx:id=\"randevuisimtext\" was not injected: check your FXML file 'BerberProfilim.fxml'.";
        assert randevularim != null : "fx:id=\"randevularim\" was not injected: check your FXML file 'BerberProfilim.fxml'.";

    }

}