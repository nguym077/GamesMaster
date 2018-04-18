package tank;

import java.util.Random;

import javafx.animation.AnimationTimer;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.*;

import javafx.scene.shape.Rectangle;
class Animation extends ActionLogic implements imageUi{
	
int animationCount;
	Animation()
	{
		animationCount=0;
	}
	
	public void missileAnima(ImageView attacker,int CountN)
	{
		animationCount=CountN;
		final int Count=CountN;
		double degree=attacker.getRotate();
		if(degree==360||degree==-360)
			degree=0;
		missile[Count].setRotate(degree);
		double X=attacker.getX()+10;
		double Y=attacker.getY()+10;
		boolean counterClock=false;
		
		  if(degree<0)
		  {
	      	counterClock=true;
	      	degree=Math.abs(degree);
		  }
		  if(degree>360)
			{
				degree=degree-360;
			}
			
		  
		  final double d=degree;
		  
	      final boolean co=counterClock;
	      missile[Count].setX(X);
	      missile[Count].setY(Y);
	      
	      //System.out.println("x "+missile[Count].getX()+" y "+missile[Count].getY()+" d "+missile[Count].getRotate());
	      fireAnima[Count]=new AnimationTimer()
		  {
	    	  double x=missile[Count].getX();
			  double y=missile[Count].getY();
			  double missileSpeed=5;
	    	  double lastTimerCall = System.nanoTime();
			  public void handle(long now) {
				  
			  if(now-lastTimerCall>200000)
			  {
				  lastTimerCall=now;
				  	
				  if(d>=0&&d<=90)
				  {
	        		if(co)
	        		{
	        			missile[Count].setX(x-Math.sin(Math.toRadians(d))*missileSpeed);
	        			missile[Count].setY(y-Math.cos(Math.toRadians(d))*missileSpeed);
	        		}
	        		else
	        		{
	        			missile[Count].setX(x+Math.sin(Math.toRadians(d))*missileSpeed);
	        			missile[Count].setY(y-Math.cos(Math.toRadians(d))*missileSpeed);
	        		}
				  }
				  else if(d>90&&d<=180)
		        	{
		        		if(co)
		        		{
		        			missile[Count].setX(x-Math.cos(Math.toRadians(d-90))*missileSpeed);
		        			missile[Count].setY(y+Math.sin(Math.toRadians(d-90))*missileSpeed);
		        		}
		        		else
		        		{
		        			missile[Count].setX(x+Math.cos(Math.toRadians(d-90))*missileSpeed);
		        			missile[Count].setY(y+Math.sin(Math.toRadians(d-90))*missileSpeed);
		        		}
		        		
		        	}
		        	else if(d>180&&d<=270)
		        	{
		        		if(co)
		        		{
		        			missile[Count].setX(x+Math.sin(Math.toRadians(d-180))*missileSpeed);
		        			missile[Count].setY(y+Math.cos(Math.toRadians(d-180))*missileSpeed);
		        		}
		        		else
		        		{
		        			missile[Count].setX(x-Math.sin(Math.toRadians(d-180))*missileSpeed);
		        			missile[Count].setY(y+Math.cos(Math.toRadians(d-180))*missileSpeed);
		        		}
		        	}
		        	else if(d>270&&d<=360)
		        	{
		        		if(co)
		        		{
		        			missile[Count].setX(x+Math.cos(Math.toRadians(d-270))*missileSpeed);
		        			missile[Count].setY(y-Math.sin(Math.toRadians(d-270))*missileSpeed);
		        		}
		        		else
		        		{
		        			missile[Count].setX(x-Math.cos(Math.toRadians(d-270))*missileSpeed);
		        			missile[Count].setY(y-Math.sin(Math.toRadians(d-270))*missileSpeed);
		        		}
		        	}
				  x=missile[Count].getX();
				  y=missile[Count].getY();
				  
			  }
			 
			  boolean hitboard=false,hitplayer=false,hitenemy=false;
			  hitplayer=checkMissileCollision(attacker,missile[Count],playerTank,rectangle);
			  hitenemy=checkMissileCollision(attacker,missile[Count],aiTank,aiRectangle);
			  hitboard=checkMissileCollision(missile[Count],board);
			  if(hitboard||hitplayer||hitenemy) 
			  {
				  stopFireAnima(fireAnima[Count],missile[Count]);
			  	  }
			  }
			  
	  };
	  		fireAnima[Count].start();
		 
	}
	public void moveAnima(Rectangle rec,ImageView view,double degree,KeyEvent key,int Counter)
	{
		final int moveCounter=Counter;
		tankAnima[moveCounter]=new AnimationTimer()
		{
			public void handle(long now) {
			KeyCode a=key.getCode();
			switch(a)
			{
				case E:
				case O:
				{
					rec.setRotate(degree+15);
					view.setRotate(degree+15);
				}
				break;
				case Q:
				case U:
				{
					rec.setRotate(degree-15);
					view.setRotate(degree-15);
					
				}
				break;
				case D:
				case L:
				{
					rec.setRotate(degree+90);
					view.setRotate(degree+90);
				}
				break;
				case A:
				case J:
				{
					rec.setRotate(degree-90);
					view.setRotate(degree-90);
				}
				break;
				case W:
				case I:
				{
					boolean check1=false,check2=false;
					double X=view.getX(), Y=view.getY();
					rectangleForwardLogic(rec,degree,X,Y);
					check1=checkMoveCollision(rec,rectangle);
					check1=checkMoveCollision(rec,aiRectangle);
					check2=checkMoveCollision(rec,board);
					if(!check1&&!check2)
						tankForwardLogic(view,degree,X,Y);
					else
						rectangleBackLogic(rec,degree,X,Y);
		
					
				}
				break;
				case S:
				case K:
				{
					boolean check1=false,check2=false;
					double X=view.getX(), Y=view.getY();
					rectangleBackLogic(rec,degree,X,Y);
					check1=checkMoveCollision(rec,rectangle);
					check1=checkMoveCollision(rec,aiRectangle);
					check2=checkMoveCollision(rec,board);
					if(!check1&&!check2)
						tankBackLogic(view,degree,X,Y);
					else
						rectangleForwardLogic(rec,degree,X,Y);

				}
				break;
				
			}
			stopAnima(tankAnima[moveCounter]);
			}
		};
		
		//moveCounter++;
		tankAnima[moveCounter].start();
	}
	int fireAnimaCounter=0;
	public void aiMoveAnima(Rectangle rec,ImageView view,int index)
	{
		Random r=new Random();
		aiTankAnima[index]=new AnimationTimer()
		{
			Random r=new Random();
			boolean next=false,left=false,right=false,up=true,fire=false;
			int action=0;
			double degree=0,X=0,Y=0;
			long lastTime=System.nanoTime();
			long lastFireTime=System.nanoTime();
			public void handle(long now) {
				degree=view.getRotate();
				X=view.getX(); Y=view.getY();
				if(X<-10&&Y<-10)
					stopAnima(this);
				int shot=r.nextInt(200);
				
				if(shot==9&&(now-lastFireTime>500000000))
				{
					lastFireTime=now;
					animationCount++;
					if(animationCount==100)
						animationCount=0;
					missileAnima(view,animationCount);
				}
				if(degree==360||degree==-360)
					degree=0;
			if(now-lastTime>300000000) 
			{
				if(up==true&&(left==false||right==false))
				{
					int turn=r.nextInt(100);
					if(turn==1)
						action=1;
					else if(turn==2)
						action=2;
					else
					action=3;
					}
				if(up==false)
				{
					if(left==false&&right==false)
					{
						action=r.nextInt(3);
						if(action==1)
							left=true;
						else if(action==2)
							right=true;
					}
					else if(left&&right==false)
					{
						action=3;left=false;
					}
					else if(left==false&&right)
					{
						action=3;right=false;
					}
				}
				
				lastTime=now;
				
				next=true;}
			if(next)
			{
				next=false;
				switch(action)
				{
				case 1: //left
				{
					rec.setRotate(degree-90);
					view.setRotate(degree-90);
				}
				break;
				case 2: //right
				{
					rec.setRotate(degree+90);
					view.setRotate(degree+90);
				}
				break;
				case 3: //up
				{
					boolean check1=false,check2=false,check3=false;
					
					rectangleForwardLogic(rec,degree,X,Y);
					check1=checkMoveCollision(rec,rectangle);
					check2=checkMoveCollision(rec,aiRectangle);
					check3=checkMoveCollision(rec,board);
					if(!check1&&!check2&&!check3)
					{
						tankForwardLogic(view,degree,X,Y);
						up=true;
						}
					else 
					{
						rectangleBackLogic(rec,degree,X,Y);
						up=false;
						}
					
					
				}
				break;
				}
				
			}
				
			//stopAnima(tankAnima[moveCounter]);
			}
		};
		
		//moveCounter++;
	
		aiTankAnima[index].start();
	}
	
	public void startAnima(int c)
	{
		fireAnima[c].start();
	}
	
	public void stopAnima(int c)
	{
		fireAnima[c].stop();
		removeImage(missile[c]);
	}
	public void stopAnima(AnimationTimer anima)
	{
		anima.stop();
	}
	public void stopFireAnima(AnimationTimer anima,ImageView view)
	{
		anima.stop();
		removeImage(view);
		
		
	}
}
