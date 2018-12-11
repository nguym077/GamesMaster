package BallGame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BallGame extends Application implements PublicVar{
	
	
	public void start(Stage stage) {
	
		root[0]=new Pane();
		data[0]=new Pane();
		mapG[0]=new Group();
		root[0].setMaxSize(sizeX, sizeY);
		root[0].setStyle("-fx-background-color: black");
		data[0].setMaxSize(sizeX, 50);
		data[0].setStyle("-fx-background-color: grey;");
        BorderPane pane = new BorderPane();
        pane.setMaxWidth(sizeX);pane.setMaxHeight(sizeY+50);
        
       
        root[0].getChildren().add(mapG[0]);
        root[0].getChildren().add(group);
        data[0].getChildren().add(dataG);
       
        initclass();
        pane.setTop(root[0]);
        pane.setBottom(data[0]);
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
		loadImage newLoadImage=new loadImage();
		newLoadImage.init();
		Map newMap=new Map();
		newMap.init();
		fireball newCircle = new fireball();
		newCircle.init();
		bunny newBunny=new bunny();
		newBunny.init();
		hero newHero=new hero();
		newHero.init();
		
		data newData=new data();
		newData.init();
		bird newBird=new bird();
		newBird.init();
		egg newEgg=new egg();
		newEgg.init();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
