package cz.gjkt.view;

import cz.gjkt.application.Main;
import cz.gjkt.model.Predmet;
import cz.gjkt.model.PredmetyDAOJDBC;
import cz.gjkt.model.SkolniRok;
import cz.gjkt.model.SkolniRokyDAOJDBC;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SkolniRokUpravController implements Initializable {

    SkolniRokController SkolniRokController;
    Scene skolniRokScene;
    SkolniRok skolniRok;

    @FXML
    TextField nazev;

    @FXML
    TextField zacatek;

    @FXML
    TextField konec;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void setNazev(String nazev){this.nazev.setText(nazev);}
    private void setZacatek(String popis){this.zacatek.setText(popis);}
    private void setKonec(String sylabus){this.konec.setText(sylabus);}

    public void setSkolniRokScene(Scene scene){skolniRokScene = scene;}
    public void setSkolniRokController(SkolniRokController controller){SkolniRokController = controller;}

    public void setSkolniRok(SkolniRok predmet){
        this.skolniRok = skolniRok;
        setNazev(predmet.getNazev());
        setZacatek(predmet.getZacatek());
        setKonec(predmet.getKonec());
    }

    public void handleZahodButton() {
        Main.getPrimaryStage().setScene(skolniRokScene);
    }

    public void handleUlozButton(){
        SkolniRokyDAOJDBC skolniRokyDAO = new SkolniRokyDAOJDBC();
        skolniRok.setNazev(nazev.getText());
        skolniRok.setZacatek(zacatek.getText());
        skolniRok.setKonec(konec.getText());
        skolniRokyDAO.update(skolniRok);
        Main.getPrimaryStage().setScene(skolniRokScene);
        SkolniRokController.refresh();
    }

}
