package Maze;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MazeController implements Initializable {
    // maze attributes
    @FXML
    private GridPane mazeGrid;

    @FXML
    private Text mazeMoveLabel;

    @FXML
    private Circle userLocation;

    @FXML
    private Circle endLocation;

    @FXML
    private Button upButton;

    @FXML
    private Button rightButton;

    @FXML
    private Button downButton;

    @FXML
    private Button leftButton;

    private int[][] mazeArray;
    private int xCurrent = 0;
    private int yCurrent = 0;

    @Override
    public void initialize(URL url, ResourceBundle res) {
        Maze mazeGame = new Maze();
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

        userLocation.toFront();
        endLocation.toFront();
    }

    public void handleMazeUpButton(ActionEvent e) {
        if (xCurrent == 0) {
            mazeMoveLabel.setText("Illegal move. Try again!");
        } else {
            String possibleMoves = Integer.toString(mazeArray[yCurrent][xCurrent]);
            if (possibleMoves.contains(Character.toString('1'))) {
                mazeMoveLabel.setText("Moved UP one space.");
                xCurrent -= 1;
                GridPane.setRowIndex(userLocation, xCurrent);
            } else {
                mazeMoveLabel.setText("Illegal move. Try again!");
            }
        }

        if (xCurrent == 7 && yCurrent == 7) {
            mazeMoveLabel.setText("CONGRATS! YOU WIN! :-)");
            upButton.setDisable(true);
            rightButton.setDisable(true);
            downButton.setDisable(true);
            leftButton.setDisable(true);

        }
    }

    public void handleMazeRightButton(ActionEvent e) {
        if (yCurrent == 7) {
            mazeMoveLabel.setText("Illegal move. Try again!");
        } else {
            String possibleMoves = Integer.toString(mazeArray[yCurrent][xCurrent]);
            if (possibleMoves.contains(Character.toString('2'))) {
                mazeMoveLabel.setText("Moved RIGHT one space.");
                yCurrent += 1;
                GridPane.setColumnIndex(userLocation, yCurrent);
            } else {
                mazeMoveLabel.setText("Illegal move. Try again!");
            }
        }

        if (xCurrent == 7 && yCurrent == 7) {
            mazeMoveLabel.setText("CONGRATS! YOU WIN! :-)");
            upButton.setDisable(true);
            rightButton.setDisable(true);
            downButton.setDisable(true);
            leftButton.setDisable(true);

        }
    }

    public void handleMazeDownButton(ActionEvent e) {
        if (xCurrent == 7) {
            mazeMoveLabel.setText("Illegal move. Try again!");
        } else {
            String possibleMoves = Integer.toString(mazeArray[yCurrent][xCurrent]);
            if (possibleMoves.contains(Character.toString('3'))) {
                mazeMoveLabel.setText("Moved DOWN one space.");
                xCurrent += 1;
                GridPane.setRowIndex(userLocation, xCurrent);
            } else {
                mazeMoveLabel.setText("Illegal move. Try again!");
            }
        }

        if (xCurrent == 7 && yCurrent == 7) {
            mazeMoveLabel.setText("CONGRATS! YOU WIN! :-)");
            upButton.setDisable(true);
            rightButton.setDisable(true);
            downButton.setDisable(true);
            leftButton.setDisable(true);

        }
    }

    public void handleMazeLeftButton(ActionEvent e) {
        if (yCurrent == 0) {
            mazeMoveLabel.setText("Illegal move. Try again!");
        } else {
            String possibleMoves = Integer.toString(mazeArray[yCurrent][xCurrent]);
            if (possibleMoves.contains(Character.toString('4'))) {
                mazeMoveLabel.setText("Moved LEFT one space.");
                yCurrent -= 1;
                GridPane.setColumnIndex(userLocation, yCurrent);
            } else {
                mazeMoveLabel.setText("Illegal move. Try again!");
            }
        }

        if (xCurrent == 7 && yCurrent == 7) {
            mazeMoveLabel.setText("CONGRATS! YOU WIN! :-)");
            upButton.setDisable(true);
            rightButton.setDisable(true);
            downButton.setDisable(true);
            leftButton.setDisable(true);

        }
    }
}
