package tank;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
abstract class ActionLogic implements imageUi{
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
	
	public boolean checkMissileCollision(ImageView attack,ImageView missile, ImageView []b,Rectangle []rec) {
		boolean collison=false;
		for(int i=0;i<b.length;i++)
		{
			if(b[i]!=null)
			{
			if(attack!=b[i])
			{
			 if (missile.getBoundsInLocal().intersects(b[i].getBoundsInLocal())) {
		        
		         {
		        destory(b[i],rec[i]);
		        collison=true;
		        break;
		        }
			    }
			}
			}
		}
	    return collison;
	}
	public boolean checkMissileCollision(ImageView a,Rectangle []b) {
		boolean collison=false;
		for(int i=0;i<b.length;i++)
		{
		 if (a.getLayoutBounds().intersects(b[i].getLayoutBounds())) {
		      
		         {
		        collison=true;break;}
		    }
		}
	    return collison;
	}
	
	
	public boolean checkMoveCollision(Rectangle a,Rectangle []b) {
		boolean collison=false;
		for(int i=0;i<b.length;i++)
		{
			if(b[i]!=null)
			{
				if(a!=b[i])
				{
				 if (a.getLayoutBounds().intersects(b[i].getLayoutBounds())) {
				     
				         {
				        collison=true;break;}
				    }
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
    			view.setX(X-Math.sin(Math.toRadians(degree))*10);
    			view.setY(Y-Math.cos(Math.toRadians(degree))*10);
    		}
    		else
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree))*10);
            	view.setY(Y-Math.cos(Math.toRadians(degree))*10);
    		}
    	}
    	else if(degree>90&&degree<=180)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-90))*10);
            	view.setY(Y+Math.sin(Math.toRadians(degree-90))*10);
    		}
    		else
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-90))*10);
            	view.setY(Y+Math.sin(Math.toRadians(degree-90))*10);
    		}
    		
    	}
    	else if(degree>180&&degree<=270)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree-180))*10);
            	view.setY(Y+Math.cos(Math.toRadians(degree-180))*10);
    		}
    		else
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree-180))*10);
            	view.setY(Y+Math.cos(Math.toRadians(degree-180))*10);
    		}
    	}
    	else if(degree>270&&degree<=360)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-270))*10);
            	view.setY(Y-Math.sin(Math.toRadians(degree-270))*10);
    		}
    		else
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-270))*10);
            	view.setY(Y-Math.sin(Math.toRadians(degree-270))*10);
    		}
    	}
	}
	public void tankBackLogic(ImageView view,double degree,double X,double Y)
	{
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
    			view.setX(X+Math.sin(Math.toRadians(degree))*10);
            	view.setY(Y+Math.cos(Math.toRadians(degree))*10);
    		}
    		else
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree))*10);
            	view.setY(Y+Math.cos(Math.toRadians(degree))*10);
    		}
    	}
    	else if(degree>90&&degree<=180)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-90))*10);
            	view.setY(Y-Math.sin(Math.toRadians(degree-90))*10);
    		}
    		else
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-90))*10);
            	view.setY(Y-Math.sin(Math.toRadians(degree-90))*10);
    		}
    		
    	}
    	else if(degree>180&&degree<=270)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree-180))*10);
            	view.setY(Y-Math.cos(Math.toRadians(degree-180))*10);
    		}
    		else
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree-180))*10);
            	view.setY(Y-Math.cos(Math.toRadians(degree-180))*10);
    		}
    	}
    	else if(degree>270&&degree<=360)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-270))*10);
            	view.setY(Y+Math.sin(Math.toRadians(degree-270))*10);
    		}
    		else
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-270))*10);
            	view.setY(Y+Math.sin(Math.toRadians(degree-270))*10);
    		}
    	}
    	
	}
	
	public void rectangleForwardLogic(Rectangle view,double degree,double X,double Y)
	{
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
    			view.setX(X-Math.sin(Math.toRadians(degree))*10);
    			view.setY(Y-Math.cos(Math.toRadians(degree))*10);
    		}
    		else
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree))*10);
            	view.setY(Y-Math.cos(Math.toRadians(degree))*10);
    		}
    	}
    	else if(degree>90&&degree<=180)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-90))*10);
            	view.setY(Y+Math.sin(Math.toRadians(degree-90))*10);
    		}
    		else
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-90))*10);
            	view.setY(Y+Math.sin(Math.toRadians(degree-90))*10);
    		}
    		
    	}
    	else if(degree>180&&degree<=270)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree-180))*10);
            	view.setY(Y+Math.cos(Math.toRadians(degree-180))*10);
    		}
    		else
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree-180))*10);
            	view.setY(Y+Math.cos(Math.toRadians(degree-180))*10);
    		}
    	}
    	else if(degree>270&&degree<=360)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-270))*10);
            	view.setY(Y-Math.sin(Math.toRadians(degree-270))*10);
    		}
    		else
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-270))*10);
            	view.setY(Y-Math.sin(Math.toRadians(degree-270))*10);
    		}
    	}
	}
	public void rectangleBackLogic(Rectangle view,double degree,double X,double Y)
	{
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
    			view.setX(X+Math.sin(Math.toRadians(degree))*10);
            	view.setY(Y+Math.cos(Math.toRadians(degree))*10);
    		}
    		else
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree))*10);
            	view.setY(Y+Math.cos(Math.toRadians(degree))*10);
    		}
    	}
    	else if(degree>90&&degree<=180)
    	{
    		if(counterClock)
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-90))*10);
            	view.setY(Y-Math.sin(Math.toRadians(degree-90))*10);
    		}
    		else
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-90))*10);
            	view.setY(Y-Math.sin(Math.toRadians(degree-90))*10);
    		}
    		
    	}
    	else if(degree>180&&degree<=270)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.sin(Math.toRadians(degree-180))*10);
            	view.setY(Y-Math.cos(Math.toRadians(degree-180))*10);
    		}
    		else
    		{
    			view.setX(X+Math.sin(Math.toRadians(degree-180))*10);
            	view.setY(Y-Math.cos(Math.toRadians(degree-180))*10);
    		}
    	}
    	else if(degree>270&&degree<=360)
    	{
    		if(counterClock)
    		{
    			view.setX(X-Math.cos(Math.toRadians(degree-270))*10);
            	view.setY(Y+Math.sin(Math.toRadians(degree-270))*10);
    		}
    		else
    		{
    			view.setX(X+Math.cos(Math.toRadians(degree-270))*10);
            	view.setY(Y+Math.sin(Math.toRadians(degree-270))*10);
    		}
    	}
    	
	}
}
