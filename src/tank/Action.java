package tank;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Action extends Ui {
	
	Animation gameAnima=new Animation();
	int animaCounter=0;
	boolean up,down,left,right;
	public void keypressed(KeyEvent event)
	{
		KeyCode code=event.getCode();
		/*
		switch(code)
		{
		case W: up=true; break;
		case S: down=true; break;
		case A: left=true; break;
		case D: right=true; break;
		}
		*/
	}
	public void keyrelease(KeyEvent event)
	{
		/*
		KeyCode code=event.getCode();
		
		switch(code)
		{
		case W: up=false; break;
		case S: down=false; break;
		case A: left=false; break;
		case D: right=false; break;
		}
		*/
	}
	public void tankMove()
	{
		double degree1,X1,Y1;
    	degree1=playerTank[0].getRotate();
    	X1=playerTank[0].getX();
    	Y1=playerTank[0].getY();
    	if(animaCounter==50)
			animaCounter=0;
		if(degree1<-360)
	      	degree1=360+degree1;
		if(degree1>360)
			degree1=degree1-360;
		//System.out.println("get d: "+degree1);
		//gameAnima.moveAnima(rectangle[0],playerTank[0],degree1,event,animaCounter);
	}
	
	/*
	public void tankRotation(KeyEvent event){
    	double degree1,X1,Y1;
    	degree1=playerTank[0].getRotate();
    	X1=playerTank[0].getX();
    	Y1=playerTank[0].getY();
		if(animaCounter==50)
			animaCounter=0;
		if(degree1<-360)
	      	degree1=360+degree1;
		if(degree1>360)
			degree1=degree1-360;
		//System.out.println("get d: "+degree1);
    	if(event.getCode().equals(KeyCode.Q)||event.getCode().equals(KeyCode.E)|event.getCode().equals(KeyCode.A)
    	||event.getCode().equals(KeyCode.D)||event.getCode().equals(KeyCode.W)||event.getCode().equals(KeyCode.S))
    	gameAnima.moveAnima(rectangle[0],playerTank[0],degree1,event,animaCounter);
    	
    	
        double degree2,X2,Y2;
        degree2=playerTank[1].getRotate();
    	X2=playerTank[1].getX();
    	Y2=playerTank[1].getY();
    	if(degree2==360||degree2==-360)
			degree2=0;
    	if(degree2<0)
	      	degree2=Math.abs(degree2);
		if(degree2>360)
			degree2=degree2-360;
    	if(event.getCode().equals(KeyCode.U)||event.getCode().equals(KeyCode.O)|event.getCode().equals(KeyCode.J)
    	    	||event.getCode().equals(KeyCode.L)||event.getCode().equals(KeyCode.I)||event.getCode().equals(KeyCode.K))
    		gameAnima.moveAnima(rectangle[1],playerTank[1],degree2,event,animaCounter);
    	
        animaCounter++;
    }
    */
	int fireAnimaCounter=0;
	long lastTime=System.nanoTime();
	
	public void fire(KeyEvent event)  {
		if(fireAnimaCounter==100)
			fireAnimaCounter=0;
		
		  if(event.getCode().equals(KeyCode.V))
		  {
			  long currentTime=System.nanoTime();
			  if(currentTime-lastTime>500000000) {
		      int fireIndex=0;
		      boolean stop1=checkStop(0);
		      if(!stop1) {
		    	  if(checkShell1()!=0) {
		    		  gameAnima.missileAnima(playerTank[0],fireAnimaCounter);
		    		  changeShell1(-1);
		    	  }
		      }
		      
		      lastTime=currentTime;
		      }
		      
		  }
		  if(event.getCode().equals(KeyCode.L))
		  {
			  
		      int fireIndex=1;
		      boolean stop2=checkStop(1);
		      if(!stop2) {
		    	  if(checkShell2()!=0) {
		    		  gameAnima.missileAnima(playerTank[1],fireAnimaCounter);
		    		  changeShell2(-1);
		    	  }
		      }
		      
		  }
		  /*
		  if(event.getCode().equals(KeyCode.J))
		  {
		      int fireIndex=2;
		      gameAnima.missileAnima(playerTank[2],fireAnimaCounter);
		  }
		  */
		  fireAnimaCounter++;
	    }
	
	
	
}
