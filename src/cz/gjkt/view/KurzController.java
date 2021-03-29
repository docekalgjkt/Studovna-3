package cz.gjkt.view;

import cz.gjkt.model.Kurz;
import cz.gjkt.model.KurzyDAOJDBC;
import cz.gjkt.model.Predmet;
import cz.gjkt.model.SkolniRok;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class KurzController extends ItemViewController<Kurz> {

    @FXML
    TextField nazev;
    @FXML
    ChoiceBox<SkolniRok> skolniRok;
    @FXML
    ChoiceBox<Predmet> predmet;

    private void setNazev(String nazev){this.nazev.setText(nazev);}
    private void setSkolniRok(SkolniRok skolniRok){}
    private void setSkolniRok(int skolniRok){}
    private void setPredmet(Predmet predmet){}
    private void setPredmet(int predmet){}

    @Override
    public void setItem(Kurz kurz){
        super.setItem(kurz);
        setNazev(kurz.getNazev());
        setSkolniRok(kurz.getSkolniRok());
        setPredmet(kurz.getPredmet());
    }

    private ObservableList<Predmet> getPredmety(){return null;}
    private ObservableList<SkolniRok> getSkolniRoky(){return null;}

    @Override
    public void handleUlozButton(){
        item.setNazev(nazev.getText());
        item.setSkolniRok(skolniRok.getId());
        item.setPredmet(predmet.getId());
        super.handleUlozButton();
    }

    @Override
    protected void initController(){
        modelDao = new KurzyDAOJDBC();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){}
}
