package Chess;

import java.util.List;
import java.util.ArrayList;


public class Chess {
    //Constructor
    public Chess(){}

    //<editor-folder Global Variables>
    private ChessPiece[][] chessboard = {
            {new ChessPiece(ChessPieceType.knight, 2), new ChessPiece(ChessPieceType.bishop, 2), new ChessPiece(ChessPieceType.queen, 2), new ChessPiece(ChessPieceType.king, 2), new ChessPiece(ChessPieceType.bishop, 2), new ChessPiece(ChessPieceType.knight, 2)},
            {new ChessPiece(ChessPieceType.pawn, 2) , new ChessPiece(ChessPieceType.pawn,2), new ChessPiece(ChessPieceType.pawn, 2), new ChessPiece(ChessPieceType.pawn, 2), new ChessPiece(ChessPieceType.pawn, 2), new ChessPiece(ChessPieceType.pawn, 2)},
            {new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0),  new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0)},
            {new ChessPiece(ChessPieceType.empty,0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0)},
            {new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1)},
            {new ChessPiece(ChessPieceType.knight, 1), new ChessPiece(ChessPieceType.bishop, 1), new ChessPiece(ChessPieceType.queen, 1), new ChessPiece(ChessPieceType.king, 1), new ChessPiece(ChessPieceType.bishop, 1), new ChessPiece(ChessPieceType.knight, 1)}
    };

    private int mCurrentPlayer = 1;
    //</editor-folder>

    //<editor-folder Player Turn Functions>
    public int GetCurrentPlayer(){
        return mCurrentPlayer == 1 ? 1 : 2;
    }

    public void SwitchPlayers(){
        if(mCurrentPlayer == 2){
            mCurrentPlayer = 1;
        }
        else
            mCurrentPlayer = 2;
    }
    //</editor-folder>

    //<editor-folder Get Moves Functions>
    public List<ChessMove> GetPossibleMoves(){
        List<ChessMove> moves = new ArrayList<>();
        List<ChessMove> allmoves = new ArrayList<>();
        List<ChessMove> empty = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                BoardPosition pos = new BoardPosition(i, j);
                if(GetPieceAtPosition(pos).getPieceType() == ChessPieceType.pawn){
                    moves = PawnMoves(pos);
                }
                else if(GetPieceAtPosition(pos).getPieceType() == ChessPieceType.knight){
                    moves = KnightMoves(pos);
                }
                else if(GetPieceAtPosition(pos).getPieceType() == ChessPieceType.bishop){
                    moves = BishopMoves(pos);
                }
                else if(GetPieceAtPosition(pos).getPieceType() == ChessPieceType.queen){
                    moves = QueenMoves(pos);
                }
                else if(GetPieceAtPosition(pos).getPieceType() == ChessPieceType.king) {
                    moves = KingMoves(pos);
                }
                for(ChessMove move: moves){
                    allmoves.add(move);
                }
                moves = empty;
            }
        }
        return allmoves;
    }

    public List<ChessMove> GetMovesForPosition(List<ChessMove> moves, BoardPosition pos){
        List<ChessMove> movesforposition = new ArrayList<>();
        for(ChessMove move: moves){
            if(move.getStartPosition() == pos) {
                movesforposition.add(move);
            }
        }
        return movesforposition;
    }

    public List<BoardPosition> GetThreatenedPositions(){
        List<BoardPosition> threatenedpositions = new ArrayList<>();
        return threatenedpositions;
    }

    public ChessPiece GetPieceAtPosition(BoardPosition pos) {
        return chessboard[pos.getRow()][pos.getCol()];
    }

    public BoardPosition GetPositionOfKing(int player){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(GetPieceAtPosition(new BoardPosition(i, j)).getPieceType() == ChessPieceType.king && chessboard[i][j].getPlayer() == player){
                    return new BoardPosition(i, j);
                }
            }
        }
        return null;
    }

    public boolean IsCheck(List<ChessMove> moves, int player){
        for(ChessMove move: moves) {
            if (GetPositionOfKing(player).getRow() == move.EndPosition.getRow() && GetPositionOfKing(player).getCol() == move.EndPosition.getCol()) {
                return true;
            }
        }
        return false;
    }
    //</editor-folder>

    //<editor-folder Apply Move Functions>
    public void ApplyMove(ChessMove m){
        m.Player = GetCurrentPlayer();
        SetPieceAtPosition(m.EndPosition, GetPieceAtPosition(m.StartPosition));
        SetStartToEmpty(m.StartPosition);
    }

    private void SetPieceAtPosition(BoardPosition pos, ChessPiece piece){
        chessboard[pos.getRow()][pos.getCol()] = new ChessPiece(piece.getPieceType(), piece.getPlayer());
    }

    private void SetStartToEmpty(BoardPosition pos){
        chessboard[pos.getRow()][pos.getCol()] = new ChessPiece(ChessPieceType.empty, 0);
    }
    //</editor-folder>

    //<editor-folder Chess Piece Move Functions>
    public List<ChessMove> PawnMoves(BoardPosition pos){
        List<ChessMove> moves = new ArrayList<>();
        if(GetPieceAtPosition(pos).getPlayer() == 1) {
            if (PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol()))) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() - 1, pos.getCol())));
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), 2)) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)));
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), 2)) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)));
            }

        }
        else{
            if (PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol()))) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() + 1, pos.getCol())));
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1), 1)) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() + 1, pos.getCol() - 1)));
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1), 1)) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() + 1, pos.getCol() + 1)));
            }
        }
        return moves;
    }

    public List<ChessMove> KnightMoves(BoardPosition pos) {
        List<ChessMove> moves = new ArrayList<>();
        if(Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol() + 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol() + 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol() - 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol() - 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() - 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() + 2))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 2), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 2))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() + 2)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() - 2))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 2), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() - 2))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() - 2)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol() + 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol() + 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 2, pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol() + 1)));
            }
        }
        if (Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol() - 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol() - 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 2, pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol() - 1)));
            }
        }
        return moves;
    }

    public List<ChessMove> BishopMoves(BoardPosition pos){
        List<ChessMove> moves = new ArrayList<>();
        if(Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol() + 2)) ) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol() + 2), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol() + 2))
                    && PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() + 2)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol() - 2)) ) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol() - 2), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol() - 2))
                    && PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() - 2)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))) {
            if ((PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1)))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))) {
            if ((PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1)))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() - 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
            if ((PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
            if ((PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol() + 2)) ) {
            if ((PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol() + 2), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 2, pos.getCol() + 2)))
                    && PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol() + 2)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol() - 2))) {
            if ((PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol() - 2), 3 - GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 2, pos.getCol() - 2)))
                    && PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol() - 2)));
            }
        }
        return moves;
    }

    public List<ChessMove> QueenMoves(BoardPosition pos){
        List<ChessMove> moves = new ArrayList<>();
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))){
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() - 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol()))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol()), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol()))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol())));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow(), pos.getCol() + 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() + 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow(), pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow(), pos.getCol() - 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() - 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() - 1))
                    ) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol()))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol()), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol()))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol())));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol())) ) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol()), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol()))
                    && PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol()))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol())));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow(), pos.getCol() + 2)) ) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() + 2), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() + 2))
                    && PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow(), pos.getCol() + 2)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow(), pos.getCol() - 2))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() - 2), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() - 2))
                    && PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow(), pos.getCol() - 2)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol()))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol()), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 2, pos.getCol()))
                     && PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol()))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol())));
            }
        }
        return moves;
    }

    public List<ChessMove> KingMoves(BoardPosition pos){
        List<ChessMove> moves = new ArrayList<>();
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))){
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() - 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol()))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol()), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol()))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol())));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow(), pos.getCol() + 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() + 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow(), pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow(), pos.getCol() - 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() - 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() - 1))
                    ) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)));
            }
        }
        if(Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol()))) {
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol()), 3-GetPieceAtPosition(pos).getPlayer())
                    || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol()))) {
                moves.add(new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol())));
            }
        }
        return moves;
    }
    //finish this
    private void PawnPromotion(BoardPosition pos, ChessPieceType type){
        if(type == ChessPieceType.queen) {
            chessboard[pos.getRow()][pos.getCol()] = new ChessPiece(ChessPieceType.queen, mCurrentPlayer);
        }
        else if(type == ChessPieceType.bishop){
            chessboard[pos.getRow()][pos.getCol()] = new ChessPiece(ChessPieceType.bishop, mCurrentPlayer);
        }
        else
            chessboard[pos.getRow()][pos.getCol()] = new ChessPiece(ChessPieceType.knight, mCurrentPlayer);
    }
    //</editor-folder>

    //<editor-folder Validation Functions>
    public boolean CheckForBothKings(){
        boolean black = false;
        boolean white = false;
        for (int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(chessboard[i][j].getPieceType() == ChessPieceType.king && chessboard[i][j].getPlayer() == 1){
                    white = true;
                }
                if(chessboard[i][j].getPieceType() == ChessPieceType.king && chessboard[i][j].getPlayer() == 2){
                    black = true;
                }
            }
        }
        return black && white;
    }

    private boolean Inbounds(BoardPosition pos){
        return pos.getCol() >= 0 && pos.getCol() < 6 & pos.getRow() >= 0 && pos.getRow() < 6;
    }

    private boolean PositionIsEnemy(BoardPosition pos, int enemyplayer){
        if(Inbounds(pos)) {
            return chessboard[pos.getRow()][pos.getCol()].getPlayer() == enemyplayer;
        }
        return false;
    }

    private boolean PositionIsEmpty(BoardPosition pos){
        return chessboard[pos.getRow()][pos.getCol()].getPlayer() == 0;
    }
    //</editor-folder>
}