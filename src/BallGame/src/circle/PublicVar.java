package circle;




import javafx.animation.AnimationTimer;
import javafx.scene.Group;
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
	Circle[] C=new Circle[10];
	//Trang[] C=new Circle[10];
	
	Path[] path = new Path[10];
	MoveTo[] moveTo = new MoveTo[1000];
	LineTo[] lineP=new LineTo[2000];
	boolean[] pathActive=new boolean[10];
	Group group = new Group();
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
	
	Circle[] C_bunny= new Circle[5]; 
	Circle[] C_hero= new Circle[1];
	
	double[] bunny_x=new double[5];
	double[] bunny_y=new double[5];
	boolean[] runBunny=new boolean[5];
	boolean[] bunnyBeHit=new boolean[5];
	
	double[] hero_x=new double[1];
	double[] hero_y=new double[1];
	boolean[] heroBeHit=new boolean[1];
	
	int[] direction=new int[1];
	
	Shape[] colliArea=new Shape[10];
}
