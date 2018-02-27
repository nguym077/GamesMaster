import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// handles all events on screen (listener)
public class MainController {
    @FXML
    private GridPane mazeGrid;

    @FXML
    private Text mazeMoveLabel;

    @FXML
    private Circle mazeUserLocation;

    Maze mazeGame = new Maze();
    int xCurrent = 0;
    int yCurrent = 0;

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

        if (xCurrent == 0) {
            mazeMoveLabel.setText("Illegal move. Try again!");
        } else {
            mazeMoveLabel.setText("Moved UP one space.");
            xCurrent -= 1;
            GridPane.setRowIndex(mazeUserLocation, xCurrent);
        }
    }

    public void handleMazeLeftButton(ActionEvent e) {
        System.out.println("LEFT button was pushed.");

        if (yCurrent == 0) {
            mazeMoveLabel.setText("Illegal move. Try again!");
        } else {
            mazeMoveLabel.setText("Moved LEFT one space.");
            yCurrent -= 1;
            GridPane.setColumnIndex(mazeUserLocation, yCurrent);
        }
    }

    public void handleMazeRightButton(ActionEvent e) {
        System.out.println("RIGHT button was pushed.");

        if (yCurrent == 7) {
            mazeMoveLabel.setText("Illegal move. Try again!");
        } else {
            mazeMoveLabel.setText("Moved RIGHT one space.");
            yCurrent += 1;
            mazeUserLocation.setLayoutY(yCurrent);
            GridPane.setColumnIndex(mazeUserLocation, yCurrent);
        }
    }

    public void handleMazeDownButton(ActionEvent e) {
        System.out.println("DOWN button was pushed.");
        if (xCurrent == 7) {
            mazeMoveLabel.setText("Illegal move. Try again!");
        } else {
            mazeMoveLabel.setText("Moved DOWN one space.");
            xCurrent += 1;
            GridPane.setRowIndex(mazeUserLocation, xCurrent);
        }
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
