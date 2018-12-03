package circle;

import javafx.scene.shape.Shape;

public class Collison implements PublicVar{

	//ball with path
	public int checkcolliPath(int ci)
	{
		int colli=-1;
		
			colliArea[ci] = Shape.intersect(path[0], C[ci]);
    		if (colliArea[ci].getBoundsInParent().getWidth()>0)
			{
				
				colli=0;
			}
		
		return colli;
	}
	public int checkleftPath(int current,int ci)
	{
		colliArea[ci]= Shape.intersect(path[current], C[ci]);
		if (colliArea[ci].getBoundsInParent().getWidth()<=0)
		 {
			
			current=-1;
		 }	
		return current;
	}
	
	
	public boolean bunnyColliPath(int bunnyi)
	{
		boolean colli=false;
		Shape coliA=Shape.intersect(C_bunny[bunnyi], path[0]);
		if (coliA.getBoundsInParent().getWidth()>0)
		 {
			colli=true;
			
			
		 }	
		return colli;
	}
	
	public boolean ballColliBunny(int ci)
	{
		boolean colli=false;
		for(int i=0;i<C_bunny.length;i++)
		{
			Shape coliA=Shape.intersect(C_bunny[i], C[ci]);
			if (coliA.getBoundsInParent().getWidth()>0)
			 {
				colli=true;
				bunnyBeHit[i]=true;
				break;
			 }
		}
			
		return colli;
	}
	
	public boolean heroColliPath(int bunnyi)
	{
		boolean colli=false;
		Shape coliA=Shape.intersect(C_hero[bunnyi], path[0]);
		if (coliA.getBoundsInParent().getWidth()>0)
		 {
			colli=true;
		 }	
		return colli;
	}
}
