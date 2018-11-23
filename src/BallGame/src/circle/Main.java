package circle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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

        Scene scene = new Scene(pane,sizeX,sizeY+50);
        stage.setTitle("circle");
        //stage.setWidth(700);
        //stage.setHeight(600);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
	}
	public void initclass()
	{
		
		test newCircle = new test();
		newCircle.init();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
