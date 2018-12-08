package circle;

import java.util.Random;

import com.sun.javafx.tools.packager.DeployParams.RunMode;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class egg implements PublicVar{

	Collison newCollison=new Collison();
	Random rnum=new Random();
	public void init()
	{
		setEgg();
		setEggAnima();
	}
	
	public void setEgg()
	{
		for(int i=0;i<C_egg.length;i++)
		{
			C_egg[i]=new Circle();
			C_egg[i].setRadius(7);
			C_egg[i].setStroke(Color.BLACK);
			C_egg[i].setFill(Color.WHITE);
			C_egg[i].setVisible(true);
			setXY(i, -1000, -1000);
			group.getChildren().add(C_egg[i]);
			
			 putEgg[i]=false;
			 eggBeHit[i]=false;
		}
		
		for(int i=0;i<egg_1_idle_L.length;i++)
	    {
	    	group.getChildren().add(egg_1_idle_L[i]);
	    	//group.getChildren().add(egg_1_idle_R[i]);
	    }
		
		newGame();
		
		
	}
	public void setEggAnima()
	{
		AnimationTimer eggAnima=new AnimationTimer()
	    {
    		int count=0;
	    	public void handle(long now)
    		{
	    		for(int i=0;i<C_egg.length;i++)
	    		{
	    		    if(eggBeHit[i])
	    			{
	    				removeEgg(i);
	    			}
	    		}
    		}
	    };eggAnima.start();
	}
    		
	public void offEgg()
	{
		getEggNum[0]=0;
		for(int i=0;i<C_egg.length;i++)
		{
			setXY(i, -1000, -1000);
			putEgg[i]=false;
			eggBeHit[i]=false;
		}
		for(int i=0;i<egg_1_idle_L.length;i++)
	    {
	    	egg_1_idle_L[i].setVisible(false);
	    	
	    }
	}
	
	public void removeEgg(int i)
	{
		
			setXY(i, -1000, -1000);
			putEgg[i]=false;
			eggBeHit[i]=false;
		
	    	egg_1_idle_L[i].setVisible(false);
	    	
	}
	public void newGame()
	{
		for(int i=0;i<gamelevel[0];i++)
		{
			int x=rnum.nextInt(sizeX-cellSize);
			int y=rnum.nextInt(sizeY-cellSize);
			
			
			activeEgg(x,y);
		}
	}
	public void activeEgg(double x,double y)
	{
		int eggi=0;
		boolean put=false;
		while(put==false)
		{
			int which=rnum.nextInt(10);
			if(putEgg[which]==false) {
				eggi=which;
				put=true;
			}
				
		}
		
		egg_x[eggi]=x;
		egg_y[eggi]=y;
		boolean done=false;
		
		while(done==false)
		{
			setXY(eggi, egg_x[eggi], egg_y[eggi]);
			if(newCollison.eggColliPath(eggi))
			{
				egg_x[eggi]=egg_x[eggi]+1;
				if(egg_x[eggi]>sizeX)
					egg_y[eggi]=egg_y[eggi]+1;
			}
			else
				done=true;
		}
		putEgg[eggi]=true;
		egg_1_idle_L[eggi].setX(egg_x[eggi]);
		egg_1_idle_L[eggi].setY(egg_y[eggi]);
		egg_1_idle_L[eggi].setVisible(true);
		eggi++;
	}
	
	public void setXY(int i,double x,double y)
	{
		C_egg[i].setCenterX(x);
		C_egg[i].setCenterY(y);
	}
}
