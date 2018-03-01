import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.util.Stack;

public class Maze extends Application {
    Path path = new Path();
    Path path1 = new Path();

    @Override
    public void start(Stage stage) {

        //the starting point of path
        int startx = 40;
        int starty = 40;

        int startmx = startx - 20;
        int startmy = starty - 20;
        Random rand = new Random();
        MoveTo moveTo1 = new MoveTo(0 + startmx, 0 + startmy);
        path1.getElements().add(moveTo1);

        //create the wall
        LineTo o1 = new LineTo(320 + startmx, 0 + startmy);
        path1.getElements().add(o1);

        LineTo o2 = new LineTo(320 + startmx, 320 + startmy);
        path1.getElements().add(o2);

        LineTo o3 = new LineTo(0 + startmx, 320 + startmy);

        path1.getElements().add(o3);

        LineTo o4 = new LineTo(0 + startmx, 0 + startmy);
        path1.getElements().add(o4);


        //create the path
        path.setStroke(Color.LIGHTGRAY);

        path.setStrokeWidth(20);
        //this double array will mark the Maze with 1
        //if a path create it will mark as 0
        MoveTo moveTo = new MoveTo(startx, starty);
        path.getElements().add(moveTo);

        int[][] way = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                way[i][j] = 1;
            }
        }
        //the initial path of index is 0,0
        //the end path of index is 7,7
        way[0][0] = 0;

        Stack st = new Stack();

        st.push(0);
        int xi = 0;
        int yi = 0;


        boolean running = true;
        while (running) {
            int countTotal = 1;
            boolean reachend = false;
            boolean check = false;
            int mark1 = 0, mark2 = 0, mark3 = 0, mark4 = 0;
            System.out.println("startx:" + startx + "starty:" + starty);
            while (check == false) {

                int dir = rand.nextInt(4) + 1;
                switch (dir) {
                    case 1: {
                        mark1 = 1;
                        int ytry = yi - 1;
                        if (ytry < 0 || way[xi][ytry] == 0) ;
                        else {
                            check = true;
                            yi = yi - 1;
                            way[xi][yi] = 0;
                            LineTo line1 = new LineTo(startx, starty = starty - 40);
                            path.getElements().add(line1);
                            countTotal++;
                        }

                    }
                    break;
                    case 2: {
                        mark2 = 1;
                        int xtry = xi + 1;
                        if (xtry > 7 || way[xtry][yi] == 0) ;
                        else {
                            check = true;
                            xi = xi + 1;
                            way[xi][yi] = 0;
                            LineTo line1 = new LineTo(startx = startx + 40, starty);
                            path.getElements().add(line1);
                            countTotal++;
                        }
                    }
                    break;
                    case 3: {
                        mark3 = 1;
                        int ytry = yi + 1;
                        if (ytry > 7 || way[xi][ytry] == 0) ;
                        else {
                            check = true;
                            yi = yi + 1;
                            way[xi][yi] = 0;
                            LineTo line1 = new LineTo(startx, starty = starty + 40);
                            path.getElements().add(line1);
                            countTotal++;
                        }
                    }
                    break;
                    case 4: {
                        mark4 = 1;
                        int xtry = xi - 1;
                        if (xtry < 0 || way[xtry][yi] == 0) ;
                        else {
                            check = true;
                            xi = xi - 1;
                            way[xi][yi] = 0;
                            LineTo line1 = new LineTo(startx = startx - 40, starty);
                            path.getElements().add(line1);
                            countTotal++;
                        }
                    }
                    break;
                }
                System.out.println("xist:" + startx + " yist:" + starty + " random " + dir);
                if (mark1 == 1 && mark2 == 1 && mark3 == 1 && mark4 == 1) {
                    if (st.empty()) {
                        check = true;
                    } else {
                        int newxy = (Integer) st.pop();
                        int newx = newxy / 10;
                        int newy = newxy % 10;
                        xi = newx - 1;
                        yi = newy - 1;
                        startx = (xi * 40) + 40;
                        starty = (yi * 40) + 40;
                        System.out.println("newx: " + newx + " newy: " + newy);
                        System.out.println("newxc: " + startx + " newyc: " + starty);
                        MoveTo moveTo2 = new MoveTo(startx, starty);
                        path.getElements().add(moveTo2);
                        if (newx == 0 && newy == 0) {
                            check = true;
                            running = false;
                        }
                        mark1 = 0;
                        mark2 = 0;
                        mark3 = 0;
                        mark4 = 0;
                    }

                }
            }

            System.out.println();
            if (check == true) {
                int xy = (xi + 1) * 10 + (yi + 1);
                st.push(xy);
                if (xy == 88) {
                    reachend = true;
                }

                if (reachend == true && countTotal >= 30) {
                    running = false;
                }
                System.out.println("push: " + xy + " xi:" + xi + " yi" + yi);
            }


        }

	    	 
	      
	     
			
		  
		  /*
	      for(int i=0;i<300;i+=20)
	      {
	    	  
	    	  LineTo line1 = new LineTo(i, i+10);  
	    	  path.getElements().add(line1);
	    	 // MoveTo moveTo1 = new MoveTo(i-10, i-5); 
	         // path.getElements().add(moveTo1);
	      }
	      */
        //Creating 1st line


        //Creating a Group object
        Group root = new Group();
        root.getChildren().add(path1);
        root.getChildren().add(path);

        //Creating a scene object

        Scene scene = new Scene(root, 600, 600);

        //Setting title to the Stage
        stage.setTitle("Drawing an arc through a path");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public Path getPath() {
        return path;
    }

    public Path getPath1() {
        return path1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}