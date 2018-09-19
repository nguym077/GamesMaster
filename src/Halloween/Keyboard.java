package Halloween;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Keyboard extends Bomb {
    boolean w,s,a,d,up,down,left,right;
    int player;
    int startX=25,startY=25;
    Keyboard()
    {
        testkey();
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
    public void setB(KeyEvent event) {

        //KeyCode code = event.getCode();

        if(event.getCode().equals(KeyCode.B))
        {
            setBomb(startX,startY,5);
        }
    }
    public void testkey() {

        testAnima[0] = new AnimationTimer() {
            public void handle(long now) {
                if (d){startX = startX + 3;System.out.println("d "+startX);}
                if(a){startX=startX-3;System.out.println("a "+startX);}
                if(w){startY=startY-3;System.out.println("w "+startY);}
                if(s){startY=startY+3;System.out.println("s "+startY);}

            }

        };testAnima[0].start();

    }
}
