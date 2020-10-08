package cz.gjkt.view;

import cz.gjkt.model.Kurz;
import cz.gjkt.model.KurzyDAOJDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class KurzyController {

    @FXML
    TableView tableView;

    KurzyDAOJDBC kurzyDao = new KurzyDAOJDBC();
    List<Kurz> kurzy;
    ObservableList<Kurz> items;
    ObservableList<Kurz> selectedItems = null;

    public void fillTable(){
        kurzy = kurzyDao.getAll();
        items = FXCollections.observableList(kurzy);
        tableView.setItems(items);
        }



    public void initColumns() {

        TableColumn<String, Kurz> nazevColumn = new TableColumn<>("Název");
        nazevColumn.setCellValueFactory(new PropertyValueFactory<>("nazev"));
        TableColumn<String, Kurz> predmetColumn = new TableColumn<>("Předmět");
        predmetColumn.setCellValueFactory(new PropertyValueFactory<>("predmet"));

        tableView.getColumns().addAll(nazevColumn,predmetColumn);
    }

    
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initColumns();
        fillTable();
        handleSelection();
    }

    public void handleSelection(){
        TableView.TableViewSelectionModel<Kurz> selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        selectedItems = selectionModel.getSelectedItems();
    }

    public void handlePridejButton(){
        Dialog<Kurz> dialog = new Dialog<>();
        dialog.setTitle("Nový kurz");
        dialog.setWidth(400);
        dialog.setHeight(300);
        kurzDialog(dialog);

        final Optional<Kurz> vysledek = dialog.showAndWait();
        if(vysledek.isPresent()){
            Kurz novyKurz = vysledek.get();
            kurzy.add(novyKurz);
            kurzyDao.insert(novyKurz);
        }
        tableView.refresh();

    }

    private void kurzDialog(Dialog dialog){
        // Vytvoření "potvrzovacího" tlačítka pro potvrzení dialogu
        ButtonType createButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        // Nastavení tlačítek dialogu
        dialog.getDialogPane().getButtonTypes().setAll(createButtonType, ButtonType.CANCEL);

        // Mřížka
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Komponenty
        TextField nazevTextField = new TextField();
        Label nazevLabel = new Label("Název");
        TextField predmetTextField = new TextField();
        Label predmetLabel = new Label("Předmět");

        grid.add(nazevLabel, 0, 0);
        grid.add(nazevTextField, 1, 0);
        grid.add(predmetLabel,0,1);
        grid.add(predmetTextField,1,1);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(new Callback<ButtonType, Kurz>() {
            @Override
            public Kurz call(ButtonType param) {
                Kurz kurz = new Kurz();
                kurz.setNazev(nazevTextField.getText());
                kurz.setPredmet(predmetTextField.getText());
                return  kurz;
            }
        });
    }

    public void handleSmazButton(){

        Kurz item = (Kurz) tableView.getSelectionModel().getSelectedItem();
        System.out.println("Selected: " + item);
        kurzy.remove(item);
        kurzyDao.delete(item);
        tableView.refresh();
    }

    public void handleUpravButton(){

        tableView.refresh();
    }
}
