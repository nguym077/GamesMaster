import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MazeController {
    // maze attributes
    @FXML
    private GridPane mazeGrid;

    @FXML
    private Text mazeMoveLabel;

    @FXML
    private Circle mazeUserLocation;

    @FXML
    private Region grid00;

    private Maze mazeGame = new Maze();
    private int[][] mazeArray = mazeGame.getMazeArray();
    private int xCurrent = 0;
    private int yCurrent = 0;

    public void setUpMaze() throws Exception {
        // -fx-background-insets: 0 0 0 0;
        // top, right, bottom, left
        Stage mazeStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("maze.fxml"));

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
}
