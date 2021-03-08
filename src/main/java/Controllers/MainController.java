package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import softablitz.FxmlLoader;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private HomeController homeController;
    @FXML private StateController stateController;
    @FXML private Button btnHome;
    @FXML private Button btnState;
    @FXML private Button btnDate;
    @FXML private Button btnNews;
    @FXML private Button btnHelpline;
    @FXML private Button btnSymptom;
    @FXML private Button btnDistrict;
    @FXML private BorderPane mainPane;


    public void handleBtnHomeAction(ActionEvent actionEvent) throws IOException, SQLException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/Home.fxml");
        mainPane.setCenter(view);
    }

    public void handleBtnStateAction(ActionEvent actionEvent) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/State.fxml");
        mainPane.setCenter(view);
    }

    public void handleBtnDateAction(ActionEvent actionEvent) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/Datewise.fxml");
        mainPane.setCenter(view);
    }

    public void handleBtnNewsAction(ActionEvent actionEvent) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/Notifications.fxml");
        mainPane.setCenter(view);
    }

    public void handleBtnHelplineAction(ActionEvent actionEvent) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/Helpline.fxml");
        mainPane.setCenter(view);
    }

    public void handleBtnSymptomAction(ActionEvent actionEvent) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/Symptom.fxml");
        mainPane.setCenter(view);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
