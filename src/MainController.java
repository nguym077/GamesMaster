import javafx.application.Platform;
import javafx.event.ActionEvent;

// handles all events on screen (listener)
public class MainController {
    public void handleMazeButton(ActionEvent e) {
        System.out.println("Maze button clicked");
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
