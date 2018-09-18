package sample;


import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Enemy extends Bomb {
    public int GhostID = 1;
    public double GhostMove=2;
    public final double r_x=0.5, r_y=0.5;
    Enemy() {
        setGhost(125, 125);
    }

    public void setGhost(int gx, int gy) {
        if (GhostID == 49)
            GhostID = 2;
        else
            GhostID++;

        Ghost1[GhostID].setX(gx + 5);
        Ghost1[GhostID].setY(gy);
        r_Ghost1[GhostID].setX(gx + r_x);
        r_Ghost1[GhostID].setY(gy + r_y);

        GhostAnima(GhostID, gx, gy);
    }

    public void removeImageView(ImageView view, Rectangle r_view) {
        view.setX(-1000);
        view.setY(0);
        r_view.setX(-1000);
        r_view.setY(0);
    }

    public void stopAnima(AnimationTimer anima) {
        anima.stop();
    }

    public void GhostAnima(int ID, int bx, int by) {
        final int ghostID=ID;

        GhostAnima[ghostID] = new AnimationTimer() {
            Random r = new Random();

            // if (frogDown[10].getBoundsInLocal().intersects(playerTank[0].getBoundsInLocal())||
            // frogDown[10].getBoundsInLocal().intersects(playerTank[1].getBoundsInLocal()))

            //  double lastTime2=System.nanoTime();
            int count1=0,count2=0;
            int direction=-1,last_direction=-1;
            double bxx=(double)bx,byy=(double)by;
            boolean block=true;
            public void handle(long now) {
               // if(direction==-1)
                count1++;count2++;
                if(count1>20&&(block==false)){
                    count1=0;
                    direction=last_direction;
                    //System.out.println("dir "+direction);
                }
                else if(count2>50||block) {
                    count2=0;
                    direction = r.nextInt(4);
                    last_direction=direction;
                }

                switch (direction)
                {
                    case 0:{
                        r_Ghost1[ghostID].setX(bxx+r_x);
                        r_Ghost1[ghostID].setY(byy+r_y-GhostMove);
                        if(!colliMetal(r_Ghost1[ghostID])){
                            block=false;
                            Ghost1[ghostID].setX(bxx=bxx+r_x);
                            Ghost1[ghostID].setY(byy=byy+r_y-GhostMove);
                        }
                        else {
                            block=true;
                            r_Ghost1[ghostID].setX(bxx + r_x);
                            r_Ghost1[ghostID].setY(byy + r_y + GhostMove);
                        }
                        break;}
                    case 1:{
                        r_Ghost1[ghostID].setX(bxx+r_x);
                        r_Ghost1[ghostID].setY(byy+r_y+GhostMove);
                        if(!colliMetal(r_Ghost1[ghostID])){
                            block=false;
                            Ghost1[ghostID].setX(bxx=bxx+r_x);
                            Ghost1[ghostID].setY(byy=byy+r_y+GhostMove);
                        }
                        else {
                            block=true;
                            r_Ghost1[ghostID].setX(bxx + r_x);
                            r_Ghost1[ghostID].setY(byy + r_y - GhostMove);
                        }
                        break;}
                    case 2:{
                        r_Ghost1[ghostID].setX(bxx+r_x-GhostMove);
                        r_Ghost1[ghostID].setY(byy+r_y);
                        if(!colliMetal(r_Ghost1[ghostID])){
                            block=false;
                            Ghost1[ghostID].setX(bxx=bxx+r_x-GhostMove);
                            Ghost1[ghostID].setY(byy=byy+r_y);
                        }
                        else {
                            block=true;
                            r_Ghost1[ghostID].setX(bxx + r_x+GhostMove);
                            r_Ghost1[ghostID].setY(byy + r_y);
                        }
                        break;}
                    case 3:{
                        r_Ghost1[ghostID].setX(bxx+r_x+GhostMove);
                        r_Ghost1[ghostID].setY(byy+r_y);
                        if(!colliMetal(r_Ghost1[ghostID])){
                            block=false;
                            Ghost1[ghostID].setX(bxx=bxx+r_x+GhostMove);
                            Ghost1[ghostID].setY(byy=byy+r_y);
                        }
                        else {
                            block=true;
                            r_Ghost1[ghostID].setX(bxx + r_x-GhostMove);
                            r_Ghost1[ghostID].setY(byy + r_y);
                        }
                        break;}
                }
                direction=-1;
            }
        };GhostAnima[ghostID].start();

    }
}