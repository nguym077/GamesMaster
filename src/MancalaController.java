import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MancalaController implements Initializable {

    @FXML
    private GridPane manacalaBoard;


    private int[] mancalaArray;

    @Override
    public void initialize(URL url, ResourceBundle res) {
        Mancala mancalaGame = new Mancala();
        mancalaArray = mancalaGame.getMancalaArray();

    }

    public void handleMancalaSpace0(ActionEvent e) {
//        if (xCurrent == 0) {
//            mazeMoveLabel.setText("Illegal move. Try again!");
//        } else {
//            String possibleMoves = Integer.toString(mazeArray[yCurrent][xCurrent]);
//            if (possibleMoves.contains(Character.toString('1'))) {
//                mazeMoveLabel.setText("Moved UP one space.");
//                xCurrent -= 1;
//                GridPane.setRowIndex(userLocation, xCurrent);
//            } else {
//                mazeMoveLabel.setText("Illegal move. Try again!");
//            }
//        }
//
//        if (xCurrent == 7 && yCurrent == 7) {
//            mazeMoveLabel.setText("CONGRATS! YOU WIN! :-)");
//            upButton.setDisable(true);
//            rightButton.setDisable(true);
//            downButton.setDisable(true);
//            leftButton.setDisable(true);
//        }
    }

    public void handleManacalaSpace1(ActionEvent e) {

    }

    public void handleManacalaSpace2(ActionEvent e) {

    }

    public void handleManacalaSpace3(ActionEvent e) {

    }

    public void handleManacalaSpace4(ActionEvent e) {

    }

    public void handleManacalaSpace5(ActionEvent e) {

    }

    public void handleManacalaSpace7(ActionEvent e) {

    }

    public void handleManacalaSpace18(ActionEvent e) {

    }

    public void handleManacalaSpace9(ActionEvent e) {

    }

    public void handleManacalaSpace10(ActionEvent e) {

    }

    public void handleManacalaSpace11(ActionEvent e) {

    }

    public void handleManacalaSpace12(ActionEvent e) {

    }
}
