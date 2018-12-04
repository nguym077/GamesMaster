package circle;


import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class data implements PublicVar{

	public void init()
	{
		
		setHealth();
		setLogo();
		setBird();
		run();
	}
	public void setHealth()
	{
		Rectangle a=new Rectangle();
		a.setWidth(1);
		a.setHeight(50);
		a.setVisible(true);
		a.setX(0);
		a.setY(0);
		dataG.getChildren().add(a);
		
		healthbar[0]=new Rectangle();
		healthbar[0].setStroke(Color.BLACK);
		healthbar[0].setWidth(200);
		healthbar[0].setHeight(20);
		healthbar[0].setX(20);
		healthbar[0].setY(10);
		healthbar[0].setFill(Color.GREEN);
		dataG.getChildren().add(healthbar[0]);
		
		healthbar[1]=new Rectangle();
		healthbar[1].setStroke(Color.BLACK);
		healthbar[1].setWidth(1);
		healthbar[1].setHeight(20);
		healthbar[1].setX(20+200);
		healthbar[1].setY(10);
		healthbar[1].setFill(Color.RED);
		dataG.getChildren().add(healthbar[1]);
		
		health[0]=200;
	}
	public void setLogo()
	{
		logo_1_idle_L[0].setX(300);
		logo_1_idle_L[0].setY(50);
		group.getChildren().add(logo_1_idle_L[0]);
	}
	public void setBird()
	{
		bird_1_idle_L[0].setX(0);
		bird_1_idle_L[0].setY(0);
	}
	public void reduceHealth()
	{
		health[0]=health[0]-20;
		double w=healthbar[1].getWidth();
		w=w+20;
		healthbar[1].setWidth(w);
		healthbar[1].setHeight(20);
		double hx=healthbar[1].getX();
		hx=hx-20;
		healthbar[1].setX(hx);
		healthbar[1].setY(10);
	}
	public void gameOver()
	{
		mapG[0].getChildren().removeAll(path[0]);
		Map newMap=new Map();
		fireball newFireball=new fireball();
		newFireball.offFireball();
		bunny newBunny=new bunny();
		newBunny.offBunny();
		hero newHero=new hero();
		newHero.offHero();
	}
	public void newGame()
	{
		Map newMap=new Map();
		newMap.init();
		
		health[0]=200;
		
		healthbar[1].setWidth(1);
		healthbar[1].setHeight(20);
		healthbar[1].setX(20+200);
		healthbar[1].setY(10);
		
		
		
		bunny newBunny=new bunny();
		newBunny.activeBunny(100, 100);
		
		hero newHero=new hero();
		newHero.activeHero(300, 300);
		
		
	}
	
	public void showBird()
	{
		bird newBird=new bird();
		newBird.activeBird();
	}
	public void showOffBird()
	{
		bird newBird=new bird();
		newBird.offBird();
	}
	public void showLogo()
	{
		logo_1_idle_L[0].setVisible(true);
	}
	public void showOffLogo()
	{
		logo_1_idle_L[0].setVisible(false);
	}
	public void run()
	{
		AnimationTimer dataRun=new AnimationTimer()
	    {
    		int count=0;
    		boolean restart=false;
    		
    		public void handle(long now)
    		{
    			if(health[0]<=0&&restart==false) {
    				restart=true;
    				gameOver();
    				showLogo();
    				showBird();
    			}
    			if(restart)
    			{
    				boolean done=false;
        			for(int i=0;i<activeBird.length;i++)
        			{
        				if(activeBird[i]==false)
        					done=true;
        				else if(activeBird[i])
        					done=false;
        			}
        			if(done) {
        				showOffBird();
        				newGame();
        				showOffLogo();
        				restart=false;
        			}
    			}
    			
    				
    		}
	    };dataRun.start();
	}
}
