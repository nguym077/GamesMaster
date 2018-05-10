package tank;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class TankMap {

    private Cell[][] map = new Cell[16][16];
    int rowSize = 16;
    int colSize = 16;

    public void mapSetup(){
        //fillOuterPerimeter();
        fillInternalMap();
    }

    private void fillOuterPerimeter(){
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (row == 0 || row == 15 || col == 0 || col == 15) {
                    map[row][col].fillCell();
                }
            }
        }
    }

    private void fillInternalMap(){
        fillRandomCellLocations();
        markPurgeAndCreate();
        purgeAndCreate();
    }

    private void fillRandomCellLocations(){
        Set<Integer> randomnumbers = new HashSet<>();
        Random RNG = new Random();
        int halfofinternalcells = ((rowSize-1)*(colSize-1))/2;
        while (randomnumbers.size() != halfofinternalcells) {
            randomnumbers.add(RNG.nextInt((rowSize-1)*(colSize-1)));
        }
        for(int number: randomnumbers){
            map[(number+colSize+1)/rowSize][(number+colSize+1)%colSize].fillCell();
        }
    }

    private void markPurgeAndCreate(){
        for(int row = 1; row < rowSize-2; row++){
            for(int col = 1; col < colSize-2; col++){
                if(map[row][col].isFilled()) {
                    if(checkSurroundingCells(row, col) < 3){
                        map[row][col].markPurge();
                    }
                }
                if(map[row][col].isEmpty()){
                    if(checkSurroundingCells(row, col) > 5){
                        map[row][col].markCreate();
                    }
                }
            }
        }
    }

    private int checkSurroundingCells(int row, int col){
        int counter = 0;
        if(map[row - 1][col - 1].isFilled()){
            counter++;
        }
        if(map[row - 1][col].isFilled()){
            counter++;
        }
        if(map[row - 1][col + 1].isFilled()){
            counter++;
        }
        if(map[row][col - 1].isFilled()){
            counter++;
        }
        if(map[row][col + 1].isFilled()){
            counter++;
        }
        if(map[row + 1][col - 1].isFilled()){
            counter++;
        }
        if(map[row + 1][col].isFilled()){
            counter++;
        }
        if(map[row + 1][col + 1].isFilled()){
            counter++;
        }
        return counter;
    }

    private void purgeAndCreate(){
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < colSize; col++) {
                if (map[row][col].isPurgeMarked()){
                    map[row][col].unfillCell();
                }
                if(map[row][col].isCreateMarked()){
                    map[row][col].fillCell();
                }
            }
        }
    }

    public Cell[][] retrieveMap(){
        return map;
    }
}
