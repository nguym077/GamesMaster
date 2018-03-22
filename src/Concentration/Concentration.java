package Concentration;

import javafx.stage.*;

import java.util.Random;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Concentration extends Application {

    private int pair = 32;  //32 pair in this game
    private int total = pair * 2;
    private int firstNum = 0;
    private int secondNum = 0;
    private int firstNumIndex = -1;
    private int secondNumIndex = -1;
    private boolean beAble = true;
    private Button bt[] = new Button[total];  //create button array
    private int num[] = new int[total];
    private boolean one = false;
    private boolean player1=true;
    private boolean player2=false;
    private int player1s=0;
    private int player2s=0;
    private boolean winer=false;
    private Timeline delayForCheck;
    private Label label1,p1s,p2s,win;
   
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        
        
        root.setStyle("-fx-background-color: #F0591E;");
        Scene scene = new Scene(root);
        

        //this loop will assign the number from 100 to the button
        for (int i = 0; i < pair; i++) {
            num[i] = i + 100;
            num[pair + i] = i + 100;
        }


        Random random = new Random(); //get random method
        //this loop will make the number random placed on the button
        for (int i = 0; i < total; i++)//shuffle the character in the name array
        {
            int c = random.nextInt(total);
            int med = num[i];
            num[i] = num[c];
            num[c] = med;
        }

        //this loop assign the size to each button
        for (int i = 0; i < total; i++) {
            bt[i] = new Button("      ");
        }

        //this loop will find the button when click
        for (int i = 0; i < total; i++) {

            final Button myButton = bt[i];

            myButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    String a = myButton.getText();
                    System.out.println(a);
                    Button se = (Button) e.getSource();
                    System.out.println(se);
                    for (int i = 0; i < total; i++) {
                        if (bt[i] == se&&bt[i].getText()=="      ") {
                        	boolean check=bt[i].getText().isEmpty();
                        	System.out.println("ck "+check);
                            if (beAble == true) {
                                if (one == false) {
                                    one = true;
                                    System.out.println(i);
                                    bt[i].setText(String.valueOf(num[i]));
                                    firstNum = num[i];
                                    firstNumIndex = i;
                                } else if (one == true) {
                                    one = false;
                                    System.out.println(i);
                                    bt[i].setText(String.valueOf(num[i]));
                                    secondNum = num[i];
                                    secondNumIndex = i;

                                    delayForCheck.play(); //after two button show up, will check if match
                                    beAble = false;
                                }
                            }
                        }
                    }
                }
            });


            delayForCheck = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            	
                @Override
                public void handle(ActionEvent event) {
                	boolean match=false;
                    //if two number match, take them off
                    if (firstNum == secondNum) {

                        System.out.println("match" + " " + firstNum + " " + "secondNum");
                        bt[firstNumIndex].setVisible(false);
                        bt[secondNumIndex].setVisible(false);
                        match=true;
                    }
                    //if not match clean the number
                    else {
                        bt[firstNumIndex].setText("      ");
                        bt[secondNumIndex].setText("      ");
                    }
                    if(player1==true&&player2==false)
                    {
                    	if(match==true)
                    	{
                    		player1s++;
                    	}
                    	String s1=String.valueOf(player1s);
                    	p1s.setText(" "+s1);
                    	player1=false;
                    	player2=true;
                    	label1.setText("Player2 Turn");
                    }
                    else if(player1==false&&player2==true)
                    {
                    	if(match==true)
                    	{
                    		player2s++;
                    	}
                    	String s2=String.valueOf(player2s);
                    	p2s.setText(" "+s2);
                    	player1=true;
                    	player2=false;
                    	label1.setText("Player1 Turn");
                    }
                    if(player1s==32||player2s==32)
                    {
                    	winer=true;
                    	if(player1s==32)
                    	{
                    		win.setText("Player1 win");
                    	}
                    	else if(player2s==32)
                    	{
                    		win.setText("Player2 win");
                    	}
                    }
                    if(winer!=true)
                    {	
                    	beAble = true;
                    }
                }
            }));

            delayForCheck.setCycleCount(1);

            delayForCheck.stop();

        }


        int index = 0;
        //this loop will add button to the root stage
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                root.add(bt[index], i, j);
                index++;
            }
        }
        label1 = new Label();
        label1.setText("Player1 Turn");
        root.add(label1,9,0);
        
        
        Label p1 = new Label();
        p1.setText("Player1 Score");
        root.add(p1,9,2);
        p1s = new Label();
        p1s.setText(" 0");
        root.add(p1s,9,3);
        
        Label p2 = new Label();
        p2.setText("Player2 Score");
        root.add(p2,9,4);
        p2s = new Label();
        p2s.setText(" 0");
        root.add(p2s,9,5);
        
        win = new Label();
        win.setText("Game Running");
        root.add(win,9,7);
        
        
        
        primaryStage.setTitle("Concentration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
