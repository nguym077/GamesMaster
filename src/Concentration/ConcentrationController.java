package Concentration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ConcentrationController implements Initializable {
    class MButton extends Button {
        String value;
        String faceDown;

        public MButton(String x) {
            faceDown = " ";
            value = x;
        }

        void faceUp() {
            setText(value);
        }

        void faceDown() {
            setText(faceDown);
        }
    }

    @FXML
    GridPane concGrid;

    private int[][] gridArray;
    private int rows;
    private int cols;
    private MButton firstChoice;
    private MButton secondChoice;
    private Timeline delayForCheck;

    private boolean twoPicks = false;

    @Override
    public void initialize(URL url, ResourceBundle res) {
        Concentration concGame = new Concentration();

        rows = concGame.getNumberOfRows();
        cols = concGame.getNumberOfColumns();
        gridArray = concGame.getBoard();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String value = Integer.toString(gridArray[i][j]);
                MButton button = new MButton(value);
                button.setStyle("-fx-pref-height: 80px; -fx-pref-width: 80px; -fx-font-size: 25px");
                button.faceDown();

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        button.faceUp();
                    }
                });

                concGrid.add(button, i, j);
            }
        }
    }
}
