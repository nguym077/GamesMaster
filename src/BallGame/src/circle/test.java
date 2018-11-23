package circle;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class test implements PublicVar{
	Circle circle;
	Rectangle r1,r2;
	public void init()
	{
		for(int i=0;i<runC.length;i++)
		{
			runC[i]=false;
		}
		
		
		
		
		//line = new Line(100, 10, 300 , 180);
		//line = new Line(200, 10, 200 , 100);
		//line = new Line(10, 300, 300 , 10);
		//line = new Line(10, 300, 300 , 300);
		//line = new Line(10, 150, 150, 300);
	    
	    for(int i=0;i<line.length;i++)
	    {
	    	line[i] = new Line();
	    	line[i].setStroke(Color.RED);
		    line[i].setStrokeWidth(2);
		   /// group.getChildren().add(line[i]);
		    setLine(i,0,0,0,0);
	    }
	    
	   // setLine(0, 10, 10, 300 , 10);
	    //setLine(1, 10, 300, 300 , 10);
	    //setLine(2, 10, 300, 300 , 300);
	    //setLine(3, 0, 0, 0, 600);
	    //setLine(4, 0, 0, 600, 0);
	    //setLine(5, 600, 600, 0, 600);
	   // setLine(6, 600, 600, 600, 0);
	    
	    //set up fireball
	    for(int i=0;i<C.length;i++)
	    {
	    	C[i] = new Circle();
			
			C[i].setRadius(15);
			C[i].setStroke(Color.BLACK);
			C[i].setFill(Color.WHITE);
			C[i].setVisible(false);
			group.getChildren().add(C[i]);
	    }
	    
	    //set up rectangel
	    for(int i=0;i<R.length;i++)
	    {
	    	R[i]= new Rectangle();
	    	R[i].setFill(Color.WHITE);
	    	R[i].setStroke(Color.BLACK);
	    	R[i].setWidth(20);
	    	R[i].setHeight(20);
	    	setR(i, -100, -100);
		    group.getChildren().add(R[i]);
	    }
	    
	    //put rectangle on the map
	    int nx=50,ny=50;
	    int inx=0,iny=0;
	    setR(0, nx, ny);
	    	setR(1, nx, ny*3);
	    	setR(2, nx, ny*7);
	    setR(3, nx*3, ny);
	    	setR(4, nx*3, ny*3);
	    setR(5, nx*5, ny);
	    	setR(6, nx*5, ny*2);
	    	setR(7, nx*5, ny*4);
	    setR(8, nx*7, ny);
	    	setR(9, nx*7, ny*3);
	    
	    /*
	    r1= new Rectangle();
	    r1.setFill(Color.RED);
	    r1.setWidth(2);
	    r1.setHeight(2);
	    r1.setX(0);
	    r1.setY(0);
	    group.getChildren().add(r1);
	    */
	    
	    //initial fireball animation
	    for(int i=0;i<fireBall.length;i++)
	    {
	    	setCanmia(i);
	    }
	    
	    //start fireball on the map
	    
	    startC(0, 0, 0, 5, 39);
	    C[0].setFill(Color.WHITE);
	    
	    startC(1, 0, 0, 10, 100);
	    C[1].setFill(Color.RED);
	    startC(2, 0, 0, 10, 200);
	    C[2].setFill(Color.BLUE);
	    startC(3, 0, 0, 10, 300);
	    C[3].setFill(Color.GREEN);
	    
	    startC(4, 0, 0, 10, 2);
	    C[4].setFill(Color.WHITE);
	    startC(5, 0, 0, 10, 39);
	    C[5].setFill(Color.WHITE);
	    startC(6, 0, 0, 10, 39);
	    C[6].setFill(Color.WHITE);
	    startC(7, 0, 0, 10, 39);
	    C[7].setFill(Color.WHITE);
	    startC(8, 0, 0, 10, 39);
	    C[8].setFill(Color.WHITE);
	    
	    
	}
	public void setCanmia(int index)
	{
		fireBall[index]=new AnimationTimer()
	    {
    		
    		int count=0;
	    	 boolean wait=false;
	    	
	    	 int current=-1;
	    	 boolean next=true;
    		 boolean coliC=false,coliR=false;
    		 double collix,colliy,disx,disy,nextD;
    		public void handle(long now)
   	         {
    			if(runC[index]==true)
   	    			 count++;
   	    		 else if(runC[index]==false)
   	    			 count=0;
   	    		 
   	    		 
   	    		 if(count>2)
   	    		 {
   	    			 count=0;
   	    			 
   	    			 cx[index]=cx[index]+motionX(index);
   	    			 cy[index]=cy[index]+motionY(index);
   	    			 //System.out.println("x "+cx[0]);
   	    			 //System.out.println("y "+cy[0]);
   	    			 //check out border
   	    			 if(cx[index]<0)
   	    				 cx[index]=sizeX;
   	    			 if(cy[index]<0)
   	    				 cy[index]=sizeY;
   	    			 if(cx[index]>sizeX)
   	    				 cx[index]=0;
   	    			 if(cy[index]>sizeY)
   	    				 cy[index]=0;
   		    		 C[index].setCenterX(cx[index]);
   		    		 C[index].setCenterY(cy[index]);
   		    		 //System.out.println("newline "+newline);
   		    		
   		    		 //if is collision and check if that fireball left
   		    		 if(current!=-1)
   		    		 {
   		    			
   		    			 if(coliR==true) {
   		    				current=checkleftR(current,index);
   		    				if(current==-1)
   		    					coliR=false;
   		    			 }
   		    			 else if(coliC==true) {
   		    				current=checkleftC(current,index);
   		    				if(current==-1)
   		    					coliC=false;
   		    			 }
   		    			 
   		    		 }
   		    		 
   		    		 //if fireball not collison anything check collison
		    		 if(current==-1)
		    		 {
		    			 next=true;
		    			 current=checkcolliR(index);  //collisoon with rectangel
		    			 if(current!=-1)
		    				 coliR=true;
		    			 else if(current==-1){
		    				current=checkcolliC(index); //collison with fireball
		    				if(current!=-1)
	  		    				 coliC=true;
		    			 }
		    		 }
   		    		
		    		 //if find collison , find fireball new degree
   		    		 if(current!=-1&&next)
   		    		 {
   		    			 next=false;
   		    			 /*
   		    			 if(coliR)
   		    				 colli = Shape.intersect(R[current], C[index]);
   		    			 else if(coliC)
   		    				colli = Shape.intersect(C[current], C[index]);
   		    			 */
   		    				 
   		    			 //Shape colli = Shape.intersect(line[current], circle);
   		    			 if(colliArea[index].getBoundsInParent().getWidth()>0||colliArea[index].getBoundsInParent().getHeight()>0)
   		    			 {
   		    				 
   		    				 collix=colliArea[index].getBoundsInParent().getMinX()+colliArea[index].getBoundsInParent().getWidth()/2;
   		    				 colliy=colliArea[index].getBoundsInParent().getMinY()+colliArea[index].getBoundsInParent().getHeight()/2;
   		    				 
   							 System.out.println("collix "+collix+" colliy "+colliy);
   							 System.out.println("centerx "+cx[index]+" centery "+cy[index]);
   							 
   							 disx=cx[index]-collix;
   							 disy=cy[index]-colliy;
   							 nextD=DEG(disx,disy);
   							 newDegree(nextD,index,disx,disy);
   							 
   		    			 }
   					    	
   		    		 }
   		    		 
   	    		 }
   	    		 
   	         }
	         
	    };fireBall[index].start();
	}
	public void setLine(int i,double sx,double sy,double ex,double ey)
	{
		line[i].setStartX(sx);
	    line[i].setStartY(sy);
	    line[i].setEndX(ex);
	    line[i].setEndY(ey);
	}
	public void setR(int i,double x,double y)
	{
		R[i].setX(x);
		R[i].setY(y);
	}
	public void setC(int i,double x,double y)
	{
		C[i].setCenterX(x);
		C[i].setCenterY(y);
	}
	//put fireball on the map, fireball index, startx, starty, speedy, degree
	public void startC(int i,double sx,double sy,double speedy,double degree)
	{
		C[i].setVisible(true);
		runC[i]=true;
		cx[i]=sx;cy[i]=sy;
		sp[i]=speedy;deg[i]=degree;
	}
	public double DEG(double x,double y)
	{
		
		double d=Math.atan2(x, y);
		double degs=Math.toDegrees(d);
		System.out.println("x y "+x+" "+y);
		System.out.println("d "+d);
		System.out.println("degs "+degs);
		if(x>=-1&&x<=1&&y<0)
			degs=180;
		else if(x>=-1&&x<=1&&y>0)
			degs=0;
		else if(y>=-1&&y<=1&&x<0)
			degs=90;
		else if(y>=-1&&y<=1&&x>0)
			degs=270;
		
		else if(x<0&&y<0)
			degs=Math.abs(degs);
		else if(x<0&&y>0)
			degs=Math.abs(degs);
		else if(x>0&&y>0)
			degs=-Math.abs(degs);
		else if(x>0&&y<0)
		{
			degs=-Math.abs(degs);
			
		}
		System.out.println("final degs "+degs);
		
		return degs;
	}
	public void newDegree(double d,int i,double x,double y)
	{
		double c1=0;
		 double h=0;
		 h=d+180;
		 System.out.println("h1 "+h);
		 if(h>=360)
			 h=h-360;
		 System.out.println("h2 "+h);
		 deg[i]=Math.abs(deg[i]);
		 if(d<=360)
			 d=360+d;
		 else if(d>360)
			 d=d-360;
		 
		 if(deg[i]<=d) {
			 System.out.println("i "+i);
			 System.out.println("d2 "+d);
			 System.out.println("deg2 "+deg[i]);
			 c1=d-deg[i];
			 deg[i]=h+c1;
			 System.out.println("c11 "+c1);
			 System.out.println("dgei1 "+deg[i]);
			 
			 
		 }
		 else if(deg[i]>d)
		 {
			 System.out.println("i "+i);
			 System.out.println("d2 "+d);
			 System.out.println("deg2 "+deg[i]);
			 c1=deg[i]-d;
			 deg[i]=h-c1;
			 System.out.println("c12 "+c1);
			 System.out.println("dgei2 "+deg[i]);
			 
		 }
		 int ri=(int)deg[i]/360;
		 if(deg[i]<0)
		 {
			 if(x>0&&y<0) {
				 deg[i]=360+deg[i];
				 deg[i]=Math.abs(deg[i]);}
			 if(x<0&&y>0) {
				 deg[i]=360+deg[i];
				 deg[i]=Math.abs(deg[i]);}
			 else 
				 deg[i]=Math.abs(deg[i]);
		 }
		 else if(ri>0)
			 deg[i]=deg[i]-360*ri;
			 System.out.println("new degree "+deg[i]);
	}
	public double motionX(int i)
	{
		double newdeg=deg[i];
		double rad=Math.toRadians(newdeg);
		double x=Math.sin(rad)*sp[i];
		
		if(newdeg==0||newdeg==180)
			x=0;
		else if(newdeg==90)
			x=x;
		else if(newdeg==270)
			x=x;
		
	    if(newdeg<90&&newdeg>0)
			x=x;
		else if(newdeg>90&&newdeg<180)	
			x=x;
		else if(newdeg>180&&newdeg<270)	
			x=x;
		else if(newdeg>270&&newdeg<360)	
			x=x;
		return x;
	}
	public double motionY(int i)
	{
		double newdeg=deg[i];
		double rad=Math.toRadians(newdeg);
		double y=Math.cos(rad)*sp[i];
		
		if(newdeg==0||newdeg==360)
			y=-y;
		else if(newdeg==90||newdeg==270)
			y=0;
		else if(newdeg==180)
			y=-y;
		
		if(newdeg<90&&newdeg>0)
			y=-y;
		else if(newdeg>90&&newdeg<180)	
			y=-y;
		else if(newdeg>180&&newdeg<270)	
			y=-y;
		else if(newdeg>270&&newdeg<360)	
			y=-y;
		
		return y;
	}
	
	public int checkcolliR(int ci)
	{
		int colli=-1;
		for(int i=0;i<R.length;i++)
		{
			colliArea[ci] = Shape.intersect(R[i], C[ci]);
    		if (colliArea[ci].getBoundsInParent().getWidth()>0)
			 {
				System.out.println("col");
				colli=i;
			    break;
			 }
		}
		return colli;
	}
	
	public int checkcolliC(int ci)
	{
		int colli=-1;
		for(int i=0;i<C.length;i++)
		{
			if(i!=ci)
			{
				colliArea[ci] = Shape.intersect(C[i], C[ci]);
	    		if (colliArea[ci].getBoundsInParent().getWidth()>0)
				 {
					System.out.println("col C");
					colli=i;
				    break;
				 }
			}
			
		}
		return colli;
	}
	
	public int checkleftR(int current,int ci)
	{
		colliArea[ci]= Shape.intersect(R[current], C[ci]);
		if (colliArea[ci].getBoundsInParent().getWidth()<=0)
		 {
			System.out.println("left");
			current=-1;
		 }	
		return current;
	}
	
	public int checkleftC(int current,int ci)
	{
		colliArea[ci]= Shape.intersect(C[current], C[ci]);
		if (colliArea[ci].getBoundsInParent().getWidth()<=0)
		 {
			System.out.println("left");
			current=-1;
		 }	
		return current;
	}
	
}
