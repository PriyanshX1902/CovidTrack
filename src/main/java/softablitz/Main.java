package softablitz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        primaryStage.setTitle("TRACK A COV");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        HomeSQL.HomeSQL();
        HelplineSQL.HelplineSQL();
        NotificationsSQL notificationsSQL = new NotificationsSQL();
        notificationsSQL.NotificationsSQL();
        DatewiseSQL.DatewiseSQL();
        launch(args);
    }
}

