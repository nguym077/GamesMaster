package Halloween;

import javafx.animation.AnimationTimer;

import java.util.Random;

public class Data extends AnimationManger  {
    public void setUp() //x50,y50
    {

        icon_1st[0].setX(5);
        icon_1st[0].setY(1);

        double p2X=sizeX/2;
        icon_2nd[0].setX(p2X);
        icon_2nd[0].setY(1);
        AnimationTimer dataTimer = new AnimationTimer() {
            int count=0,count2=0;
            int lastDropBome=10,lastDropPower=10,lastDropHealth=10,lastDropSpeed=10;
            public void handle(long now) {
                count++;
                count2++;
                //test

                if(count2>50)
                {
                    count2=0;
                    for(int i=0;i<10;i++)
                    {
                        removeImageViewOnly(icon_health[i]);
                        removeImageViewOnly(icon_power[i]);
                        removeImageViewOnly(icon_bomb[i]);
                        removeImageViewOnly(icon_speed[i]);
                        // removeImageView(icon_health[i],r_icon_health[i]);
                    }
                    //0-4 player1,5-9 player2
                    for(int i=0;i<health[0];i++)
                    {
                        icon_health[i].setX(10+25+5*i+25*i);
                        icon_health[i].setY(1);
                    }

                    for(int i=0;i<bomb_power[0];i++)
                    {
                        icon_power[i].setX(10+25+5*5+25*5+5*i+25*i);
                        icon_power[i].setY(1);
                    }
                    for(int i=0;i<bomb_numbers[0];i++)
                    {
                        icon_bomb[i].setX(10+25+5*i+25*i);
                        icon_bomb[i].setY(25);
                    }
                    for(int i=0;i<(player_speed[0]-2);i++)
                    {
                        icon_speed[i].setX(10+25+5*5+25*5+5*i+25*i);
                        icon_speed[i].setY(25);
                    }
                    //for Player 2
                    int index=0;
                    for(int i=0;i<health[1];i++)
                    {
                        index=5+i;
                        icon_health[index].setX(p2X+10+25+5*i+25*i);
                        icon_health[index].setY(1);
                    }
                    for(int i=0;i<bomb_power[1];i++)
                    {
                        index=5+i;
                        icon_power[index].setX(p2X+10+25+5*5+25*5+5*i+25*i);
                        icon_power[index].setY(1);
                    }
                    for(int i=0;i<bomb_numbers[1];i++)
                    {
                        index=5+i;
                        icon_bomb[index].setX(p2X+10+25+5*i+25*i);
                        icon_bomb[index].setY(25);
                    }
                    for(int i=0;i<(player_speed[1]-2);i++)
                    {
                        index=5+i;
                        icon_speed[index].setX(p2X+10+25+5*5+25*5+5*i+25*i);
                        icon_speed[index].setY(25);
                    }
                }

                if(count>500)
                {
                    count=0;
                    int newX=0,newY=0;
                    Random drop=new Random();
                    int newItem=drop.nextInt(7);
                    newX=drop.nextInt(((int)sizeX)/25-1);
                    newY=drop.nextInt(((int)sizeY)/25-1);

                    if(newItem==1)
                    {
                        boolean set=false;
                        while(set==false)
                        {
                            r_icon_health[lastDropHealth].setX(newX*25+25);
                            r_icon_health[lastDropHealth].setY(newY*25+25);
                            if(colliMetal(r_icon_health[lastDropHealth]))
                            {

                                newX=drop.nextInt(((int)(sizeX)/25));
                                newY=drop.nextInt(((int)(sizeY)/25));
                            }
                            else
                            {
                                set=true;
                            }
                        }
                        icon_health[lastDropHealth].setX(newX*25+25);
                        icon_health[lastDropHealth].setY(newY*25+25);
                    }
                    else if(newItem==2)
                    {
                        boolean set=false;
                        while(set==false)
                        {
                            r_icon_bomb[lastDropBome].setX(newX*25+25);
                            r_icon_bomb[lastDropBome].setY(newY*25+25);
                            if(colliMetal(r_icon_bomb[lastDropBome]))
                            {

                                newX=drop.nextInt(((int)(sizeX)/25));
                                newY=drop.nextInt(((int)(sizeY)/25));
                            }
                            else
                            {
                                set=true;
                            }
                        }
                        icon_bomb[lastDropBome].setX(newX*25+25);
                        icon_bomb[lastDropBome].setY(newY*25+25);
                    }
                    else if(newItem==3)
                    {
                        boolean set=false;
                        while(set==false)
                        {
                            r_icon_power[lastDropPower].setX(newX*25+25);
                            r_icon_power[lastDropPower].setY(newY*25+25);
                            if(colliMetal(r_icon_power[lastDropPower]))
                            {

                                newX=drop.nextInt(((int)(sizeX)/25));
                                newY=drop.nextInt(((int)(sizeY)/25));
                            }
                            else
                            {
                                set=true;
                            }
                        }
                        icon_power[lastDropPower].setX(newX*25+25);
                        icon_power[lastDropPower].setY(newY*25+25);
                    }
                    else if(newItem==4)
                    {
                        boolean set=false;
                        while(set==false)
                        {
                            r_icon_speed[lastDropSpeed].setX(newX*25+25);
                            r_icon_speed[lastDropSpeed].setY(newY*25+25);
                            if(colliMetal(r_icon_speed[lastDropSpeed]))
                            {

                                newX=drop.nextInt(((int)(sizeX)/25));
                                newY=drop.nextInt(((int)(sizeY)/25));
                            }
                            else
                            {
                                set=true;
                            }
                        }
                        icon_speed[lastDropSpeed].setX(newX*25+25);
                        icon_speed[lastDropSpeed].setY(newY*25+25);
                    }
                    else if(newItem==5)
                    {
                        boolean set=false;
                        while(set==false)
                        {
                            r_icon_noHurt[lastDropSpeed].setX(newX*25+25);
                            r_icon_noHurt[lastDropSpeed].setY(newY*25+25);
                            if(colliMetal(r_icon_speed[lastDropSpeed]))
                            {

                                newX=drop.nextInt(((int)(sizeX)/25));
                                newY=drop.nextInt(((int)(sizeY)/25));
                            }
                            else
                            {
                                set=true;
                            }
                        }
                        icon_noHurt[lastDropSpeed].setX(newX*25+25);
                        icon_noHurt[lastDropSpeed].setY(newY*25+25);
                    }
                    /*
                    else if(newItem==6)
                    {
                        boolean set=false;
                        while(set==false)
                        {
                            r_icon_throughWall[lastDropSpeed].setX(newX*25+25);
                            r_icon_throughWall[lastDropSpeed].setY(newY*25+25);
                            if(colliMetal(r_icon_speed[lastDropSpeed]))
                            {
                                newX=drop.nextInt(((int)sizeX)/25);
                                newY=drop.nextInt(((int)sizeY)/25);
                            }
                            else
                            {
                                set=true;
                            }
                        }
                        r_icon_throughWall[lastDropSpeed].setX(newX*25+25);
                        r_icon_throughWall[lastDropSpeed].setY(newY*25+25);
                    }
                    */
                    else if(newItem==6)
                    {
                        boolean set=false;
                        while(set==false)
                        {
                            r_icon_addLife[lastDropSpeed].setX(newX*25+25);
                            r_icon_addLife[lastDropSpeed].setY(newY*25+25);
                            if(colliMetal(r_icon_speed[lastDropSpeed]))
                            {

                                newX=drop.nextInt(((int)(sizeX)/25));
                                newY=drop.nextInt(((int)(sizeY)/25));
                            }
                            else
                            {
                                set=true;
                            }
                        }
                        r_icon_addLife[lastDropSpeed].setX(newX*25+25);
                        r_icon_addLife[lastDropSpeed].setY(newY*25+25);
                    }
                }
            }

        };dataTimer.start();

    }



}