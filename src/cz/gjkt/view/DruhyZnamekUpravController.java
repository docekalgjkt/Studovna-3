package cz.gjkt.view;

import cz.gjkt.application.Main;
import cz.gjkt.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DruhyZnamekUpravController implements Initializable {

    DruhyZnamekController druhZnamkyController;
    Scene druhyZnamekScene;
    DruhZnamky druhZnamky;

    @FXML
    TextField nazev;

    @FXML
    TextField datum;

    @FXML
    TextField popis;

    @FXML
    ChoiceBox<TypZnamky> typZnamky;

    @FXML
    ChoiceBox<Kurz> kurz;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typZnamky.getItems().addAll(getTypyZnamek());
        kurz.getItems().addAll(getKurzy());

    }

    private ObservableList<TypZnamky> getTypyZnamek(){
        TypyZnamekDAOJDBC daotz = new TypyZnamekDAOJDBC();
        return FXCollections.observableList(daotz.getAll());
    }

    private ObservableList<Kurz> getKurzy(){
        KurzyDAOJDBC daok = new KurzyDAOJDBC();
        return FXCollections.observableList(daok.getAll());
    }

    private void setNazev(String nazev){this.nazev.setText(nazev);}
    private void setDatum(String datum){this.datum.setText(datum);}
    private void setPopis(String popis){this.popis.setText(popis);}

    public void setDruhyZnamekScene(Scene scene){druhyZnamekScene = scene;}
    public void setDruhyZnamekController(DruhyZnamekController controller){druhZnamkyController = controller;}

    public void setDruhZnamky(DruhZnamky druhZnamky){
        this.druhZnamky = druhZnamky;
        setNazev(druhZnamky.getNazev());
        setDatum(druhZnamky.getDatum());
        setPopis(druhZnamky.getPopis());
    }

    public void handleZahodButton() {
        Main.getPrimaryStage().setScene(druhyZnamekScene);
    }

    public void handleUlozButton(){
        DruhyZnamekDAOJDBC druhyZnamekDAO = new DruhyZnamekDAOJDBC();
        druhZnamky.setNazev(nazev.getText());
        druhZnamky.setDatum(datum.getText());
        druhZnamky.setPopis(popis.getText());
        druhZnamky.setTypZnamky(typZnamky.getValue().getId());
        druhZnamky.setKurz(kurz.getValue().getId());
        druhyZnamekDAO.update(druhZnamky);
        Main.getPrimaryStage().setScene(druhyZnamekScene);
        druhZnamkyController.refresh();
    }

}
