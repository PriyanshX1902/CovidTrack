package Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

public class SymptomController implements Initializable{
    @FXML private ComboBox<String> Age;
    @FXML private ComboBox<String> Sex;
    @FXML private  RadioButton Yes;
    @FXML private  RadioButton No;
    @FXML private  CheckBox None;
    @FXML private CheckBox Fever;
    @FXML private CheckBox DryCough;
    @FXML private CheckBox FeelingShortnessOfBreath;
    @FXML private CheckBox SoreThroat;
    @FXML private CheckBox HoarsenessInVoice;
    @FXML private CheckBox Headache;
    @FXML private CheckBox RunningNose;
    @FXML private CheckBox LossOfSmellAndTaste;
    @FXML private Button Submit;
    @FXML private Button Reset;
    @FXML private Label Score;
    @FXML private Label Risk;

    public void ComboBoxes(){

        Age.getItems().setAll("Below 5 years", "5-18 years", "18-30 years", "30-50 years", "Above 50 years");
        Sex.getItems().setAll("Female", "Male", "Other");
        ToggleGroup tg = new ToggleGroup();
        Yes.setToggleGroup(tg);
        No.setToggleGroup(tg);
    }
    public int CalculateResult(){
        int Result = 0;
        if(Fever.isSelected()){
            Result+=18;
        }
        if(DryCough.isSelected()){
            Result+=12;
        }
        if(FeelingShortnessOfBreath.isSelected()){
            Result+=12;
        }
        if(SoreThroat.isSelected()){
            Result+=8;
        }
        if(RunningNose.isSelected()){
            Result+=6;
        }
        if(HoarsenessInVoice.isSelected()){
            Result+=5;
        }
        if(Headache.isSelected()){
            Result+=5;
        }
        if(LossOfSmellAndTaste.isSelected()){
            Result+=4;
        }
        if(Age.getSelectionModel().getSelectedItem().equals("Below 5 years")){
            Result+=8;
        }
        if(Age.getSelectionModel().getSelectedItem().equals("5-18 years")){
            Result+=5;
        }
        if(Age.getSelectionModel().getSelectedItem().equals("18-30 years")){
            Result+=6;
        }
        if(Age.getSelectionModel().getSelectedItem().equals("30-50 years")){
            Result+=9;
        }
        if(Age.getSelectionModel().getSelectedItem().equals("Above 50 years")){
            Result+=10;
        }
        if(Sex.getSelectionModel().getSelectedItem().equals("Female")){
            Result+=3;
        }
        if(Sex.getSelectionModel().getSelectedItem().equals("Male")){
            Result+=5;
        }
        if(Sex.getSelectionModel().getSelectedItem().equals("Other")){
            Result+=4;
        }
        if(Yes.isSelected()){
            Result+=25;
        }
        return Result;
    }
    public void ShowResult(int result) {
        Score.setTextFill(Color.BLACK);
        Risk.setTextFill(Color.BLACK);
        if (result > 55) {
            Score.setTextFill(Color.RED);
            Risk.setText("High Risk");
            Risk.setTextFill(Color.RED);

        } else if (result > 40) {
            Score.setTextFill(Color.ORANGE);
            Risk.setText("Medium Risk");
            Risk.setTextFill(Color.ORANGE);

        } else {
            Score.setTextFill(Color.GREEN);
            Risk.setText("Low Risk");
            Risk.setTextFill(Color.GREEN);

        }
        String score = Integer.toString(result);
        Score.setText(score + "/100");

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ComboBoxes();
        Submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                ShowResult(CalculateResult());
            }
        });

    }
}
