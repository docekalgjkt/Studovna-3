package cz.gjkt.view;

import cz.gjkt.application.Main;
import cz.gjkt.model.Kurz;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Optional;

public class StudentiKurzuController {

    public void handlePridejButton(){}

    public void handleSmazButton(){}

    public void handleUpravButton(){}

    public void handleDomu() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/main.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }
}
