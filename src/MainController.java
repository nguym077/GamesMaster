import Maze.MazeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
        Parent root = FXMLLoader.load(getClass().getResource("Maze/maze.fxml"));
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
        Parent root = FXMLLoader.load(getClass().getResource("Mancala/mancala.fxml"));
        Scene scene = new Scene(root);
        mazeStage.setTitle("Mancala");

        mazeStage.setScene(scene);
        mazeStage.show();
    }
}
