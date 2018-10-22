package Halloween;

import Halloween.AnimationManger;
import javafx.animation.AnimationTimer;

import java.util.Random;

/*
public class Enemy_Monster extends AnimationManger {
    private int MonsterD = 0;
    private double MonsterMove=1;
    Enemy_Monster()
    {
        setBat(125, 125);
        setBat(125, 225);
        setBat(125, 325);
        setBat(225, 125);
    }
    public void setBat(int gx, int gy) {
        if (MonsterD == 49)
            MonsterD = 0;
        else
            MonsterD++;
        r_Monster1[MonsterD].setX(gx + r_x);
        r_Monster1[MonsterD].setY(gy + r_y);
        MonsterAnima(MonsterD, gx, gy);
    }
    public void MonsterAnima(int ID, int bx, int by) {
        final int newID=ID*3;
        Bat_checkHit[ID]=0;
        BatAnima[ID] = new AnimationTimer() {
            Random r = new Random();
            // if (frogDown[10].getBoundsInLocal().intersects(playerTank[0].getBoundsInLocal())||
            // frogDown[10].getBoundsInLocal().intersects(playerTank[1].getBoundsInLocal()))
            //  double lastTime2=System.nanoTime();
            int count1=0,count2=0;
            int direction=-1,last_direction=-1;
            double bxx=(double)bx,byy=(double)by;
            boolean block=true;
            int testMove=10;
            int change_direction=-1;
            int animaID=newID;
            int BatFlyRate=10;
            public void handle(long now) {
                // if(direction==-1)
                //count1++;count2++;
                Bat1[newID].setX(bxx);
                Bat1[newID].setY(byy);
                Bat1[newID+1].setX(bxx);
                Bat1[newID+1].setY(byy);
                Bat1[newID+2].setX(bxx);
                Bat1[newID+2].setY(byy);
                if(Bat_checkHit[ID]==1)
                {
                    removeImageView(Bat1[newID],r_Bat[ID]);
                    removeImageView(Bat1[newID+1],r_Bat[ID]);
                    removeImageView(Bat1[newID+2],r_Bat[ID]);
                    stopAnima(ID, BatAnima[ID]);
                    direction=-2;
                    setBat(125, 125);
                }
                if(direction==-1)
                {
                    direction=r.nextInt(4);
                    //direction=0;
                    block=true;
                }
                count2++;
                if(count2>=0&&count2<BatFlyRate){
                    animaID=newID;
                    Bat1[newID].setVisible(true);
                    Bat1[newID+1].setVisible(false);
                    Bat1[newID+2].setVisible(false);
                }
                if(count2>=BatFlyRate&&count2<2*BatFlyRate)
                {
                    animaID=newID+1;
                    Bat1[newID].setVisible(false);
                    Bat1[newID+1].setVisible(true);
                    Bat1[newID+2].setVisible(false);
                }
                else if(count2>=2*BatFlyRate&&count2<3*BatFlyRate){
                    animaID=newID+2;
                    Bat1[newID].setVisible(false);
                    Bat1[newID+1].setVisible(false);
                    Bat1[newID+2].setVisible(true);
                }
                if(count2>=3*BatFlyRate)
                    count2=0;
                switch (direction)
                {
                    case 0:{
                        if(block)
                        {
                            r_Bat[ID].setX(bxx+r_x);
                            r_Bat[ID].setY(byy+r_y-testMove);
                            if(!colliMetal(r_Bat[ID])
                                    &&!Object_colliBomb(r_Bat[ID])
                                    &&!colliBrick(r_Bat[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Bat[ID].setX(bxx + r_x);
                            r_Bat[ID].setY(byy + r_y + testMove);
                        }
                        if(block==false&&count1<(25/MonsterMove)){
                            r_Bat[ID].setX(bxx + r_x);
                            r_Bat[ID].setY(byy + r_y - MonsterMove);
                            byy=byy-MonsterMove;
                            Bat1[animaID].setX(bxx);
                            Bat1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);
                            count1++;
                        }
                        if(count1==(25/MonsterMove)){
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
                            r_Bat[ID].setX(bxx+r_x);
                            r_Bat[ID].setY(byy+r_y+testMove);
                            if(!colliMetal(r_Bat[ID])&&!Object_colliBomb(r_Bat[ID])&&!colliBrick(r_Bat[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Bat[ID].setX(bxx + r_x);
                            r_Bat[ID].setY(byy + r_y - testMove);
                        }
                        if(block==false&&count1<(25/MonsterMove)){
                            r_Bat[ID].setX(bxx + r_x);
                            r_Bat[ID].setY(byy + r_y + MonsterMove);
                            byy=byy+MonsterMove;
                            Bat1[animaID].setX(bxx);
                            Bat1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);
                            count1++;
                        }
                        if(count1==(25/MonsterMove)){
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
                            r_Bat[ID].setX(bxx+r_x-testMove);
                            r_Bat[ID].setY(byy+r_y);
                            if(!colliMetal(r_Bat[ID])&&!Object_colliBomb(r_Bat[ID])&&!colliBrick(r_Bat[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Bat[ID].setX(bxx + r_x+ testMove);
                            r_Bat[ID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/MonsterMove)){
                            r_Bat[ID].setX(bxx + r_x - MonsterMove);
                            r_Bat[ID].setY(byy + r_y );
                            bxx=bxx-MonsterMove;
                            Bat1[animaID].setX(bxx);
                            Bat1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);
                            count1++;
                        }
                        if(count1==(25/MonsterMove)){
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
                            r_Bat[ID].setX(bxx+r_x+testMove);
                            r_Bat[ID].setY(byy+r_y);
                            if(!colliMetal(r_Bat[ID])&&!Object_colliBomb(r_Bat[ID])&&!colliBrick(r_Bat[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Bat[ID].setX(bxx + r_x- testMove);
                            r_Bat[ID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/MonsterMove)){
                            r_Bat[ID].setX(bxx + r_x + MonsterMove);
                            r_Bat[ID].setY(byy + r_y );
                            bxx=bxx+MonsterMove;
                            Bat1[animaID].setX(bxx);
                            Bat1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);
                            count1++;
                        }
                        if(count1==(25/MonsterMove)){
                            count1=0;
                            change_direction=r.nextInt(10);
                            block=true;
                            if(change_direction==0)
                                direction=-1;
                        }
                        break;}
                }
            }
        };MonsterAnima[ID].start();
    }
}
*/