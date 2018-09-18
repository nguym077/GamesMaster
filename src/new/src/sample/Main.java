package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application implements PublicVar{


    @Override
    public void start(Stage stage) {
        Pane root =new Pane();  //this is the game pane
        Pane data =new Pane();  //this pane will record game data like health, power etc.


        GameUI newGameUI=new GameUI();  //load the ui from image folder


        Map newmap=new Map();  //set up ui on the pane
        Keyboard testkey=new Keyboard();
        Bomb newbomb=new Bomb();

        initClass();


        BorderPane pane = new BorderPane();
        root.setMaxSize(sizeX, sizeY);
        root.setStyle("-fx-background-color: black");
        //root.requestFocus();
        for(int i=0;i<background.length;i++)
        {
            root.getChildren().add(background[i]);
        }
        for(int i=0;i<Blocks.length;i++)
        {
            root.getChildren().add(Blocks[i]);
            root.getChildren().add(r_Blocks[i]);
        }
        for(int i=0;i<Iron_Wall.length;i++)
        {
            root.getChildren().add(Iron_Wall[i]);
            root.getChildren().add(r_Iron_Wall[i]);
        }
        for(int i=0;i<Bricks.length;i++)
        {
            root.getChildren().add(Bricks[i]);
            root.getChildren().add(r_Bricks[i]);
        }
        for(int i=0;i<Bombs1.length;i++)
        {
            root.getChildren().add(Bombs1[i]);
            root.getChildren().add(r_Bombs1[i]);
        }
        for(int i=0;i<Fire1.length;i++)
        {
            root.getChildren().add(Fire1[i]);
            root.getChildren().add(Fire2[i]);
            root.getChildren().add(Fire3[i]);
            root.getChildren().add(r_Fire1[i]);
            root.getChildren().add(r_Fire2[i]);
            root.getChildren().add(r_Fire3[i]);
        }

        add(root);
        data.setMaxSize(sizeX, 50);
        data.setStyle("-fx-background-color: gray;");
        pane.setLeft(root);
        pane.setBottom(data);
        Scene scene = new Scene(pane,sizeXX,sizeYY);
        stage.setTitle("ImageView");
        //stage.setWidth(700);
        //stage.setHeight(600);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override

            public void handle(KeyEvent event) {
                testkey.keypressed(event);
                testkey.setB(event);
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                testkey.keyrelease(event);

            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
    public void initClass()
    {
        Enemy newEnemy=new Enemy();
    }

    public void add(Pane rt)
    {
        for(int i=0;i<Ghost1.length;i++)
        {
            rt.getChildren().add(Ghost1[i]);
            rt.getChildren().add(r_Ghost1[i]);
        }
    }
}
