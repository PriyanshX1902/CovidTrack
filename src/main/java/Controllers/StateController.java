package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import softablitz.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class StateController implements Initializable {

    @FXML private TableView<StateList> stateTable;
    @FXML private TableColumn<StateList, String> stateUT;
    @FXML private TableColumn<StateList, Integer> confirmed;
    @FXML private TableColumn<StateList, Integer> recovered;
    @FXML private TableColumn<StateList, Integer> deaths;
    @FXML private TableColumn<StateList, Integer> total;
    @FXML private TextField searchField;
    @FXML private Label TimeStamp;

    public class StateList{
        public String State;
        public int active;
        public int recovered;
        public int deceased;
        public int total;

        public StateList(String state, int totalinfected, int recovered, int deceased, int total) {
            this.State = state;
            this.active = totalinfected;
            this.recovered = recovered;
            this.deceased = deceased;
            this.total = total;
        }

        public String getState() {
            return State;
        }
        public int getActive() {
            return active;
        }

        public int getRecovered() {
            return recovered;
        }
        public int getDeceased() {
            return deceased;
        }

        public int getTotal() {
            return total;
        }
    }

    public void showData()
    {
        try {
            StateList[] stateList = new StateList[0];
            Connection connection = SQLConnection.getConnection();
            ObservableList<StateList> stateObservableArrayList = FXCollections.observableArrayList(stateList);
            ResultSet resultSet = connection.createStatement().executeQuery("Select * from STATEWISE");
            while(resultSet.next()){
                stateObservableArrayList.add(new StateList(resultSet.getString("State"),
                        resultSet.getInt("Active"),
                        resultSet.getInt("Recovered"),
                        resultSet.getInt("Deceased"),
                        resultSet.getInt("TotalCases")));
            }
            Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
            String timeStampString = timestamp.toString();
            TimeStamp.setText(timeStampString);

            stateUT.setCellValueFactory(new PropertyValueFactory<StateList, String>("State"));
            confirmed.setCellValueFactory(new PropertyValueFactory<StateList, Integer>("active"));
            recovered.setCellValueFactory(new PropertyValueFactory<StateList, Integer>("recovered"));
            deaths.setCellValueFactory(new PropertyValueFactory<StateList, Integer>("deceased"));
            total.setCellValueFactory(new PropertyValueFactory<StateList, Integer>("total"));
            stateTable.setItems(stateObservableArrayList);

            FilteredList<StateList> filteredData = new FilteredList<>(stateObservableArrayList, b-> true);
            searchField.textProperty().addListener(((observableValue, oldValue, newValue) -> {
                filteredData.setPredicate(stateTable -> {
                    if(newValue==null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();

                    if(stateTable.getState().toLowerCase().indexOf(lowerCaseFilter)!=-1)
                        return true;
                    else
                        return false;
                });
            } ));
            SortedList<StateList> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(stateTable.comparatorProperty());
            stateTable.setItems(sortedData);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void handleBtnRefreshAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        HomeSQL homeSQL = new HomeSQL();
        homeSQL.HomeSQL();
        showData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showData();
    }
}
