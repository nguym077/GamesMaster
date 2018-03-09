public class Chess {

    private ChessPiece[][] chessboard = {
            {new ChessPiece(ChessPieceType.knight, 2), new ChessPiece(ChessPieceType.bishop, 2), new ChessPiece(ChessPieceType.queen, 2), new ChessPiece(ChessPieceType.king, 2), new ChessPiece(ChessPieceType.bishop, 2), new ChessPiece(ChessPieceType.knight, 2)},
            {new ChessPiece(ChessPieceType.pawn, 2) , new ChessPiece(ChessPieceType.pawn,2), new ChessPiece(ChessPieceType.pawn, 2), new ChessPiece(ChessPieceType.pawn, 2), new ChessPiece(ChessPieceType.pawn, 2), new ChessPiece(ChessPieceType.pawn, 2)},
            {new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0)},
            {new ChessPiece(ChessPieceType.empty,0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0), new ChessPiece(ChessPieceType.empty, 0)},
            {new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1), new ChessPiece(ChessPieceType.pawn, 1)},
            {new ChessPiece(ChessPieceType.knight, 1), new ChessPiece(ChessPieceType.bishop, 1), new ChessPiece(ChessPieceType.queen, 1), new ChessPiece(ChessPieceType.king, 1), new ChessPiece(ChessPieceType.bishop, 1), new ChessPiece(ChessPieceType.knight, 1)} };

    private int mCurrentPlayer = 1;

    public Chess(){
    }

    public void ApplyMove(){
        if(DetectCheck()){

        }

        mCurrentPlayer--;
    }

    public void GetPossibleMoves(){
        getCurrentPlayer();
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(GetPieceAtPosition(i, j).getPlayer() == mCurrentPlayer){
                    if(GetPieceAtPosition(i, j).getPieceType() == ChessPieceType.pawn){
                       PawnMoves(i, j);
                    }
                    else if(GetPieceAtPosition(i, j).getPieceType() == ChessPieceType.knight){
                        KnightMoves(i, j);
                    }
                    else if(GetPieceAtPosition(i, j).getPieceType() == ChessPieceType.bishop){
                        BishopMoves(i, j);
                    }
                    else if(GetPieceAtPosition(i, j).getPieceType() == ChessPieceType.queen){
                        QueenMoves(i, j);
                    }
                    else if(GetPieceAtPosition(i, j).getPieceType() == ChessPieceType.king){
                        KingMoves(i, j);
                    }
                }
            }
        }
    }

    private ChessPiece GetPieceAtPosition(int row, int col) {
        return chessboard[row][col];
    }

    private int GetRowOfKing(){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(GetPieceAtPosition(i, j).getPieceType() == ChessPieceType.king){
                    return i;
                }
            }
        }
        return 0;
    }

    private int GetColOfKing(){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(GetPieceAtPosition(i, j).getPieceType() == ChessPieceType.king){
                    return j;
                }
            }
        }
        return 0;
    }

    private void PawnMoves(int row, int col){
        if(PositionIsEmpty(row + 1, col)){
            //show moves on board
        }
        if(PositionIsEnemy(row + 1, col - 1)){
            //show moves on board
        }
        if(PositionIsEnemy(row + 1, col + 1)){
            //show move on board
        }
    }

    private void KnightMoves(int row, int col) {
        if((PositionIsEnemy(row + 2, col + 1)||PositionIsEmpty(row + 2, col + 1)) && Inbounds(row + 2, col + 1)) {

        }
        if((PositionIsEnemy(row + 2, col - 1)||PositionIsEmpty(row + 2, col - 1)) && Inbounds(row + 2, col - 1)){

        }
        if((PositionIsEnemy(row + 1, col + 2)||PositionIsEmpty(row + 1, col + 2)) && Inbounds(row + 1, col + 2)){

        }
        if((PositionIsEnemy(row + 1, col - 2)||PositionIsEmpty(row + 1, col - 2)) && Inbounds(row + 1, col - 2)){

        }
        if((PositionIsEnemy(row - 1, col + 2)||PositionIsEmpty(row - 1, col + 2)) && Inbounds(row - 1, col + 2)){

        }
        if((PositionIsEnemy(row - 1, col - 2)||PositionIsEmpty(row - 1, col - 2)) && Inbounds(row - 1, col - 2)){

        }
        if((PositionIsEnemy(row - 2, col + 1)||PositionIsEmpty(row - 2, col + 1)) && Inbounds(row - 2, col + 1)){

        }
        if((PositionIsEnemy(row - 2, col - 1)||PositionIsEmpty(row - 2, col - 1)) && Inbounds(row - 2, col - 1)){

        }
    }

    private void BishopMoves(int row, int col){
        if((PositionIsEnemy(row + 2, col + 2)||PositionIsEmpty(row + 2, col + 2)) && Inbounds(row + 2, col + 2)) {

        }
        if((PositionIsEnemy(row + 2, col - 2)||PositionIsEmpty(row + 2, col - 2)) && Inbounds(row + 2, col - 2)){

        }
        if((PositionIsEnemy(row + 1, col + 1)||PositionIsEmpty(row + 1, col + 1)) && Inbounds(row + 1, col + 1)){

        }
        if((PositionIsEnemy(row + 1, col - 1)||PositionIsEmpty(row + 1, col - 1)) && Inbounds(row + 1, col - 1)){

        }
        if((PositionIsEnemy(row - 1, col + 1)||PositionIsEmpty(row - 1, col + 1)) && Inbounds(row - 1, col + 1)){

        }
        if((PositionIsEnemy(row - 1, col - 1)||PositionIsEmpty(row - 1, col - 1)) && Inbounds(row - 1, col - 1)){

        }
        if((PositionIsEnemy(row - 2, col + 2)||PositionIsEmpty(row - 2, col + 2)) && Inbounds(row - 2, col + 2)){

        }
        if((PositionIsEnemy(row - 2, col - 2)||PositionIsEmpty(row - 2, col - 2)) && Inbounds(row - 2, col - 2)){

        }
    }

    private void QueenMoves(int row, int col){
        if((PositionIsEnemy(row + 2, col + 1)||PositionIsEmpty(row + 2, col + 1)) && Inbounds(row + 2, col + 1)) {

        }
        if((PositionIsEnemy(row + 2, col - 1)||PositionIsEmpty(row + 2, col - 1)) && Inbounds(row + 2, col - 1)){

        }
        if((PositionIsEnemy(row + 1, col + 2)||PositionIsEmpty(row + 1, col + 2)) && Inbounds(row + 1, col + 2)){

        }
        if((PositionIsEnemy(row + 1, col - 2)||PositionIsEmpty(row + 1, col - 2)) && Inbounds(row + 1, col - 2)){

        }
        if((PositionIsEnemy(row - 1, col + 2)||PositionIsEmpty(row - 1, col + 2)) && Inbounds(row - 1, col + 2)){

        }
        if((PositionIsEnemy(row - 1, col - 2)||PositionIsEmpty(row - 1, col - 2)) && Inbounds(row - 1, col - 2)){

        }
        if((PositionIsEnemy(row - 2, col + 1)||PositionIsEmpty(row - 2, col + 1)) && Inbounds(row - 2, col + 1)){

        }
        if((PositionIsEnemy(row - 2, col - 1)||PositionIsEmpty(row - 2, col - 1)) && Inbounds(row - 2, col - 1)){

        }
    }

    private void KingMoves(int row, int col){
        if((PositionIsEnemy(row + 1, col + 1)||PositionIsEmpty(row + 1, col + 1)) && Inbounds(row + 1, col + 1)) {

        }
        if((PositionIsEnemy(row + 1, col - 1)||PositionIsEmpty(row + 1, col - 1)) && Inbounds(row + 1, col - 1)){

        }
        if((PositionIsEnemy(row + 1, col)||PositionIsEmpty(row + 1, col)) && Inbounds(row + 1, col)){

        }
        if((PositionIsEnemy(row, col + 1)||PositionIsEmpty(row, col - 1)) && Inbounds(row, col - 1)){

        }
        if((PositionIsEnemy(row, col - 1)||PositionIsEmpty(row, col + 1)) && Inbounds(row, col + 1)){

        }
        if((PositionIsEnemy(row - 1, col + 1)||PositionIsEmpty(row - 1, col + 1)) && Inbounds(row - 1, col + 1)){

        }
        if((PositionIsEnemy(row - 1, col - 1)||PositionIsEmpty(row - 1, col - 1)) && Inbounds(row - 1, col - 1)){

        }
        if((PositionIsEnemy(row - 1, col)||PositionIsEmpty(row - 1, col)) && Inbounds(row - 1, col)){

        }
    }

    public void PawnPromotion(int row, int col, ChessPiece newPiece){
        chessboard[row][col] = newPiece;
    }

    private boolean DetectCheck(){
        int x = GetRowOfKing();
        int y = GetColOfKing();
        return false;
    }

    private boolean Inbounds(int col, int row){
        return col > 0 && col < 6 & row > 0 && row < 6;
    }

    private boolean PositionIsEnemy(int row, int col){
        return chessboard[row][col].getPlayer() == 1;
    }

    private boolean PositionIsEmpty(int row, int col){
        return chessboard[row][col].getPlayer() == 0;
    }

    public int getCurrentPlayer(){
        return mCurrentPlayer == 1 ? 1 : 2;
    }
}