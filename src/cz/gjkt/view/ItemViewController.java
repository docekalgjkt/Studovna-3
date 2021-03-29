package cz.gjkt.view;

import cz.gjkt.application.Main;
import cz.gjkt.model.IModelDao;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class ItemViewController<T> implements Initializable {

    protected IModelDao modelDao;
    protected ListViewController listViewController;
    protected Scene listViewScene;
    T item;

    public void setListViewController(ListViewController controller){}
    public void setListViewScene(Scene scene){}
    public void setItem(T item){this.item = item;}

    protected void handleUlozButton() {
 /*       IModel i = (IModel) item;
        if (i.getId() == 0) {
            i.setId(modelDao.insert(item));
            listViewController.addItem(item);
        } else {
            modelDao.update(item);
        }
        Main.getPrimaryStage().setScene(listViewScene);
        listViewController.refresh();*/
    }

    public void handleZahodButton(){
        Main.getPrimaryStage().setScene(listViewScene);
    }

    protected abstract void initController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initController();
    }
}
