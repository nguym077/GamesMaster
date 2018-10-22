package Halloween;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class player extends AnimationManger {
    private int playerID = 0;
    private double playerMove = 0.25;
    int setx=0,sety=0;
    player() {
        setx=125;sety=425;
        setPlayer(25, 570);
        for(int i=0;i<Bricks.length;i++)
        {
            int x=(int)Bricks[i].getX();
            int y=(int)Bricks[i].getY();

            if(x==setx)
            {
                if(y==sety-25||y==sety+25)
                    removeImageView(Bricks[i],r_Bricks[i]);
            }
            if(y==sety)
            {
                if(x==setx-25||x==setx+25)
                    removeImageView(Bricks[i],r_Bricks[i]);
            }
            if(x==setx&&y==sety)
                removeImageView(Bricks[i],r_Bricks[i]);
        }

    }

    public void setPlayer(int gx, int gy) {
        if (playerID == 5)
            playerID = 0;


        charX[playerID]=gx;
        charY[playerID]=gy;
        for (int i = 0; i < 3; i++) {

            player_L[playerID * 3 + i].setX(gx);
            player_L[playerID * 3 + i].setY(gy);
            if (i == 0)
                player_L[playerID * 3 + i].setVisible(true);
            else
                player_L[playerID * 3 + i].setVisible(false);
        }

        r_player[playerID].setX(charX[playerID]+5+2.5);
        r_player[playerID].setY(charY[playerID]+5+2.5);
        playerAnima(playerID, gx, gy);
        playerID++;
    }

    public void playerAnima(int ID, int bx, int by) {
        final int newID=ID*3;
        player_checkHit[ID]=0;
        PlayerAnima[ID] = new AnimationTimer() {
            Random r = new Random();

            int count1=0,count2=0;
            int direction=-1,last_direction=-1;
            double bxx=(double)bx,byy=(double)by;
            boolean block=true;
            int testMove=10;
            int change_direction=-1;
            int animaID=newID;
            int Rate=10;
            int speed=5;

            public void handle(long now) {
                // if(direction==-1)
                //count1++;count2++;
                player_L[newID].setX(charX[ID]);
                player_L[newID].setY(charY[ID]);
                player_L[newID+1].setX(charX[ID]);
                player_L[newID+1].setY(charY[ID]);
                player_L[newID+2].setX(charX[ID]);
                player_L[newID+2].setY(charY[ID]);
                if(player_checkHit[ID]==1)
                {
                    removeImageView(player_L[newID],r_player[ID]);
                    removeImageView(player_L[newID+1],r_player[ID]);
                    removeImageView(player_L[newID+2],r_player[ID]);
                    stopAnima(PlayerAnima[ID]);
                    direction=-2;
                    //setBat(125, 125);
                }

                count2++;

                if(count2>=0&&count2<Rate){

                    animaID=newID;

                    player_L[newID].setVisible(true);

                    player_L[newID+1].setVisible(false);

                    player_L[newID+2].setVisible(false);
                }
                if(count2>=Rate&&count2<2*Rate)
                {
                    animaID=newID+1;
                    player_L[newID].setVisible(false);
                    player_L[newID+1].setVisible(true);
                    player_L[newID+2].setVisible(false);
                }
                else if(count2>=2*Rate&&count2<3*Rate){
                    animaID=newID+2;
                    player_L[newID].setVisible(false);
                    player_L[newID+1].setVisible(false);
                    player_L[newID+2].setVisible(true);
                }
                if(count2>=3*Rate)
                    count2=0;
                count1++;
                if(count1>3)
                {
                    count1=0;
                    if(status[ID]==1)
                    {
                        //System.out.println("move up 1");
                        r_player[ID].setX(charX[ID]+5+2.5);
                        r_player[ID].setY(charY[ID]+5+2.5);

                        r_player[ID].setY(charY[ID]+5-5+2.5);
                        if(!colliMetal(r_player[ID])
                                //&&!Object_colliBomb(r_player[ID])
                                &&!colliBrick(r_player[ID])){
                            block=false;
                        }
                        else
                            block=true;
                        //System.out.println("coli");
                        //r_player[ID].setY(charY[ID]+3+2.5);

                        if(block==false) {
                            r_player[ID].setX(charX[ID]+5+2.5);
                            r_player[ID].setY(charY[ID]+5+2.5);
                            charY[ID] = charY[ID] - speed;
                            player_L[animaID].setX(charX[ID]);
                            player_L[animaID].setY(charY[ID]);
                        }

                    }
                    else if(status[ID]==2)
                    {
                        r_player[ID].setX(charX[ID]+5+2.5);
                        r_player[ID].setY(charY[ID]+5+2.5);

                        r_player[ID].setY(charY[ID]+5+10+2.5);
                        if(!colliMetal(r_player[ID])
                                // &&!Object_colliBomb(r_player[ID])
                                &&!colliBrick(r_player[ID])){
                            block=false;
                        }
                        else
                            block=true;
                        //r_player[ID].setY(charY[ID]+10+2.5);

                        if(block==false) {
                            charY[ID] = charY[ID] + speed;
                            r_player[ID].setX(charX[ID]+5+2.5);
                            r_player[ID].setY(charY[ID]+5+2.5);

                            player_L[animaID].setX(charX[ID]);
                            player_L[animaID].setY(charY[ID]);
                        }

                    }
                    else if(status[ID]==3)
                    {
                        r_player[ID].setX(charX[ID]+5+2.5);
                        r_player[ID].setY(charY[ID]+5+2.5);

                        r_player[ID].setX(charX[ID]+5+2.5-5);
                        if(!colliMetal(r_player[ID])
                                //&&!Object_colliBomb(r_player[ID])
                                &&!colliBrick(r_player[ID])){
                            block=false;
                        }
                        else
                            block=true;
                        //r_player[ID].setX(charX[ID]+2.5+3);

                        if(block==false) {
                            charX[ID] = charX[ID] - speed;
                            r_player[ID].setX(charX[ID]+5+2.5);
                            r_player[ID].setY(charY[ID]+5+2.5);

                            player_L[animaID].setX(charX[ID]);
                            player_L[animaID].setY(charY[ID]);
                        }

                    }
                    else if(status[ID]==4)
                    {
                        r_player[ID].setX(charX[ID]+5+2.5);
                        r_player[ID].setY(charY[ID]+5+2.5);

                        r_player[ID].setX(charX[ID]+5+2.5+5);
                        if(!colliMetal(r_player[ID])
                                //&&!Object_colliBomb(r_player[ID])
                                &&!colliBrick(r_player[ID])){
                            block=false;
                        }
                        else
                            block=true;
                        //r_player[ID].setX(charX[ID]+2.5-3);

                        if(block==false) {
                            charX[ID] = charX[ID] + speed;
                            r_player[ID].setX(charX[ID]+5+2.5);
                            r_player[ID].setY(charY[ID]+5+2.5);

                            player_L[animaID].setX(charX[ID]);
                            player_L[animaID].setY(charY[ID]);
                        }

                    }
                    else
                    {
                        r_player[ID].setX(charX[ID]+5+2.5);
                        r_player[ID].setY(charY[ID]+5+2.5);
                    }
                }
            }
        };PlayerAnima[ID].start();
    }
}