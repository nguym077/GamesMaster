package tank;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

interface imageUi {
	double sizeXX=1200,sizeYY=700;
	//game window size
	double sizeX=1200,sizeY=650;
	//player tank rotate angle, move forward distance, back ward distance
	double angle=3,initialSpeed=2;
	double damage=-10;
	ImageView [] playerTank=new ImageView[3];
	ImageView [] explosion=new ImageView[90];
	ImageView [] missile=new ImageView[100];  
	ImageView [] aiTank=new ImageView[3000];
	ImageView [] backGround=new ImageView[10]; //back ground map image
	ImageView [] wall=new ImageView[3000];
	ImageView [] grass=new ImageView[100];
	
	ImageView [] ground=new ImageView[1000];
	ImageView [] greenTree=new ImageView[500];
	ImageView [] yellowTree=new ImageView[500];
	ImageView [] yellowRoadH=new ImageView[300];
	ImageView [] yellowRoadCR=new ImageView[10];
	ImageView [] yellowRoadV=new ImageView[300];
	
	ImageView [] bunnyLeft=new ImageView[80];
	ImageView [] bunnyRight=new ImageView[80];
	ImageView [] bunnyUp=new ImageView[80];
	ImageView [] bunnyDown=new ImageView[80];
	
	ImageView [] frogLeft=new ImageView[60];
	ImageView [] frogRight=new ImageView[60];
	ImageView [] frogUp=new ImageView[60];
	ImageView [] frogDown=new ImageView[60];
	
	ImageView []shellLabel=new ImageView[2];
	
	
	AnimationTimer [] explosionAnima=new AnimationTimer[30];
	AnimationTimer [] fireAnima=new AnimationTimer[100];
	AnimationTimer []rotateA=new AnimationTimer[30];
	AnimationTimer []moveA=new AnimationTimer[30];
	AnimationTimer []tankAnima=new AnimationTimer[50];
	AnimationTimer []aiTankAnima=new AnimationTimer[50];
	AnimationTimer []aiBunnyAnima=new AnimationTimer[20];
	AnimationTimer []aiFrogAnima=new AnimationTimer[20];
	AnimationTimer []randomForgAnima=new AnimationTimer[1];
	
	Rectangle [] rectangle=new Rectangle[3]; //for player tank
	Rectangle [] board=new Rectangle[4];  //for game window
	Rectangle [] aiRectangle=new Rectangle[300]; //for ai
	Rectangle [] path=new Rectangle[10]; //for path without wall
	Rectangle [] wallRec=new Rectangle[3000];  //for wall
	Rectangle [] health=new Rectangle[4]; //for player tank
	Rectangle [] dataRec=new Rectangle[1]; //for player tank
	
	Rectangle [] coliFrog=new Rectangle[1]; //for player tank
	
	Path []mazePath = new Path[1]; 
	
	
	Text []player1 = new Text[4];
	Text []player2 = new Text[4];
	
	int []aiBunnyDirection=new int[20];
	int []aiFrogDirection=new int[20];
	double []crossBunnyDir=new double[4];
	int []aiBunnySpeed=new int[20];
	double []playerTankSpeed=new double[2];
	int []coliFrogType=new int[1];
	int []shell=new int[2];
	double []healthNum=new double[2];
}
