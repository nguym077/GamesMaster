package Halloween;


import javafx.animation.AnimationTimer;

import java.util.Random;

public class Bird extends AnimationManger {
    private int BirdID = 0;
    private double BirdMove=0.5;

    Bird() {
        setBird(350, 225);
        setBird(350, 325);
        //setBird(375, 425);
        //setBird(425, 225);
    }

    public void setBird(int gx, int gy) {
        if (BirdID == 49)
            BirdID = 0;
        else
            BirdID++;

        Bird1[BirdID*4].setX(gx);
        Bird1[BirdID*4].setY(gy);
        Bird1[BirdID*4+1].setX(gx);
        Bird1[BirdID*4+1].setY(gy);
        Bird1[BirdID*4+1].setVisible(false);
        Bird1[BirdID*4+2].setX(gx);
        Bird1[BirdID*4+2].setY(gy);
        Bird1[BirdID*4+2].setVisible(false);
        Bird1[BirdID*4+3].setX(gx);
        Bird1[BirdID*4+3].setY(gy);
        Bird1[BirdID*4+3].setVisible(false);

        r_Bird[BirdID].setX(gx + r_x);
        r_Bird[BirdID].setY(gy + r_y);
        BirdAnima(BirdID, gx, gy);
    }

    public void BirdAnima(int ID, int bx, int by) {
        final int newID=ID*4;
        Bird_checkHit[ID]=0;
        BirdAnima[ID] = new AnimationTimer() {
            Random r = new Random();
            int count1=0,count2=0;
            int direction=-1,last_direction=-1;
            double bxx=(double)bx,byy=(double)by;
            boolean block=true;
            int testMove=10;
            int change_direction=-1;
            int animaID=newID;
            int BirdMoveRate=10;

            public void handle(long now) {
                // if(direction==-1)
                //count1++;count2++;
                Bird1[newID].setX(bxx);
                Bird1[newID].setY(byy);
                Bird1[newID+1].setX(bxx);
                Bird1[newID+1].setY(byy);
                Bird1[newID+2].setX(bxx);
                Bird1[newID+2].setY(byy);
                Bird1[newID+3].setX(bxx);
                Bird1[newID+3].setY(byy);

                if(Bird_checkHit[ID]==1)
                {
                    removeImageView(Bird1[newID],r_Bird[ID]);
                    removeImageView(Bird1[newID+1],r_Bird[ID]);
                    removeImageView(Bird1[newID+2],r_Bird[ID]);
                    removeImageView(Bird1[newID+3],r_Bird[ID]);
                    stopAnima(ID,BirdAnima[ID]);
                    direction=-2;
                    //setBat(125, 125);
                }
                if(direction==-1)
                {
                    direction=r.nextInt(4);
                    //direction=0;
                    block=true;
                }
                count2++;

                if(count2>=0&&count2<BirdMoveRate){

                    animaID=newID;

                    Bird1[newID].setVisible(true);
                    Bird1[newID+1].setVisible(false);
                    Bird1[newID+2].setVisible(false);
                    Bird1[newID+3].setVisible(false);
                }
                else if(count2>=BirdMoveRate&&count2<2*BirdMoveRate)
                {
                    animaID=newID+1;
                    Bird1[newID].setVisible(false);
                    Bird1[newID+1].setVisible(true);
                    Bird1[newID+2].setVisible(false);
                    Bird1[newID+3].setVisible(false);
                }
                else if(count2>=2*BirdMoveRate&&count2<3*BirdMoveRate){
                    animaID=newID+2;
                    Bird1[newID].setVisible(false);
                    Bird1[newID+1].setVisible(false);
                    Bird1[newID+2].setVisible(true);
                    Bird1[newID+3].setVisible(false);
                }
                else if(count2>=3*BirdMoveRate&&count2<4*BirdMoveRate){
                    animaID=newID+3;
                    Bird1[newID].setVisible(false);
                    Bird1[newID+1].setVisible(false);
                    Bird1[newID+2].setVisible(false);
                    Bird1[newID+3].setVisible(true);
                }
                if(count2>=4*BirdMoveRate)
                    count2=0;



                switch (direction)
                {
                    case 0:{
                        if(block)
                        {
                            r_Bird[ID].setX(bxx+r_x);
                            r_Bird[ID].setY(byy+r_y-testMove);
                            if(!colliMetal(r_Bird[ID])
                                    &&!Object_colliBomb(r_Bird[ID])
                                    &&!colliBrick(r_Bird[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Bird[ID].setX(bxx + r_x);
                            r_Bird[ID].setY(byy + r_y + testMove);
                        }
                        if(block==false&&count1<(25/BirdMove)){
                            r_Bird[ID].setX(bxx + r_x);
                            r_Bird[ID].setY(byy + r_y - BirdMove);
                            byy=byy-BirdMove;
                            Bird1[animaID].setX(bxx);
                            Bird1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/BirdMove)){
                            count1=0;
                            change_direction=r.nextInt(10);
                            block=true;
                            if(change_direction==0)
                                direction=-1;
                        }
                        break;}
                    case 1:{
                        if(block)
                        {
                            r_Bird[ID].setX(bxx+r_x);
                            r_Bird[ID].setY(byy+r_y+testMove);
                            if(!colliMetal(r_Bird[ID])&&!Object_colliBomb(r_Bird[ID])&&!colliBrick(r_Bird[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Bird[ID].setX(bxx + r_x);
                            r_Bird[ID].setY(byy + r_y - testMove);
                        }
                        if(block==false&&count1<(25/BirdMove)){
                            r_Bird[ID].setX(bxx + r_x);
                            r_Bird[ID].setY(byy + r_y + BirdMove);
                            byy=byy+BirdMove;
                            Bird1[animaID].setX(bxx);
                            Bird1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/BirdMove)){
                            count1=0;
                            change_direction=r.nextInt(10);
                            block=true;
                            if(change_direction==0)
                                direction=-1;

                        }
                        break;}
                    case 2:{
                        if(block)
                        {
                            r_Bird[ID].setX(bxx+r_x-testMove);
                            r_Bird[ID].setY(byy+r_y);
                            if(!colliMetal(r_Bird[ID])&&!Object_colliBomb(r_Bird[ID])&&!colliBrick(r_Bird[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Bird[ID].setX(bxx + r_x+ testMove);
                            r_Bird[ID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/BirdMove)){
                            r_Bird[ID].setX(bxx + r_x - BirdMove);
                            r_Bird[ID].setY(byy + r_y );
                            bxx=bxx-BirdMove;
                            Bird1[animaID].setX(bxx);
                            Bird1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/BirdMove)){
                            count1=0;
                            change_direction=r.nextInt(10);
                            block=true;
                            if(change_direction==0)
                                direction=-1;
                        }
                        break;}
                    case 3:{
                        if(block)
                        {
                            r_Bird[ID].setX(bxx+r_x+testMove);
                            r_Bird[ID].setY(byy+r_y);
                            if(!colliMetal(r_Bird[ID])&&!Object_colliBomb(r_Bird[ID])&&!colliBrick(r_Bird[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Bird[ID].setX(bxx + r_x- testMove);
                            r_Bird[ID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/BirdMove)){
                            r_Bird[ID].setX(bxx + r_x + BirdMove);
                            r_Bird[ID].setY(byy + r_y );
                            bxx=bxx+BirdMove;
                            Bird1[animaID].setX(bxx);
                            Bird1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/BirdMove)){
                            count1=0;
                            change_direction=r.nextInt(10);
                            block=true;
                            if(change_direction==0)
                                direction=-1;
                        }
                        break;}
                }


            }
        };BirdAnima[ID].start();
    }
}
