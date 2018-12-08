package circle;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

public class bird implements PublicVar{
	
	public void init()
	{
		activeBird[0]=false;
		for(int i=0;i<bird_1_idle_L.length;i++)
		{
			group.getChildren().add(bird_1_idle_L[i]);
		}
		run();
	}
	
	public void run()
	{
		AnimationTimer birdMove=new AnimationTimer()
	    {
			
			int count=0,count2=0;
	    	ImageView lastView=fireball_1_idle_R[0];
	    	int birdNum=0;
	    	public void handle(long now)
		    {
				if(activeBird[0])
					count++;
				if(count>1)
				{
					count=0;
					if(Move(0))
						offBird();
					else 
					{
						if(birdNum>=3)
							birdNum=0;
						lastView=idle(0, birdNum);
						birdNum++;
					}
						
				}
		    }
	    };birdMove.start();
	}
	public boolean Move(int i)
	{
		boolean stop=false;
		bird_x[i]=bird_x[i]+15;
		bird_y[i]=bird_y[i]+0;
		
		if( (bird_x[i]>sizeX-30)||(bird_y[i]>sizeY-30) )
			stop=true;
		return stop;
	}
	
	public void activeBird()
	{
		activeBird[0]=true;
		bird_x[0]=0;
		bird_y[0]=300;
	}
	public void offBird()
	{
		for(int i=0;i<activeBird.length;i++)
		{
			activeBird[i]=false;
		}
		for(int i=0;i<bird_1_idle_L.length;i++)
		{
			bird_1_idle_L[i].setVisible(false);
		}
	}
	public ImageView idle(int index,int i)
	{
		int newID=index*3+i;
		ImageView view=new ImageView();
		{
			bird_1_idle_L[newID].setVisible(true);
			bird_1_idle_L[newID].setX(bird_x[index]);
			bird_1_idle_L[newID].setY(bird_y[index]);
			//bird_1_idle_L[newID].setRotate(deg[index]+90);
			view=bird_1_idle_L[newID];
			}
		
		return view;	
	}
	
}
