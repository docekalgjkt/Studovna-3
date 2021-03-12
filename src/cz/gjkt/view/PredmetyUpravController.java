package cz.gjkt.view;

import cz.gjkt.application.Main;
import cz.gjkt.model.Predmet;
import cz.gjkt.model.PredmetyDAOJDBC;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PredmetyUpravController implements Initializable {

        PredmetyController predmetController;
        Scene predmetyScene;
        Predmet predmet;

        @FXML
        TextField nazev;

        @FXML
        TextField popis;

        @FXML
        TextField sylabus;

        @FXML
        TextField zkratka;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }

        private void setNazev(String nazev){this.nazev.setText(nazev);}
        private void setPopis(String popis){this.popis.setText(popis);}
        private void setSylabus(String sylabus){this.sylabus.setText(sylabus);}
        private void setZkratka(String zkratka){this.zkratka.setText(zkratka);}

        public void setPredmetyScene(Scene scene){predmetyScene = scene;}
        public void setPredmetController(PredmetyController controller){predmetController = controller;}

        public void setPredmet(Predmet predmet){
            this.predmet = predmet;
            setNazev(predmet.getNazev());
            setPopis(predmet.getPopis());
            setSylabus(predmet.getSylabus());
            setZkratka(predmet.getZkratka());
        }

        public void handleZahodButton() {
            Main.getPrimaryStage().setScene(predmetyScene);
        }

        public void handleUlozButton(){
            PredmetyDAOJDBC predmetyDAO = new PredmetyDAOJDBC();
            predmet.setNazev(nazev.getText());
            predmet.setPopis(popis.getText());
            predmet.setSylabus(sylabus.getText());
            predmet.setZkratka(zkratka.getText());
            predmetyDAO.update(predmet);
            Main.getPrimaryStage().setScene(predmetyScene);
            predmetController.refresh();
        }

    }
