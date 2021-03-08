package cz.gjkt.view;

import cz.gjkt.application.Main;
import cz.gjkt.model.Predmet;
import cz.gjkt.model.PredmetyDAOJDBC;
import cz.gjkt.model.TypZnamky;
import cz.gjkt.model.TypyZnamekDAOJDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TypyZnamekUpravController implements Initializable {

    TypyZnamekController typZnamkyController;
    Scene typyZnamekScene;
    TypZnamky typZnamky;

    @FXML
    TextField nazev;

    @FXML
    TextField popis;

    @FXML
    TextField min;

    @FXML
    TextField vaha;

    @FXML
    TextField rocnik;

    @FXML
    TextField pololeti;

    @FXML
    ChoiceBox<Predmet> predmet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        predmet.getItems().addAll(getPredmety());
    }

    private ObservableList<Predmet> getPredmety(){
        PredmetyDAOJDBC daop = new PredmetyDAOJDBC();
        return FXCollections.observableList(daop.getAll());
    }


    private void setNazev(String nazev){this.nazev.setText(nazev);}
    private void setPopis(String popis){this.popis.setText(popis);}
    private void setMin(int min){this.min.setText(String.valueOf(min));}
    private void setVaha(int vaha){this.vaha.setText(String.valueOf(vaha));}
    private void setRocnik(int rocnik){this.rocnik.setText(String.valueOf(rocnik));}
    private void setPololeti(int pololeti){this.pololeti.setText(String.valueOf(pololeti));}


    public void setTypyZnamekScene(Scene scene){typyZnamekScene = scene;}
    public void setTypyZnamekController(TypyZnamekController controller){typZnamkyController = controller;}

    public void setTypZnamky(TypZnamky typZnamky){
        this.typZnamky = typZnamky;
        setNazev(typZnamky.getNazev());
        setPopis(typZnamky.getPopis());
        setMin(typZnamky.getMin());
        setVaha(typZnamky.getVaha());
        setRocnik(typZnamky.getRocnik());
        setPololeti(typZnamky.getPololeti());

    }

    public void handleZahodButton() {
        Main.getPrimaryStage().setScene(typyZnamekScene);
    }

    public void handleUlozButton(){
        TypyZnamekDAOJDBC typyZnamekDAO = new TypyZnamekDAOJDBC();
        typZnamky.setNazev(nazev.getText());
        typZnamky.setPopis(popis.getText());
        typZnamky.setMin(min.getText());
        typZnamky.setVaha(vaha.getText());
        typZnamky.setRocnik(rocnik.getText());
        typZnamky.setPololeti(pololeti.getText());
        typZnamky.setPredmet(predmet.getValue().getId());
        typyZnamekDAO.update(typZnamky);
        Main.getPrimaryStage().setScene(typyZnamekScene);
        typZnamkyController.refresh();
    }
}
