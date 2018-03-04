import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MazeController implements Initializable {
    // maze attributes
    @FXML
    private GridPane mazeGrid;

    @FXML
    private Text mazeMoveLabel;

    @FXML
    private Circle mazeUserLocation;

    private Maze mazeGame;
    private int[][] mazeArray;
    private int xCurrent = 0;
    private int yCurrent = 0;

    @Override
    public void initialize(URL url, ResourceBundle res) {
        Stage tempStage = new Stage();

        mazeGame = new Maze();
        mazeArray = mazeGame.getMazeArray();

        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray.length; j++) {
                Region r = new Region();

                // 1 == UP, 2 == RIGHT, 3 == DOWN, 4 == LEFT
                String directions =  Integer.toString(mazeArray[i][j]);
                String css = "";
                if (directions.contains(Character.toString('1'))) {
                    css = css.concat("0 ");
                } else {
                    css = css.concat("3 ");
                }

                if (directions.contains(Character.toString('2'))) {
                    css = css.concat("0 ");
                } else {
                    css = css.concat("3 ");
                }

                if (directions.contains(Character.toString('3'))) {
                    css = css.concat("0 ");
                } else {
                    css = css.concat("3 ");
                }

                if (directions.contains(Character.toString('4'))) {
                    css = css.concat("0;");
                } else {
                    css = css.concat("3;");
                }

                r.setStyle("-fx-background-color: #c5c5c5; -fx-background-insets: " + css);
                mazeGrid.add(r, i, j);
            }
        }
    }

    public void handleMazeUpButton(ActionEvent e) {
        System.out.println(mazeMoveLabel);

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
