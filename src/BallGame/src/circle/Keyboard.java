package circle;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Keyboard implements PublicVar{
	
	boolean w,s,a,d,up,down,left,right;
	public void init()
	{
		key();
	}
	public void keypressed(KeyEvent event)
    {
        KeyCode code=event.getCode();
        //boolean stop1=checkStop(0);
        //boolean stop2=checkStop(1);
        switch(code)
        {
            case W: w=true; break;
            case S: s=true; break;
            case A: a=true; break;
            case D: d=true; break;
            case UP: up=true; break;
            case DOWN: down=true; break;
            case LEFT: left=true; break;
            case RIGHT: right=true; break;
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
    public void key()
    {
    	AnimationTimer keyboard = new AnimationTimer() {
            int count=0;boolean start=false;
            public void handle(long now) {
            	if(w&&!s&&!a&&!d)
            		direction[0]=0;  //up
            	else if(!w&&s&&!a&&!d)
            		direction[0]=1;  //down
            	else if(!w&&!s&&a&&!d)
            		direction[0]=2;  //left
            	else if(!w&&!s&&!a&&d)
            		direction[0]=3; //right
            	else if(!w&&!s&&!a&&!d)
            		direction[0]=-1;
            }
    	};keyboard.start();
    }
}
