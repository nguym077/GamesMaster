package Halloween;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Player extends AnimationManger {
    private int playerID = 0;
    private double playerMove = 0.25;
    int setx=0,sety=0;
    Player() {

    }
    public void initial( )
    {
        setx=125;sety=425;
        setPlayer(25, (int)sizeY-50);
        setPlayer((int)(sizeX-50), (int)(sizeY-50));
    }
    public void setPlayer(int gx, int gy) {
        if (playerID == 2)
            playerID = 0;


        charX[playerID]=gx;
        charY[playerID]=gy;
        System.out.println("Player id "+playerID+" x y "+charX[playerID]+" "+charY[playerID]);
        for (int i = 0; i < 3; i++) {

            player_L[playerID * 3 + i].setX(gx);
            player_L[playerID * 3 + i].setY(gy);
            if (i == 0)
                player_L[playerID * 3 + i].setVisible(true);
            else
                player_L[playerID * 3 + i].setVisible(false);
        }

        playerAnima(playerID, gx, gy);
        playerID++;
    }

    public void playerAnima(int ID, int bx, int by) {
        final int newID=ID*3;
        player_checkHit[ID]=0;
        PlayerAnima[ID] = new AnimationTimer() {
            Random r = new Random();

            // if (frogDown[10].getBoundsInLocal().intersects(playerTank[0].getBoundsInLocal())||
            // frogDown[10].getBoundsInLocal().intersects(playerTank[1].getBoundsInLocal()))

            //  double lastTime2=System.nanoTime();
            int count1=0,count2=0,noHurtCount=0,countI=0;
            int direction=-1,last_direction=-1;
            double bxx=(double)bx,byy=(double)by;
            boolean block=true,ini=false;
            int testMove=10;
            int change_direction=-1;
            int animaID=newID;
            int Rate=10;
            int speed=player_speed[ID]*2;
            int last_status=0;
            public void handle(long now) {
                if(ini==false)
                countI++;
                if(countI>50&&ini==false)
                {
                    ini=true;
                    r_player[ID].setX(charX[ID]+2.5-25);
                    r_player[ID].setY(charY[ID]+2.5);
                    ColliBrickAndDestroy(r_player[ID]);

                    r_player[ID].setX(charX[ID]+2.5+25);
                    r_player[ID].setY(charY[ID]+2.5);
                    ColliBrickAndDestroy(r_player[ID]);

                    r_player[ID].setX(charX[ID]+2.5);
                    r_player[ID].setY(charY[ID]+2.5+25);
                    ColliBrickAndDestroy(r_player[ID]);

                    r_player[ID].setX(charX[ID]+2.5);
                    r_player[ID].setY(charY[ID]+2.5-25);
                    ColliBrickAndDestroy(r_player[ID]);

                    r_player[ID].setX(charX[ID]+5+2.5);
                    r_player[ID].setY(charY[ID]+2.5);
                    ColliBrickAndDestroy(r_player[ID]);
                }
                // if(direction==-1)
                //count1++;count2++;


                player_L[newID].setX(charX[ID]);
                player_L[newID].setY(charY[ID]);
                player_L[newID+1].setX(charX[ID]);
                player_L[newID+1].setY(charY[ID]);
                player_L[newID+2].setX(charX[ID]);
                player_L[newID+2].setY(charY[ID]);


                count2++;

                if(count2>=0&&count2<Rate){

                    animaID=newID;
                    if(noHurt[ID]%2!=0)
                        player_L[newID].setVisible(false);
                    else
                    player_L[newID].setVisible(true);
                    player_L[newID+1].setVisible(false);
                    player_L[newID+2].setVisible(false);

                }
                if(count2>=Rate&&count2<2*Rate)
                {
                    animaID=newID+1;
                    if(noHurt[ID]%2!=0)
                        player_L[newID+1].setVisible(false);
                    else
                        player_L[newID+1].setVisible(true);
                    player_L[newID].setVisible(false);

                    player_L[newID+2].setVisible(false);
                }
                else if(count2>=2*Rate&&count2<3*Rate){
                    animaID=newID+2;
                    if(noHurt[ID]%2!=0)
                        player_L[newID+2].setVisible(false);
                    else
                        player_L[newID+2].setVisible(true);
                    player_L[newID].setVisible(false);
                    player_L[newID+1].setVisible(false);

                }
                if(throughWall[ID]>=0)
                {
                    throughWall[ID]--;
                    if(throughWall[ID]<0)
                    {

                        ColliBrickAndDestroy(r_player[ID]);

                    }
                }
                colliDropItem(ID,r_player[ID]);
                if(HeroColliEnemy(r_player[ID])&&noHurt[ID]<=0)
                {
                    health[ID]=health[ID]-1;
                    System.out.println("hero id "+ID);
                    noHurt[ID]=100;
                }

                if(noHurt[ID]>0)
                {
                    noHurt[ID]--;
                }

                if(count2>=3*Rate)
                    count2=0;
                count1++;
                    //System.out.println("rect x y "+r_player[ID].getX()+" "+r_player[ID].getY());
                    if(count1>3)
                    {


                        //System.out.println("status "+status[ID]);
                        count1=0;

                        if(status[ID]==1||status[ID]==2)
                        {
                            if(last_status==3||last_status==4||status[ID]==0)
                            {
                                int hx=charX[ID]/100*100,dx=charX[ID]%100,fx=0;
                                if(dx>=10&&dx<35)
                                    fx=hx+20;
                                else if(dx>=35&&dx<55)
                                    fx=hx+45;
                                else if(dx>=55&&dx<85)
                                    fx=hx+75;
                                else if(dx>=85&&dx<100)
                                    fx=hx+95;
                                else
                                    fx=charX[ID];
                                charX[ID]=fx;

                                int h=charY[ID]/100*100,d=charY[ID]%100,f=0;
                                if(d>=10&&d<35)
                                    f=h+20;
                                else if(d>=35&&d<55)
                                    f=h+45;
                                else if(d>=55&&d<85)
                                    f=h+75;
                                else if(d>=85&&d<100)
                                    f=h+95;
                                else
                                    f=charY[ID];
                                charY[ID]=f;
                                player_L[animaID].setX(charX[ID]);
                                player_L[animaID].setY(charY[ID]);
                            }
                        }
                        else if(last_status==3||last_status==4)
                        {
                            if(status[ID]==1||status[ID]==2||status[ID]==0)
                            {
                                int hx=charX[ID]/100*100,dx=charX[ID]%100,fx=0;
                                if(dx>=10&&dx<35)
                                    fx=hx+20;
                                else if(dx>=35&&dx<55)
                                    fx=hx+45;
                                else if(dx>=55&&dx<85)
                                    fx=hx+75;
                                else if(dx>=85&&dx<100)
                                    fx=hx+95;
                                else
                                    fx=charX[ID];
                                charX[ID]=fx;

                                int h=charY[ID]/100*100,d=charY[ID]%100,f=0;
                                if(d>=10&&d<35)
                                    f=h+20;
                                else if(d>=35&&d<55)
                                    f=h+45;
                                else if(d>=55&&d<85)
                                    f=h+75;
                                else if(d>=85&&d<100)
                                    f=h+95;
                                else
                                    f=charY[ID];
                                charY[ID]=f;
                                player_L[animaID].setX(charX[ID]);
                                player_L[animaID].setY(charY[ID]);
                            }
                        }
                        if(status[ID]==0)
                        {
                            last_status=0;

                        }
                        if(status[ID]==1)   //up
                        {
                            last_status=1;
                            //System.out.println("move up 1");
                            r_player[ID].setX(charX[ID]+5+2.5);
                            r_player[ID].setY(charY[ID]+5-5+2.5);
                            if(!colliMetal(r_player[ID])&&!colliBrick(r_player[ID]))
                            {
                             block=false;
                            }
                             //&&!Object_colliBomb(r_player[ID])
                            else
                                block=true;
                                //System.out.println("coli");
                            //r_player[ID].setY(charY[ID]+3+2.5);

                            if(block==false) {
                                //System.out.println("move up x y"+charX[ID]+" "+charY[ID]);

                                charY[ID] = charY[ID] - speed;

                                r_player[ID].setX(charX[ID]+2.5);
                                r_player[ID].setY(charY[ID]+2.5);
                                player_L[animaID].setX(charX[ID]);
                                player_L[animaID].setY(charY[ID]);
                                //System.out.println("move up x y"+charX[ID]+" "+charY[ID]);
                            }

                        }
                        else if(status[ID]==2)  //down
                        {
                            last_status=2;
                            r_player[ID].setX(charX[ID]+5+2.5);
                            r_player[ID].setY(charY[ID]+5+10+2.5);
                            if(!colliMetal(r_player[ID])&&!colliBrick(r_player[ID]))
                            {
                                block=false;
                            }
                            //&&!Object_colliBomb(r_player[ID])
                            else
                                block=true;
                            //r_player[ID].setY(charY[ID]+10+2.5);

                            if(block==false) {
                                //System.out.println("move down x y"+charX[ID]+" "+charY[ID]);

                                charY[ID] = charY[ID] + speed;
                                r_player[ID].setX(charX[ID]+2.5);
                                r_player[ID].setY(charY[ID]+2.5);
                                player_L[animaID].setX(charX[ID]);
                                player_L[animaID].setY(charY[ID]);
                                //System.out.println("move down x y"+charX[ID]+" "+charY[ID]);
                            }

                        }
                        else if(status[ID]==3)
                        {
                            last_status=3;
                            r_player[ID].setX(charX[ID]+5+2.5);
                            r_player[ID].setY(charY[ID]+5+2.5);

                            r_player[ID].setX(charX[ID]+5+2.5-5);
                            if(!colliMetal(r_player[ID])&&!colliBrick(r_player[ID]))
                            {
                                block=false;
                            }
                            //&&!Object_colliBomb(r_player[ID])
                            else
                                block=true;
                            //r_player[ID].setX(charX[ID]+2.5+3);

                            if(block==false) {
                                //System.out.println("move left x y"+charX[ID]+" "+charY[ID]);
                                charX[ID] = charX[ID] - speed;
                                r_player[ID].setX(charX[ID]+2.5);
                                r_player[ID].setY(charY[ID]+2.5);

                                player_L[animaID].setX(charX[ID]);
                                player_L[animaID].setY(charY[ID]);
                                //System.out.println("move left x y"+charX[ID]+" "+charY[ID]);
                            }

                        }
                        else if(status[ID]==4)
                        {
                            last_status=4;
                            r_player[ID].setX(charX[ID]+5+2.5);
                            r_player[ID].setY(charY[ID]+5+2.5);

                            r_player[ID].setX(charX[ID]+5+2.5+5);
                            if(!colliMetal(r_player[ID])&&!colliBrick(r_player[ID]))
                            {
                                block=false;
                            }
                            //&&!Object_colliBomb(r_player[ID])
                            else
                                block=true;
                            //r_player[ID].setX(charX[ID]+2.5-3);

                            if(block==false) {
                                //System.out.println("move right x y"+charX[ID]+" "+charY[ID]);
                                charX[ID] = charX[ID] + speed;
                                r_player[ID].setX(charX[ID]+2.5);
                                r_player[ID].setY(charY[ID]+2.5);
                                player_L[animaID].setX(charX[ID]);
                                player_L[animaID].setY(charY[ID]);
                                //System.out.println("move right x y"+charX[ID]+" "+charY[ID]);
                            }

                        }
                        else
                        {
                            r_player[ID].setX(charX[ID]+2.5);
                            r_player[ID].setY(charY[ID]+2.5);
                        }
                        //System.out.println("count "+count1+" bxx "+bxx+" byy "+byy);


                    }
                    //check death
                if(health[ID]<=0)
                {
                    removeImageView(player_L[newID],r_player[ID]);
                    removeImageView(player_L[newID+1],r_player[ID]);
                    removeImageView(player_L[newID+2],r_player[ID]);
                    stopAnima(ID,PlayerAnima[ID]);

                    bomb_power[ID]=0;
                    player_speed[ID]=0;
                    bomb_numbers[ID]=0;
                    //setBat(125, 125);
                }
                    }

        };PlayerAnima[ID].start();

    }
}