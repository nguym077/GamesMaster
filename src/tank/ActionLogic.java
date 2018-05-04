package tank;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
abstract class ActionLogic extends dataPanel implements imageUi{
	int animationCount;
	
	public void removeImage(ImageView view)
	{
		view.setX(-50);
		view.setY(-50);
	}
	public void removeRectangle(Rectangle rec)
	{
		rec.setX(-50);
		rec.setY(-50);
	}

	public boolean checkOutBoard(ImageView view)
	{
		double boardX=1000,boardY=1000;
		boolean Out=false;
		if(view.getX()>boardX||view.getX()<0||view.getY()>boardY||view.getY()<0)
		{
			Out=true;
		}
		return Out;
	}
	
	public boolean checkMissileCollision(ImageView attack,ImageView missile) {
		boolean collison=false;
		//check wall
		if(!collison)
		{
			for(int i=0;i<wallRec.length;i++)
			{
				if(wallRec[i]!=null)
				{
					 if (missile.getBoundsInLocal().intersects(wallRec[i].getBoundsInLocal())) 
				        {
						 
				        //destory(playerTank[i],rectangle[i]);
						removeImage(missile);
				        collison=true;
				        break;
				        }
				}
			}
		}
		//check board
		if(!collison)
		{
			for(int i=0;i<board.length;i++)
			{
				if(board[i]!=null)
				{
				 if (missile.getBoundsInLocal().intersects(board[i].getBoundsInLocal())) 
			        {
					 
			        //destory(playerTank[i],rectangle[i]);
					removeImage(missile);
			        collison=true;
			        break;
			        }
				}
			}
		}
		if(!collison)
		{
			tankAnima[0].stop();
			for(int i=0;i<playerTank.length;i++)
			{
				if(playerTank[i]!=null)
				{
					if(attack!=playerTank[i])
					{
					 if (missile.getBoundsInLocal().intersects(playerTank[i].getBoundsInLocal())) 
				        {
						 newHealth(i,damage);
						 if(checkStop(i))
							 tankAnima[0].stop();
							 stopAnima(tankAnima[i]);
						 //System.out.println("stop "+checkStop(i));
				        //destory(playerTank[i],rectangle[i]);
				        collison=true;
				        break;
				        }
					    
					}
				}
			}
		}
		if(!collison)
		{
			for(int i=0;i<aiTank.length;i++)
			{
				if(aiTank[i]!=null)
				{
					if(attack!=aiTank[i])
					{
					 if (missile.getBoundsInLocal().intersects(aiTank[i].getBoundsInLocal())) 
				        {
				        destory(aiTank[i],aiRectangle[i]);
				        collison=true;
				        break;
				        }
					    
					}
				}
			}
		}
	    return collison;
	}
	
	
	public boolean setWallCollision(ImageView a) {
			
			boolean collison=false;
			//check with path
			if(!collison) {
				for(int i=0;i<path.length;i++)
				{
					if(path[i]!=null)
					{
					 if (a.getLayoutBounds().intersects(path[i].getLayoutBounds())) {
					     
					         {
					        collison=true;break;}
					    }
						
					}
				}
			}
			if(!collison) {
				for(int i=0;i<wall.length;i++)
				{
					if(wall[i]!=null)
					{
						if(a!=wall[i])
						{
						 if (a.getLayoutBounds().intersects(wall[i].getLayoutBounds())) {
						     
						         {
						        collison=true;break;}
						    }
						}
					}
				}
			}
			return collison;
	}
	public boolean checkMoveCollision(Rectangle a) {
		
		boolean collison=false;
		
		if(!collison) {
			for(int i=0;i<board.length;i++)
			{
				if(board[i]!=null)
				{
					if(a!=board[i])
					{
					 if (a.getBoundsInLocal().intersects(board[i].getBoundsInLocal())) {
					     
					         {
					        collison=true;break;}
					    }
					}
				}
			}
		}
		
		//with wall
		if(!collison) {
			for(int i=0;i<wallRec.length;i++)
			{
				if(wallRec[i]!=null)
				{
				 if (a.getBoundsInLocal().intersects(wallRec[i].getBoundsInLocal())) {
				     
				         {
				        collison=true;break;}
				    }
				}
			}
		}
		//check with player
		if(!collison) {
			for(int i=0;i<rectangle.length;i++)
			{
				if(rectangle[i]!=null)
				{
					if(a!=rectangle[i])
					{
					 if (a.getBoundsInLocal().intersects(rectangle[i].getBoundsInLocal())) {
						 
					        collison=true;break;
					    }
					}
				}
			}
		}
		if(!collison) {
			for(int i=0;i<aiRectangle.length;i++)
			{
				if(aiRectangle[i]!=null)
				{
					if(a!=aiRectangle[i])
					{
					 if (a.getBoundsInLocal().intersects(aiRectangle[i].getBoundsInLocal())) {
					     
					         {
					        collison=true;break;}
					    }
					}
				}
			}
		}
		 
	    return collison;
	   
	}
	public boolean checkFrogCollision(Rectangle a) {
			boolean collison=false;
			if(!collison) {
				for(int i=0;i<coliFrog.length;i++)
				{
					if(coliFrog[i]!=null)
					{
						if(a!=coliFrog[i])
						{
						 if (a.getBoundsInLocal().intersects(coliFrog[i].getBoundsInLocal())) {
						    
						         {
						        	 if(coliFrogType[0]==4) {
						        		 if(a==rectangle[0]) {
						        		 crossingBunny(playerTank[0],coliFrog[0]);
						        		 halfHealth(0);
						        		 }
						        		 else if(a==rectangle[1])
						        		 {
							        		 crossingBunny(playerTank[1],coliFrog[0]);
							        		 halfHealth(1);
						        		 }
						        	 }
						        	 else
						        	 {
						        		 if(a==rectangle[0]) {
						        			 newHealth(0,50);
						        			 changeShell1(10);
							        		 }
						        		 else if(a==rectangle[1])
						        		 {
						        			 newHealth(1,50);
						        			 changeShell2(10);
						        		 }
						        	 }
						        		 
						        collison=true;break;}
						    }
						}
					}
				}
				for(int i=15;i<19;i++) {
					if (a.getBoundsInLocal().intersects(bunnyLeft[i].getBoundsInLocal())||
							a.getBoundsInLocal().intersects(bunnyRight[i].getBoundsInLocal())||
							a.getBoundsInLocal().intersects(bunnyUp[i].getBoundsInLocal())||
							a.getBoundsInLocal().intersects(bunnyDown[i].getBoundsInLocal())) {
					    
				         
				        		 if(a==rectangle[0]) {
				        			 playerTank[0].setX(50);
										playerTank[0].setY(20);
										 halfHealth(0);
				        		 }
				        		
				        		 
				        		 else if(a==rectangle[1])
				        		 {
				        			 playerTank[1].setX(50);
										playerTank[1].setY(20);
					        		 halfHealth(1);
				        		 }
				        		 collison=true;break;
				         
				    }
				}
				
			}
			
			return collison;
	}
	int animaIndex=0;
	public void destory(ImageView a,Rectangle rec)
	{
		double X=a.getX()+20;
		double Y=a.getY()+20;
		//a.setDisable(true);
		//a.setVisible(false);
		
		if(animaIndex==30) 
			animaIndex=0;
		final int Index=animaIndex;
		explosion(X,Y,Index);
		animaIndex++;
		removeImage(a);
		removeRectangle(rec);
	}
	
