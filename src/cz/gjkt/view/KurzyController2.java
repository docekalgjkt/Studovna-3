package cz.gjkt.view;

import cz.gjkt.model.Kurz;
import cz.gjkt.model.KurzyDAOJDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class KurzyController2 extends ListViewController<Kurz> {

    @FXML
    TableView tableView;

    @Override
    protected void initController() {
        window = "../view/Kurz.fxml";
        modelDao = new KurzyDAOJDBC();
    }

    @Override
    protected void initColumns() {
        TableColumn<String, Kurz> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<String, Kurz> nazevColumn = new TableColumn<>("Název");
        nazevColumn.setCellValueFactory(new PropertyValueFactory<>("nazev"));
        TableColumn<String, Kurz> skolniRokColumn = new TableColumn<>("Školní Rok");
        skolniRokColumn.setCellValueFactory(new PropertyValueFactory<>("skolniRok"));
        TableColumn<String, Kurz> predmetColumn = new TableColumn<>("Předmět");
        predmetColumn.setCellValueFactory(new PropertyValueFactory<>("predmet"));
        nazevColumn.setEditable(true);

        tableView.getColumns().addAll(idColumn, nazevColumn,skolniRokColumn,predmetColumn);
    }

    @Override
    protected Kurz createNewItem() {
        return new Kurz();
    }

    public void handleOtevriButton(ActionEvent actionEvent){
        window = "../view/KurzData.fxml";
        handleUpravButton(actionEvent);
    }
}
