package tank;
import javafx.scene.input.*;
import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.layout.*;


import javafx.stage.Stage; 


public class Main extends Application implements imageUi{
				
	//for dataPanel
	Pane root =new Pane();
	Pane data =new Pane();
	
    @Override 
    public void start(Stage stage) {
    	Ui gameUi=new Ui();
    	Animation gameAnima=new Animation();
    	
    	AiAnimation aiAnima=new AiAnimation();
    	
    	//ActionLogic action=new ActionLogic();
    	AiSetup ais=new AiSetup();
    	
    	
    	
    	//aiAnima.startAi();
    	
    	
    	Action gameAction=new Action();
    	BorderPane pane = new BorderPane();
    	//pane.resize(sizeX, sizeY);
    	
    	root.setMaxSize(sizeX, sizeY);
    	root.setStyle("-fx-background-color: black");
    	//root.getChildren().add(backGround[0]);
    	
    	for(int i=0;i<path.length;i++)
    	{
    		root.getChildren().add(path[i]);
    	}
    	for(int i=0;i<mazePath.length;i++)
    	{
    		root.getChildren().add(mazePath[i]);
    	}
    	/*
    	for(int i=0;i<ground.length;i++)
    	{
    		//root.getChildren().add(ground[i]);
    	}
    	for(int i=0;i<yellowRoadH.length;i++)
    	{
    		//root.getChildren().add(yellowRoadH[i]);
    	}
    	for(int i=0;i<yellowRoadV.length;i++)
    	{
    		//root.getChildren().add(yellowRoadV[i]);
    	}
    	for(int i=0;i<yellowRoadCR.length;i++)
    	{
    		//root.getChildren().add(yellowRoadCR[i]);
    	}
    	*/
    	for(int i=0;i<wall.length;i++)
    	{
    		root.getChildren().add(wall[i]);
    	}
    	
    	/*
    	 //add tree
        for(int i=0;i<greenTree.length;i++)
    	{
    		root.getChildren().add(greenTree[i]);
    	}
    	for(int i=0;i<yellowTree.length;i++)
    	{
    		root.getChildren().add(yellowTree[i]);
    	}
    	*/
    	root.requestFocus();
    	//root.setStyle("-fx-background-image: url(images/Duke.png);");
        
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
        for(int i=0;i<68;i++)
        {
        	root.getChildren().add(bunnyLeft[i]);
        	root.getChildren().add(bunnyRight[i]);
        	root.getChildren().add(bunnyUp[i]);
        	root.getChildren().add(bunnyDown[i]);
        }
        for(int i=0;i<57;i++)
        {
			root.getChildren().add(frogLeft[i]);
			root.getChildren().add(frogRight[i]);
			root.getChildren().add(frogUp[i]);
			root.getChildren().add(frogDown[i]);
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
        
        data.setMaxSize(sizeX, 50);
		data.setStyle("-fx-background-color: gray;");
		data.getChildren().add(dataRec[0]);
		
		for(int i=0;i<4;i++)
		{
			data.getChildren().add(player1[i]);
			data.getChildren().add(player2[i]);
		}
		for(int i=0;i<2;i++)
		{
			data.getChildren().add(shellLabel[i]);
		}
		
		for(int i=0;i<4;i++)
		{
			data.getChildren().add(health[i]);
			//data.getChildren().add(player1[i]);
		}
		for(int i=68;i<80;i++)
        {
			data.getChildren().add(bunnyLeft[i]);
			data.getChildren().add(bunnyRight[i]);
			data.getChildren().add(bunnyUp[i]);
			data.getChildren().add(bunnyDown[i]);
        }
		for(int i=57;i<60;i++)
        {
			data.getChildren().add(frogLeft[i]);
			data.getChildren().add(frogRight[i]);
			data.getChildren().add(frogUp[i]);
			data.getChildren().add(frogDown[i]);
        }
        pane.setLeft(root);
    	pane.setBottom(data);
    	//pane.setCenter(data);
    	//ControlRoot.getChildren().addAll(root,root2);
        Scene scene = new Scene(pane,sizeXX,sizeYY);
       
        
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
            	gameAnima.keypressed(event);
                gameAction.fire(event);
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
            	gameAnima.keyrelease(event);
                
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