	public void explosion(double X,double Y,int index)
	{
		explosionAnima[index]=new AnimationTimer() {
			 final int i=(index)*2+index;
			 final double lastTime=System.nanoTime();
			 public void handle(long now) {
				  double fix=0;
				  fix=-5.5;
				  explosion[i].setX(X+fix);
				  explosion[i].setY(Y+fix);
				  if(now-lastTime>200000000)
				  {
					  removeImage(explosion[i]);
					  fix=-7.5;
					  explosion[i+1].setX(X+fix);
					  explosion[i+1].setY(Y+fix);
					
				  }  
				  if(now-lastTime>400000000)
				  {
					  fix=-8;
					  explosion[i+2].setX(X+fix);
					  explosion[i+2].setY(Y+fix);
					  removeImage(explosion[i+1]);
				  }
				  if(now-lastTime>600000000)
				  {
					  removeImage(explosion[i+2]);
					  stopEAnima(index);
				  }
		  }
		  
		};
			 explosionAnima[index].start();
			 
	}
	
	public void stopEAnima(int animaIndex)
	{
		explosionAnima[animaIndex].stop();
	}
	public void tankForwardLogic(ImageView view,double degree,double X,double Y)
	{
		double forwardDistance=0;
		if(view==playerTank[0]) {
			forwardDistance=playerTankSpeed[0];}
		else if(view==playerTank[1]) {
			forwardDistance=playerTankSpeed[1];}
		
		boolean counterClock=false;
		double distance=1;
    	if(degree<0)
    	{
    		degree=Math.abs(degree);
    		counterClock=true;
    	}
    	if(degree>=0&&degree<=90)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree))*forwardDistance);
    			view.setY(Y-Math.cos(Math.toRadians(degree))*forwardDistance);
    		}
    		else
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree))*forwardDistance);
            	view.setY(Y-Math.cos(Math.toRadians(degree))*forwardDistance);
    		}
    	}
    	else if(degree>90&&degree<=180)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-90))*forwardDistance);
            	view.setY(Y+Math.sin(Math.toRadians(degree-90))*forwardDistance);
    		}
    		else
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-90))*forwardDistance);
            	view.setY(Y+Math.sin(Math.toRadians(degree-90))*forwardDistance);
    		}
    		
    	}
    	else if(degree>180&&degree<=270)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree-180))*forwardDistance);
            	view.setY(Y+Math.cos(Math.toRadians(degree-180))*forwardDistance);
    		}
    		else
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree-180))*forwardDistance);
            	view.setY(Y+Math.cos(Math.toRadians(degree-180))*forwardDistance);
    		}
    	}
    	else if(degree>270&&degree<=360)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-270))*forwardDistance);
            	view.setY(Y-Math.sin(Math.toRadians(degree-270))*forwardDistance);
    		}
    		else
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-270))*forwardDistance);
            	view.setY(Y-Math.sin(Math.toRadians(degree-270))*forwardDistance);
    		}
    	}
	}
	public void tankBackLogic(ImageView view,double degree,double X,double Y)
	{
		double backwardDistance=0;
		if(view==playerTank[0]) {
			backwardDistance=playerTankSpeed[0];}
		else if(view==playerTank[1]) {
			backwardDistance=playerTankSpeed[1];}
		
		boolean counterClock=false;
    	if(degree<0)
    	{
    		degree=Math.abs(degree);
    		counterClock=true;
    	}
    	
    	if(degree>=0&&degree<=90)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree))*backwardDistance);
            	view.setY(Y+Math.cos(Math.toRadians(degree))*backwardDistance);
    		}
    		else
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree))*backwardDistance);
            	view.setY(Y+Math.cos(Math.toRadians(degree))*backwardDistance);
    		}
    	}
    	else if(degree>90&&degree<=180)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-90))*backwardDistance);
            	view.setY(Y-Math.sin(Math.toRadians(degree-90))*backwardDistance);
    		}
    		else
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-90))*backwardDistance);
            	view.setY(Y-Math.sin(Math.toRadians(degree-90))*backwardDistance);
    		}
    		
    	}
    	else if(degree>180&&degree<=270)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree-180))*backwardDistance);
            	view.setY(Y-Math.cos(Math.toRadians(degree-180))*backwardDistance);
    		}
    		else
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree-180))*backwardDistance);
            	view.setY(Y-Math.cos(Math.toRadians(degree-180))*backwardDistance);
    		}
    	}
    	else if(degree>270&&degree<=360)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-270))*backwardDistance);
            	view.setY(Y+Math.sin(Math.toRadians(degree-270))*backwardDistance);
    		}
    		else
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-270))*backwardDistance);
            	view.setY(Y+Math.sin(Math.toRadians(degree-270))*backwardDistance);
    		}
    	}
    	
	}
	
	public void rectangleForwardLogic(Rectangle view,double degree,double X,double Y)
	{
		double distance=0;
		if(view==rectangle[0]) {
			distance=playerTankSpeed[0];}
		else if(view==rectangle[1]) {
			distance=playerTankSpeed[1];}
		boolean counterClock=false;
    	if(degree<0)
    	{
    		degree=Math.abs(degree);
    		counterClock=true;
    	}
    	
    	if(degree>=0&&degree<=90)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree))*distance);
    			view.setY(Y-Math.cos(Math.toRadians(degree))*distance);
    		}
    		else
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree))*distance);
            	view.setY(Y-Math.cos(Math.toRadians(degree))*distance);
    		}
    	}
    	else if(degree>90&&degree<=180)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-90))*distance);
            	view.setY(Y+Math.sin(Math.toRadians(degree-90))*distance);
    		}
    		else
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-90))*distance);
            	view.setY(Y+Math.sin(Math.toRadians(degree-90))*distance);
    		}
    		
    	}
    	else if(degree>180&&degree<=270)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree-180))*distance);
            	view.setY(Y+Math.cos(Math.toRadians(degree-180))*distance);
    		}
    		else
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree-180))*distance);
            	view.setY(Y+Math.cos(Math.toRadians(degree-180))*distance);
    		}
    	}
    	else if(degree>270&&degree<=360)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-270))*distance);
            	view.setY(Y-Math.sin(Math.toRadians(degree-270))*distance);
    		}
    		else
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-270))*distance);
            	view.setY(Y-Math.sin(Math.toRadians(degree-270))*distance);
    		}
    	}
	}
	public void rectangleBackLogic(Rectangle view,double degree,double X,double Y)
	{
		double distance=0;
		if(view==rectangle[0]) {
			distance=playerTankSpeed[0];}
		else if(view==rectangle[1]) {
			distance=playerTankSpeed[1];}
		boolean counterClock=false;
    	if(degree<0)
    	{
    		degree=Math.abs(degree);
    		counterClock=true;
    	}
    	
    	if(degree>=0&&degree<=90)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree))*distance);
            	view.setY(Y+Math.cos(Math.toRadians(degree))*distance);
    		}
    		else
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree))*distance);
            	view.setY(Y+Math.cos(Math.toRadians(degree))*distance);
    		}
    	}
    	else if(degree>90&&degree<=180)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-90))*distance);
            	view.setY(Y-Math.sin(Math.toRadians(degree-90))*distance);
    		}
    		else
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-90))*distance);
            	view.setY(Y-Math.sin(Math.toRadians(degree-90))*distance);
    		}
    		
    	}
    	else if(degree>180&&degree<=270)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree-180))*distance);
            	view.setY(Y-Math.cos(Math.toRadians(degree-180))*distance);
    		}
    		else
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree-180))*distance);
            	view.setY(Y-Math.cos(Math.toRadians(degree-180))*distance);
    		}
    	}
    	else if(degree>270&&degree<=360)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-270))*distance);
            	view.setY(Y+Math.sin(Math.toRadians(degree-270))*distance);
    		}
    		else
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-270))*distance);
            	view.setY(Y+Math.sin(Math.toRadians(degree-270))*distance);
    		}
    	}
    	
	}
	boolean checkStop(int index)
	{
		boolean stop=false;
		if(index==0) 
		{
		if(health[1].getWidth()==0)
			stop=true;
		}
		else if(index==1) 
		{
		if(health[3].getWidth()==0)
			stop=true;
		}
		return stop;
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
