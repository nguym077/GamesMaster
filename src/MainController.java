import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// handles all events on screen (listener)
public class MainController {
    @FXML
    private GridPane mazeGrid;

    @FXML
    private Text moveLabel;

    Maze mazeGame = new Maze();

    public void handleMazeButton(ActionEvent e) throws Exception {
        Stage mazeStage = new Stage();

        System.out.println("Maze button clicked");
        System.out.println("Start maze game.");

        Parent root = FXMLLoader.load(getClass().getResource("maze.fxml"));
        Path p = mazeGame.getPath();
        Path p1 = mazeGame.getPath1();


        mazeStage.setTitle("Maze");
        Scene scene = new Scene(root);
        mazeStage.setScene(scene);
        mazeStage.show();
    }

    public void handleMazeUpButton(ActionEvent e) {
        System.out.println("UP button was pushed.");
        moveLabel.setText("Moved UP one space.");
    }

    public void handleMazeLeftButton(ActionEvent e) {
        System.out.println("LEFT button was pushed.");
        moveLabel.setText("Moved LEFT one space.");
    }

    public void handleMazeRightButton(ActionEvent e) {
        System.out.println("RIGHT button was pushed.");
        moveLabel.setText("Moved RIGHT one space.");
    }

    public void handleMazeDownButton(ActionEvent e) {
        System.out.println("DOWN button was pushed.");
        moveLabel.setText("Moved DOWN one space.");
    }

    public void handleConcButton(ActionEvent e) {
        System.out.println("Concentration button clicked");
    }

    public void handleMancalaButton(ActionEvent e) {
        System.out.println("Mancala button clicked");
    }

    public void handleQuitButton(ActionEvent e) {
        System.exit(0);
    }
}
