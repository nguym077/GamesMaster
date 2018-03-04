import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

// handles all events on screen (listener)
public class MainController {
    @FXML
    private MazeController mazeController = new MazeController();

    public void handleMazeButton() throws Exception {
        System.out.println("Maze button clicked");
        System.out.println("Start maze game.");
        mazeController.setUpMaze();
    }

    public void handleConcButton() {
        System.out.println("Concentration button clicked");
        System.out.println("Start concentration game.");
    }

    public void handleMancalaButton() {
        System.out.println("Mancala button clicked");
        System.out.println("Start mancala game.");
    }
}
