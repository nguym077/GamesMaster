package Chess;

public class ChessPiece {
    private ChessPieceType PieceType;
    private int Player;

    public ChessPiece(ChessPieceType type, int player){
        PieceType = type;
        Player = player;
    }

    public ChessPieceType getPieceType(){
        return PieceType;
    }

    public int getPlayer(){
        return Player;
    }
}
