package tank;
import java.util.Random;

import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

class AiAction extends Animation {
	Random r=new Random();
	
	public void aiMove()
	{
		aiMoveAnima(aiRectangle[0],aiTank[0],0);
		aiMoveAnima(aiRectangle[1],aiTank[1],0);
		aiMoveAnima(aiRectangle[2],aiTank[2],0);
		
	}
	public void aiFire()
	{
		
	}
}
