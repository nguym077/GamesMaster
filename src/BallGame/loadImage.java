package BallGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.*;
public class loadImage implements PublicVar{
	double idleX=0,idleY=0;
	
	public loadImage() {
		//initialImage();
		
	}
	String front,back_L,back_R;
	ImageView[]view_L;ImageView[]view_R;
	int eachNumber,length,xl,xr,yl,yr;
	double degL,degR;
	double scales;
	public void init()
	{	
		
		fireball_1_load_idle();
		hero_1_load_idle();
		logo_1_load_idle();
		bird_1_load_idle();
		bunny_1_load_idle();
		wall_1_load_idle();
		egg_1_load_idle();
	}
	
	public void fireball_1_load_idle()
	{
		//System.out.println("enemy_1_load_shoot");
		front="images/fireball_";
		back_L="_L.png";back_R="_R.png";
		view_L=fireball_1_idle_L;view_R=fireball_1_idle_R;
		eachNumber=fireball_1_idle_imageN;length=fireball_1_idle_L.length;
		xl=110;xr=65;yl=70;yr=70;scales=0.15;
		degL=90;degR=-90;
		create_imageview();
	}
	public void hero_1_load_idle()
	{
		//System.out.println("enemy_1_load_shoot");
		front="images/p1_";
		back_L=".png";back_R=".png";
		view_L=hero_1_idle_L;view_R=hero_1_idle_R;
		eachNumber=hero_1_idle_imageN;length=hero_1_idle_L.length;
		xl=12;xr=12;yl=16;yr=16;scales=0.7;
		degL=0;degR=0;
		create_imageview();
	}
	public void logo_1_load_idle()
	{
		//System.out.println("enemy_1_load_shoot");
		front="images/logo_";
		back_L=".png";back_R=".png";
		view_L=logo_1_idle_L;view_R=logo_1_idle_R;
		eachNumber=logo_1_idle_imageN;length=logo_1_idle_L.length;
		xl=-5;xr=0;yl=584;yr=0;scales=0.5;
		degL=0;degR=0;
		create_imageview();
	}
	public void bird_1_load_idle()
	{
		//System.out.println("enemy_1_load_shoot");
		front="images/birdLeft";
		back_L=".png";back_R=".png";
		view_L=bird_1_idle_L;view_R=bird_1_idle_R;
		eachNumber=bird_1_idle_imageN;length=bird_1_idle_L.length;
		xl=0;xr=0;yl=0;yr=0;scales=0.5;
		degL=0;degR=0;
		create_imageview();
	}
	public void bunny_1_load_idle()
	{
		//System.out.println("enemy_1_load_shoot");
		front="images/bunny_";
		back_L="_L.png";back_R="_R.png";
		view_L=bunny_1_idle_L;view_R=bunny_1_idle_R;
		eachNumber=bunny_1_idle_imageN;length=bunny_1_idle_L.length;
		xl=9;xr=19;yl=20;yr=20;scales=1.0;
		degL=0;degR=0;
		create_imageview();
	}
	public void wall_1_load_idle()
	{
		//System.out.println("enemy_1_load_shoot");
		front="images/wall_";
		back_L=".png";back_R=".png";
		view_L=wall_1_idle_L;view_R=wall_1_idle_R;
		eachNumber=wall_1_idle_imageN;length=wall_1_idle_L.length;
		xl=0;xr=0;yl=50;yr=50;scales=1.0;
		degL=0;degR=0;
		create_imageview();
	}
	public void egg_1_load_idle()
	{
		//System.out.println("enemy_1_load_shoot");
		front="images/egg_";
		back_L=".png";back_R=".png";
		view_L=egg_1_idle_L;view_R=egg_1_idle_R;
		eachNumber=egg_1_idle_imageN;length=egg_1_idle_L.length;
		xl=21;xr=0;yl=36;yr=36;scales=0.5;
		degL=0;degR=0;
		create_imageview();
	}
	public void create_imageview() 
	{
    	
        String[] url_L = new String[eachNumber];
        String[] url_R = new String[eachNumber];
        for(int i=0;i<eachNumber;i++)
        {
             url_L[i] = front+String.valueOf(i+1)+back_L;
             url_R[i] = front+String.valueOf(i+1)+back_R;
        	//url[i] = "Image/Fish_2/move/Fish_move_2_000.png";
             ////System.out.println( url[i] );
        }
       
        Image[] newImage_L = new Image[eachNumber];
        Image[] newImage_R = new Image[eachNumber];
        for(int i=0;i<eachNumber;i++)
        {
        	newImage_L[i] = new Image(url_L[i]);
        	newImage_R[i] = new Image(url_R[i]);
            //System.out.println("i "+i);
        }
        
        double actualWidth=newImage_L[0].getWidth(),actualHeight=newImage_L[0].getHeight();
        idleX=actualWidth*Scale*scales;idleY=actualHeight*Scale*scales;
        ////System.out.println("idley "+idleY);
        for (int i = 0; i <length; i=i+eachNumber) {
        
            for(int j=0;j<eachNumber;j++)
            {
            	int index=i+j;
            	view_L[index] = new ImageView(newImage_L[j]);
                ////System.out.println("check laod image "+c1_idle_L[index].getId());
            	view_L[index].setPreserveRatio(true);
            	
            	view_L[index].setFitWidth(idleX);
            	//fish_2_move_L[index].setFitWidth(actualHeight*Scale);
                //c1_idle_L[i + j].setFitHeight(Y);
            	view_L[index].setVisible(false);
            	view_L[index].setX(100);
            	view_L[index].setY(100);
            	view_L[index].setRotate(degL);
            	view_L[index].setTranslateX((0-xl)*Scale*scales);
            	view_L[index].setTranslateY(0-idleY+yl*Scale*scales);
            	//view_L[index].setTranslateY(actualHeight-2*(actualHeight));
            	//view_L[index].setId(String.valueOf(index));
               
                //Color(c1_idle_L[index],HUE[id][0]);
            	
            	view_R[index] =new ImageView(newImage_R[j]);
                ////System.out.println("check laod image "+c1_idle_L[index].getId());
            	view_R[index].setPreserveRatio(true);
                
            	view_R[index].setFitWidth(idleX);
            	//fish_2_move_R[index].setFitWidth(actualHeight*Scale);
                //c1_idle_L[i + j].setFitHeight(Y);
            	view_R[index].setVisible(false);
            	view_R[index].setX(100);
            	view_R[index].setY(100);
            	view_R[index].setRotate(degR);
            	view_R[index].setTranslateX((0-xr)*Scale*scales);
            	view_R[index].setTranslateY(0-idleY+yr*Scale*scales);
            	//view_L[index].setTranslateY(actualHeight-2*(actualHeight));
            	////System.out.println("trnasX "+fish_2_move_R[index].getTranslateY());
            	//view_R[index].setId(String.valueOf(index));
               
            
            }
            
        }
        
        
    }
}
