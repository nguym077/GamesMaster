package tank;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


class Ui extends ActionLogic implements imageUi{
	Ui()
	{
		tank();
		effect();
		missile();
		rectangle();
		setBoard();
		setTank();
	}
	public void setTank()
	{
		playerTank[0].setX(10);
		playerTank[0].setY(300);
		playerTank[1].setX(300);
		playerTank[1].setY(10);
		playerTank[2].setX(300);
		playerTank[2].setY(300);
		
		
		rectangle[0].setX(10);
		rectangle[0].setY(300);
		rectangle[1].setX(300);
		rectangle[1].setY(10);
		rectangle[2].setX(300);
		rectangle[2].setY(300);
		
		aiTank[0].setX(10);
		aiTank[0].setY(10);
		aiTank[1].setX(50);
		aiTank[1].setY(50);
		aiTank[2].setX(100);
		aiTank[2].setY(100);
		
		aiRectangle[0].setX(10);
		aiRectangle[0].setY(10);
		aiRectangle[1].setX(50);
		aiRectangle[1].setY(50);
		aiRectangle[2].setX(100);
		aiRectangle[2].setY(100);
		
	}
	public void tank()
	{
		String []Tank=new String[4];
		Tank[0]="green-tank-up.gif";
		Tank[1]="yellow-tank-up.gif";
		Tank[2]="yellow-tank-up.gif";
		Tank[3]="white-tank-up.gif";
		Image []PtankImage=new Image[4];
		
		
		for(int i=0;i<playerTank.length;i++)
		{
			PtankImage[i] = new Image(Tank[i]);
			playerTank[i]=new ImageView(PtankImage[i]);
		}
		
		
		PtankImage[3] = new Image(Tank[3]);
		for(int i=0;i<aiTank.length;i++)
		{
			aiTank[i]=new ImageView(PtankImage[3]);
			removeImage(aiTank[i]);
		}
		
	}
	public void effect()
	{
		String []expl=new String[3];
		expl[0]="explosion1.gif";
		expl[1]="explosion2.gif";
		expl[2]="explosion3.gif";
		
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
		String missileGif="missile-up.gif";
		Image missileImage = new Image(missileGif);
		
		for(int i=0;i<missile.length;i++)
		{
			missile[i]=new ImageView(missileImage);
			removeImage(missile[i]);
		}
		 
	}
	public void rectangle()
	{
		for(int i=0;i<rectangle.length;i++) {
		rectangle[i]=new Rectangle(40.0, 40.0);
		rectangle[i].setFill(Color.TRANSPARENT);
		//rectangle[i].setFill(Color.RED);
		}
		for(int i=0;i<aiRectangle.length;i++)
		{
			aiRectangle[i]=new Rectangle(40.0, 40.0);
			aiRectangle[i].setFill(Color.TRANSPARENT);
			removeRectangle(aiRectangle[i]);
		}
		
	}
	public void setBoard()
	{
		board[0]=new Rectangle(sizeX,1);
        board[1]=new Rectangle(sizeX,1);
        board[2]=new Rectangle(1,sizeY);
        board[3]=new Rectangle(1,sizeY);
        board[1].setFill(Color.RED);
        board[0].setX(-1);board[0].setY(-1);
        board[1].setX(-1);board[1].setY(sizeY);
        board[2].setX(-1);board[2].setY(-1);
        board[3].setX(sizeX);board[3].setY(0);
	}
	
}
