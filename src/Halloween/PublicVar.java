package Halloween;


import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public interface PublicVar {
    double sizeX=1175,sizeY=625;
    double sizeXX=sizeX,sizeYY=700;
    int XY=25,r_XY=20;
    double r_x=2.5, r_y=2.5;
    ImageView[] background=new ImageView[3];
    ImageView[] Iron_Wall=new ImageView[400];
    Rectangle[] r_Iron_Wall=new Rectangle[400]; //for player tank
    ImageView[] Blocks=new ImageView[200];
    Rectangle[] r_Blocks=new Rectangle[200];
    ImageView[] Bricks=new ImageView[500];
    Rectangle[] r_Bricks=new Rectangle[500];
    ImageView[] Gravestones=new ImageView[500];
    Rectangle[] r_Gravestones=new Rectangle[500];

    int[] Bomb_checkHit=new int[50];
    ImageView[] Bombs1=new ImageView[100];
    Rectangle[] r_Bombs1=new Rectangle[100];
    AnimationTimer[] bombAnima=new AnimationTimer[50];

    int[] Ghost_checkHit=new int[50];
    ImageView[] Ghost1=new ImageView[100];
    Rectangle[] r_Ghost1=new Rectangle[100];
    AnimationTimer[] GhostAnima=new AnimationTimer[50];

    int[] Monster_checkHit=new int[10];
    ImageView[] Monster1_L=new ImageView[160];
    ImageView[] Monster1_R=new ImageView[160];
    Rectangle[] r_Monster1=new Rectangle[10];
    AnimationTimer[] MonsterAnima=new AnimationTimer[10];

    int[] player_checkHit=new int[5];
    ImageView[] player_L=new ImageView[15];
    ImageView[] player_R=new ImageView[15];
    Rectangle[] r_player=new Rectangle[5];
    AnimationTimer[] PlayerAnima=new AnimationTimer[5];


    ImageView[] Fire1=new ImageView[500];
    Rectangle[] r_Fire1=new Rectangle[500];
    ImageView[] Fire2=new ImageView[500];
    Rectangle[] r_Fire2=new Rectangle[500];
    ImageView[] Fire3=new ImageView[500];
    Rectangle[] r_Fire3=new Rectangle[500];

    int[] Bat_checkHit=new int[50];
    ImageView[] Bat1=new ImageView[150];
    Rectangle[] r_Bat=new Rectangle[50];
    AnimationTimer[] BatAnima=new AnimationTimer[50];

    int[] Vamp_checkHit=new int[50];
    ImageView[] Vamp1=new ImageView[200];
    Rectangle[] r_Vamp=new Rectangle[50];
    AnimationTimer[] VampAnima=new AnimationTimer[50];
    
    int[] Zombie_checkHit=new int[50];
    ImageView[] Zombie1=new ImageView[200];
    Rectangle[] r_Zombie=new Rectangle[50];
    AnimationTimer[] ZombieAnima=new AnimationTimer[50];

    int[] Bird_checkHit=new int[50];
    ImageView[] Bird1=new ImageView[200];
    Rectangle[] r_Bird=new Rectangle[50];
    AnimationTimer[] BirdAnima=new AnimationTimer[50];

    AnimationTimer[] testAnima=new AnimationTimer[50];

    int[] charX=new int[5];
    int[] charY=new int[5];
    int[] status=new int[5];

    int[] bombX=new int[50];
    int[] bombY=new int[50];
}
