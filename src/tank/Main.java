package tank;
import javafx.scene.input.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage; 
import javafx.beans.property.*;
import javafx.beans.binding.*;

import java.util.ArrayList;

import javafx.animation.*;


public class Main extends Application implements imageUi{
				
	
    @Override 
    public void start(Stage stage) {
    	
    	Ui gameUi=new Ui();
    	Animation gameAnima=new Animation();
    	Action gameAction=new Action();
    	BorderPane pane = new BorderPane();
    	pane.resize(500, 500);
    	
    	Pane root =new Pane();
    	
    	root.setMaxSize(sizeX, sizeY);
    	root.setStyle("-fx-background-color: black");
    	root.requestFocus();
    	//root.setStyle("-fx-background-image: url(images/Duke.png);");
    	
    	Button left=new Button("hi");
    	left.setDisable(true);
    	Button center=new Button("center");
    	FlowPane flow = new FlowPane();
    	//flow.setPadding(new Insets(10, 10, 10, 10));
    	//flow.setStyle("-fx-background-color: DAE6F3;");
    	//flow.setHgap(5);
    	flow.getChildren().addAll(left, center);
    	flow.resize(200, 200);
    
    	pane.setLeft(root);
    	pane.setCenter(flow);
    	
    	//ControlRoot.getChildren().addAll(root,root2);
        Scene scene = new Scene(pane,500,500);
       
        scene.setFill(Color.BLACK);
        
        for(int i=0;i<board.length;i++)
        {
        	root.getChildren().add(board[i]);
        	
        }
        for(int i=0;i<playerTank.length;i++)
        {
        	root.getChildren().add(playerTank[i]);
        }
        for(int i=0;i<aiTank.length;i++)
        {
        	root.getChildren().add(aiTank[i]);
        }
        for(int i=0;i<missile.length;i++)
        {
        	root.getChildren().add(missile[i]);
        }
        for(int i=0;i<explosion.length;i++)
        {
        	root.getChildren().add(explosion[i]);
        }
        for(int i=0;i<rectangle.length;i++)
        {
        	root.getChildren().add(rectangle[i]);
        }
        for(int i=0;i<aiRectangle.length;i++)
        {
        	root.getChildren().add(aiRectangle[i]);
        }
        AiAction aiAction=new AiAction();
        aiAction.aiMove();
        
        stage.setTitle("ImageView");
        //stage.setWidth(700);
        //stage.setHeight(600);
        stage.setScene(scene); 
        stage.sizeToScene(); 
        //stage.setResizable(false);
        stage.show(); 
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                gameAction.tankRotation(event);
                gameAction.fire(event);
            }
        });
        /*
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
            	MulitPressed(event);
            }
        });
        */
       
    }
  
    public static void main(String[] args) {
        launch(args);
    }
}