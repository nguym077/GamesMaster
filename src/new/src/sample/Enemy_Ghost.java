package sample;

import javafx.animation.AnimationTimer;

import java.util.Random;

public class Enemy_Ghost extends AnimationManger {
    private int GhostID = 0;
    private double GhostMove=0.25;
    Enemy_Ghost()
    {
        setGhost(125, 125);
        setGhost(225, 125);
        setGhost(325, 125);
        setGhost(225, 225);
        setGhost(225, 325);}
    public void setGhost(int gx, int gy) {
        if (GhostID == 49)
            GhostID = 1;
        else
            GhostID++;

        Ghost1[GhostID].setX(gx + 5);
        Ghost1[GhostID].setY(gy);
        r_Ghost1[GhostID].setX(gx + r_x);
        r_Ghost1[GhostID].setY(gy + r_y);

        GhostAnima(GhostID, gx, gy);
    }

    public void GhostAnima(int ID, int bx, int by) {
        final int ghostID=ID;
        Ghost_checkHit[ghostID]=0;
        GhostAnima[ghostID] = new AnimationTimer() {
            Random r = new Random();

            // if (frogDown[10].getBoundsInLocal().intersects(playerTank[0].getBoundsInLocal())||
            // frogDown[10].getBoundsInLocal().intersects(playerTank[1].getBoundsInLocal()))

            //  double lastTime2=System.nanoTime();
            int count1=0,count2=0;
            int direction=-1,last_direction=-1;
            double bxx=(double)bx,byy=(double)by;
            boolean block=true;
            int testMove=10;
            public void handle(long now) {
                // if(direction==-1)
                //count1++;count2++;
                if(Ghost_checkHit[ghostID]==1)
                {
                    removeImageView(Ghost1[ghostID],r_Ghost1[ghostID]);
                    stopAnima(GhostAnima[ghostID]);
                    direction=-2;
                }
                if(direction==-1)
                {
                    direction=r.nextInt(4);
                    //direction=0;
                    block=true;
                }
                switch (direction)
                {
                    case 0:{
                        if(block)
                        {
                            r_Ghost1[ghostID].setX(bxx+r_x);
                            r_Ghost1[ghostID].setY(byy+r_y-testMove);
                            if(!colliMetal(r_Ghost1[ghostID])&&!colliBomb(r_Ghost1[ghostID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Ghost1[ghostID].setX(bxx + r_x);
                            r_Ghost1[ghostID].setY(byy + r_y + testMove);
                        }
                        if(block==false&&count1<(25/GhostMove)){
                            r_Ghost1[ghostID].setX(bxx + r_x);
                            r_Ghost1[ghostID].setY(byy + r_y - GhostMove);
                            byy=byy-GhostMove;
                            Ghost1[ghostID].setX(bxx+5);
                            Ghost1[ghostID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/GhostMove)){
                            count1=0;
                            direction=-1;
                        }
                        break;}
                    case 1:{
                        if(block)
                        {
                            r_Ghost1[ghostID].setX(bxx+r_x);
                            r_Ghost1[ghostID].setY(byy+r_y+testMove);
                            if(!colliMetal(r_Ghost1[ghostID])&&!colliBomb(r_Ghost1[ghostID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Ghost1[ghostID].setX(bxx + r_x);
                            r_Ghost1[ghostID].setY(byy + r_y - testMove);
                        }
                        if(block==false&&count1<(25/GhostMove)){
                            r_Ghost1[ghostID].setX(bxx + r_x);
                            r_Ghost1[ghostID].setY(byy + r_y + GhostMove);
                            byy=byy+GhostMove;
                            Ghost1[ghostID].setX(bxx+5);
                            Ghost1[ghostID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/GhostMove)){
                            count1=0;
                            direction=-1;
                        }
                        break;}
                    case 2:{
                        if(block)
                        {
                            r_Ghost1[ghostID].setX(bxx+r_x-testMove);
                            r_Ghost1[ghostID].setY(byy+r_y);
                            if(!colliMetal(r_Ghost1[ghostID])&&!colliBomb(r_Ghost1[ghostID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Ghost1[ghostID].setX(bxx + r_x+ testMove);
                            r_Ghost1[ghostID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/GhostMove)){
                            r_Ghost1[ghostID].setX(bxx + r_x - GhostMove);
                            r_Ghost1[ghostID].setY(byy + r_y );
                            bxx=bxx-GhostMove;
                            Ghost1[ghostID].setX(bxx+5);
                            Ghost1[ghostID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/GhostMove)){
                            count1=0;
                            direction=-1;
                        }
                        break;}
                    case 3:{
                        if(block)
                        {
                            r_Ghost1[ghostID].setX(bxx+r_x+testMove);
                            r_Ghost1[ghostID].setY(byy+r_y);
                            if(!colliMetal(r_Ghost1[ghostID])&&!colliBomb(r_Ghost1[ghostID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Ghost1[ghostID].setX(bxx + r_x- testMove);
                            r_Ghost1[ghostID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/GhostMove)){
                            r_Ghost1[ghostID].setX(bxx + r_x + GhostMove);
                            r_Ghost1[ghostID].setY(byy + r_y );
                            bxx=bxx+GhostMove;
                            Ghost1[ghostID].setX(bxx+5);
                            Ghost1[ghostID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/GhostMove)){
                            count1=0;
                            direction=-1;
                        }
                        break;}
                }


            }
        };GhostAnima[ghostID].start();

    }
}
