package circle;




import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public interface PublicVar {
	int sizeX=1050,sizeY=500;
	int cellSize=50;
	double Scale=1.0;
	
	Pane[] root =new Pane[1];  //this is the game pane
	Pane[] data =new Pane[1];  //this pane will record game Data like health, power etc.
	
	Circle[] C=new Circle[10];
	Rectangle[] healthbar=new Rectangle[2];
	//Trang[] C=new Circle[10];
	
	Path[] path = new Path[10];
	MoveTo[] moveTo = new MoveTo[1000];
	LineTo[] lineP=new LineTo[2000];
	boolean[] pathActive=new boolean[10];
	
	Group[] mapG = new Group[1];
	
	Group group = new Group();
	Group dataG = new Group();
	double[] cx=new double[10];
	double[] cy=new double[10];
	double[] sp=new double[10];  //speed
	double[] deg=new double[10]; //degree
	boolean[] runC=new boolean[10];
	int numX=sizeX/cellSize+1;
	int numY=sizeY/cellSize+1;
	int numCells=numX*numY;
	Line[] lineX=new Line[numX];
	Line[] lineY=new Line[numY];
	AnimationTimer[] fireBall=new AnimationTimer[10];
	AnimationTimer[] bunny=new AnimationTimer[5];
	AnimationTimer[] hero=new AnimationTimer[1];
	
	Circle[] C_bunny= new Circle[2]; 
	Circle[] C_hero= new Circle[1];
	Circle[] C_egg= new Circle[10];
	
	double[] bunny_x=new double[2];
	double[] bunny_y=new double[2];
	boolean[] runBunny=new boolean[2];
	boolean[] bunnyBeHit=new boolean[2];
	int[] bunnyDir=new int[2];
	
	double[] health=new double[1];
	
	
	double[] hero_x=new double[1];
	double[] hero_y=new double[1];
	boolean[] runHero=new boolean[1];
	boolean[] heroBeHit=new boolean[1];
	
	double[] egg_x=new double[10];
	double[] egg_y=new double[10];
	boolean[] putEgg=new boolean[10];
	boolean[] eggBeHit=new boolean[10];
	
	int[] direction=new int[1];
	int[] gamelevel=new int[1];
	int[] getEggNum=new int[1];
	
	Shape[] colliArea=new Shape[10];
	
	int maxNumber_fireball_1=10;
	int fireball_1_idle_imageN=5;int fireball_1_idleN=maxNumber_fireball_1*fireball_1_idle_imageN; //6*50
	ImageView[] fireball_1_idle_L=new ImageView[fireball_1_idleN]; 
	ImageView[] fireball_1_idle_R=new ImageView[fireball_1_idleN];
	
	int maxNumber_hero_1=1;
	int hero_1_idle_imageN=3;int hero_1_idleN=maxNumber_hero_1*hero_1_idle_imageN; //6*50
	ImageView[] hero_1_idle_L=new ImageView[hero_1_idleN]; 
	ImageView[] hero_1_idle_R=new ImageView[hero_1_idleN];
	
	int maxNumber_logo_1=1;
	int logo_1_idle_imageN=1;int logo_1_idleN=maxNumber_logo_1*logo_1_idle_imageN; //6*50
	ImageView[] logo_1_idle_L=new ImageView[logo_1_idleN]; 
	ImageView[] logo_1_idle_R=new ImageView[logo_1_idleN];
	
	int maxNumber_bird_1=1;
	int bird_1_idle_imageN=3;int bird_1_idleN=maxNumber_bird_1*bird_1_idle_imageN; //6*50
	ImageView[] bird_1_idle_L=new ImageView[bird_1_idleN]; 
	ImageView[] bird_1_idle_R=new ImageView[bird_1_idleN];
	
	int maxNumber_bunny_1=2;
	int bunny_1_idle_imageN=3;int bunny_1_idleN=maxNumber_bunny_1*bunny_1_idle_imageN; //6*50
	ImageView[] bunny_1_idle_L=new ImageView[bunny_1_idleN]; 
	ImageView[] bunny_1_idle_R=new ImageView[bunny_1_idleN];
	
	int maxNumber_wall_1=200;
	int wall_1_idle_imageN=4;int wall_1_idleN=maxNumber_wall_1*wall_1_idle_imageN; //6*50
	ImageView[] wall_1_idle_L=new ImageView[wall_1_idleN]; 
	ImageView[] wall_1_idle_R=new ImageView[wall_1_idleN];
	
	int maxNumber_egg_1=1;
	int egg_1_idle_imageN=10;int egg_1_idleN=maxNumber_egg_1*egg_1_idle_imageN; //6*50
	ImageView[] egg_1_idle_L=new ImageView[egg_1_idleN]; 
	ImageView[] egg_1_idle_R=new ImageView[egg_1_idleN];
	
	boolean[] activeBird=new boolean[1];
	double[] bird_x=new double[1];
	double[] bird_y=new double[1];
}
 