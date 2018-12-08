package circle;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

public class Map implements PublicVar{

	Random rWall=new Random();
	public void init()
	{
		wallImage();
		//drawCells();
		drawWalls();
		
	}
	public void newMap()
	{
		drawWalls();
	}
	public void offMap()
	{
		mapG[0].getChildren().removeAll(path[0]);
		for(int i=0;i<wall_1_idle_L.length;i++)
		{
			wall_1_idle_L[i].setVisible(false);
		}
		
	}
	public void wallImage()
	{
		for(int i=0;i<wall_1_idle_L.length;i++)
		{
			group.getChildren().add(wall_1_idle_L[i]);
			wall_1_idle_L[i].setVisible(false);
			wall_1_idle_L[i].setX(-1000);
			wall_1_idle_L[i].setY(-1000);
		}
		
	}
	public void drawWalls()
	{
		for(int i=0;i<path.length;i++)
	    {
	    	path[i]=new Path();
	    }
		mapG[0].getChildren().add(path[0]);
		
		int nextx=0,nexty=0;
	    System.out.println("cells "+numCells);
	    
	    for(int ix=0;ix<sizeX/cellSize;ix++)
	    {
	    	for(int iy=0;iy<sizeY/cellSize;iy++)
	    	{
	    		int r=rWall.nextInt(2);
	    		if(r==0)
		    	{
		    		int rs=rWall.nextInt(4);
		    		if(rs==0)
		    			addHorizontalWall(ix*cellSize,iy*cellSize);
		    		else if(rs==1)
		    			addVerticalWall(ix*cellSize,iy*cellSize);
		    		
		    		else if(rs==2)
		    			addDiagonalWall_1(ix*cellSize,iy*cellSize);
		    		else if(rs==3)
		    			addDiagonalWall_2(ix*cellSize,iy*cellSize);
		    		
		    	}
	    	}
	    }
	    
	}
	public void drawCells()
	{
		for(int i=0;i<lineX.length;i++)
	    {
	    	lineX[i] = new Line();
	    	lineX[i].setStroke(Color.WHITE);
		    lineX[i].setStrokeWidth(1);
		    group.getChildren().add(lineX[i]);
		    setLineX(i,i*cellSize,0,i*cellSize,sizeY);
	    }
		for(int i=0;i<lineY.length;i++)
	    {
	    	lineY[i] = new Line();
	    	lineY[i].setStroke(Color.WHITE);
		    lineY[i].setStrokeWidth(1);
		    group.getChildren().add(lineY[i]);
		    setLineY(i,0,i*cellSize,sizeX,i*cellSize);
	    }
	}
	public void setLineX(int i,double sx,double sy,double ex,double ey)
	{
		lineX[i].setStartX(sx);
	    lineX[i].setStartY(sy);
	    lineX[i].setEndX(ex);
	    lineX[i].setEndY(ey);
	}
	public void setLineY(int i,double sx,double sy,double ex,double ey)
	{
		lineY[i].setStartX(sx);
	    lineY[i].setStartY(sy);
	    lineY[i].setEndX(ex);
	    lineY[i].setEndY(ey);
	}
	
	int linei=0,movei=0;
	//initial wall on the map
	
	int wall_1=0;
	public void addHorizontalWall(int sx,int sy)
	{
		moveTo[movei] = new MoveTo(sx, sy);
		path[0].getElements().add(moveTo[movei]);
	    movei=movei+1;
	    
	    lineP[linei] = new LineTo(sx+cellSize, sy);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx+cellSize,sy+cellSize/10);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx,sy+cellSize/10);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx,sy);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    
	    int wall=wall_1*4;
	    wall_1_idle_L[wall].setX(sx);
	    wall_1_idle_L[wall].setY(sy);
	    wall_1_idle_L[wall].setVisible(true);
	    wall_1++;
	    
	    System.out.println("wall "+wall+" "+"xy "+sx+" "+sy);
	}
	
	int wall_2=0;
	public void addVerticalWall(int sx,int sy)
	{
		moveTo[movei] = new MoveTo(sx, sy);
		
		path[0].getElements().add(moveTo[movei]);
	    movei=movei+1;
	    
	    lineP[linei] = new LineTo(sx+cellSize/10, sy);  
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx+cellSize/10,sy+cellSize);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx,sy+cellSize);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx,sy);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    
	    int wall=wall_2*4+1;
	    wall_1_idle_L[wall].setX(sx);
	    wall_1_idle_L[wall].setY(sy);
	    wall_1_idle_L[wall].setVisible(true);
	    wall_2++;
	}
	int wall_4=0;
	public void addDiagonalWall_1(int sx,int sy)
	{
		
		moveTo[movei] = new MoveTo(sx, sy);
		
		path[0].getElements().add(moveTo[movei]);
	    movei=movei+1;
	    
	    lineP[linei] = new LineTo(sx+cellSize/10, sy);  
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx+cellSize,sy+cellSize*9/10);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx+cellSize,sy+cellSize);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx+cellSize*9/10,sy+cellSize);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx,sy+cellSize/10);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx,sy);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    
	    int wall=wall_4*4+2;
	    wall_1_idle_L[wall].setX(sx);
	    wall_1_idle_L[wall].setY(sy);
	    wall_1_idle_L[wall].setVisible(true);
	    wall_4++;
	}
	int wall_3=0;
	public void addDiagonalWall_2(int sx,int sy)
	{
		
		moveTo[movei] = new MoveTo(sx+cellSize, sy);
		
		path[0].getElements().add(moveTo[movei]);
	    movei=movei+1;
	    
	    lineP[linei] = new LineTo(sx+cellSize, sy+cellSize/10);  
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx+cellSize/10,sy+cellSize);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx,sy+cellSize);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx,sy+cellSize*9/10);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx+cellSize*9/10,sy);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    lineP[linei] = new LineTo(sx+cellSize,sy);
	    path[0].getElements().add(lineP[linei]);
	    linei=linei+1;
	    
	    int wall=wall_3*4+3;
	    wall_1_idle_L[wall].setX(sx);
	    wall_1_idle_L[wall].setY(sy);
	    wall_1_idle_L[wall].setVisible(true);
	    wall_3++;
	}
	public void moveWall(int i,int nx,int ny)
	{
		moveTo[i].setX(nx);
		moveTo[i].setY(ny);
		i=i*4;
		lineP[i].setX(nx+cellSize);
		lineP[i].setY(ny);
		i=i+1;
		lineP[i].setX(nx+cellSize);
		lineP[i].setY(ny+cellSize);
		i=i+1;
		lineP[i].setX(nx);
		lineP[i].setY(ny+cellSize);
		i=i+1;
		lineP[i].setX(nx);
		lineP[i].setY(ny);
	}
		
}
