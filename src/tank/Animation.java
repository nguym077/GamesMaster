package tank;

import java.util.Random;

import javafx.animation.AnimationTimer;

import javafx.scene.image.ImageView;
import javafx.scene.input.*;

import javafx.scene.shape.Rectangle;
class Animation extends ActionLogic implements imageUi{
	
int animationCount;
	Animation()
	{
		animationCount=0;
		moveAnima(0);
		/*
		aiMoveAnima(aiRectangle[0],aiTank[0],0);
		aiMoveAnima(aiRectangle[1],aiTank[1],0);
		aiMoveAnima(aiRectangle[2],aiTank[2],0);
		*/
	}
	public void missileAnima(ImageView attacker,int CountN)
	{
		animationCount=CountN;
		final int Count=CountN;
		double degree=attacker.getRotate();
		if(degree==360||degree==-360)
			degree=0;
		missile[Count].setRotate(degree);
		double X=attacker.getX()+attacker.getFitWidth()/2;
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
			 
			  boolean hit=false;
			  hit=checkMissileCollision(attacker,missile[Count]);
			  
			  if(hit) 
			  {
				  stopFireAnima(fireAnima[Count],missile[Count]);
			  	  }
			  }
			  
	  };
	  		fireAnima[Count].start();
		 
	}
	boolean w,s,a,d,up,down,left,right;
	int player;
	public void keypressed(KeyEvent event)
	{
		KeyCode code=event.getCode();
		boolean stop1=checkStop(0);
		boolean stop2=checkStop(1);
		switch(code)
		{
		case W: if(!stop1)w=true; break;
		case S: if(!stop1)s=true; break;
		case A: if(!stop1)a=true; break;
		case D: if(!stop1)d=true; break;
		case UP: if(!stop2)up=true; break;
		case DOWN: if(!stop2)down=true; break;
		case LEFT: if(!stop2)left=true; break;
		case RIGHT: if(!stop2)right=true; break;
		}
		//System.out.println("left: t "+left);
	}
	public void keyrelease(KeyEvent event)
	{
		
		KeyCode code=event.getCode();
		
		switch(code)
		{
		case W: w=false; break;
		case S: s=false; break;
		case A: a=false; break;
		case D: d=false; break;
		case UP: up=false; break;
		case DOWN: down=false; break;
		case LEFT: left=false; break;
		case RIGHT: right=false; break;
		}
		
	}
	
	public void moveAnima(int index)
	{
		int player=0;
		//final int moveCounter=Counter;
		tankAnima[player]=new AnimationTimer()
		{	
			public void handle(long now) {
				
			double degree=playerTank[player].getRotate();
			if(degree==360)
				degree=0;
			if(degree==-360)
				degree=0;
			double X=playerTank[player].getX(), Y=playerTank[player].getY();
			if(a) {
				System.out.println("left");
				rectangle[player].setRotate(degree-angle);
				playerTank[player].setRotate(degree-angle);
			}
			if(d) {
				rectangle[player].setRotate(degree+angle);
				playerTank[player].setRotate(degree+angle);
			}
			if(w)
			{
				boolean check1=false,check2=false;
				rectangleForwardLogic(rectangle[player],degree,X,Y);
				check1=checkMoveCollision(rectangle[player]);
				if(!check1)
					tankForwardLogic(playerTank[player],degree,X,Y);
				else
					rectangleBackLogic(rectangle[player],degree,X,Y);
			}
			if(s)
			{
				boolean check1=false,check2=false;
				
				rectangleBackLogic(rectangle[player],degree,X,Y);
				check1=checkMoveCollision(rectangle[player]);
				if(!check1)
					tankBackLogic(playerTank[player],degree,X,Y);
				else
					rectangleForwardLogic(rectangle[player],degree,X,Y);
			}
			
			}
		};
		tankAnima[player].start();
		
		
		int player2=1;
		tankAnima[player2]=new AnimationTimer()
		{	
			public void handle(long now) {
				
			double degree=playerTank[player2].getRotate();
			if(degree==360)
				degree=0;
			if(degree==-360)
				degree=0;
			double X=playerTank[player2].getX(), Y=playerTank[player2].getY();
			if(left) {
				System.out.println("left");
				rectangle[player2].setRotate(degree-angle);
				playerTank[player2].setRotate(degree-angle);
			}
			if(right) {
				rectangle[player2].setRotate(degree+angle);
				playerTank[player2].setRotate(degree+angle);
			}
			if(up)
			{
				boolean check1=false,check2=false;
				rectangleForwardLogic(rectangle[player2],degree,X,Y);
				check1=checkMoveCollision(rectangle[player2]);
				if(!check1)
					tankForwardLogic(playerTank[player2],degree,X,Y);
				else
					rectangleBackLogic(rectangle[player2],degree,X,Y);
			}
			if(down)
			{
				boolean check1=false,check2=false;
				
				rectangleBackLogic(rectangle[player2],degree,X,Y);
				check1=checkMoveCollision(rectangle[player2]);
				if(!check1)
					tankBackLogic(playerTank[player2],degree,X,Y);
				else
					rectangleForwardLogic(rectangle[player2],degree,X,Y);
			}
			
			}
		};
		tankAnima[player2].start();
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
					check1=checkMoveCollision(rec);
					
					if(!check1)
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
	
}
