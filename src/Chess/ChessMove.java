package Chess;

public class ChessMove {

    public BoardPosition StartPosition;
    public BoardPosition EndPosition;
    public int Player;

    public ChessMove(BoardPosition start, BoardPosition end){
        StartPosition = start;
        EndPosition = end;
    }

    public BoardPosition getStartPosition(){
        return StartPosition;
    }

    public BoardPosition getEndPosition(){
        return EndPosition;
    }

    public void setPlayerMove(int player){
        Player = player;
    }

    public int getPlayerMove(){
        return Player;
    }
}
