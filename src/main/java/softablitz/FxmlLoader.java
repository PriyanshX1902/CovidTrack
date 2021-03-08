package softablitz;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class FxmlLoader {
    private Pane view;
    public Pane getPage(String fileName) throws IOException {
        try {
            URL fileUrl = Main.class.getResource(fileName);
            if(fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view = new FXMLLoader().load(fileUrl);

        } catch (FileNotFoundException e) {
            System.out.println("No page "+fileName+" please check FxmlLoader");
            e.printStackTrace();
        }
        return view;
    }
}
