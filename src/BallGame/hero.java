package BallGame;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
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
			runHero[i]=false;
		}
		activeHero(300,100);
		
		for(int i=0;i<hero_1_idle_L.length;i++)
	    {
	    	group.getChildren().add(hero_1_idle_L[i]);
	    	group.getChildren().add(hero_1_idle_R[i]);
	    }
		
	}
	public void activeHero(double x,double y)
	{
		int activei=0;
		
		if(activei!=-1)
		{
			
			//C_hero[activei].setVisible(true);
			
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
			hero_1_idle_L[0].setVisible(true);
			hero_1_idle_L[0].setX(hero_x[0]);
			hero_1_idle_L[0].setY(hero_y[0]);
			runHero[0]=true;
		}
		
	}
	//de active hero
	public void offHero()
	{
		for(int i=0;i<hero_1_idle_L.length;i++) 
		{
			hero_1_idle_L[i].setVisible(false);
		}
		C_hero[0].setCenterX(-1000);
		C_hero[0].setCenterY(-1000);
		runHero[0]=false;
		
	}
	public void setHeroAnima(int index)
	{
		hero[index]=new AnimationTimer()
	    {
    		int count=0,count2=0,count3=0;
	    	int move=-1;
	    	int imagenum=0;
	    	ImageView lastView=fireball_1_idle_R[0];
	    	boolean next=false,moveToHero=false;
	    	
    		public void handle(long now)
   	        {
    			if(runHero[0])
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
        				newCollison.heroColliEgg(index);
        				
        				if(imagenum>=3)
     		    			 imagenum=0;
     		    		 lastView.setVisible(false);
     		    		 lastView=idle(index,imagenum);
     		    		 imagenum++;
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
	
	public ImageView idle(int index,int i)
	{
		int newID=index*3+i;
		ImageView view=new ImageView();
		{
			hero_1_idle_L[newID].setVisible(true);
			hero_1_idle_L[newID].setX(hero_x[index]);
			hero_1_idle_L[newID].setY(hero_y[index]);
			//hero_1_idle_L[newID].setRotate(deg[index]+90);
			view=hero_1_idle_L[newID];
			}
		
		return view;	
	}
}