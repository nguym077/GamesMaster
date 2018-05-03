package tank;

import javafx.scene.image.ImageView;

import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class dataPanel extends Maze implements imageUi{
	//double health1,health2;
	//int shell1=50,shell2=50;
	dataPanel()
	{
		playerTankSpeed[0]=initialSpeed;
		playerTankSpeed[1]=initialSpeed;
		shell();
		healthNum[0]=200;
		healthNum[1]=200;
		dataRec[0]=new Rectangle(sizeX,50);
		health[0]=new Rectangle(200,15);
		health[1]=new Rectangle(200,15);
		health[2]=new Rectangle(200,15);
		health[3]=new Rectangle(200,15);
		
		dataRec[0].setVisible(false);
		//health[0].setWidth(100);
		//health[0].setHeight(10);
		health[0].setX(100);
		health[0].setY(5);
		health[0].setFill(Color.RED);
		health[1].setX(100);
		health[1].setY(5);
		health[1].setFill(Color.GREEN);
		
		health[2].setX(700);
		health[2].setY(5);
		health[2].setFill(Color.RED);
		health[3].setX(700);
		health[3].setY(5);
		health[3].setFill(Color.GREEN);
		
		player1[0]=new Text("P1");
		player1[0].setLayoutX(15);
		player1[0].setLayoutY(15);
		player1[0].setScaleY(3);
		player1[0].setX(1);
		player1[0].setY(2);
		
		player1[1]=new Text("Health:");
		player1[1].setLayoutX(20);
		player1[1].setLayoutY(15);
		player1[1].setX(30);
		player1[1].setY(2);
		
		player2[0]=new Text("P2");
		player2[0].setLayoutX(15);
		player2[0].setLayoutY(15);
		player2[0].setScaleY(3);
		player2[0].setX(600);
		player2[0].setY(2);
		
		player2[1]=new Text("Health:");
		player2[1].setLayoutX(20);
		player2[1].setLayoutY(15);
		player2[1].setX(630);
		player2[1].setY(2);
		
		shellLabel[0].setX(50);
		shellLabel[0].setY(25);
		
		player1[2]=new Text("50");
		player1[2].setLayoutX(20);
		player1[2].setLayoutY(20);
		player1[2].setX(70);
		player1[2].setY(20);
		player1[3]=new Text("/50");
		player1[3].setLayoutX(20);
		player1[3].setLayoutY(20);
		player1[3].setX(85);
		player1[3].setY(20);
		
		shellLabel[1].setX(650);
		shellLabel[1].setY(25);
		
		player2[2]=new Text("50");
		player2[2].setLayoutX(20);
		player2[2].setLayoutY(20);
		player2[2].setX(680);
		player2[2].setY(20);
		player2[3]=new Text("/50");
		player2[3].setLayoutX(20);
		player2[3].setLayoutY(20);
		player2[3].setX(695);
		player2[3].setY(20);
	}
	boolean checkHealth1()
	{
		boolean stop=false;
		if(healthNum[0]==0)
			stop=true;
		return stop;
	}
	boolean checkHealth2()
	{
		boolean stop=false;
		if(healthNum[1]==0)
			stop=true;
		return stop;
	}
	public void halfHealth(int playerTankIndex)
	{
		if(playerTankIndex==0)
		{
			healthNum[0]=healthNum[0]*0.5;
			if(healthNum[0]<0)
				healthNum[0]=0;
			health[1].setWidth(healthNum[0]);
			double percent=(healthNum[0]/200);
			playerTankSpeed[0]=initialSpeed*percent;
			
		}
		else if(playerTankIndex==1)
		{
			healthNum[1]=healthNum[1]*0.5;
			if(healthNum[1]<0)
				healthNum[1]=0;
			health[3].setWidth(healthNum[1]);
			double percent=(healthNum[1]/200);
			playerTankSpeed[1]=initialSpeed*percent;
		}
	}
	public void newHealth(int playerTankIndex,double live)
	{
		if(playerTankIndex==0)
		{
			healthNum[0]=healthNum[0]+live;
			if(healthNum[0]<0)
				healthNum[0]=0;
			else if(healthNum[0]>200)
				healthNum[0]=200;
			health[1].setWidth(healthNum[0]);
			double percent=(healthNum[0]/200);
			playerTankSpeed[0]=initialSpeed*percent;
			
		}
		else if(playerTankIndex==1)
		{
			healthNum[1]=healthNum[1]+live;
			if(healthNum[1]<0)
				healthNum[1]=0;
			else if(healthNum[1]>200)
				healthNum[1]=200;
			health[3].setWidth(healthNum[1]);
			double percent=(healthNum[1]/200);
			playerTankSpeed[1]=initialSpeed*percent;
		}
	}
	public void shell()
	{
		shell[0]=50;shell[1]=50;
		String shell="shell pic 1.png";
		Image []shellImage=new Image[1];
		shellImage[0]=new Image(shell);
		for(int i=0;i<shellLabel.length;i++)
		{
			shellLabel[i]=new ImageView(shellImage[0]);
		}
	}
	//shell remain numbers
	public void changeShell1(int num)
	{
		
		if(shell[0]!=0)
			shell[0]=shell[0]+num;
		if(shell[0]>50)
			shell[0]=50;
		
		player1[2].setText(String.valueOf(shell[0]));
	}
	public void changeShell2(int num)
	{
		if(shell[1]!=0)
			shell[1]=shell[1]+num;
		if(shell[1]>50)
			shell[1]=50;
		player2[2].setText(String.valueOf(shell[1]));
	}
	int checkShell1()
	{
		return shell[0];
	}
	int checkShell2()
	{
		return shell[1];
	}
	//take 16 and 17 as crossing Bunny 
		public void crossingBunny(ImageView attacker,Rectangle wall)
		{
			double direction=0;	
			double x=wall.getX();
			double y=wall.getY();
			double ax=600;
			double ay=300;
			
			if(playerTank[0].equals(attacker)||playerTank[1].equals(attacker)) {
				aiBunnySpeed[15]=2;
				crossBunnyDir[0]=(ax-x)/20;
				crossBunnyDir[1]=(ay-y)/20;
				//System.out.println("ax-x "+crossBunnyDir[0]);
				//System.out.println("ay-y "+crossBunnyDir[1]);
				aiBunnyAnima[15].start();
				direction=Math.abs(playerTank[0].getRotate());
				//System.out.println("p1");
			}
			/*
			else if(playerTank[1].equals(attacker)) {
				aiBunnySpeed[16]=2;
				crossBunnyDir[2]=(ax-x)/10;
				crossBunnyDir[3]=(ay-y)/10;
				aiBunnyAnima[16].start();
				//System.out.println("p2");
				direction=Math.abs(playerTank[1].getRotate());
			}
			*/
			//crossBunnyDir
			boolean location=false;
			boolean withwall=false;
			boolean withtank=false;
			boolean withbunny=false;
			boolean withfrog=false;
			
				double x1=0,y1=0;
				int dir=-1;
				if(Math.abs(x-ax)<=100)
				{
					x1=5;
				}
				if(Math.abs(y-ay)<=100)
				{
					y1=5;
				}
				double space=25;
				//up left
				if(x-ax>0&&y-ay>0) {
					x=x-space-x1;
					y=y-space-y1;
					dir=0;
				}
				//down left
				else if(x-ax>0&&y-ay<0)
				{
					x=x-space-x1;
					y=y+space+x1;
					dir=0;
				}
				//up rigth
				else if(x-ax<0&&y-ay>0)
				{
					x=x+space+x1;
					y=y-space-y1;
					dir=1;
				}
				//down right
				else if(x-ax<0&&y-ay<0)
				{
					x=x+space+x1;
					y=y+space+y1;
					dir=1;
				}
		
			setupBunny(15,x,y,dir);
			int findPath=0;
			for(int i=0;i<path.length;i++)
			{
				if(attacker.getBoundsInLocal().intersects(path[i].getBoundsInLocal())) {
				findPath=i;break;}
			}
			
			double px=path[findPath].getX();
			double py=path[findPath].getY();
		}
		
		public void setupBunny(int index,double x,double y,int angle)
		{
			Random dir=new Random();
			int newIndex=index*4; 
			int lastIndex=newIndex+4;
			for(int i=newIndex;i<lastIndex;i++)
			{
				bunnyRight[i].setX(x);
				bunnyRight[i].setY(y);
				bunnyLeft[i].setX(x);
				bunnyLeft[i].setY(y);
				bunnyUp[i].setX(x);
				bunnyUp[i].setY(y);
				bunnyDown[i].setX(x);
				bunnyDown[i].setY(y);
				
				bunnyLeft[i].setVisible(false);
				bunnyRight[i].setVisible(false);
				bunnyUp[i].setVisible(false);
				bunnyDown[i].setVisible(false);
			}
			int newDir=dir.nextInt(4);
			aiBunnyDirection[index]=angle;
			aiBunnyAnima[index].start();
		}
}
