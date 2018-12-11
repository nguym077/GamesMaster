package BallGame;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class bunny extends fireball implements PublicVar{

	Collison newCollison=new Collison();
	Random rnum=new Random();
	double speed=1;
	public void init()
	{
		setBunny();
	}
	public void setBunny()
	{
		for(int i=0;i<C_bunny.length;i++)
		{
			C_bunny[i]=new Circle();
			C_bunny[i].setRadius(7);
			C_bunny[i].setStroke(Color.BLACK);
			C_bunny[i].setFill(Color.WHITE);
			C_bunny[i].setVisible(false);
			group.getChildren().add(C_bunny[i]);
			setBunnyAnima(i);
			
			runBunny[i]=false;
			bunnyBeHit[i]=false;
			bunnyDir[i]=0;
		}
		activeBunny(100,100);
		for(int i=0;i<bunny_1_idle_L.length;i++)
	    {
	    	group.getChildren().add(bunny_1_idle_L[i]);
	    	group.getChildren().add(bunny_1_idle_R[i]);
	    }
	}
	public void activeBunny(double x,double y)
	{
		int activei=-1;
		for(int i=0;i<C_bunny.length;i++)
		{
			if(runBunny[i]==false)
				activei=i;
		}
		if(activei!=-1)
		{
			//C_bunny[activei].setVisible(true);
			int index=activei*3;
			//bunny_1_idle_L[index].setVisible(true);
			runBunny[activei]=true;
			bunny_x[activei]=x;
			bunny_y[activei]=y;
			
			
			
			boolean done=false;
			
			while(done==false)
			{
				setXY(activei, bunny_x[activei], bunny_y[activei]);
				if(newCollison.bunnyColliPath(activei))
				{
					bunny_x[activei]=bunny_x[activei]+1;
					if(bunny_x[activei]>sizeX)
						bunny_y[activei]=bunny_y[activei]+1;
				}
				else
					done=true;
			}
		}
		
	}
	public void offBunny()
	{
		for(int i=0;i<C_bunny.length;i++)
		{
			C_bunny[i].setCenterX(-1000);
			C_bunny[i].setCenterY(-1000);
			C_bunny[i].setVisible(false);
			bunnyBeHit[i]=false;
			runBunny[i]=false;
			
		}
		for(int i=0;i<bunny_1_idle_L.length;i++)
		{
			bunny_1_idle_L[i].setVisible(false);
			bunny_1_idle_R[i].setVisible(false);
		}
		
	}
	public void setBunnyAnima(int index)
	{
		bunny[index]=new AnimationTimer()
	    {
    		int count=0,count2=0,count3=0;
	    	int move=-1;
	    	boolean next=false,moveToHero=false;
	    	ImageView lastView=fireball_1_idle_R[0];
    		int imagenum=0;
    		public void handle(long now)
   	        {
    			if(runBunny[index])
    			count++;
    			
    			if(count>1)
    			{
    				count=0;
    				count2++;
    				
    				if(bunnyBeHit[index])
    				{
    					bunnyBeHit[index]=false;
    					int act=rnum.nextInt(10);
    					if(act==0)
    					activeBunny(bunny_x[index]+30, bunny_y[index]+30);
    				}
    				if(count3>100)
    				{
    					count3=0;
    					
    					double disx=bunny_x[index]-hero_x[0];
    					double disy=bunny_y[index]-hero_y[0];
    					startCtoHero(bunny_x[index], bunny_y[index], gamelevel[0]*0.2+5,disx,disy);
    				}
    				if(count2>100||move==-1) {
    					count2=0;
    					int target=rnum.nextInt(100);
    					if(target>=75&&target<100)
    					{
    						next=true;
    						moveToHero=false;
    					}
    					else if(target>=0&&target<75)
    					{
    						next=false;
    						moveToHero=true;
    					}
    						
    						
    				}
    				
    				boolean done=false,loop=false;
    				while(done==false)
    				{
    					if(next) {
	    				move=rnum.nextInt(4);
	    				next=false;
    					}
    					else if(loop)
    					{
    						moveToHero=false;
    						move=move+1;
    						if(move>=4)
    							move=0;
    					}
	    				
	    				
	    				if(moveToHero)
	    					toHero(index);
	    				else
	    					Move(index, move);
	    				if(newCollison.bunnyColliPath(index))
	    				{
	    					if(moveToHero)
	    						toNoHero(index);
	    					else
	    						noMove(index, move);
	    					loop=true;
	    				}
	    				else
	    				{
	    					done=true;
	    					count3++;
	    					
	    					if(imagenum>=3)
	     		    			 imagenum=0;
	     		    		 lastView.setVisible(false);
	     		    		 if(bunnyDir[index]==0)
	     		    			 lastView=walk_L(index,imagenum);
	     		    		 else if(bunnyDir[index]==1)
	     	  		    		 lastView=walk_R(index,imagenum);
	     		    		 imagenum++;
	    				}
    				}
    				
    				
    					
    				
    			}
   	        }
	    };bunny[index].start();
	}
	public void Move(int i,int move)
	{
		if(move==0) 
			bunny_y[i]=bunny_y[i]+speed;
		
		else if(move==1)
			bunny_y[i]=bunny_y[i]-speed;
		else if(move==2)
		{
			bunnyDir[i]=0;
			bunny_x[i]=bunny_x[i]+speed;
		}
			
		else if(move==3)
		{
			bunnyDir[i]=1;
			bunny_x[i]=bunny_x[i]-speed;
		}
			
		outMap(i);
		setXY(i,bunny_x[i],bunny_y[i]);
	}
	public void noMove(int i,int move)
	{
		if(move==0)
			bunny_y[i]=bunny_y[i]-speed;
		else if(move==1)
			bunny_y[i]=bunny_y[i]+speed;
		else if(move==2)
			bunny_x[i]=bunny_x[i]-speed;
		else if(move==3)
			bunny_x[i]=bunny_x[i]+speed;
		outMap(i);
		setXY(i,bunny_x[i],bunny_y[i]);
	}
	public void outMap(int i)
	{
		if(bunny_x[i]>sizeX)
			bunny_x[i]=0;
		if(bunny_x[i]<0)
			bunny_x[i]=sizeX;
		
		if(bunny_y[i]>sizeY)
			bunny_y[i]=0;
		if(bunny_y[i]<0)
			bunny_y[i]=sizeY;
	}
	
	public void toHero(int i)
	{
		
		double disx=hero_x[0]-bunny_x[i];
		double disy=hero_y[0]-bunny_y[i];
		
		if(disx>0&&disy>0)
		{
			bunny_x[i]=bunny_x[i]+speed;
			bunny_y[i]=bunny_y[i]+speed;
			bunnyDir[i]=1;
		}
		else if(disx>0&&disy<0)
		{
			bunny_x[i]=bunny_x[i]+speed;
			bunny_y[i]=bunny_y[i]-speed;
			bunnyDir[i]=1;
		}
		else if(disx<0&&disy>0)
		{
			bunny_x[i]=bunny_x[i]-speed;
			bunny_y[i]=bunny_y[i]+speed;
			bunnyDir[i]=0;
		}
		else if(disx<0&&disy<0)
		{
			bunny_x[i]=bunny_x[i]-speed;
			bunny_y[i]=bunny_y[i]-speed;
			bunnyDir[i]=0;
		}
		outMap(i);
		setXY(i,bunny_x[i],bunny_y[i]);	
	}
	public void toNoHero(int i)
	{
		
		double disx=hero_x[0]-bunny_x[i];
		double disy=hero_y[0]-bunny_y[i];
		
		if(disx>0&&disy>0)
		{
			bunny_x[i]=bunny_x[i]-speed;
			bunny_y[i]=bunny_y[i]-speed;
		}
		else if(disx>0&&disy<0)
		{
			bunny_x[i]=bunny_x[i]-speed;
			bunny_y[i]=bunny_y[i]+speed;
		}
		else if(disx<0&&disy>0)
		{
			bunny_x[i]=bunny_x[i]+speed;
			bunny_y[i]=bunny_y[i]-speed;
		}
		else if(disx<0&&disy<0)
		{
			bunny_x[i]=bunny_x[i]+speed;
			bunny_y[i]=bunny_y[i]+speed;
		}
		outMap(i);
		setXY(i,bunny_x[i],bunny_y[i]);	
	}
	
	public void setXY(int i,double x,double y)
	{
		C_bunny[i].setCenterX(x);
		C_bunny[i].setCenterY(y);
	}
	public ImageView walk_L(int index,int i)
	{
		int newID=index*3+i;
		ImageView view=new ImageView();
		{
			bunny_1_idle_L[newID].setVisible(true);
			bunny_1_idle_L[newID].setX(bunny_x[index]);
			bunny_1_idle_L[newID].setY(bunny_y[index]);
			//bunny_1_idle_L[newID].setRotate(deg[index]+90);
			view=bunny_1_idle_L[newID];
			}
		
		return view;	
	}
	public ImageView walk_R(int index,int i)
	{
		int newID=index*3+i;
		ImageView view=new ImageView();
		{
			bunny_1_idle_R[newID].setVisible(true);
			bunny_1_idle_R[newID].setX(bunny_x[index]);
			bunny_1_idle_R[newID].setY(bunny_y[index]);
			//bunny_1_idle_R[newID].setRotate(deg[index]+90);
			view=bunny_1_idle_R[newID];
			}
		
		return view;	
	}
	
}
