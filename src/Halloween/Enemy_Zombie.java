package Halloween;

import javafx.animation.AnimationTimer;

import java.util.Random;

public class Enemy_Zombie extends AnimationManger {
    private int ZombieID = 0;
    private double ZombieMove=0.5;

    Enemy_Zombie()
    {

    }
    public void initial()
    {
        Random rn=new Random();
        for(int i=0;i<10;i++)
        {
            int n=rn.nextInt(20);
            int r=rn.nextInt(20);
            int x=75+n*50;
            int y=75+r*25;
            if(x<=(sizeX-25)||y<=(75+n*25))
            setZombie(x, y);
        }
    }
    public void setZombie(int gx, int gy) {
        if (ZombieID == 49)
            ZombieID = 0;
        else
            ZombieID++;

        Zombie1[ZombieID*4].setX(gx);
        Zombie1[ZombieID*4].setY(gy);
        Zombie1[ZombieID*4+1].setX(gx);
        Zombie1[ZombieID*4+1].setY(gy);
        Zombie1[ZombieID*4+1].setVisible(false);
        Zombie1[ZombieID*4+2].setX(gx);
        Zombie1[ZombieID*4+2].setY(gy);
        Zombie1[ZombieID*4+2].setVisible(false);
        Zombie1[ZombieID*4+3].setX(gx);
        Zombie1[ZombieID*4+3].setY(gy);
        Zombie1[ZombieID*4+3].setVisible(false);

        r_Zombie[ZombieID].setX(gx + r_x);
        r_Zombie[ZombieID].setY(gy + r_y);
        ColliBrickAndDestroy(r_Zombie[ZombieID]);
        ZombieAnima(ZombieID, gx, gy);
    }

    public void ZombieAnima(int ID, int bx, int by) {
        final int newID=ID*4;
        Zombie_checkHit[ID]=0;
        ZombieAnima[ID] = new AnimationTimer() {
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
            int ZombieMoveRate=10;
            public void handle(long now) {
                // if(direction==-1)
                //count1++;count2++;
                Zombie1[newID].setX(bxx);
                Zombie1[newID].setY(byy);
                Zombie1[newID+1].setX(bxx);
                Zombie1[newID+1].setY(byy);
                Zombie1[newID+2].setX(bxx);
                Zombie1[newID+2].setY(byy);
                Zombie1[newID+3].setX(bxx);
                Zombie1[newID+3].setY(byy);

                if(Zombie_checkHit[ID]==1)
                {
                    removeImageView(Zombie1[newID],r_Zombie[ID]);
                    removeImageView(Zombie1[newID+1],r_Zombie[ID]);
                    removeImageView(Zombie1[newID+2],r_Zombie[ID]);
                    removeImageView(Zombie1[newID+3],r_Zombie[ID]);
                    stopAnima(ID,ZombieAnima[ID]);
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

                if(count2>=0&&count2<ZombieMoveRate){

                    animaID=newID;

                    Zombie1[newID].setVisible(true);
                    Zombie1[newID+1].setVisible(false);
                    Zombie1[newID+2].setVisible(false);
                    Zombie1[newID+3].setVisible(false);
                }
                else if(count2>=ZombieMoveRate&&count2<2*ZombieMoveRate)
                {
                    animaID=newID+1;
                    Zombie1[newID].setVisible(false);
                    Zombie1[newID+1].setVisible(true);
                    Zombie1[newID+2].setVisible(false);
                    Zombie1[newID+3].setVisible(false);
                }
                else if(count2>=2*ZombieMoveRate&&count2<3*ZombieMoveRate){
                    animaID=newID+2;
                    Zombie1[newID].setVisible(false);
                    Zombie1[newID+1].setVisible(false);
                    Zombie1[newID+2].setVisible(true);
                    Zombie1[newID+3].setVisible(false);
                }
                else if(count2>=3*ZombieMoveRate&&count2<4*ZombieMoveRate){
                    animaID=newID+3;
                    Zombie1[newID].setVisible(false);
                    Zombie1[newID+1].setVisible(false);
                    Zombie1[newID+2].setVisible(false);
                    Zombie1[newID+3].setVisible(true);
                }
                if(count2>=4*ZombieMoveRate)
                    count2=0;



                switch (direction)
                {
                    case 0:{
                        if(block)
                        {
                            r_Zombie[ID].setX(bxx+r_x);
                            r_Zombie[ID].setY(byy+r_y-testMove);
                            if(!colliMetal(r_Zombie[ID])
                                    &&!Object_colliBomb(r_Zombie[ID])
                                    &&!colliBrick(r_Zombie[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Zombie[ID].setX(bxx + r_x);
                            r_Zombie[ID].setY(byy + r_y + testMove);
                        }
                        if(block==false&&count1<(25/ZombieMove)){
                            r_Zombie[ID].setX(bxx + r_x);
                            r_Zombie[ID].setY(byy + r_y - ZombieMove);
                            byy=byy-ZombieMove;
                            Zombie1[animaID].setX(bxx);
                            Zombie1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/ZombieMove)){
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
                            r_Zombie[ID].setX(bxx+r_x);
                            r_Zombie[ID].setY(byy+r_y+testMove);
                            if(!colliMetal(r_Zombie[ID])&&!Object_colliBomb(r_Zombie[ID])&&!colliBrick(r_Zombie[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Zombie[ID].setX(bxx + r_x);
                            r_Zombie[ID].setY(byy + r_y - testMove);
                        }
                        if(block==false&&count1<(25/ZombieMove)){
                            r_Zombie[ID].setX(bxx + r_x);
                            r_Zombie[ID].setY(byy + r_y + ZombieMove);
                            byy=byy+ZombieMove;
                            Zombie1[animaID].setX(bxx);
                            Zombie1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/ZombieMove)){
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
                            r_Zombie[ID].setX(bxx+r_x-testMove);
                            r_Zombie[ID].setY(byy+r_y);
                            if(!colliMetal(r_Zombie[ID])&&!Object_colliBomb(r_Zombie[ID])&&!colliBrick(r_Zombie[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Zombie[ID].setX(bxx + r_x+ testMove);
                            r_Zombie[ID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/ZombieMove)){
                            r_Zombie[ID].setX(bxx + r_x - ZombieMove);
                            r_Zombie[ID].setY(byy + r_y );
                            bxx=bxx-ZombieMove;
                            Zombie1[animaID].setX(bxx);
                            Zombie1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/ZombieMove)){
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
                            r_Zombie[ID].setX(bxx+r_x+testMove);
                            r_Zombie[ID].setY(byy+r_y);
                            if(!colliMetal(r_Zombie[ID])&&!Object_colliBomb(r_Zombie[ID])&&!colliBrick(r_Zombie[ID])){
                                block=false;
                            }
                            else {
                                block=true;
                                direction=-1;
                            }
                            r_Zombie[ID].setX(bxx + r_x- testMove);
                            r_Zombie[ID].setY(byy + r_y );
                        }
                        if(block==false&&count1<(25/ZombieMove)){
                            r_Zombie[ID].setX(bxx + r_x + ZombieMove);
                            r_Zombie[ID].setY(byy + r_y );
                            bxx=bxx+ZombieMove;
                            Zombie1[animaID].setX(bxx);
                            Zombie1[animaID].setY(byy);
                            //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);

                            count1++;
                        }
                        if(count1==(25/ZombieMove)){
                            count1=0;
                            change_direction=r.nextInt(10);
                            block=true;
                            if(change_direction==0)
                                direction=-1;
                        }
                        break;}
                }


            }
        };ZombieAnima[ID].start();

    }
}
