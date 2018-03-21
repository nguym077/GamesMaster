package Chess;

import java.util.List;
import java.util.ArrayList;

public class Chess {

    private ChessPiece[][] chessboard = {
            {new ChessPiece(ChessPieceType.knight, 2), new ChessPiece(ChessPieceType.bishop, 2), new ChessPiece(ChessPieceType.queen, 2), new ChessPiece(ChessPieceType.king, 2), new ChessPiece(ChessPieceType.bishop, 2), new ChessPiece(ChessPieceType.knight, 2)},
            {new ChessPiece(ChessPieceType.pawn, 2) , new ChessPiece(ChessPieceType.pawn,2), new ChessPiece(ChessPieceType.pawn, 2), new ChessPiece(ChessPieceType.pawn, 2), new ChessPiece(ChessPieceType.pawn, 2), new ChessPiece(ChessPieceType.pawn, 2)},
            {new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0)},
            {new ChessPiece(ChessPieceType.empty,0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0)},
            {new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1)},
            {new ChessPiece(ChessPieceType.knight, 1), new ChessPiece(ChessPieceType.bishop, 1), new ChessPiece(ChessPieceType.queen, 1), new ChessPiece(ChessPieceType.king, 1), new ChessPiece(ChessPieceType.bishop, 1), new ChessPiece(ChessPieceType.knight, 1)}
    };

    private int mCurrentPlayer = 1;

    public Chess(){
        /*
        do{
            List<ChessMove> possiblemoves = GetPossibleMoves();
            GetThreatenedPositions(possiblemoves);
            possiblemoves = GetCurrentPlayerMoves(possiblemoves);
            BoardPosition pos = new BoardPosition(1,1);
            GetMovesForPosition(possiblemoves, pos);
            ChessMove move = possiblemoves.get(0);
            ApplyMove(move);
        }while(CheckForBothKings());
        */
    }

    public List<ChessMove> GetPossibleMoves(){
        List<ChessMove> moves = new ArrayList<>();
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
            }
        }
        return moves;
    }

    public List<ChessMove> GetCurrentPlayerMoves(List<ChessMove> moves){
        List<ChessMove> currentplayermoves = new ArrayList<>();
        if(!IsCheck(moves)) {
            for (ChessMove move : moves) {
                if (move.getPlayerMove() == getCurrentPlayer()) {
                    currentplayermoves.add(move);
                }
            }
        }
        else
            System.out.print("Your King is in Check");
            for (ChessMove move : moves) {
                if (move.getPlayerMove() == mCurrentPlayer && GetPieceAtPosition(move.StartPosition).getPieceType() == ChessPieceType.king) {
                    currentplayermoves.add(move);
                }
            }
        return currentplayermoves;
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

    public void ApplyMove(ChessMove m){
        m.Player = getCurrentPlayer();
        SetPieceAtPosition(m.EndPosition, GetPieceAtPosition(m.StartPosition));
        SetStartToEmpty(m.StartPosition);
        mCurrentPlayer = -mCurrentPlayer;
    }

    public List<BoardPosition> GetThreatenedPositions(List<ChessMove> moves){
        List<BoardPosition> threatenedpositions = new ArrayList<>();
        for(ChessMove move: moves){
            if(move.Player != getCurrentPlayer()){
                threatenedpositions.add(move.EndPosition);
            }
        }
        return threatenedpositions;
    }

    public ChessPiece GetPieceAtPosition(BoardPosition pos) {
        return chessboard[pos.getRow()][pos.getCol()];
    }

    private BoardPosition GetPositionOfKing(int player){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(GetPieceAtPosition(new BoardPosition(i, j)).getPieceType() == ChessPieceType.king && chessboard[i][j].getPlayer() == player){
                    return new BoardPosition(i, j);
                }
            }
        }
        return null;
    }

    private List<ChessMove> PawnMoves(BoardPosition pos){
        List<ChessMove> moves = new ArrayList<>();
        //if(pos.getRow() + 1 < 5) {
        if(GetPieceAtPosition(pos).getPlayer() == 1) {
            if (PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol()))) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() + 1, pos.getCol())));
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1), 1) ) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() + 1, pos.getCol())));
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1), 1) ) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() + 1, pos.getCol())));
            }
        }
        else{
            if (PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol()))) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() - 1, pos.getCol())));
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), 2)) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)));
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), 2)) {
                moves.add(new ChessMove(pos, new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)));
            }
        }
        /*
        }
        else {
            if (PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol()))) {

                PawnPromotion(new BoardPosition(pos.getRow() + 1, pos.getCol()), ChessPieceType.king);
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))) {
                PawnPromotion(new BoardPosition(pos.getRow() + 1, pos.getCol()), ChessPieceType.king);
            }
            if (PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))) {
                PawnPromotion(new BoardPosition(pos.getRow() + 1, pos.getCol()), ChessPieceType.king);
            }
        }
        */
        return moves;
    }

    private List<ChessMove> KnightMoves(BoardPosition pos) {
        List<ChessMove> moves = new ArrayList<>();
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer())|| PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol() + 1))
                && Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol() + 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() + 1) ));
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer())|| PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol() - 1))
                && Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol() - 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() - 1) ));
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 2), GetPieceAtPosition(pos).getPlayer())|| PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 2))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() + 2))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() + 2) ));
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 2), GetPieceAtPosition(pos).getPlayer())|| PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() - 2))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() - 2))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() - 2) ));
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer())|| PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() + 1) ));
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer())|| PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() - 1) ));
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer())|| PositionIsEmpty(new BoardPosition(pos.getRow() - 2, pos.getCol() + 1))
                && Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol() + 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol() + 1) ));
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer())|| PositionIsEmpty(new BoardPosition(pos.getRow() -2, pos.getCol() - 1))
                && Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol() - 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol() - 1) ));
        }
        return moves;
    }

    private List<ChessMove> BishopMoves(BoardPosition pos){
        List<ChessMove> moves = new ArrayList<>();
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol() + 2), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol() + 2))
                && Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol() + 2)) && PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))) {
            moves.add( new ChessMove( new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() + 2)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol() - 2), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol() - 2))
                && Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol() - 2)) && PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() -1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() - 2)) );
        }
        if((PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer())||PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1)))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() + 1)) );
        }
        if((PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer())||PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1)))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() - 1)) );
        }
        if((PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer())||PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)) );
        }
        if((PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol()- 1)))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)) );
        }
        if((PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol() + 2), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() - 2, pos.getCol() + 2)))
                && Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol() + 2)) && PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol() + 2)) );
        }
        if((PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol() - 2), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() - 2, pos.getCol() - 2)))
                && Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol() - 2)) && PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol() - 2)) );
        }
        return moves;
    }

    private List<ChessMove> QueenMoves(BoardPosition pos){
        List<ChessMove> moves = new ArrayList<>();
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() + 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol() - 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol()), GetPieceAtPosition(pos).getPlayer())||PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol()))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol()))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 1, pos.getCol())) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() + 1))
                && Inbounds(new BoardPosition(pos.getRow(), pos.getCol() + 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow(), pos.getCol() + 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() - 1))
                && Inbounds(new BoardPosition(pos.getRow(), pos.getCol() - 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol() + 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol()), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol()))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol()))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 1, pos.getCol())) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 2, pos.getCol()), GetPieceAtPosition(pos).getPlayer())||PositionIsEmpty(new BoardPosition(pos.getRow() + 2, pos.getCol()))
                && Inbounds(new BoardPosition(pos.getRow() + 2, pos.getCol())) && PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol()))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() + 2, pos.getCol())) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() + 2), GetPieceAtPosition(pos).getPlayer())||PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() + 2))
                && Inbounds(new BoardPosition(pos.getRow(), pos.getCol() + 2)) && PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() + 1))) {
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow(), pos.getCol() + 2)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() - 2), GetPieceAtPosition(pos).getPlayer())||PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() - 2))
                && Inbounds(new BoardPosition(pos.getRow(), pos.getCol() - 2)) && PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() - 1))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow(), pos.getCol() - 2)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 2, pos.getCol()), GetPieceAtPosition(pos).getPlayer())||PositionIsEmpty(new BoardPosition(pos.getRow() - 2, pos.getCol()))
                && Inbounds(new BoardPosition(pos.getRow() - 2, pos.getCol())) && PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol()))){
            moves.add( new ChessMove(new BoardPosition(pos.getRow(), pos.getCol()), new BoardPosition(pos.getRow() - 2, pos.getCol())) );
        }
        return moves;
    }

    private List<ChessMove> KingMoves(BoardPosition pos){
        List<ChessMove> chessmoves = new ArrayList<>();
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() + 1))) {
            chessmoves.add( new ChessMove(pos, new BoardPosition(pos.getRow() + 1, pos.getCol() + 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol() - 1))){
            chessmoves.add( new ChessMove(pos, new BoardPosition(pos.getRow() + 1, pos.getCol() - 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() + 1, pos.getCol()), GetPieceAtPosition(pos).getPlayer())||PositionIsEmpty(new BoardPosition(pos.getRow() + 1, pos.getCol()))
                && Inbounds(new BoardPosition(pos.getRow() + 1, pos.getCol()))){
            chessmoves.add( new ChessMove(pos, new BoardPosition(pos.getRow() + 1, pos.getCol())) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() + 1))
                && Inbounds(new BoardPosition(pos.getRow(), pos.getCol() + 1))){
            chessmoves.add( new ChessMove(pos, new BoardPosition(pos.getRow(), pos.getCol() + 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow(), pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow(), pos.getCol() - 1))
                && Inbounds(new BoardPosition(pos.getRow(), pos.getCol() - 1))){
            chessmoves.add( new ChessMove(pos, new BoardPosition(pos.getRow() + 2, pos.getCol() + 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() + 1))){
            chessmoves.add( new ChessMove(pos, new BoardPosition(pos.getRow() - 1, pos.getCol() + 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol() - 1))){
            chessmoves.add( new ChessMove(pos, new BoardPosition(pos.getRow() - 1, pos.getCol() - 1)) );
        }
        if(PositionIsEnemy(new BoardPosition(pos.getRow() - 1, pos.getCol()), GetPieceAtPosition(pos).getPlayer()) || PositionIsEmpty(new BoardPosition(pos.getRow() - 1, pos.getCol()))
                && Inbounds(new BoardPosition(pos.getRow() - 1, pos.getCol()))){
            chessmoves.add( new ChessMove(pos, new BoardPosition(pos.getRow() - 1, pos.getCol())) );
        }
        return chessmoves;
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

    //finish this
    private boolean IsCheck(List<ChessMove> moves){
        /*
        for(BoardPosition : moves) {

            if (GetPositionOfKing(getCurrentPlayer()) == GetThreatenedPositions(move)) {
                return true;
            }
        }
        */
        return false;
    }

    private boolean Inbounds(BoardPosition pos){
        return pos.getCol() >= 0 && pos.getCol() < 6 & pos.getRow() >= 0 && pos.getRow() < 6;
    }

    private boolean PositionIsEnemy(BoardPosition pos, int player){
        return chessboard[pos.getRow()][pos.getCol()].getPlayer() != player && chessboard[pos.getRow()][pos.getCol()].getPlayer() != 0;
    }

    private boolean PositionIsEmpty(BoardPosition pos){
        return chessboard[pos.getRow()][pos.getCol()].getPlayer() == 0;
    }

    private void SetPieceAtPosition(BoardPosition pos, ChessPiece piece){
        chessboard[pos.getRow()][pos.getCol()] = new ChessPiece(piece.getPieceType(), piece.getPlayer());
    }

    private void SetStartToEmpty(BoardPosition pos){
        chessboard[pos.getRow()][pos.getCol()] = new ChessPiece(ChessPieceType.empty, 0);
    }

    private int getCurrentPlayer(){
        return mCurrentPlayer == 1 ? 1 : 2;
    }

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
}