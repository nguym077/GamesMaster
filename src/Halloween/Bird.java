package Halloween;


import javafx.animation.AnimationTimer;
import java.util.Random;

public class Bird extends AnimationManger {
    private Random r = new Random();

    private int birdID = 0;
    private double birdMove = 0.5;
    private boolean droppedCandy = false;
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
        //candyLoc_x = r.nextInt(1000) + 50;
        //candyLoc_y = r.nextInt(500) + 50;

        // makes sure the candy drop isn't at a metal block location
        boolean check=false;
        while(check==false) {
        	candyLoc_x=r.nextInt((int)sizeX-50)/25;
        	
        	candyLoc_y=r.nextInt((int)sizeY-50)/25;
        	
        if(candyLoc_x%2==0&&candyLoc_y%2==0)
        	check=true;
	        dropX[0]=candyLoc_x;
	    	dropY[0]=candyLoc_y;
            candyLoc_x=candyLoc_x*25+25;
            candyLoc_y=candyLoc_y*25+25;
        	
        }
        System.out.println("candy location: " + candyLoc_x + ", " + candyLoc_y);

        BirdAnima(birdID, gx, gy);
    }

    private void BirdAnima(int ID, int bx, int by) {
        final int newID = ID*4;
        Bird_checkHit[ID] = 0;

        BirdAnima[ID] = new AnimationTimer() {
            int count1 = 0;
            int count2 = 0;
            int count3=0;
            int holdCount=0;
            int animaID = newID;

            int direction = -1;
            int lastDirection = -1;
            int changeDirection = -1;

            double bxx = (double) bx;
            double byy = (double) by;

            int birdMoveRate = 20;

            int dir=0;
            boolean createBricks=false;
            public void handle(long now) {
            	bxx=Bird1[animaID].getX();
                byy=Bird1[animaID].getY();
                
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
                
                /*
                bxx=Bird1[animaID].getX();
                byy=Bird1[animaID].getY();
                if(Bird1[animaID].getX()>=(sizeX-50))  
                {
                	dir=2; //go left
                }
                else if(Bird1[animaID].getY()>=(sizeY-50))
                {
                	dir=0; //go up
                }
                else if(Bird1[animaID].getX()<=(50))
                {
                	dir=3; //go right
                }
                else if(Bird1[animaID].getY()<=(50))
                {
                	dir=1; //go down
                }
                
                if(dir==0) //up
                {
           
                    Bird1[animaID].setX(bxx);
                    Bird1[animaID].setY(byy-birdMove);
                }
                else if(dir==1)  //down
                {
                
                    Bird1[animaID].setX(bxx);
                    Bird1[animaID].setY(byy+birdMove);
                }
                else if(dir==2) //left
                {
                	
                    Bird1[animaID].setX(bxx-birdMove);
                    Bird1[animaID].setY(byy);
                }
                else if(dir==3)  //right
                {
                	
                    Bird1[animaID].setX(bxx+birdMove);
                    Bird1[animaID].setY(byy);
                }
                
                if(count3==50)
                {
                	createBricks=true;
                }
                if(createBricks)
                {
                	bxx=Bird1[animaID].getX();
                    byy=Bird1[animaID].getY();
                	r_Bird[ID].setX(bxx+r_x);
                	r_Bird[ID].setY(byy+r_y);
                	if(!colliMetal(r_Bird[ID])&&!colliBrick(r_Bird[ID])&&!BirdColliEnemy(r_Bird[ID]))
                	{
                		System.out.println("bxy "+bxx+" "+byy);
                		for(int i=0;i<Bricks.length;i++)
                		{
                			if(!activeB[i])
                			{
                				int bx1=(int)bxx/100,by1=(int)byy/100;
                				bx1=bx1*100;by1=by1*100;
                				double bx=bxx%100,by=byy%100;
                				if(bx>0&&bx<=25)
                				{bxx=bx1+0;}
                				if(bx>25&&bx<=50)
            					{bxx=bx1+25;}
                				if(bx>50&&bx<=75)
            					{bxx=bx1+50;}
                				if(bx>75&&bx<=100)
            					{bxx=bx1+75;}
                				
                				if( by>0&& by<=25)
                				{byy= by1+0;}
                				if( by>25&& by<=50)
            					{byy= by1+25;}
                				if( by>50&& by<=75)
            					{byy= by1+50;}
                				if( by>75&& by<=100)
            					{byy= by1+75;}
                				
                				Bricks[i].setX(bxx);
                				Bricks[i].setY(byy);
                				activeB[i]=true;
                				createBricks=false;
                				break;
                			}
                		}
                	}
                }
                
                count3++;
                if(count3>100)
                {
                	count3=0;
                	if(Bird1[animaID].getX()>=(sizeX-50))  
                    {
                    	dir=2; //go left
                    }
                    else if(Bird1[animaID].getY()>=(sizeY-50))
                    {
                    	dir=0; //go up
                    }
                    else if(Bird1[animaID].getX()<=(50))
                    {
                    	dir=3; //go right
                    }
                    else if(Bird1[animaID].getY()<=(50))
                    {
                    	dir=1; //go down
                    }
                    else {
                    	dir = r.nextInt(4);
                    	
                    	System.out.println("dir "+dir);
    				}
                    
                }
                
                */
                bxx=Bird1[animaID].getX();
                byy=Bird1[animaID].getY();
                // drops off candy at specified location
                if (dropItem[0]==false&&r_Bird[ID].getX() == candyLoc_x && r_Bird[ID].getY() == candyLoc_y) {
                	dropItem[0] = true;
                	System.out.println("drop "+dropItem[0]+" x y "+bxx+" "+byy);
                }
                
                if (dropItem[0]) {
                   holdCount++;
                   
                   		if(holdCount>100)
                   		{
                   			holdCount=0;
                   			dropItem[0]=false;
                   			boolean check=false;
                   			while(check==false) {
                   	        	candyLoc_x=r.nextInt((int)sizeX-50)/25;
                   	        	
                   	        	candyLoc_y=r.nextInt((int)sizeY-50)/25;
                   	        	
                   	        if(candyLoc_x%2==0&&candyLoc_y%2==0)
                   	        	check=true;
                   	        	dropX[0]=candyLoc_x;
                   	        	dropY[0]=candyLoc_y;
                   	            candyLoc_x=candyLoc_x*25+25;
                   	            candyLoc_y=candyLoc_y*25+25;
                   	        	
                   	        }
                   		}
                    	
                        
                        /*
                        // picks a new "random" location for next candy drop
                        candyLoc_y = r.nextInt(500) + 50;
                        while (candyLoc_y % 25 != 0 || candyLoc_y % 10 == 0) {
                            candyLoc_y = r.nextInt(500) + 50;
                        }
                        candyLoc_x = r.nextInt(500) + 50;
                        while (candyLoc_x % 25 != 0 || candyLoc_x % 10 == 0) {
                            candyLoc_x = r.nextInt(1000) + 50;
                        }
                        */
                      
                } else {
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
                        r_Bird[animaID].setX(bxx);
                        r_Bird[animaID].setY(byy);

                        Bird1[animaID].setX(bxx);
                        Bird1[animaID].setY(byy);
                    }
                    if (r_Bird[ID].getX() != candyLoc_x) {
                    	if(r_Bird[ID].getX()<candyLoc_x)
                    	{
                    		 r_Bird[ID].setX(bxx + r_x + birdMove);
                             r_Bird[ID].setY(byy + r_y);
                             bxx = bxx + birdMove;
                    	}
                    	else {
                    		r_Bird[ID].setX(bxx + r_x - birdMove);
                            r_Bird[ID].setY(byy + r_y);
                            bxx = bxx - birdMove;
                    	}
                    		
                    	r_Bird[animaID].setX(bxx);
                        r_Bird[animaID].setY(byy);

                        Bird1[animaID].setX(bxx);
                        Bird1[animaID].setY(byy);

                        count1++;
                    }
                    
                }
                
            }
        };
        BirdAnima[ID].start();
    }
}