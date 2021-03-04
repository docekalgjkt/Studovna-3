package cz.gjkt.view;

import cz.gjkt.application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    Button kurzId;

    public void selectPredmety(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Predmety.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        
        Main.getPrimaryStage().setScene(scene);
    }

    public void selectStudenti(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Studenti.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }

    public void selectKurzy(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Kurzy.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }

    public void selectTypyZnamek(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/TypyZnamek.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }

    public void selectDruhyZnamek(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/DruhyZnamek.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }

    public void selectSkolniRok(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/SkolniRok.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }

  /*  public void selectNastaveni(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Nefunguje.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }*/

    public void selectOAplikaci(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/OAplikaci.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }

    public void selectUzivatel(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Nefunguje.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }

    public void selectStudentiKurzu(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/StudentiKurzu.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }

    public void odhlasit(){
        System.exit(0);
    }
}
