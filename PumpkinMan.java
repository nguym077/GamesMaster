package Halloween;

import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class PumpkinMan extends Application implements PublicVar{

    Pane root;
    Pane data;
    @Override
    public void start(Stage stage) {
        root =new Pane();  //this is the game pane
        data =new Pane();  //this pane will record game Data like health, power etc.
        root.setMaxSize(sizeX, sizeY);
        root.setStyle("-fx-background-color: black");
        data.setMaxSize(sizeX, 50);
        data.setStyle("-fx-background-color: grey;");

        GameUI newGameUI=new GameUI();  //load the ui from background_images folder
        newGameUI.initial();
        Map newmap=new Map();  //set up ui on the pane
        Keyboard testkey=new Keyboard();



        BorderPane pane = new BorderPane();
        pane.setMaxWidth(sizeX);pane.setMaxHeight(sizeYY);
        //root.requestFocus();
        add(root);

        addData(data);

        pane.setTop(data);
        pane.setBottom(root);

        Scene scene = new Scene(pane,sizeXX,sizeY+50);
        stage.setTitle("Pumpkin-Man");
        //stage.setWidth(700);
        //stage.setHeight(600);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        initClass();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override

            public void handle(KeyEvent event) {
                testkey.keypressed(event);
                testkey.setB(event);
                testkey.setB2(event);
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

        Bomb newbomb=new Bomb();
        Enemy_Ghost newGhost=new Enemy_Ghost();
        //Enemy_Bat newBat=new Enemy_Bat();

        //Enemy_Vamp newVamp=new Enemy_Vamp();
        Enemy_Zombie newZombie=new Enemy_Zombie();
        Bird newBird = new Bird();
        Player newPlayer=new Player();
        Data newData=new Data();


        newGhost.initial();
        //newBat.initial();
        //newVamp.initial();
        newZombie.initial();
        newPlayer.initial();

        newData.setUp();
    }

    public void add(Pane rt)
    {
        for(int i=0;i<background.length;i++)
        {
            rt.getChildren().add(background[i]);
        }
        for(int i=0;i<Blocks.length;i++)
        {
            rt.getChildren().add(Blocks[i]);
            rt.getChildren().add(r_Blocks[i]);
        }
        for(int i=0;i<Iron_Wall.length;i++)
        {
            rt.getChildren().add(Iron_Wall[i]);
            rt.getChildren().add(r_Iron_Wall[i]);
        }
        for(int i=0;i<Bricks.length;i++)
        {
            rt.getChildren().add(Bricks[i]);
            rt.getChildren().add(r_Bricks[i]);
        }
        for(int i=0;i<Bombs1.length;i++)
        {
            rt.getChildren().add(Bombs1[i]);
            rt.getChildren().add(r_Bombs1[i]);
        }
        for(int i=10;i<50;i++)
        {
            rt.getChildren().add(icon_bomb[i]);
            rt.getChildren().add(icon_power[i]);
            rt.getChildren().add(icon_health[i]);
            rt.getChildren().add(icon_speed[i]);
            rt.getChildren().add(icon_noHurt[i]);
            rt.getChildren().add(icon_throughWall[i]);
            rt.getChildren().add(icon_addLife[i]);

            rt.getChildren().add(r_icon_bomb[i]);
            rt.getChildren().add(r_icon_power[i]);
            rt.getChildren().add(r_icon_health[i]);
            rt.getChildren().add(r_icon_speed[i]);
            rt.getChildren().add(r_icon_noHurt[i]);
            rt.getChildren().add(r_icon_throughWall[i]);
            rt.getChildren().add(r_icon_addLife[i]);

        }

        for(int i=0;i<Fire1.length;i++)
        {
            rt.getChildren().add(Fire1[i]);
            rt.getChildren().add(Fire2[i]);
            rt.getChildren().add(Fire3[i]);
            rt.getChildren().add(r_Fire1[i]);
            rt.getChildren().add(r_Fire2[i]);
            rt.getChildren().add(r_Fire3[i]);
        }

        for(int i=0;i<Ghost1.length;i++)
        {
            rt.getChildren().add(Ghost1[i]);
            rt.getChildren().add(r_Ghost1[i]);
        }

//        for(int i=0;i<Bat1.length;i++)
//        {
//            rt.getChildren().add(Bat1[i]);
//            if(i<Bat1.length/3)
//                rt.getChildren().add(r_Bat[i]);
//        }
//
//        for(int i=0;i<Vamp1.length;i++)
//        {
//            rt.getChildren().add(Vamp1[i]);
//            if(i<Vamp1.length/4)
//                rt.getChildren().add(r_Vamp[i]);
//        }

        for(int i=0;i<Zombie1.length;i++)
        {
            rt.getChildren().add(Zombie1[i]);
            if(i<Zombie1.length/4)
                rt.getChildren().add(r_Zombie[i]);
        }
        for(int i=0;i<Bird1.length;i++)
        {
            rt.getChildren().add(Bird1[i]);
            if(i<Bird1.length/4)
                rt.getChildren().add(r_Bird[i]);
        }
        /*
        for(int i=0;i<Monster1_L.length;i++)
        {
            rt.getChildren().add(Monster1_L[i]);
            rt.getChildren().add(Monster1_R[i]);
            if(i<10)
                rt.getChildren().add(r_Monster1[i]);
        }
        */
        for(int i=0;i<player_L.length;i++)
        {
            rt.getChildren().add(player_L[i]);
            //rt.getChildren().add(Monster1_R[i]);

        }
        for(int i=0;i<r_player.length;i++)
        {
            rt.getChildren().add(r_player[i]);
            //rt.getChildren().add(Monster1_R[i]);
        }

    }
    public void addData(Pane datai)
    {
        datai.getChildren().add(icon_1st[0]);
        datai.getChildren().add(icon_1st[1]);
        datai.getChildren().add(icon_2nd[0]);
        datai.getChildren().add(icon_2nd[1]);

        for(int i=0;i<10;i++)
        {
            datai.getChildren().add(icon_bomb[i]);
            datai.getChildren().add(icon_power[i]);
            datai.getChildren().add(icon_health[i]);
            datai.getChildren().add(icon_speed[i]);
            datai.getChildren().add(r_icon_bomb[i]);
            datai.getChildren().add(r_icon_power[i]);
            datai.getChildren().add(r_icon_health[i]);
            datai.getChildren().add(r_icon_speed[i]);
        }
    }

    public void startGame(Objects newClass)
    {

    }
}
