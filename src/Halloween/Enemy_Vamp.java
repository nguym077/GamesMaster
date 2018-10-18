package Halloween;

import javafx.animation.AnimationTimer;

import java.util.Random;

/*
public class Enemy_Vamp extends AnimationManger {
    private int VampID = 0;
    private double VampMove=0.5;

    Enemy_Vamp()
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
                setVamp(x, y);
        }


    }

    public void setVamp(int gx, int gy) {
        if (VampID == 49)
            VampID = 0;
        else
            VampID++;

        Vamp1[VampID*4].setX(gx);
        Vamp1[VampID*4].setY(gy);
        Vamp1[VampID*4+1].setX(gx);
        Vamp1[VampID*4+1].setY(gy);
        Vamp1[VampID*4+1].setVisible(false);
        Vamp1[VampID*4+2].setX(gx);
        Vamp1[VampID*4+2].setY(gy);
        Vamp1[VampID*4+2].setVisible(false);
        Vamp1[VampID*4+3].setX(gx);
        Vamp1[VampID*4+3].setY(gy);
        Vamp1[VampID*4+3].setVisible(false);

        r_Vamp[VampID].setX(gx + r_x);
        r_Vamp[VampID].setY(gy + r_y);
        ColliBrickAndDestroy(r_Vamp[VampID]);
        VampAnima(VampID, gx, gy);
    }

    public void VampAnima(int ID, int bx, int by) {
        final int newID=ID*4;
        Vamp_checkHit[ID]=0;
        VampAnima[ID] = new AnimationTimer() {
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
            int VampMoveRate=10;
            public void handle(long now) {
                // if(direction==-1)
                //count1++;count2++;
                Vamp1[newID].setX(bxx);
                Vamp1[newID].setY(byy);
                Vamp1[newID+1].setX(bxx);
                Vamp1[newID+1].setY(byy);
                Vamp1[newID+2].setX(bxx);
                Vamp1[newID+2].setY(byy);
                Vamp1[newID+3].setX(bxx);
                Vamp1[newID+3].setY(byy);

                if(Vamp_checkHit[ID]==1)
                {
                    removeImageView(Vamp1[newID],r_Vamp[ID]);
                    removeImageView(Vamp1[newID+1],r_Vamp[ID]);
                    removeImageView(Vamp1[newID+2],r_Vamp[ID]);
                    removeImageView(Vamp1[newID+3],r_Vamp[ID]);
                    stopAnima(ID,VampAnima[ID]);
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

                if(count2>=0&&count2<VampMoveRate){

                    animaID=newID;

                    Vamp1[newID].setVisible(true);
                    Vamp1[newID+1].setVisible(false);
                    Vamp1[newID+2].setVisible(false);
                    Vamp1[newID+3].setVisible(false);
                }
                else if(count2>=VampMoveRate&&count2<2*VampMoveRate)
                {
                    animaID=newID+1;
                    Vamp1[newID].setVisible(false);
                    Vamp1[newID+1].setVisible(true);
                    Vamp1[newID+2].setVisible(false);
                    Vamp1[newID+3].setVisible(false);
                }
                else if(count2>=2*VampMoveRate&&count2<3*VampMoveRate){
                    animaID=newID+2;
                    Vamp1[newID].setVisible(false);
                    Vamp1[newID+1].setVisible(false);
                    Vamp1[newID+2].setVisible(true);
                    Vamp1[newID+3].setVisible(false);
                }
                else if(count2>=3*VampMoveRate&&count2<4*VampMoveRate){
                    animaID=newID+3;
                    Vamp1[newID].setVisible(false);
                    Vamp1[newID+1].setVisible(false);
                    Vamp1[newID+2].setVisible(false);
                    Vamp1[newID+3].setVisible(true);
                }
                if(count2>=4*VampMoveRate)
                    count2=0;



                switch (direction)
                {
                    case 0:{
                        if(block)
                        {
                            r_Vamp[ID].setX(bxx+r_x);
                            r_Vamp[ID].setY(byy+r_y-testMove);
                            if(!colliMetal(r_Vamp[ID])
                                    &&!Object_colliBomb(r_Vamp[ID])
                                    &&!colliBrick(r_Vamp[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Vamp[ID].setX(bxx + r_x);
                            r_Vamp[ID].setY(byy + r_y + testMove);
                        }
                        if(block==false&&count1<(25/VampMove)){
                            r_Vamp[ID].setX(bxx + r_x);
                            r_Vamp[ID].setY(byy + r_y - VampMove);
                            byy=byy-VampMove;
                            Vamp1[animaID].setX(bxx);
                            Vamp1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/VampMove)){
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
                            r_Vamp[ID].setX(bxx+r_x);
                            r_Vamp[ID].setY(byy+r_y+testMove);
                            if(!colliMetal(r_Vamp[ID])&&!Object_colliBomb(r_Vamp[ID])&&!colliBrick(r_Vamp[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Vamp[ID].setX(bxx + r_x);
                            r_Vamp[ID].setY(byy + r_y - testMove);
                        }
                        if(block==false&&count1<(25/VampMove)){
                            r_Vamp[ID].setX(bxx + r_x);
                            r_Vamp[ID].setY(byy + r_y + VampMove);
                            byy=byy+VampMove;
                            Vamp1[animaID].setX(bxx);
                            Vamp1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/VampMove)){
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
                            r_Vamp[ID].setX(bxx+r_x-testMove);
                            r_Vamp[ID].setY(byy+r_y);
                            if(!colliMetal(r_Vamp[ID])&&!Object_colliBomb(r_Vamp[ID])&&!colliBrick(r_Vamp[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Vamp[ID].setX(bxx + r_x+ testMove);
                            r_Vamp[ID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/VampMove)){
                            r_Vamp[ID].setX(bxx + r_x - VampMove);
                            r_Vamp[ID].setY(byy + r_y );
                            bxx=bxx-VampMove;
                            Vamp1[animaID].setX(bxx);
                            Vamp1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/VampMove)){
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
                            r_Vamp[ID].setX(bxx+r_x+testMove);
                            r_Vamp[ID].setY(byy+r_y);
                            if(!colliMetal(r_Vamp[ID])&&!Object_colliBomb(r_Vamp[ID])&&!colliBrick(r_Vamp[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Vamp[ID].setX(bxx + r_x- testMove);
                            r_Vamp[ID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/VampMove)){
                            r_Vamp[ID].setX(bxx + r_x + VampMove);
                            r_Vamp[ID].setY(byy + r_y );
                            bxx=bxx+VampMove;
                            Vamp1[animaID].setX(bxx);
                            Vamp1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/VampMove)){
                            count1=0;
                            change_direction=r.nextInt(10);
                            block=true;
                            if(change_direction==0)
                                direction=-1;
                        }
                        break;}
                }


            }
        };VampAnima[ID].start();

    }
}

*/