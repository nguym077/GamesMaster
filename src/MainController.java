import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button mazeButton;

    @FXML
    private MazeController mazeController = new MazeController();
    
    @FXML
    private Button mancalaButton;

    @FXML
    private MazeController mancalaController = new MazeController();

    public void handleMazeButton() throws Exception {
        System.out.println("Maze button clicked");
        System.out.println("Start maze game.");

        Stage mazeStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("maze.fxml"));
        Scene scene = new Scene(root);
        mazeStage.setTitle("Maze");

        mazeStage.setScene(scene);
        mazeStage.show();
    }

    public void handleConcButton() {
        System.out.println("Concentration button clicked");
        System.out.println("Start concentration game.");
    }

    public void handleMancalaButton() throws Exception {
        System.out.println("Mancala button clicked");
        System.out.println("Start mancala game.");
        
        Stage mazeStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("mancala.fxml"));
        Scene scene = new Scene(root);
        mazeStage.setTitle("Mancala");

        mazeStage.setScene(scene);
        mazeStage.show();
    }
}
