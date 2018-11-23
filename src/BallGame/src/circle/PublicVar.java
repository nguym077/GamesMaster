package circle;




import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public interface PublicVar {
	int sizeX=600,sizeY=500;
	Circle[] C=new Circle[10];
	//Trang[] C=new Circle[10];
	Rectangle[] R= new Rectangle[10];
	Group group = new Group();
	double[] cx=new double[10];
	double[] cy=new double[10];
	double[] sp=new double[10];  //speed
	double[] deg=new double[10]; //degree
	boolean[] runC=new boolean[10];
	Line[] line=new Line[10];
	
	AnimationTimer[] fireBall=new AnimationTimer[10];
	
	Shape[] colliArea=new Shape[10];
}
