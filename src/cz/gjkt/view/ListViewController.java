package cz.gjkt.view;

import cz.gjkt.application.Main;
import cz.gjkt.model.IModelDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class ListViewController<T> implements Initializable {

    @FXML
    TableView tableView;

    ObservableList<T> items;
    ObservableList<T> selectedItems = null;

    String window;
    IModelDao modelDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initController();
        initColumns();
        fillTable();
        handleSelection();
    }

    protected abstract void initController();
    protected abstract void initColumns();
    protected abstract T createNewItem();

    protected void fillTable() {
        items = FXCollections.observableList(modelDao.getAll());
        tableView.setItems(items);
    }
    protected void handleSelection(){
        TableView.TableViewSelectionModel<T> selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        selectedItems = selectionModel.getSelectedItems();
    }
    public void handlePridejButton(ActionEvent actionEvent){
        otevriItemWindow(window, createNewItem());
    }
    public void handleSmazButton(ActionEvent actionEvent){
        T item = (T) tableView.getSelectionModel().getSelectedItem();
        items.remove(item);
        modelDao.delete(item);
        tableView.refresh();
    }
    public void handleUpravButton(ActionEvent actionEvent) {
        T item = (T) tableView.getSelectionModel().getSelectedItem();
        if (item != null) otevriItemWindow(window, item);
    }
    public void handleDomuButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Main.fxml"));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(rootLayout);

        Main.getPrimaryStage().setScene(scene);
    }

    protected void otevriItemWindow(String window, T item){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(window));
        AnchorPane rootLayout = null;
        try {
            rootLayout = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ItemViewController controller = (ItemViewController) loader.getController();
        controller.setItem(item);
        controller.setListViewScene(tableView.getScene());
        controller.setListViewController(this);
        Scene scene = new Scene(rootLayout);
        Stage ps = Main.getPrimaryStage();
        ps.setScene(scene);
    }
    public void addItem(T item) {items.add(item);}
    public void refresh(){tableView.refresh();}
}
