package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import softablitz.Helpline;
import softablitz.HelplineAPI;
import softablitz.HelplineSQL;
import softablitz.SQLConnection;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class HelplineController implements Initializable {
    @FXML private Label number;
    @FXML private Label number_tollfree;
    @FXML private Hyperlink email;
    @FXML private Hyperlink twitter;
    @FXML private Hyperlink facebook;
    @FXML private TableView<Helpline.HelplineData.Contacts.Regional> regionalTable;
    @FXML private TableColumn<Helpline.HelplineData.Contacts.Regional, String> state;
    @FXML private TableColumn<Helpline.HelplineData.Contacts.Regional, String> contact;
    @FXML private TextField searchField;
    @FXML private Label TimeStamp;

    HelplineAPI helplineAPI = new HelplineAPI();

    public void PrimaryContact() {
        try {
            Helpline response = helplineAPI.HelplineAPI();
            Helpline.HelplineData.Contacts.Primary primary = response.data.contacts.primary;
            number.setText(primary.number);
            number_tollfree.setText("1075");
            email.setText(primary.email);
            twitter.setText(primary.twitter);
            facebook.setText(primary.facebook);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void handleBtnEmailAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        Helpline response = helplineAPI.HelplineAPI();
        Helpline.HelplineData.Contacts.Primary primary = response.data.contacts.primary;
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://mail.google.com/mail/u/?authuser=ncov2019@gov.in"));
    }

    public void handleBtnTwitterAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        Helpline response = helplineAPI.HelplineAPI();
        Helpline.HelplineData.Contacts.Primary primary = response.data.contacts.primary;
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(primary.twitter));
    }

    public void handleBtnFacebookAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        Helpline response = helplineAPI.HelplineAPI();
        Helpline.HelplineData.Contacts.Primary primary = response.data.contacts.primary;
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(primary.facebook));
    }

    public void handleBtnRefreshAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        HelplineSQL helplineSQL = new HelplineSQL();
        helplineSQL.HelplineSQL();
        PrimaryContact();
        RegionalContact();
    }


    public void RegionalContact() {
        try {
            Helpline.HelplineData.Contacts.Regional[] regional = new Helpline.HelplineData.Contacts.Regional[0];

            ObservableList<Helpline.HelplineData.Contacts.Regional> regionalList = FXCollections.observableArrayList(regional);

            Connection connection = SQLConnection.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from HELPLINESREGIONAL");

            while(resultSet.next()) {
                regionalList.add(new Helpline.HelplineData.Contacts.Regional(resultSet.getString("state"), resultSet.getString("contact")));
            }
            Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
            String timeStampString = timestamp.toString();
            TimeStamp.setText(timeStampString);

            state.setCellValueFactory(new PropertyValueFactory<Helpline.HelplineData.Contacts.Regional, String>("loc"));
            contact.setCellValueFactory(new PropertyValueFactory<Helpline.HelplineData.Contacts.Regional, String>("number"));
            regionalTable.setItems(regionalList);

            FilteredList<Helpline.HelplineData.Contacts.Regional> filteredData = new FilteredList<>(regionalList, b-> true);

            searchField.textProperty().addListener(((observableValue, oldValue, newValue) -> {
                filteredData.setPredicate(regionalTable -> {
                    if(newValue==null)
                        return true;

                    String lowerCaseFilter = newValue.toLowerCase();

                    if(regionalTable.getLoc().toLowerCase().indexOf(lowerCaseFilter)!=-1)
                        return true;
                    else
                        return false;
                });
            } ));
            SortedList<Helpline.HelplineData.Contacts.Regional> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(regionalTable.comparatorProperty());
            regionalTable.setItems(sortedData);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PrimaryContact();
        RegionalContact();
    }

}
