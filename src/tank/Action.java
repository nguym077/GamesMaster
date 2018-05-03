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
		 
		  fireAnimaCounter++;
	    }
	
	
	
}
