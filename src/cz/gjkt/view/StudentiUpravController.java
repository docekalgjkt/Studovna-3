package cz.gjkt.view;

import cz.gjkt.application.Main;
import cz.gjkt.model.Student;
import cz.gjkt.model.StudentiDAOJDBC2;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentiUpravController implements Initializable {

    StudentiController studentController;
    Scene studentiScene;
    Student student;

    @FXML
    TextField jmeno;

    @FXML
    TextField prijmeni;

    @FXML
    TextField email;

    @FXML
    TextField rokNastupu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void setJmeno(String jmeno){this.jmeno.setText(jmeno);}
    private void setPrijmeni(String prijmeni){this.prijmeni.setText(prijmeni);}
    private void setEmail(String email){this.email.setText(email);}
    private void setRokNastupu(int rokNastupu){this.rokNastupu.setText(String.valueOf(rokNastupu));}

    public void setStudentiScene(Scene scene){studentiScene = scene;}
    public void setStudentController(StudentiController controller){studentController = controller;}

    public void setStudent(Student student){
        this.student = student;
        setJmeno(student.getJmeno());
        setPrijmeni(student.getPrijmeni());
        setEmail(student.getEmail());
        setRokNastupu(student.getRokNastupu());
    }

    public void handleZahodButton() {
        Main.getPrimaryStage().setScene(studentiScene);
    }

    public void handleUlozButton(){
        StudentiDAOJDBC2 studentiDAO = new StudentiDAOJDBC2();
        student.setJmeno(jmeno.getText());
        student.setPrijmeni(prijmeni.getText());
        student.setEmail(email.getText());
        student.setRokNastupu(rokNastupu.getText());
        studentiDAO.update(student);
        Main.getPrimaryStage().setScene(studentiScene);
        studentController.refresh();
    }

}

