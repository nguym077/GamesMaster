package Chess;

public class BoardPosition {
    public int Row;
    public int Col;

    public BoardPosition(int row, int col){
        Row = row;
        Col = col;
    }

    public int getRow(){
        return Row;
    }

    public int getCol(){
        return Col;
    }
}
