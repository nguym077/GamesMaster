package tank;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

interface imageUi {
	double sizeX=400,sizeY=500;
	double setScale=20;
	ImageView [] playerTank=new ImageView[3];
	ImageView [] explosion=new ImageView[90];
	ImageView [] missile=new ImageView[100];  
	ImageView [] aiTank=new ImageView[3000];
	
	AnimationTimer [] explosionAnima=new AnimationTimer[30];
	AnimationTimer [] fireAnima=new AnimationTimer[100];
	AnimationTimer []rotateA=new AnimationTimer[30];
	AnimationTimer []moveA=new AnimationTimer[30];
	AnimationTimer []tankAnima=new AnimationTimer[50];
	AnimationTimer []aiTankAnima=new AnimationTimer[50];
	
	Rectangle [] rectangle=new Rectangle[3];
	Rectangle [] board=new Rectangle[4];
	Rectangle [] aiRectangle=new Rectangle[3000];
	
}
