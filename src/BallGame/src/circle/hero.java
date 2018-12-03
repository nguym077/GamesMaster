package circle;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class hero implements PublicVar {
	Collison newCollison=new Collison();
	Random rnum=new Random();
	double speed=3;
	public void init()
	{
		setHero();
	}
	public void setHero()
	{
		for(int i=0;i<C_hero.length;i++)
		{
			C_hero[i]=new Circle();
			C_hero[i].setRadius(7);
			C_hero[i].setStroke(Color.BLACK);
			C_hero[i].setFill(Color.BLUE);
			C_hero[i].setVisible(false);
			group.getChildren().add(C_hero[i]);
			setHeroAnima(i);
			
			heroBeHit[i]=false;
		}
		activeHero(300,100);
	}
	public void activeHero(double x,double y)
	{
		int activei=0;
		
		if(activei!=-1)
		{
			C_hero[activei].setVisible(true);
			
			hero_x[activei]=x;
			hero_y[activei]=y;
			
			
			
			boolean done=false;
			
			while(done==false)
			{
				setXY(activei, hero_x[activei], hero_y[activei]);
				if(newCollison.heroColliPath(activei))
				{
					hero_x[activei]=hero_x[activei]+1;
					if(hero_x[activei]>sizeX)
						hero_y[activei]=hero_y[activei]+1;
				}
				else
					done=true;
			}
		}
		
	}
	public void setHeroAnima(int index)
	{
		hero[index]=new AnimationTimer()
	    {
    		int count=0,count2=0,count3=0;
	    	int move=-1;
	    	boolean next=false,moveToHero=false;
	    	
    		public void handle(long now)
   	        {
    			
    			count++;
    			
    			if(count>1)
    			{
    				count=0;
    				count2++;
    				
    				
    				if(direction[0]!=-1)
    				{
    					move=direction[0];
    					Move(0, direction[0]);
        				if(newCollison.heroColliPath(index))
        				{
        					noMove(index, move);
        				}
    				}
        				
    				
    			}
   	        }
	    };hero[index].start();
	}
	public void Move(int i,int move)
	{
		if(move==0)
			hero_y[i]=hero_y[i]-speed;
		else if(move==1)
			hero_y[i]=hero_y[i]+speed;
		else if(move==2)
			hero_x[i]=hero_x[i]-speed;
		else if(move==3)
			hero_x[i]=hero_x[i]+speed;
		outMap(i);
		setXY(i,hero_x[i],hero_y[i]);
	}
	public void noMove(int i,int move)
	{
		if(move==0)
			hero_y[i]=hero_y[i]+speed;
		else if(move==1)
			hero_y[i]=hero_y[i]-speed;
		else if(move==2)
			hero_x[i]=hero_x[i]+speed;
		else if(move==3)
			hero_x[i]=hero_x[i]-speed;
		outMap(i);
		setXY(i,hero_x[i],hero_y[i]);
	}
	public void outMap(int i)
	{
		if(hero_x[i]>sizeX)
			hero_x[i]=0;
		if(hero_x[i]<0)
			hero_x[i]=sizeX;
		
		if(hero_y[i]>sizeY)
			hero_y[i]=0;
		if(hero_y[i]<0)
			hero_y[i]=sizeY;
	}
	public void setXY(int i,double x,double y)
	{
		C_hero[i].setCenterX(x);
		C_hero[i].setCenterY(y);
	}
}