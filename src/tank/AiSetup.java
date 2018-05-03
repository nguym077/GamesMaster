package tank;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;
class AiSetup extends dataPanel {
	AiSetup()
	{
		initDirection();
		Bunny();
		setBunny();
		Forg();
		setForg();
	}
	public void bunnyControl()
	{
		
	}
	public void removeImage(ImageView view)
	{
		view.setX(-50);
		view.setY(-50);
	}
	//initial bunny direction
	public void initDirection()
	{
		for(int i=0;i<aiBunnyDirection.length;i++)
		{
			aiBunnyDirection[i]=-1;
		}
	}
	//initial bunny speed
	public void initSpeed()
	{
		for(int i=0;i<aiBunnySpeed.length;i++)
		{
			aiBunnySpeed[i]=0;
		}
	}
	public void Bunny()
	{
		String index;
		String []bunny=new String[16];
		Image []bunnyi = new Image[16];
		for(int i=0;i<16;i++)
		{
			if(i<4) {
			bunny[i]="bunny up "+String.valueOf(i+1)+".png";
			bunnyi[i]=new Image(bunny[i]);
			}
			if(i>=4&&i<8) {
			bunny[i]="bunny down "+String.valueOf(i-3)+".png";
			bunnyi[i]=new Image(bunny[i]);
			}
			if(i>=8&&i<12) {
				bunny[i]="bunny left "+String.valueOf(i-7)+".png";
				bunnyi[i]=new Image(bunny[i]);
			}
			if(i>=12&&i<16) {
				bunny[i]="bunny right "+String.valueOf(i-11)+".png";
				bunnyi[i]=new Image(bunny[i]);
			}
		}
		
		int up=0,down=0,left=0,right=0;
		for(int i=0;i<bunnyUp.length;i++)
		{
			if(up==4)
				up=0;
			bunnyUp[i]=new ImageView(bunnyi[up]);
			removeImage(bunnyUp[i]);
			up++;
		}
		for(int i=0;i<bunnyDown.length;i++)
		{
			if(down==8)
				down=4;
			bunnyDown[i]=new ImageView(bunnyi[down]);
			removeImage(bunnyDown[i]);
			down++;
		}
		for(int i=0;i<bunnyLeft.length;i++)
		{
			if(left==12)
				left=8;
			bunnyLeft[i]=new ImageView(bunnyi[left]);
			removeImage(bunnyLeft[i]);
			left++;
		}	
		for(int i=0;i<bunnyRight.length;i++)
		{
			if(right==16)
				right=12;
			bunnyRight[i]=new ImageView(bunnyi[right]);
			removeImage(bunnyRight[i]);
			right++;
		}		
	
	}
	public void setBunny() {
		
		aiBunnyDirection[17]=0;
		aiBunnyAnima[17].start();
		aiBunnyDirection[18]=0;
		aiBunnyAnima[18].start();
		aiBunnyDirection[19]=0;
		aiBunnyAnima[19].start();
		
		double x=0;
		for(int i=68;i<80;i++)
		{
			if(i>=68&&i<72)
				x=1160;
			else if(i>=72&&i<76)
				x=1130;
			else if(i>=76&&i<80)
				x=1100;
			bunnyRight[i].setX(x);
			bunnyRight[i].setY(10);
			bunnyLeft[i].setX(x);
			bunnyLeft[i].setY(10);
			bunnyUp[i].setX(x);
			bunnyUp[i].setY(10);
			bunnyDown[i].setX(x);
			bunnyDown[i].setY(10);
			
			bunnyLeft[i].setVisible(false);
			bunnyRight[i].setVisible(false);
			bunnyUp[i].setVisible(false);
			bunnyDown[i].setVisible(false);
		}
	}
	
	public void Forg()
	{
		String index;
		String []frog=new String[12];
		Image []frogi = new Image[12];
		for(int i=0;i<12;i++)
		{
			
			if(i<3) {
				frog[i]="Frog up "+String.valueOf(i+1)+".png";
				frogi[i]=new Image(frog[i]);
			}
			if(i>=3&&i<6) {
				frog[i]="Frog down "+String.valueOf(i-2)+".png";
				frogi[i]=new Image(frog[i]);
			}
			if(i>=6&&i<9) {
				frog[i]="Frog left "+String.valueOf(i-5)+".png";
				frogi[i]=new Image(frog[i]);
			}
			if(i>=9&&i<12) {
				frog[i]="Frog right "+String.valueOf(i-8)+".png";
				frogi[i]=new Image(frog[i]);
			}
		}
		
		int up=0,down=0,left=0,right=0;
		for(int i=0;i<frogUp.length;i++)
		{
			if(up==3)
				up=0;
			frogUp[i]=new ImageView(frogi[up]);
			removeImage(frogUp[i]);
			up++;
		}
		for(int i=0;i<frogDown.length;i++)
		{
			if(down==6)
				down=3;
			frogDown[i]=new ImageView(frogi[down]);
			removeImage(frogDown[i]);
			down++;
		}
		
		for(int i=0;i<frogLeft.length;i++)
		{
			if(left==9)
				left=6;
			frogLeft[i]=new ImageView(frogi[left]);
			removeImage(frogLeft[i]);
			left++;
		}	
		
		for(int i=0;i<frogRight.length;i++)
		{
			if(right==12)
				right=9;
			frogRight[i]=new ImageView(frogi[right]);
			removeImage(frogRight[i]);
			right++;
		}		
		
	
	}
	public void setForg() {
		aiFrogAnima[19].start();
		//display on the datapanel
		for(int i=57;i<60;i++)
		{
			frogLeft[i].setX(1080);
			if(i==58)
				frogLeft[i].setY(15-3);
			else if(i==59)
				frogLeft[i].setY(15-7);
			else
				frogLeft[i].setY(15);
			frogLeft[i].setVisible(false);
		}
	}
	
	public void randomForg()
	{
		
	}
	
}
