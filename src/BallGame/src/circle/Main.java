package circle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application implements PublicVar{
	Pane root;
	Pane data;
	
	public void start(Stage stage) {
		root =new Pane();  //this is the game pane
        data =new Pane();  //this pane will record game Data like health, power etc.
        root.setMaxSize(sizeX, sizeY);
        root.setStyle("-fx-background-color: white");
        data.setMaxSize(sizeX, 50);
        data.setStyle("-fx-background-color: grey;");
        BorderPane pane = new BorderPane();
        pane.setMaxWidth(sizeX);pane.setMaxHeight(sizeY+50);
        
        root.getChildren().add(group);
        
        initclass();
        pane.setTop(root);
        //pane.setBottom(root);
        Keyboard newKeyboard = new Keyboard();
        newKeyboard.init();
        Scene scene = new Scene(pane,sizeX,sizeY+50);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override

            public void handle(KeyEvent event) {
            	newKeyboard.keypressed(event);
            	
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
            	newKeyboard.keyrelease(event);

            }
        });
        
        stage.setTitle("circle");
        //stage.setWidth(700);
        //stage.setHeight(600);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
	}
	public void initclass()
	{
		Map newMap=new Map();
		newMap.init();
		fireball newCircle = new fireball();
		newCircle.init();
		bunny newBunny=new bunny();
		newBunny.init();
		hero newHero=new hero();
		newHero.init();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
