package cz.gjkt.view;

import cz.gjkt.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.Map;


public class KurzDataController extends ItemViewController {

    @FXML
    TableView tableView;

    @FXML
    TextField nazevKurzu;

    private StudentiKurzu studenti;
    private List<DruhZnamky> druhyZnamekKurzu;

    public void setItem(Kurz kurz){
        super.setItem(kurz);
        nazevKurzu.setText(kurz.getNazev());
        studenti = getStudenti();
        druhyZnamekKurzu = new DruhyZnamekKurzuDAO(kurz).getAll();
        setColumns();
        fillTable();
    }

    private void fillTable() {
        if (studenti != null) {
            for (Student s : studenti.getStudenti()){
                tableView.getItems().add(0,s);
            }
        }
    }

    private StudentiKurzu getStudenti(){return null;}

    private void setColumns(){
        tableView .getColumns().clear();
        TableColumn<String, Student> prijmeniColumn = new TableColumn<>("Student");
        prijmeniColumn.setCellValueFactory(new PropertyValueFactory<>("prijmeni"));
        tableView.getColumns().add(prijmeniColumn);
        for (DruhZnamky dz : druhyZnamekKurzu){
            TableColumn<Map, DruhZnamky> tableColumn = new TableColumn<>(dz.getNazev());
            tableColumn.setCellValueFactory(new MapValueFactory<>(dz));
            tableView.getColumns().add(tableColumn);
        }
    }

    @Override
    protected void initController() {
        modelDao = new DruhyZnamekDAOJDBC();
    }
}
