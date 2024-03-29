import Concentration.Concentration;
import Halloween.PumpkinMan;
import Maze.MazeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tank.Tank;

// handles all events on screen (listener)
public class MainController {
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

    public void handleConcButton() throws Exception {
        Stage concStage = new Stage();
        Concentration concGame = new Concentration();
        concGame.start(concStage);

//        System.out.println("Concentration button clicked");
//        System.out.println("Start concentration game.");
//
//        Stage concStage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("Concentration/concentration.fxml"));
//        Scene scene = new Scene(root);
//        concStage.setTitle("Concentration");
//
//        concStage.setScene(scene);
//        concStage.show();
    }

    public void handleMancalaButton() throws Exception {
        System.out.println("Mancala button clicked");
        System.out.println("Start mancala game.");
        
        Stage mancalaStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Mancala/mancala.fxml"));
        Scene scene = new Scene(root);
        mancalaStage.setTitle("Mancala");

        mancalaStage.setScene(scene);
        mancalaStage.show();
    }

    public void handleChessButton() throws Exception {
        System.out.println("Chess button clicked");
        System.out.println("Start Chess game.");

        Stage chessStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Chess/chess.fxml"));
        Scene scene = new Scene(root);
        chessStage.setTitle("Chess");

        chessStage.setScene(scene);
        chessStage.show();
    }

    public void handleTankButton() throws Exception {
        System.out.println("Tank button clicked");
        System.out.println("Start Tank game.");

        Stage tankStage = new Stage();
        Tank tankGame = new Tank();
        tankGame.start(tankStage);
    }

    public void handlePumpkinButton() throws Exception {
        System.out.println("Pumpkin-Man button clicked.");
        System.out.println("Start Pumpkin-Man game.");

        Stage pumpkinStage = new Stage();
        PumpkinMan pumpkinGame = new PumpkinMan();
        pumpkinGame.start(pumpkinStage);
    }
}
