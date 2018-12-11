package Halloween;

import javafx.animation.AnimationTimer;

import java.util.Random;

public class Data extends AnimationManger  {
	
    public void setUp() //x50,y50
    {

    	//0-4 player1,5-9 player2
        for(int i=0;i<5;i++)
        {
            icon_health[i].setX(10+25+5*i+25*i);
            icon_health[i].setY(1);
        }

        for(int i=0;i<5;i++)
        {
            icon_power[i].setX(10+25+5*5+25*5+5*i+25*i);
            icon_power[i].setY(1);
        }
        for(int i=0;i<5;i++)
        {
            icon_bomb[i].setX(10+25+5*i+25*i);
            icon_bomb[i].setY(25);
        }
        for(int i=0;i<5;i++)
        {
            icon_speed[i].setX(10+25+5*5+25*5+5*i+25*i);
            icon_speed[i].setY(25);
        }
        int in=0;
        for(int i=0;i<5;i++)
        {
        	for(int j=0;j<10;j++)
        	{
        		in=i*10+j;
        		icon_numbers[in].setVisible(false);
        		icon_numbers[in].setX(10+25+5*5+25*5+5*5+25*5+25+15*i);
                icon_numbers[in].setY(1);
        	}
            
            
        }
        score[0]=0;
        icon_1st[0].setX(5);
        icon_1st[0].setY(1);

        double p2X=sizeX/2;
        
        //for Player 2
        int index=0;
        for(int i=0;i<5;i++)
        {
            index=5+i;
            icon_health[index].setX(p2X+10+25+5*i+25*i);
            icon_health[index].setY(1);
        }
        for(int i=0;i<5;i++)
        {
            index=5+i;
            icon_power[index].setX(p2X+10+25+5*5+25*5+5*i+25*i);
            icon_power[index].setY(1);
        }
        for(int i=0;i<5;i++)
        {
            index=5+i;
            icon_bomb[index].setX(p2X+10+25+5*i+25*i);
            icon_bomb[index].setY(25);
        }
        for(int i=0;i<5;i++)
        {
            index=5+i;
            icon_speed[index].setX(p2X+10+25+5*5+25*5+5*i+25*i);
            icon_speed[index].setY(25);
        }
        
        for(int i=0;i<5;i++)
        {
        	
        	for(int j=0;j<10;j++)
        	{
        		in=i*10+50+j;
        		icon_numbers[in].setVisible(false);
        		icon_numbers[in].setX(p2X+10+25+5*5+25*5+5*5+25*5+25+15*i);
                icon_numbers[in].setY(1);
        	}
        }
        score[1]=0;
        icon_2nd[0].setX(p2X);
        icon_2nd[0].setY(1);
        
        AnimationTimer dataTimer = new AnimationTimer() {
            int count=0,count2=0;
            int trytime=10;
            int lastDropBome=10,lastDropPower=10,lastDropHealth=10,lastDropSpeed=10;
            int newX=0,newY=0;
            Random drop=new Random();
            
            boolean dropDone=false;
            int newItem=0;
            public void handle(long now) {
                count++;
                count2++;
                //test
                setNumbers(score[0], 0);
                setNumbers(score[1], 1);
                if(count2>50)
                {
                	//score[0]=score[0]+6;
                	//score[1]=score[1]+7;
                    count2=0;
                    for(int i=0;i<10;i++)
                    {
                        icon_health[i].setVisible(false);
                        icon_power[i].setVisible(false);
                        icon_bomb[i].setVisible(false);
                        icon_speed[i].setVisible(false);
                        // removeImageView(icon_health[i],r_icon_health[i]);
                    }
                    //0-4 player1,5-9 player2
                    for(int i=0;i<health[0];i++)
                    {
                        icon_health[i].setVisible(true);
                      
                    }

                    for(int i=0;i<bomb_power[0];i++)
                    {
                        icon_power[i].setVisible(true);
                       
                    }
                    for(int i=0;i<bomb_numbers[0];i++)
                    {
                        icon_bomb[i].setVisible(true);
                    }
                    for(int i=0;i<(player_speed[0]-2);i++)
                    {
                        icon_speed[i].setVisible(true);
                    }
                    //for Player 2
                    int index=0;
                    for(int i=0;i<health[1];i++)
                    {
                        index=5+i;
                        icon_health[index].setVisible(true);
                       
                    }
                    for(int i=0;i<bomb_power[1];i++)
                    {
                        index=5+i;
                        icon_power[index].setVisible(true);
                     
                    }
                    for(int i=0;i<bomb_numbers[1];i++)
                    {
                        index=5+i;
                        icon_bomb[index].setVisible(true);
                     
                    }
                    for(int i=0;i<(player_speed[1]-2);i++)
                    {
                        index=5+i;
                        icon_speed[index].setVisible(true);
                      
                    }
                }

                if(count>0)
                {
                    count=1;
                    
                    /*
                    boolean check=false;
                    while(check==false) {
                    newX=drop.nextInt((int)sizeX-50)/25;
                    newY=drop.nextInt((int)sizeY-50)/25;
                    if(newX%2==0&&newY%2==0)
                    	check=true;
                    }
                    System.out.println("x "+newX+" y "+newY);
                    */
                    
                    if(dropItem[0]&&dropDone==false)
                    {
                    	dropDone=true;
                    	dropItem[0]=true;
                    	newItem=drop.nextInt(6)+1;
                    	
                    	newX=dropX[0];
                    	newY=dropY[0];
                    	System.out.println("new item "+newItem+" x y "+newX+" "+newY);
                    }
                    if(dropItem[0]==false&&dropDone)
                    {
                    	dropDone=false;
                    }
                    
                    if(newItem==1)
                    {
                    	trytime=10;
                        boolean set=false;
                        
                            r_icon_health[lastDropHealth].setX(newX*25+25+2.5);
                            r_icon_health[lastDropHealth].setY(newY*25+25+2.5);
                           
                        
                        icon_health[lastDropHealth].setX(newX*25+25);
                        icon_health[lastDropHealth].setY(newY*25+25);
                        newItem=0;
                    }
                    else if(newItem==2)
                    {
                        boolean set=false;
                        
                            r_icon_bomb[lastDropBome].setX(newX*25+25+2.5);
                            r_icon_bomb[lastDropBome].setY(newY*25+25+2.5);
                          
                        
                        icon_bomb[lastDropBome].setX(newX*25+25);
                        icon_bomb[lastDropBome].setY(newY*25+25);
                        newItem=0;
                    }
                    else if(newItem==3)
                    {
                        boolean set=false;
                       
                            r_icon_power[lastDropPower].setX(newX*25+25+2.5);
                            r_icon_power[lastDropPower].setY(newY*25+25+2.5);
                           
                        icon_power[lastDropPower].setX(newX*25+25);
                        icon_power[lastDropPower].setY(newY*25+25);
                        newItem=0;
                    }
                    else if(newItem==4)
                    {
                        boolean set=false;
                        
                            r_icon_speed[lastDropSpeed].setX(newX*25+25+2.5);
                            r_icon_speed[lastDropSpeed].setY(newY*25+25+2.5);
                           
                        icon_speed[lastDropSpeed].setX(newX*25+25);
                        icon_speed[lastDropSpeed].setY(newY*25+25);
                        newItem=0;
                    }
                    else if(newItem==5)
                    {
                        boolean set=false;
                       
                            r_icon_noHurt[lastDropSpeed].setX(newX*25+25+2.5);
                            r_icon_noHurt[lastDropSpeed].setY(newY*25+25+2.5);
                           
                        icon_noHurt[lastDropSpeed].setX(newX*25+25);
                        icon_noHurt[lastDropSpeed].setY(newY*25+25);
                        newItem=0;
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
                        r_icon_addLife[lastDropSpeed].setX(newX*25+25+2.5);
                        r_icon_addLife[lastDropSpeed].setY(newY*25+25+2.5);
                           
                        icon_addLife[lastDropSpeed].setX(newX*25+25);
                        icon_addLife[lastDropSpeed].setY(newY*25+25);
                        newItem=0;
                    }
                    else if(newItem==7)
                    {
                    	
                    	 r_icon_throughWall[lastDropSpeed].setX(newX*25+25+2.5);
                         r_icon_throughWall[lastDropSpeed].setY(newY*25+25+2.5);
                         addBrick(r_icon_throughWall[lastDropSpeed]);
                        
                        newItem=0;
                    }
                }
            }

        };dataTimer.start();

    }

public void setNumbers(int num,int player)
{
	int d=num%10-1,d10=num%100/10-1,d100=num%1000/100-1,d1000=num%10000/1000-1,d10000=num%100000/10000-1;
	if(d==-1)d=9;if(d10==-1)d10=9;if(d100==-1)d100=9;if(d1000==-1)d1000=9;if(d10000==-1)d10000=9;
	int in=0;
	if(player==0)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<10;j++)
			{
				in=i*10+j;
				icon_numbers[in].setVisible(false);
			}
			
		}
		in=40+d;
	    icon_numbers[in].setVisible(true);
	    in=30+d10;
	    icon_numbers[in].setVisible(true);
	    in=20+d100;
	    icon_numbers[in].setVisible(true);
	    in=10+d1000;
	    icon_numbers[in].setVisible(true);
	    in=d10000;
	    icon_numbers[in].setVisible(true);
	}
	
	if(player==1)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<10;j++)
			{
				in=i*10+j+50;
				icon_numbers[in].setVisible(false);
			}
			
		}
		in=90+d;
	    icon_numbers[in].setVisible(true);
	    in=80+d10;
	    icon_numbers[in].setVisible(true);
	    in=70+d100;
	    icon_numbers[in].setVisible(true);
	    in=60+d1000;
	    icon_numbers[in].setVisible(true);
	    in=50+d10000;
	    icon_numbers[in].setVisible(true);
	}
	
	
}

}
