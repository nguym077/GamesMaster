package tank;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

class AiAnimation extends Animation {
	boolean moveup=false,movedown=false,moveleft=true,moveright=false;
	AiAnimation()
	{
		for(int i=0;i<aiBunnyAnima.length;i++) {
			System.out.println("index "+i);
		aiBunny(i);
		}
		for(int i=0;i<aiFrogAnima.length;i++) {
			System.out.println("index "+i);
			aiFrog(i);
		}
		randomFrog();
	}
	public void randomFrog()
	{
		
		randomForgAnima[0]=new AnimationTimer()
		{
			Random r=new Random();
			double lastTime=System.nanoTime();
			double lastTime2=System.nanoTime();
			long count=0;
			boolean initial=true;
			public void handle(long now) {
				int rx=-10,ry=-10;
				count++;
				if(count>1000||initial) {
					count=0;
					initial=false;
					while(true)
					{
						boolean col=false;
						rx=r.nextInt((int)sizeX);
						ry=r.nextInt((int)sizeY);
						frogDown[10].setX(rx);
						frogDown[10].setY(ry);
						if (frogDown[10].getBoundsInLocal().intersects(playerTank[0].getBoundsInLocal())||
								frogDown[10].getBoundsInLocal().intersects(playerTank[1].getBoundsInLocal()))
				        {
							col=true;
				        }
						for(int i=0;i<board.length;i++)
						{
							if(frogDown[10].getBoundsInLocal().intersects(board[i].getBoundsInLocal()))
							{
								col=true;
							}
						}
						
						for(int i=0;i<wall.length;i++)
						{
							if(frogDown[10].getBoundsInLocal().intersects(wall[i].getBoundsInLocal()))
							{
								col=true;
							}
						}
						if(col==false)
							break;
					}
					coliFrogType[0]=r.nextInt(5);
					//coliFrogType[0]=4;
					frogDown[10].setVisible(true);
					coliFrog[0]=new Rectangle(2,2);
					coliFrog[0].setX(rx);
					coliFrog[0].setY(ry);
				}
				
				for(int i=0;i<rectangle.length;i++)
				{
					if(coliFrog[0].getBoundsInLocal().intersects(rectangle[i].getBoundsInLocal()))
					{
						frogDown[10].setVisible(false);
						coliFrog[0].setX(-10);
						coliFrog[0].setY(-10);
					}
				}
				
			}
		};randomForgAnima[0].start();
	}
	long bunnySpeed=100000000;
	public void aiBunny(int index)
	{
		
		aiBunnyAnima[index]=new AnimationTimer()
		{
			Random r=new Random();
			int direction=-1;
			int newDirection=-1;
			
			int i=0,indexI=index*4;
			double lastTime=System.nanoTime();
			double lastTime2=System.nanoTime();
			public void handle(long now) {
					newDirection=aiBunnyDirection[index];
				//newDirection=0;
				if(newDirection!=direction) {
					bunnyLeft[indexI+i].setVisible(false);
					bunnyRight[indexI+i].setVisible(false);
					bunnyUp[indexI+i].setVisible(false);
					bunnyDown[indexI+i].setVisible(false);
					direction=newDirection;
				}
				
				switch(direction)
				{
					case 0: //left
					{
						if(now-lastTime>bunnySpeed) {
						bunnyLeft[indexI+i].setVisible(false);
						i=i+1;
						if(i==4)
							i=0;
						bunnyLeft[indexI+i].setVisible(true);
						bunnyMove(bunnyLeft[indexI+i],index,0);
						lastTime=now;
						}
					}
					break;
					case 1: //right
					{
						if(now-lastTime>bunnySpeed) {
						bunnyRight[indexI+i].setVisible(false);
						i=i+1;
						if(i==4)
							i=0;
						bunnyRight[indexI+i].setVisible(true);
						bunnyMove(bunnyRight[indexI+i],index,1);
						lastTime=now;
						}
					}
					break;
					case 2: //up
					{
						if(now-lastTime>bunnySpeed) {
						bunnyUp[indexI+i].setVisible(false);
						i=i+1;
						if(i==4)
							i=0;
						bunnyUp[indexI+i].setVisible(true);
						bunnyMove(bunnyUp[indexI+i],index,2);
						//bunnyIncomingMove(bunnyUp[indexI+i],index);
						lastTime=now;
						}
					}
					break;
					case 3: //down
					{
						if(now-lastTime>bunnySpeed) {
						bunnyDown[indexI+i].setVisible(false);
						i=i+1;
						if(i==4)
							i=0;
						bunnyDown[indexI+i].setVisible(true);
						bunnyMove(bunnyDown[indexI+i],index,3);
						lastTime=now;
						}
					}
					break;
				}
			}
		};
		
	}
	long forgSpeed=300000000;
	public void aiFrog(int index)
	{
		
		aiFrogAnima[index]=new AnimationTimer()
		{
			Random r=new Random();
			int direction=-1;
			int newDirection=-1;
			int i=0,indexI=index*3;
			double lastTime=System.nanoTime();
			double lastTime2=System.nanoTime();
			public void handle(long now) {
				if(now-lastTime2>90000000) {
					lastTime2=now;
					//direction=r.nextInt(4);\
					newDirection=0;
						/*
						bunnyLeft[indexI+i].setVisible(false);
						bunnyRight[indexI+i].setVisible(false);
						bunnyUp[indexI+i].setVisible(false);
						bunnyDown[indexI+i].setVisible(false);
						*/
					
				}
				if(newDirection!=direction) {
					bunnyLeft[indexI+i].setVisible(false);
					bunnyRight[indexI+i].setVisible(false);
					bunnyUp[indexI+i].setVisible(false);
					bunnyDown[indexI+i].setVisible(false);
					direction=newDirection;
				}
				switch(direction)
				{
					case 0: //left
					{
						if(now-lastTime>forgSpeed) {
							
						frogLeft[indexI+i].setVisible(false);
						i=i+1;
						if(i==3)
							i=0;
						frogLeft[indexI+i].setVisible(true);
						lastTime=now;
						}
					}
					break;
					case 1: //right
					{
						if(now-lastTime>forgSpeed) {
						frogRight[indexI+i].setVisible(false);
						i=i+1;
						if(i==4)
							i=0;
						frogRight[indexI+i].setVisible(true);
						lastTime=now;
						}
					}
					break;
					case 2: //up
					{
						if(now-lastTime>forgSpeed) {
						frogUp[indexI+i].setVisible(false);
						i=i+1;
						if(i==4)
							i=0;
						frogUp[indexI+i].setVisible(true);
						lastTime=now;
						}
					}
					break;
					case 3: //up
					{
						if(now-lastTime>forgSpeed) {
						frogDown[indexI+i].setVisible(false);
						i=i+1;
						if(i==4)
							i=0;
						frogDown[indexI+i].setVisible(true);
						lastTime=now;
						}
					}
					break;
				}
			}
		};
		
	}
	public void bunnyIncomingMove(ImageView view,int index)
	{
		boolean collison=false;
		double x=view.getX();
		double y=view.getY();
		double speed=aiBunnySpeed[index];
		double degree=aiBunnyDirection[index];
		
		
		
		if(!collison) {
			for(int i=0;i<wallRec.length;i++)
			{
				if(wallRec[i]!=null)
				{
				 if (view.getBoundsInLocal().intersects(wallRec[i].getBoundsInLocal())) {
				     
				         {
				        collison=true;break;}
				    }
				}
			}
		}
		if(collison) {
			removeBunny(index);
			stopA(index);
		}
			
		
		
	}
	public void bunnyMove(ImageView view,int index,int dir)
	{
		boolean collison=false;
		double x=view.getX();
		double y=view.getY();
		double speed=aiBunnySpeed[index];
		if(index==15) {
			
			double moveX=x+crossBunnyDir[0]-2;
			double moveY=y+crossBunnyDir[1]-3;
			System.out.println("moveX "+moveX);
			System.out.println("moveY "+moveY);
			view.setX(moveX);
			view.setY(moveY);
		}
		else
		{
			if(dir==0)
				view.setX(x-speed);
			else if(dir==1)
				view.setX(x+speed);
			else if(dir==2)
				view.setY(y-speed);
			else if(dir==3)
				view.setY(y+speed);
		}
		
		
		if(!collison) {
			for(int i=0;i<wall.length;i++)
			{
				if(wall[i]!=null)
				{
				 if (view.getBoundsInLocal().intersects(wall[i].getBoundsInLocal())) {
				     
				         {
				        collison=true;System.out.println("coli");break;}
				    }
				}
			}
		}
		if(collison) {
			removeBunny(index);
			stopA(index);
		}
			
		
		
	}
	public void removeBunny(int index)
	{
		
		for(int i=index*4;i<index*4+4;i++)
		{
			bunnyUp[i].setX(-50);
			bunnyUp[i].setY(-50);
			bunnyDown[i].setX(-50);
			bunnyDown[i].setY(-50);
			bunnyLeft[i].setX(-50);
			bunnyLeft[i].setY(-50);
			bunnyRight[i].setX(-50);
			bunnyRight[i].setY(-50);	
		}
	}
	public void bunnyColisionWall(int index)
	{
		boolean withwall=false;
		int imageIndex=index*4;
		for(int s=0;s<dataPanel.wall.length;s++)
		{
			if(bunnyUp[imageIndex].getBoundsInLocal().intersects(dataPanel.wall[s].getBoundsInLocal())||
					bunnyDown[imageIndex].getBoundsInLocal().intersects(dataPanel.wall[s].getBoundsInLocal())||
					bunnyLeft[imageIndex].getBoundsInLocal().intersects(dataPanel.wall[s].getBoundsInLocal())||
					bunnyRight[imageIndex].getBoundsInLocal().intersects(dataPanel.wall[s].getBoundsInLocal()))
			{withwall=true;
			//aiBunnyAnima[15].stop();
			break;}
		}
	}
	//public void 
	public void invisble(ImageView view)
	{
		view.setVisible(false);
	}
	public void stopA(int index)
	{
		aiBunnyAnima[index].stop();
	}
}
