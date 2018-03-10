package Concentration;

import java.util.Random;

public class Concentration {
    private int numberOfRows = 8;
    private int numberOfColumns = 8;
    private int[][] board = new int[numberOfRows][numberOfColumns];

    private Random rand = new Random();

    public Concentration() {
        //this loop will assign the number from 100 to the button
        int start = 100;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns - 1; j += 2) {
                board[i][j] = i + start;
                board[i][j + 1] = i + start;
                start++;
            }
        }

        // shuffles board
        for (int i = 0; i < 500; i++) {
            int x1 = rand.nextInt(numberOfRows);
            int y1 = rand.nextInt(numberOfColumns);

            int x2 = rand.nextInt(numberOfRows);
            int y2 = rand.nextInt(numberOfColumns);

            int temp = board[x1][y1];
            board[x1][y1] = board[x2][y2];
            board[x2][y2] = temp;
        }

    }

    public int[][] getBoard() {
        return board;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public static void main(String[] args) {
        Concentration test = new Concentration();
        int[][] testarray = test.getBoard();

        for (int i = 0; i < test.numberOfRows; i++) {
            for (int j = 0; j < test.getNumberOfColumns(); j++) {
                System.out.print(testarray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
