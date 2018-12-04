package circle;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class fireball implements PublicVar{
	Circle circle;
	Rectangle r1,r2;
	Collison newCollison= new Collison();
	data newData=new data();
	public void init()
	{
		for(int i=0;i<runC.length;i++)
		{
			runC[i]=false;
		}
		
	    //set up fireball
	    for(int i=0;i<C.length;i++)
	    {
	    	C[i] = new Circle();
			
			C[i].setRadius(6);
			C[i].setStroke(Color.BLACK);
			C[i].setFill(Color.BLACK);
			C[i].setVisible(false);
			group.getChildren().add(C[i]);
	    }
	    for(int i=0;i<fireball_1_idle_L.length;i++)
	    {
	    	group.getChildren().add(fireball_1_idle_L[i]);
	    	group.getChildren().add(fireball_1_idle_R[i]);
	    }
	    
	    //initial fireball animation
	    for(int i=0;i<fireBall.length;i++)
	    {
	    	setCanmia(i);
	    }
	  
	    
	    
	}
	
	
	public void setCanmia(int index)
	{
		fireBall[index]=new AnimationTimer()
	    {
    		
    		int count=0,count2=0;
	    	 boolean wait=false;
	    	
	    	 int current=-1,countHit=0;
	    	 boolean next=true;
    		 boolean coliC=false,coliR=false,coliBunny=false,coliHero=false;
    		 double collix,colliy,disx,disy,nextD;
    		 ImageView lastView=fireball_1_idle_R[0];
    		 int imagenum=0;
    		public void handle(long now)
   	         {
    			if(runC[index]==true)
   	    			 count++;
   	    		 else if(runC[index]==false)
   	    		 {
   	    			 count=0;
   	    			 count2=0;
   	    		 }
   	    		 if(count>1)
   	    		 {
   	    			 count=0;
   	    			 count2++;
   	    			 
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
   		    				//current=checkleftR(current,index);
   		    				current=newCollison.checkleftPath(current,index);
   		    				if(current==-1)
   		    					coliR=false;
   		    			 }
   		    			 
   		    			 
   		    		 }
   		    		 
   		    		 //if fireball not collison anything check collison
		    		 if(current==-1)
		    		 {
		    			 next=true;
		    			 //current=checkcolliR(index);  //collisoon with rectangel
		    			 if(count2>=10)
		    			 {
		    				 count2=10;
		    				 coliBunny=newCollison.ballColliBunny(index);
			    			 if(coliBunny)
			    				 countHit=11;
		    			 }
		    			 if(coliBunny==false)
		    			 {
		    				 coliHero=newCollison.ballColliHero(index);
		    				 if(coliHero)
		    				 {
		    					 newData.reduceHealth();
		    					 countHit=11;
		    				 }
			    				 
		    			 }
		    			 if(coliHero==false)
		    			 {
		    				 current=newCollison.checkcolliPath(index); 
			    			 if(current!=-1)
			    			 {
			    				 coliR=true;
			    				 countHit++;
			    			 } 
		    			 }
		    			 
		    				
		    			 
		    			 
		    			 
		    		 }
		    			if(imagenum>=5)
	   		    			 imagenum=0;
	   		    		 lastView.setVisible(false);
	   		    		 lastView=idle(index,imagenum);
	   		    		 imagenum++;
	   		    		 
		    		 if(countHit>10)
		    		 {
		    			 countHit=0;
		    			 stopC(index);
		    			 lastView.setVisible(false);
		    		 }
		    			 
		    		 //if find collison , find fireball new degree
		    		 else if(current!=-1&&next)
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
   		    				 
   							 //System.out.println("collix "+collix+" colliy "+colliy);
   							 //System.out.println("centerx "+cx[index]+" centery "+cy[index]);
   							 
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
	
	
	public void setC(int i,double x,double y)
	{
		C[i].setCenterX(x);
		C[i].setCenterY(y);
	}
	//put fireball on the map, fireball index, startx, starty, speedy, degree
	public void startC(int i,double sx,double sy,double speedy,double degree)
	{
		//C[i].setVisible(true);
		runC[i]=true;
		cx[i]=sx;cy[i]=sy;
		sp[i]=speedy;deg[i]=degree;
	}
	
	int balli=0;
	public void startCtoHero(double sx,double sy,double speedy,double disx,double disy)
	{
		if(balli>=10)
			balli=0;
		//C[balli].setVisible(true);
		runC[balli]=true;
		cx[balli]=sx;cy[balli]=sy;
		
		
		double nextD=Math.abs(DEGi(disx,disy));
		
		sp[balli]=speedy;
		
		if(disx==0&&disy>0)
			deg[balli]=0;
		else if(disx==0&&disy<0)
			deg[balli]=180;
		else if(disy==0&&disx<0)
			deg[balli]=90;
		else if(disy==0&&disx>0)
			deg[balli]=270;
		
		else if(disx<0&&disy>0)
			deg[balli]=90-nextD;
		else if(disx<0&&disy<0)
			deg[balli]=nextD+90;
		else if(disx>0&&disy<0)
			deg[balli]=180+(90-nextD);
		else if(disx>0&&disy>0)
			deg[balli]=270+nextD;
		
		
		System.out.println("f deg "+deg[balli]);
		
		balli++;
	}
	public void stopC(int i)
	{
		
		C[i].setVisible(false);
		runC[i]=false;
		C[i].setCenterX(-1000);
  		C[i].setCenterY(-1000);
		//sp[balli]=speedy;deg[balli]=degree;
	}
	public void offFireball()
	{
		for(int i=0;i<C.length;i++)
		{
			C[i].setCenterX(-1000);
			C[i].setCenterY(-1000);
			C[i].setVisible(false);
			runC[i]=false;
		}
		for(int i=0;i<fireball_1_idle_L.length;i++)
		{
			fireball_1_idle_L[i].setVisible(false);
		}
	}
	public double DEG(double x,double y)
	{
		
		double d=Math.atan2(x, y);
		double degs=Math.toDegrees(d);
		//System.out.println("x y "+x+" "+y);
		//System.out.println("d "+d);
		//System.out.println("degs "+degs);
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
		//System.out.println("final degs "+degs);
		
		return degs;
	}
	public double DEGi(double x,double y)
	{
		
		double d=Math.atan2(x, y);
		double degs=Math.toDegrees(d);
		degs=Math.abs(degs)-90;
		
		//System.out.println("final degs "+degs);
		
		return degs;
	}
	public double newDegree(double d,int i,double x,double y)
	{
		double c1=0;
		 double h=0;
		 h=d+180;
		 
		 if(h>=360)
			 h=h-360;
	
		 deg[i]=Math.abs(deg[i]);
		 if(d<=360)
			 d=360+d;
		 else if(d>360)
			 d=d-360;
		 
		 if(deg[i]<=d) {
			 c1=d-deg[i];
			 deg[i]=h+c1;
			 
			 
		 }
		 else if(deg[i]>d)
		 {
			 c1=deg[i]-d;
			 deg[i]=h-c1;
			 
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
		 
		 return deg[i];
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
	
	
	public ImageView idle(int index,int i)
	{
		int newID=index*5+i;
		ImageView view=new ImageView();
		{
			fireball_1_idle_L[newID].setVisible(true);
			fireball_1_idle_L[newID].setX(cx[index]);
			fireball_1_idle_L[newID].setY(cy[index]);
			fireball_1_idle_L[newID].setRotate(deg[index]+90);
			view=fireball_1_idle_L[newID];
			}
		
		return view;	
	}
	
	
	
	
	
}

