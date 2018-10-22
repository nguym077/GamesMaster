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
        testkey2();
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
    int next=0;
    public void setB(KeyEvent event) {

        //KeyCode code = event.getCode();
        if(event.getCode().equals(KeyCode.B))
        {
            if(bomb_numbers[0]>0){
                setBomb(0,charX[0]+10,charY[0]+10, bomb_power[0],3);
            }
        }
        if(event.getCode().equals(KeyCode.T)&&life[0]>0&&health[0]<=0)
        {
            health[0]=3;
            bomb_numbers[0]=1;
            bomb_power[0]=1;
            player_speed[0]=3;
            life[0]=life[0]-1;
            PlayerAnima[0].start();
            noHurt[0]=100;
        }

    }
    public void setB2(KeyEvent event) {

        //KeyCode code = event.getCode();
        if(event.getCode().equals(KeyCode.P))
        {
            if(bomb_numbers[1]>0){
                setBomb(1,charX[1]+10,charY[1]+10, bomb_power[1],3);
            }
        }
        if(event.getCode().equals(KeyCode.I)&&life[1]>0&&health[1]<=0)
        {
            health[1]=3;
            bomb_numbers[1]=1;
            bomb_power[1]=1;
            player_speed[1]=3;
            life[1]=life[1]-1;
            PlayerAnima[1].start();
            noHurt[1]=100;
        }

    }
    public void testkey() {

        testAnima[0] = new AnimationTimer() {
            int count=0;boolean start=false;
            public void handle(long now) {
                if(start==false)
                count++;
                if(count>100)
                {
                    start=true;
                    if(w){status[0]=1;}
                    else if(s){status[0]=2;}
                    else if(a){status[0]=3;}
                    else if(d){status[0]=4;}
                    else status[0]=0;
                }


            }

        };testAnima[0].start();

    }
    public void testkey2() {

        AnimationTimer testAnima2 = new AnimationTimer() {
            int count=0;boolean start=false;
            public void handle(long now) {
                if(start==false)
                    count++;
                if(count>100)
                {
                    if(up){status[1]=1;}
                    else if(down){status[1]=2;}
                    else if(left){status[1]=3;}
                    else if(right){status[1]=4;}
                    else status[1]=0;
                }


            }

        };testAnima2.start();

    }
}
