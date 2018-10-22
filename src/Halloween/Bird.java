package Halloween;


import javafx.animation.AnimationTimer;
import java.util.Random;

public class Bird extends AnimationManger {
    private Random r = new Random();

    private int birdID = 0;
    private double birdMove = 0.5;
    private int candyLoc_x;
    private int candyLoc_y;


    public Bird() {
        setBird(0, 400);
        //setBird(1150, 300);
        //setBird(0, 200);
        //setBird(575, 600);
    }

    private void setBird(int gx, int gy) {
        if (birdID == 49)
            birdID = 0;
        else
            birdID++;

        Bird1[birdID *4].setX(gx);
        Bird1[birdID *4].setY(gy);
        Bird1[birdID *4+1].setX(gx);
        Bird1[birdID *4+1].setY(gy);
        Bird1[birdID *4+1].setVisible(false);
        Bird1[birdID *4+2].setX(gx);
        Bird1[birdID *4+2].setY(gy);
        Bird1[birdID *4+2].setVisible(false);
        Bird1[birdID *4+3].setX(gx);
        Bird1[birdID *4+3].setY(gy);
        Bird1[birdID *4+3].setVisible(false);

        r_Bird[birdID].setX(gx + r_x);
        r_Bird[birdID].setY(gy + r_y);

        // x: 0 - 1150, y: 0 - 600
        candyLoc_x = r.nextInt(1000) + 50;
        candyLoc_y = r.nextInt(500) + 50;
        System.out.println("candy location: " + candyLoc_x + ", " + candyLoc_y);

        BirdAnima(birdID, gx, gy);
    }

