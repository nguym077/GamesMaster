package sample;


import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public interface PublicVar {
    double sizeX=1175,sizeY=625;
    double sizeXX=sizeX,sizeYY=700;
    int XY=25,r_XY=20;
    ImageView[] background=new ImageView[3];
    ImageView[] Iron_Wall=new ImageView[400];
    Rectangle[] r_Iron_Wall=new Rectangle[400]; //for player tank
    ImageView[] Blocks=new ImageView[200];
    Rectangle[] r_Blocks=new Rectangle[200];
    ImageView[] Bricks=new ImageView[500];
    Rectangle[] r_Bricks=new Rectangle[500];

    int[] checkHit=new int[50];
    ImageView[] Bombs1=new ImageView[100];
    Rectangle[] r_Bombs1=new Rectangle[100];
    AnimationTimer[] bombAnima=new AnimationTimer[50];

    ImageView[] Ghost1=new ImageView[100];
    Rectangle[] r_Ghost1=new Rectangle[100];
    AnimationTimer[] GhostAnima=new AnimationTimer[50];

    ImageView[] Fire1=new ImageView[500];
    Rectangle[] r_Fire1=new Rectangle[500];
    ImageView[] Fire2=new ImageView[500];
    Rectangle[] r_Fire2=new Rectangle[500];
    ImageView[] Fire3=new ImageView[500];
    Rectangle[] r_Fire3=new Rectangle[500];




    AnimationTimer[] testAnima=new AnimationTimer[50];
}
