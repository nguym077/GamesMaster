import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Mancala {
	
	private int[] mancalaboard = {4,4,4,4,4,4,0,4,4,4,4,4,4,0};
	private int[] score = {0, 0};
	
	public Mancala(){
		int player = 0;
		int spaceselected = 0;
		boolean repeat = false;
		do{
			player = getCurrentPlayer(player);
			repeat = false;
			//get spaceselected
			while ( !( !checkIfSpaceSelectedIsEmpty(spaceselected) && checkIfSpaceSelectedWasOnPlayersSide(player, spaceselected) ) ){
				//validation
			}
			repeat = applyMove(player, spaceselected);
			if(repeat){
				continue;
			}
			player++;
		} while(!checkIfLeftSideIsEmpty() && !checkIfRightSideIsEmpty());
	}
	
	public int getCurrentPlayer(int player){
		return player == 0 ? 0 : 1;
	}
	
	public boolean checkIfSpaceSelectedIsEmpty(int boardNumber){
		if(mancalaboard[boardNumber] == 0){
			return true;
		}
		return false;
	}
	
	public boolean checkIfSpaceSelectedWasOnPlayersSide(int player, int boardNumber){
		if(player  == 0){
			if(boardNumber < 6 && boardNumber != 0){
				return true;
			}
			else {
				return false;
			}
		}
		else
			if(boardNumber > 6 && boardNumber < 13){
				return true;
			}
			else
				return false;
	}	
	
	public boolean checkIfParallelIsEmpty(int boardNumber){
		if(mancalaboard[Math.abs(boardNumber - 12)] > 0 && boardNumber != 6 && boardNumber != 13){
			return true;
		}
		return false;
	}
	
	public boolean applyMove(int player, int boardNumber){
		int i = boardNumber + 1;
		int end = boardNumber + mancalaboard[boardNumber];
		mancalaboard[boardNumber] = 0;
		while (i <= end) {
			if(player == 0){
				if(!(i == 13)){
					mancalaboard[i % 14] += 1;	
				}
			}
			else
				if(!(i == 6)){
					mancalaboard[i % 14] += 1;
				}
			i++;
		}
		collectParallelSpace(player, end);
		return false;
	}
	
	public void collectParallelSpace(int player, int spaceLanded){
		if ( !checkIfParallelIsEmpty(spaceLanded) && mancalaboard[spaceLanded] == 1) {
			if( player == 0 && (spaceLanded + mancalaboard[spaceLanded] < 7 ) && mancalaboard[spaceLanded] != 6 ){
				score[player] += mancalaboard[spaceLanded];
				score[player] += mancalaboard[Math.abs(spaceLanded - 12)];
				mancalaboard[spaceLanded] = 0;
				mancalaboard[Math.abs(spaceLanded - 12)] = 0;
			}
			if( player == 1 && (spaceLanded + mancalaboard[spaceLanded]) < 14 && (spaceLanded + mancalaboard[spaceLanded]) > 7 && mancalaboard[spaceLanded] != 13 ){
				score[player] += mancalaboard[spaceLanded];
				score[player] += mancalaboard[Math.abs(spaceLanded - 12)];
				mancalaboard[spaceLanded] = 0;
				mancalaboard[Math.abs(spaceLanded - 12)] = 0;
			}
		}
	}
	
	public boolean checkIfLeftSideIsEmpty(){
		for(int i = 0; i < 7; i++){
			if(mancalaboard[i] > 0 ){
				 return false;
			}
		}
		return true;
	}
	
	public boolean checkIfRightSideIsEmpty(){
		for(int i = 7; i < 13; i++){
			if(mancalaboard[i] > 0 ){
				 return false;
			}
		}
		return true;
	}
	
	public int[] getMancalaArray() {
        return mancalaboard;
    }
	
}
