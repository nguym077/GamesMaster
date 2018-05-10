package tank;

import java.util.Random;
import java.util.Stack;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

class Maze extends Tank implements imageUi{
	public void setMaze(double x, double y,int index)
	{
		
		double startx=x+40;
		   double starty=y+80;
		   Random rand = new Random();
		   int wallIndex=0;
		  /*
		   int startmx=startx-20;
		   int startmy=starty-20;
	      Path path1 = new Path(); 
	      
	      MoveTo moveTo1 = new MoveTo(0+startmx, 0+startmy); 
	      path1.getElements().add(moveTo1);
	      
	      //create the wall
		  LineTo o1 = new LineTo(320+startmx, 0+startmy);  
		  path1.getElements().add(o1);
	   	  
	   	  LineTo o2 = new LineTo(320+startmx, 320+startmy);  
	   	  path1.getElements().add(o2);
	 	  
	 	  LineTo o3 = new LineTo(0+startmx, 320+startmy);
	 	  
	 	  path1.getElements().add(o3);
		  
		  LineTo o4 = new LineTo(0+startmx, 0+startmy);  
		  path1.getElements().add(o4);
	      
		  */
		  //create the path 
		  int mazeI=index;
		  //Path path = new Path(); 
		  mazePath[mazeI]=new Path();
		  mazePath[0].setVisible(false);
		   mazePath[mazeI].setStroke(Color.LIGHTGRAY);
		  
		  mazePath[mazeI].setStrokeWidth(5);
	      //this double array will mark the map with 1
	      //if a path create it will mark as 0
		  MoveTo moveTo = new MoveTo(startx, starty); 
	      mazePath[mazeI].getElements().add(moveTo);
	      int wayX=19,wayY=9;
	      int [][] way=new int[wayX][wayY];
	      for(int i=0;i<wayX;i++)
	      {
	      	for(int j=0;j<wayY;j++)
	      	{
	      		way[i][j]=0;
	      	}
	      }
	      
	      for(int i=0;i<8;i++)
	      {
	      	for(int j=0;j<8;j++)
	      	{
	      		//System.out.println("x:"+i+" y:"+j+way[i][j]);
	      	}
	      }
	   
	      //the initial path of index is 0,0
	      //the end path of index is 7,7
	      way[0][0]=1;
	      
	      Stack st = new Stack();
	      
	      st.push(0);
	      int xi=0;
		  int yi=0;
		  
	     
	    	  boolean running=true;
	    	  while(running)
	    	  {
	    		  int countTotal=1;
	    		  boolean reachend=false;
	    		  boolean check=false;
	    			int mark1=0,mark2=0,mark3=0,mark4=0;
	    			//System.out.println("startx:"+startx+"starty:"+starty);
	    	        while(check==false)
	    	        {
	    	        	
	    	        	int  dir = rand.nextInt(4) + 1;
	    	        	switch(dir)
	    	        	{
	    		        	case 1:
	    		        	{
	    		        		mark1=1;
	    		        		 int ytry=yi-1;
	    		        		 if(ytry<0||way[xi][ytry]!=0);
	    		        		 else
	    		        		 {
	    		        			 check=true;
	    		        			 yi=yi-1;
	    		        			 way[xi][yi]=1;
	    		        			 for(int i=0;i<6;i++)
	    		        			 {
	    		        				 wall[wallIndex].setX(startx);
		    		        			 wall[wallIndex].setY(starty-60+i*10);
		    		        			 wallRec[wallIndex].setX(startx);
		    		        			 wallRec[wallIndex].setY(starty-60+i*10);
		    		        			 wallIndex++; 
	    		        			 }
	    		        			 
	    		        			 //System.out.println("add x y "+xi+" "+yi);
	    		        			 LineTo line1 = new LineTo(startx, starty=starty-60);  
	    		        	      	 mazePath[mazeI].getElements().add(line1);
	    		        	      	 countTotal++;
	    		        		 }
	    		        			 
	    		        	}
	    		        	break;
	    		        	case 2:
	    		        	{
	    		        		mark2=1;
	    		        		int xtry=xi+1;
	    		        		 if(xtry>wayX-1||way[xtry][yi]!=0);
	    		        		 else
	    		        		 {
	    		        			 check=true;
	    		        			 xi=xi+1;
	    		        			 way[xi][yi]=2;
	    		        			 for(int i=0;i<6;i++)
	    		        			 {
	    		        				 wall[wallIndex].setX(startx+60-i*10);
		    		        			 wall[wallIndex].setY(starty);
		    		        			 wallRec[wallIndex].setX(startx+60-i*10);
		    		        			 wallRec[wallIndex].setY(starty);
		    		        			 wallIndex++; 
	    		        			 }
	    		        			 //System.out.println("add x y "+xi+" "+yi);
	    		        			 LineTo line1 = new LineTo(startx=startx+60,starty);  
	    		        	      	 mazePath[mazeI].getElements().add(line1);
	    		        	      	countTotal++;
	    		        		 }
	    		        	}
	    		        	break;
	    		        	case 3:
	    		        	{
	    		        		mark3=1;
	    		        		int ytry=yi+1;
	    		        		 if(ytry>wayY-1||way[xi][ytry]!=0);
	    		        		 else
	    		        		 {
	    		        			 check=true;
	    		        			 yi=yi+1;
	    		        			 way[xi][yi]=3;
	    		        			 for(int i=0;i<6;i++)
	    		        			 {
	    		        				 wall[wallIndex].setX(startx);
		    		        			 wall[wallIndex].setY(starty+60-i*10);
		    		        			 wallRec[wallIndex].setX(startx);
		    		        			 wallRec[wallIndex].setY(starty+60-i*10);
		    		        			 wallIndex++; 
	    		        			 }
	    		        			 //System.out.println("add x y "+xi+" "+yi);
	    		        			 LineTo line1 = new LineTo(startx,starty=starty+60);  
	    		        	      	 mazePath[mazeI].getElements().add(line1);
	    		        	      	countTotal++;
	    		        		 }
	    		        	}
	    		        	break;
	    		        	case 4:
	    		        	{
	    		        		mark4=1;
	    		        		int xtry=xi-1;
	    		        		 if(xtry<0||way[xtry][yi]!=0);
	    		        		 else
	    		        		 {
	    		        			 check=true;
	    		        			 xi=xi-1;
	    		        			 way[xi][yi]=4;
	    		        			 for(int i=0;i<6;i++)
	    		        			 {
	    		        				 wall[wallIndex].setX(startx-60+i*10);
		    		        			 wall[wallIndex].setY(starty);
		    		        			 wallRec[wallIndex].setX(startx-60+i*10);
		    		        			 wallRec[wallIndex].setY(starty);
		    		        			 wallIndex++; 
	    		        			 }
	    		        			 //System.out.println("add x y "+xi+" "+yi);
	    		        			 LineTo line1 = new LineTo(startx=startx-60,starty);  
	    		        	      	 mazePath[mazeI].getElements().add(line1);
	    		        	      	countTotal++;
	    		        		 }
	    		        	}
	    		        	break;
	    	        	}
	    	        	//System.out.println("xist:"+startx+"yist:"+starty+" random "+dir);
	    	        	if(mark1==1&&mark2==1&&mark3==1&&mark4==1)
	    	        	{
	    	        		if(st.empty())
	    	        		{
	    	        			check=true;
	    	        		}
	    	        		else
	    	        		{
	    	        			int newxy=(Integer)st.pop();
	    		        		int newx=newxy/10;
	    		        		int newy=newxy%10;
	    		        		xi=newx-1;
	    		        		yi=newy-1;
	    		        		startx=(xi*60)+60;
	    		        		starty=(yi*60)+60;
	    		        		//System.out.println("newx: "+newx+" newy: "+newy);
	    		        		//System.out.println("newxc: "+startx+" newyc: "+starty);
	    		        		MoveTo moveTo2 = new MoveTo(startx,starty); 
	    		        	    mazePath[mazeI].getElements().add(moveTo2);
	    		        	    if(newx==0&&newy==0)
	    		        	    {
	    		        	    	check=true;running=false;
	    		        	    }
	    		        	    mark1=0;mark2=0;mark3=0;mark4=0;
	    	        		}
	    	        		
	    	        	}
	    	        }
	    	        
	    	        //System.out.println();
	    	        if(check==true)
	    	        {
	    	        	int xy=(xi+1)*10+(yi+1);
	    	        	st.push(xy);
	    	        	if(xy==wayX*wayY)
	    	        	{
	    	        		reachend=true;
	    	        	}
	    	        	
	    	        	if(reachend==true&&countTotal>=10)
	    	        	{  
	    	        		running=false;
	    	        	}
	    	        	//System.out.println("push: "+xy+" xi:"+xi+" yi"+yi);
	    	        }
	    	        
	    	        
	    	    	 
	    	  }
	   for(int i=0;i<wall.length;i++)
	   {
		   for(int j=0;j<path.length-4;j++)
		   {
			   if (wall[i].getBoundsInLocal().intersects(path[j].getBoundsInLocal()))
			   {
				   wall[i].setX(-50);
				   wall[i].setY(-50);
				   wallRec[i].setX(-50);
				   wallRec[i].setY(-50);
			   }
		   }
		   
	   }
	}
	
}