    private void BirdAnima(int ID, int bx, int by) {
        final int newID = ID*4;
        Bird_checkHit[ID] = 0;
        BirdAnima[ID] = new AnimationTimer() {
            int count1 = 0;
            int count2 = 0;
            int animaID = newID;

            int direction = -1;
            int lastDirection = -1;
            int changeDirection = -1;

            double bxx = (double) bx;
            double byy = (double) by;

            int birdMoveRate = 20;

            public void handle(long now) {
                Bird1[newID].setX(bxx);
                Bird1[newID].setY(byy);
                Bird1[newID+1].setX(bxx);
                Bird1[newID+1].setY(byy);
                Bird1[newID+2].setX(bxx);
                Bird1[newID+2].setY(byy);
                Bird1[newID+3].setX(bxx);
                Bird1[newID+3].setY(byy);
                count2++;

                // animates bird across four pngs in /bird_images
                if(count2 >= 0 && count2 < birdMoveRate){
                    animaID=newID;
                    Bird1[newID].setVisible(true);
                    Bird1[newID+1].setVisible(false);
                    Bird1[newID+2].setVisible(false);
                    Bird1[newID+3].setVisible(false);
                } else if(count2 >= birdMoveRate && count2 < 2*birdMoveRate) {
                    animaID=newID+1;
                    Bird1[newID].setVisible(false);
                    Bird1[newID+1].setVisible(true);
                    Bird1[newID+2].setVisible(false);
                    Bird1[newID+3].setVisible(false);
                } else if(count2 >= 2*birdMoveRate && count2 < 3*birdMoveRate){
                    animaID=newID+2;
                    Bird1[newID].setVisible(false);
                    Bird1[newID+1].setVisible(false);
                    Bird1[newID+2].setVisible(true);
                    Bird1[newID+3].setVisible(false);
                } else if(count2 >= 3*birdMoveRate && count2 < 4*birdMoveRate){
                    animaID=newID+3;
                    Bird1[newID].setVisible(false);
                    Bird1[newID+1].setVisible(false);
                    Bird1[newID+2].setVisible(false);
                    Bird1[newID+3].setVisible(true);
                }

                // forces animation to repeat
                if(count2 >= 4*birdMoveRate)
                    count2 = 0;

                // bird flies to candy's random location
                if (r_Bird[ID].getY() != candyLoc_y) {
                    if (r_Bird[ID].getY() < candyLoc_y) {
                        r_Bird[ID].setX(bxx + r_x);
                        r_Bird[ID].setY(byy + r_y + birdMove);
                        byy = byy + birdMove;
                    } else {
                        r_Bird[ID].setX(bxx + r_x);
                        r_Bird[ID].setY(byy + r_y - birdMove);
                        byy = byy - birdMove;
                    }
                    Bird1[animaID].setX(bxx);
                    Bird1[animaID].setY(byy);
                }
                if ( r_Bird[ID].getX() != candyLoc_x) {
                    r_Bird[ID].setX(bxx + r_x + birdMove);
                    r_Bird[ID].setY(byy + r_y);
                    bxx = bxx + birdMove;
                    Bird1[animaID].setX(bxx);
                    Bird1[animaID].setY(byy);

                    count1++;
                }

//                if(count1 == (25/birdMove)){
//                    count1 = 0;
//                    changeDirection = r.nextInt(10);
//                    if(changeDirection == 0)
//                        direction = -1;
//                }

//                switch (direction) {
//                    case 0:{
//                        if(block) {
//                            r_Bird[ID].setX(bxx + r_x);
//                            r_Bird[ID].setY(byy + r_y - testMove);
//                            if(!colliMetal(r_Bird[ID])
//                                    &&!Object_colliBomb(r_Bird[ID])
//                                    &&!colliBrick(r_Bird[ID])){
//                                block = false;
//                            } else {
//                                block = true;
//                                direction = -1;
//                            }
//                            r_Bird[ID].setX(bxx + r_x);
//                            r_Bird[ID].setY(byy + r_y + testMove);
//                        }
//
//                        if(block == false && count1 < (25/birdMove)){
//                            r_Bird[ID].setX(bxx + r_x);
//                            r_Bird[ID].setY(byy + r_y - birdMove);
//                            byy = byy - birdMove;
//                            Bird1[animaID].setX(bxx);
//                            Bird1[animaID].setY(byy);
//
//                            count1++;
//                        }
//
//                        if(count1 == (25/birdMove)){
//                            count1 = 0;
//                            changeDirection = r.nextInt(10);
//                            block = true;
//                            if(changeDirection == 0)
//                                direction = -1;
//                        }
//
//                        break;}
//
//                    case 1:{
//                        if(block) {
//                            r_Bird[ID].setX(bxx+r_x);
//                            r_Bird[ID].setY(byy+r_y+testMove);
//                            if(!colliMetal(r_Bird[ID])&&!Object_colliBomb(r_Bird[ID])&&!colliBrick(r_Bird[ID])){
//                                block=false;
//                            }
//                            else {
//                                block=true;
//                                direction=-1;
//                            }
//                            r_Bird[ID].setX(bxx + r_x);
//                            r_Bird[ID].setY(byy + r_y - testMove);
//                        } if(block==false&&count1<(25/birdMove)){
//                            r_Bird[ID].setX(bxx + r_x);
//                            r_Bird[ID].setY(byy + r_y + birdMove);
//                            byy=byy+birdMove;
//                            Bird1[animaID].setX(bxx);
//                            Bird1[animaID].setY(byy);
//
//                            count1++;
//                        }
//
//                        if(count1==(25/birdMove)){
//                            count1=0;
//                            changeDirection=r.nextInt(10);
//                            block=true;
//                            if(changeDirection==0)
//                                direction=-1;
//                        }
//
//                        break;}
//                    case 2:{
//                        if(block) {
//                            r_Bird[ID].setX(bxx+r_x-testMove);
//                            r_Bird[ID].setY(byy+r_y);
//                            if(!colliMetal(r_Bird[ID])&&!Object_colliBomb(r_Bird[ID])&&!colliBrick(r_Bird[ID])){
//                                block=false;
//                            } else {
//                                block=true;
//                                direction=-1;
//                            }
//                            r_Bird[ID].setX(bxx + r_x+ testMove);
//                            r_Bird[ID].setY(byy + r_y );
//                        }
//
//                        if(block==false&&count1<(25/birdMove)){
//                            r_Bird[ID].setX(bxx + r_x - birdMove);
//                            r_Bird[ID].setY(byy + r_y );
//                            bxx=bxx-birdMove;
//                            Bird1[animaID].setX(bxx);
//                            Bird1[animaID].setY(byy);
//
//                            count1++;
//                        }
//
//                        if(count1==(25/birdMove)){
//                            count1=0;
//                            changeDirection=r.nextInt(10);
//                            block=true;
//                            if(changeDirection==0)
//                                direction=-1;
//                        }
//
//                        break;}
//                    case 3:{
//                        if(block) {
//                            r_Bird[ID].setX(bxx+r_x+testMove);
//                            r_Bird[ID].setY(byy+r_y);
//                            if(!colliMetal(r_Bird[ID])&&!Object_colliBomb(r_Bird[ID])&&!colliBrick(r_Bird[ID])){
//                                block=false;
//                            } else {
//                                block=true;
//                                direction=-1;
//                            }
//                            r_Bird[ID].setX(bxx + r_x- testMove);
//                            r_Bird[ID].setY(byy + r_y );
//                        }
//
//                        if(block==false&&count1<(25/birdMove)){
//                            r_Bird[ID].setX(bxx + r_x + birdMove);
//                            r_Bird[ID].setY(byy + r_y );
//                            bxx=bxx+birdMove;
//                            Bird1[animaID].setX(bxx);
//                            Bird1[animaID].setY(byy);
//
//                            count1++;
//                        }
//
//                        if(count1==(25/birdMove)){
//                            count1=0;
//                            changeDirection=r.nextInt(10);
//                            block=true;
//                            if(changeDirection==0)
//                                direction=-1;
//                        }
//
//                        break;}
//                }
            }
        };
        BirdAnima[ID].start();
    }
}
