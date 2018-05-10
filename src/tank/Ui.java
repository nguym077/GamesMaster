package tank;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

class Ui extends ActionLogic implements imageUi{
	Random Rand=new Random();
	Ui()
	{
		tank();
		//backGround();
		effect();
		missile();
		rectangle();
		setBoard();
		setTank();
		setWall();
		setPath();
		//setMap();
		//setTree();
		//setRoad();
	}
	public void setTank()
	{
		playerTank[0].setX(50);
		playerTank[0].setY(20);
		playerTank[1].setX(1100);
		playerTank[1].setY(600);
		
		
		
		rectangle[0].setX(50);
		rectangle[0].setY(20);
		rectangle[1].setX(1100);
		rectangle[1].setY(600);
		
		
	}
	
	public void tank()
	{
		String []Tank=new String[4];
		Tank[0]="tank/image/Tank 1.png";
		//Tank[0]="green-tank-up.gif";
		Tank[1]="tank/image/yellow-tank-up.gif";
		Tank[2]="tank/image/yellow-tank-up.gif";
		Tank[3]="tank/image/white-tank-up.gif";
		Image []PtankImage=new Image[4];
		
		for(int i=0;i<playerTank.length;i++)
		{
			PtankImage[i] = new Image(Tank[i]);
			
			playerTank[i]=new ImageView(PtankImage[i]);
			playerTank[i].setFitWidth(15);
			playerTank[i].setFitHeight(30);
			removeImage(playerTank[i]);
		}
		
		
		PtankImage[3] = new Image(Tank[3]);
		for(int i=0;i<aiTank.length;i++)
		{
			aiTank[i]=new ImageView(PtankImage[3]);
			removeImage(aiTank[i]);
		}
		
	}
	public void backGround()
	{
		String []url=new String[4];
		url[0]="tank/image/grass_background.jpg";
		
		Image []background=new Image[4];
		background[0] = new Image(url[0]);
		for(int i=0;i<backGround.length;i++)
		{
			
			backGround[i]=new ImageView(background[0]);
			backGround[i].setFitHeight(100);
			backGround[i].setFitWidth(200);
			removeImage(backGround[i]);
		}
		
	}
	public void effect()
	{
		String []expl=new String[3];
		expl[0]="tank/image/explosion1.gif";
		expl[1]="tank/image/explosion2.gif";
		expl[2]="tank/image/explosion3.gif";
		
		Image []explosionImage=new Image[3];
		for(int i=0;i<3;i++)
		{
			explosionImage[i]=new Image(expl[i]);
		}
		int explIndex=0;
		for(int i=0;i<explosion.length;i++)
		{   if(explIndex==3) explIndex=0;
			explosion[i]=new ImageView(explosionImage[explIndex]);
			removeImage(explosion[i]);
			explIndex++;
		}
	}
	public void missile()
	{
		String missileGif="tank/image/shell 1.png";
		Image missileImage = new Image(missileGif);
		
		for(int i=0;i<missile.length;i++)
		{
			missile[i]=new ImageView(missileImage);
			missile[i].setFitWidth(10);
			missile[i].setFitHeight(10);
			removeImage(missile[i]);
		}
		 
	}
	public void rectangle()
	{
		for(int i=0;i<rectangle.length;i++) {
		rectangle[i]=new Rectangle(15.0, 25.0);
		rectangle[i].setFill(Color.TRANSPARENT);
		//rectangle[i].setFill(Color.RED);
		}
		for(int i=0;i<aiRectangle.length;i++)
		{
			aiRectangle[i]=new Rectangle(15, 25.0);
			aiRectangle[i].setFill(Color.TRANSPARENT);
			removeRectangle(aiRectangle[i]);
		}
		
	}
	public void setBoard()
	{
		board[0]=new Rectangle(sizeX,1);
        board[1]=new Rectangle(sizeX,1);
        //board[1].setFill(Color.GRAY);
        board[2]=new Rectangle(1,sizeY);
        board[3]=new Rectangle(1,sizeY);
        //board[1].setFill(Color.RED);
        board[0].setX(-1);board[0].setY(-1);
        board[1].setX(-1);board[1].setY(sizeY);
        board[2].setX(-1);board[2].setY(-1);
        board[3].setX(sizeX);board[3].setY(0);
	}
	public void setWall()
	{
		String []url=new String[4];
		url[0]="tank/image/wall 2.png";
		
		Image []image=new Image[4];
		image[0] = new Image(url[0]);
		for(int i=0;i<wall.length;i++)
		{
			
			wall[i]=new ImageView(image[0]);
			wall[i].setFitWidth(10);
			wall[i].setFitHeight(10);
			
			wallRec[i]=new Rectangle(wall[i].getFitWidth()-4,wall[i].getFitHeight()-4);
			removeImage(wall[i]);
			removeRectangle(wallRec[i]);
			/*
			while(true) {
				int x=Rand.nextInt((int)(sizeX-10));
				int y=Rand.nextInt((int)(sizeY-10));
			//wall[i].setX(x);
			//wall[i].setY(y);
			//wallRec[i].setX(x+2);
			//wallRec[i].setY(y+2);
			System.out.println("here i "+i+" x "+x+" y "+y);
			if(!setWallCollision(wall[i]))
				break;
			}
			*/
		}
	}
	public void setPath()
	{
		double x=60,y=60;
		path[0]=new Rectangle(sizeX,y);
		path[0].setX(0);path[0].setY(0);
		path[1]=new Rectangle(sizeX,y);
		path[1].setX(0);path[1].setY((sizeY-3*y)/2+y);
		path[2]=new Rectangle(sizeX,y);
		path[2].setX(0);path[2].setY(2*(sizeY-3*y)/2+2*y);
		
		
		path[3]=new Rectangle(x,sizeY);
		path[3].setX(0);path[3].setY(0);
		path[4]=new Rectangle(x,sizeY);
		path[4].setX((sizeX-3*x)/2+x);path[4].setY(0);
		path[5]=new Rectangle(x,sizeY);
		path[5].setX(2*(sizeX-3*x)/2+2*x);path[5].setY(0);
		//(sizeX-3*x)/2+x+10  (sizeY-3*y)/2+2*y+15
		double innerX=12,innerY=12;
		path[6]=new Rectangle((sizeX-3*x)/2-2*innerX,(sizeY-3*y)/2-2*innerY);
		path[6].setX(x+innerX);path[6].setY(y+innerY);
		setMaze(x+innerX,y+innerY,0);
		
		path[7]=new Rectangle((sizeX-3*x)/2-2*innerX,(sizeY-3*y)/2-2*innerY);
		path[7].setX((sizeX-3*x)/2+2*x+innerX);path[7].setY(y+innerY);
		//setMaze((sizeX-3*x)/2+2*x+innerX,y+innerY,1);
		
		path[8]=new Rectangle((sizeX-3*x)/2-2*innerX,(sizeY-3*y)/2-2*innerY);
		path[8].setX(x+innerX);path[8].setY((sizeY-3*y)/2+2*y+innerY);
		//setMaze(x+innerX,(sizeY-3*y)/2+2*y+innerY,2);
		
		path[9]=new Rectangle((sizeX-3*x)/2-2*innerX,(sizeY-3*y)/2-2*innerY);
		path[9].setX((sizeX-3*x)/2+2*x+innerX);path[9].setY((sizeY-3*y)/2+2*y+innerY);
		//setMaze((sizeX-3*x)/2+2*x+innerX,(sizeY-3*y)/2+2*y+innerY,3);
		for(int i=0;i<10;i++)
		{
			//path[i].setFill(Color.RED);
		}
		
		
	}
	
