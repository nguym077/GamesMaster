package Halloween;

import javafx.animation.AnimationTimer;

import java.util.Random;

/*
public class Enemy_Bat extends AnimationManger {
    private int BatID = 0;
    private double BatMove=1;
    Enemy_Bat()
    {

    }
    public void initial()
    {
        Random rn=new Random();
        for(int i=0;i<3;i++)
        {
            int n=rn.nextInt(20);
            int r=rn.nextInt(20);
            int x=75+n*50;
            int y=75+r*25;
            if(x<=(sizeX-25)||y<=(75+n*25))
                setBat(x, y);
        }


    }

    public void setBat(int gx, int gy) {
        if (BatID == 49)
            BatID = 0;
        else
            BatID++;

        Bat1[BatID*3].setX(gx);
        Bat1[BatID*3].setY(gy);
        Bat1[BatID*3+1].setX(gx);
        Bat1[BatID*3+1].setY(gy);
        Bat1[BatID*3+1].setVisible(false);
        Bat1[BatID*3+2].setX(gx);
        Bat1[BatID*3+2].setY(gy);
        Bat1[BatID*3+2].setVisible(false);

        r_Bat[BatID].setX(gx + r_x);
        r_Bat[BatID].setY(gy + r_y);

        ColliBrickAndDestroy(r_Bat[BatID]);
        BatAnima(BatID, gx, gy);
    }

    public void BatAnima(int ID, int bx, int by) {
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
                    stopAnima(ID,BatAnima[ID]);
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
                        if(block==false&&count1<(25/BatMove)){
                            r_Bat[ID].setX(bxx + r_x);
                            r_Bat[ID].setY(byy + r_y - BatMove);
                            byy=byy-BatMove;
                            Bat1[animaID].setX(bxx);
                            Bat1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/BatMove)){
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
                        if(block==false&&count1<(25/BatMove)){
                            r_Bat[ID].setX(bxx + r_x);
                            r_Bat[ID].setY(byy + r_y + BatMove);
                            byy=byy+BatMove;
                            Bat1[animaID].setX(bxx);
                            Bat1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/BatMove)){
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
                        if(block==false&&count1<(25/BatMove)){
                            r_Bat[ID].setX(bxx + r_x - BatMove);
                            r_Bat[ID].setY(byy + r_y );
                            bxx=bxx-BatMove;
                            Bat1[animaID].setX(bxx);
                            Bat1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/BatMove)){
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
                        if(block==false&&count1<(25/BatMove)){
                            r_Bat[ID].setX(bxx + r_x + BatMove);
                            r_Bat[ID].setY(byy + r_y );
                            bxx=bxx+BatMove;
                            Bat1[animaID].setX(bxx);
                            Bat1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/BatMove)){
                            count1=0;
                            change_direction=r.nextInt(10);
                            block=true;
                            if(change_direction==0)
                                direction=-1;
                        }
                        break;}
                }


            }
        };BatAnima[ID].start();

    }
}

*/