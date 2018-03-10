package Mancala;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MancalaController implements Initializable{

    @FXML
    private GridPane manacalaBoard;

    @FXML
    private Text mancalaMoveLabel;

    @FXML
    private Text scoreBoard;

    private int[] mancalaArray;
    private int score[] = {0, 0};

    @Override
    public void initialize(URL url, ResourceBundle res) {
        Mancala mancalaGame = new Mancala();
        mancalaArray = mancalaGame.getMancalaArray();

    }

    public boolean checkIfLeftSideIsEmpty(){
        for(int i = 0; i < 7; i++){
            if(mancalaArray[i] > 0 ){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfRightSideIsEmpty(){
        for(int i = 7; i < 13; i++){
            if(mancalaArray[i] > 0 ){
                return false;
            }
        }
        return true;
    }



    public void handleMancalaSpace0(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. There are no pieces in there");
            mancalaMoveLabel.setText("Illegal move, can not pick from that side");
        }
        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);
        }
    }

    public void handleManacalaSpace1(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);
        }
    }

    public void handleManacalaSpace2(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);
        }
    }

    public void handleManacalaSpace3(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);
        }
    }

    public void handleManacalaSpace4(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);
        }
    }

    public void handleManacalaSpace5(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);
        }
    }

    public void handleManacalaSpace7(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);

        }
    }

    public void handleManacalaSpace18(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);

        }
    }

    public void handleManacalaSpace9(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);
        }
    }

    public void handleManacalaSpace10(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);
        }
    }

    public void handleManacalaSpace11(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);

        }
    }

    public void handleManacalaSpace12(ActionEvent e) {
        if (mancalaArray[0] == 0) {
            mancalaMoveLabel.setText("Illegal move. Try again!");
        }

        if (!checkIfLeftSideIsEmpty() || !checkIfRightSideIsEmpty()) {
            scoreBoard.setText( score[0] + " - " + score[1]);
        }
    }
}