	public void setMap()
	{
		String []url=new String[4];
		url[0]="tank/image/ground 1.png";
		
		Image []image=new Image[4];
		image[0] = new Image(url[0]);
		
		for(int i=0;i<ground.length;i++)
		{
			ground[i]=new ImageView(image[0]);
		}
		int xi=0;
		for(int i=0;i<sizeX;i=i+35)
		{
			for(int j=0;j<sizeY;j=j+35)
			{
				ground[xi].setX(i);
				ground[xi].setY(j);
				xi++;
			}
		}
	}
	public void setTree()
	{
		String []url=new String[4];
		url[0]="tank/image/tree 1.png";
		url[1]="tank/image/tree 2.png";
		Image []image=new Image[4];
		image[0] = new Image(url[0]);
		image[1] = new Image(url[1]);
		
		for(int i=0;i<greenTree.length;i++)
		{
			greenTree[i]=new ImageView(image[0]);
			
		}
		for(int i=0;i<yellowTree.length;i++)
		{
			yellowTree[i]=new ImageView(image[1]);
		}
		
		for(int i=0;i<0;i++)
		{
			while(true)
			{
				boolean withwall=false;
				//do{
				int x=Rand.nextInt((int)sizeX);
				int y=Rand.nextInt((int)sizeY);
				greenTree[i].setX(x);
				greenTree[i].setY(y);
				int newsize=20 + (int)(Math.random() * (30 - 20));
				
				greenTree[i].setFitWidth(newsize);
				greenTree[i].setFitHeight(newsize);
			
				for(int w=0;w<wallRec.length;w++) {
					if (greenTree[i].getBoundsInLocal().intersects(wallRec[w].getBoundsInLocal()))
						{withwall=true;break;}
					
				}
				if(!withwall)
					break;
			}
			
			while(true)
			{
				boolean withwall=false;
				
				int x=Rand.nextInt((int)sizeX);
				int y=Rand.nextInt((int)sizeY);
				yellowTree[i].setX(x);
				yellowTree[i].setY(y);
				int newsize=20 + (int)(Math.random() * (30 - 20));
				
				yellowTree[i].setFitWidth(newsize);
				yellowTree[i].setFitHeight(newsize);
				for(int w=0;w<wallRec.length;w++) {
					if (yellowTree[i].getBoundsInLocal().intersects(wallRec[w].getBoundsInLocal()))
						{withwall=true;break;}
				}
				if(!withwall)
					break;
			}
		
		}
	}
	public void setRoad()
	{
		String []url=new String[4];
		url[0]="tank/image/road H 1.png";
		url[1]="tank/image/road CR 1.png";
		url[2]="tank/image/road V 1.png";
		Image []image=new Image[4];
		image[0] = new Image(url[0]);
		image[1] = new Image(url[1]);
		image[2] = new Image(url[2]);
		for(int i=0;i<yellowRoadH.length;i++)
		{
			yellowRoadH[i]=new ImageView(image[0]);
			removeImage(yellowRoadH[i]);
			
		}
		for(int i=0;i<yellowRoadCR.length;i++)
		{
			yellowRoadCR[i]=new ImageView(image[1]);
			removeImage(yellowRoadCR[i]);
			
		}
		for(int i=0;i<yellowRoadV.length;i++)
		{
			yellowRoadV[i]=new ImageView(image[2]);
			removeImage(yellowRoadV[i]);
			
		}
		for(int i=0;i<35;i++)
		{
			yellowRoadH[i].setX(i*35);
			yellowRoadH[i].setY(315);
		}
		yellowRoadCR[0].setX(17*35);
		yellowRoadCR[0].setY(315);
		yellowRoadCR[1].setX(1*35);
		yellowRoadCR[1].setY(315);
		yellowRoadCR[2].setX(33*35);
		yellowRoadCR[2].setY(315);
		
		for(int i=0;i<20;i++)
		{
			yellowRoadV[i].setX(1*35);
			yellowRoadV[i].setY(i*35);
		}
		for(int i=20;i<40;i++)
		{
			yellowRoadV[i].setX(17*35);
			yellowRoadV[i].setY((i-20)*35);
		}
		for(int i=40;i<60;i++)
		{
			yellowRoadV[i].setX(33*35);
			yellowRoadV[i].setY((i-40)*35);
		}
	}
}
