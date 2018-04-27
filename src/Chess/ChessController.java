package Chess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.awt.event.MouseEvent;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ChessController implements Initializable{
    @FXML
    private ImageView whitePawn1;

    @FXML
    private ImageView whitePawn2;

    @FXML
    private ImageView whitePawn3;

    @FXML
    private ImageView whitePawn4;

    @FXML
    private ImageView whitePawn5;

    @FXML
    private ImageView whitePawn6;

    @FXML
    private ImageView whiteKnight1;

    @FXML
    private ImageView whiteBishop1;

    @FXML
    private ImageView whiteQueen;

    @FXML
    private ImageView whiteKing;

    @FXML
    private ImageView whiteBishop2;

    @FXML
    private ImageView whiteKnight2;

    @FXML
    private ImageView blackPawn1;

    @FXML
    private ImageView blackPawn2;

    @FXML
    private ImageView blackPawn3;

    @FXML
    private ImageView blackPawn4;

    @FXML
    private ImageView blackPawn5;

    @FXML
    private ImageView blackPawn6;

    @FXML
    private ImageView blackKnight1;

    @FXML
    private ImageView blackBishop1;

    @FXML
    private ImageView blackQueen;

    @FXML
    private ImageView blackKing;

    @FXML
    private ImageView blackBishop2;

    @FXML
    private ImageView blackKnight2;

    @FXML
    private GridPane chessGrid;

    private Chess mChess = new Chess();
    private int newRowPosition = -1;
    private int newColPosition = -1;

    @Override
    public void initialize(URL url, ResourceBundle res) {
        if(GridPane.getColumnIndex(whitePawn1) == null) {
            GridPane.setColumnIndex(whitePawn1, 0);
        }
        if(GridPane.getColumnIndex(whiteKnight1) == null) {
            GridPane.setColumnIndex(whiteKnight1, 0);
        }
        if(GridPane.getColumnIndex(blackPawn1) == null){
            GridPane.setColumnIndex(blackPawn1, 0);
        }
        if(GridPane.getRowIndex(blackKnight1) == null){
            GridPane.setRowIndex(blackKnight1, 0);
        }
        if(GridPane.getColumnIndex(blackKnight1) == null){
            GridPane.setColumnIndex(blackKnight1, 0);
        }
        if(GridPane.getRowIndex(blackBishop1) == null){
            GridPane.setRowIndex(blackBishop1, 0);
        }
        if(GridPane.getRowIndex(blackQueen) == null){
            GridPane.setRowIndex(blackQueen, 0);
        }
        if(GridPane.getRowIndex(blackKing) == null){
            GridPane.setRowIndex(blackKing, 0);
        }
        if(GridPane.getRowIndex(blackBishop2) == null){
            GridPane.setRowIndex(blackBishop2, 0);
        }
        if(GridPane.getRowIndex(blackKnight2) == null){
            GridPane.setRowIndex(blackKnight2, 0);
        }
    }

    // White Chess Piece Handlers
    public void handleWhitePawn1(){
        moves(whitePawn1, 1);
    }

    public void handleWhitePawn2(){
        moves(whitePawn2, 1);
    }

    public void handleWhitePawn3(){
        moves(whitePawn3, 1);
    }

    public void handleWhitePawn4(){
        moves(whitePawn4, 1);
    }

    public void handleWhitePawn5(){
        moves(whitePawn5, 1);
    }

    public void handleWhitePawn6(){
        moves(whitePawn6, 1);
    }

    public void handleWhiteKnight1(){
        moves(whiteKnight1, 1);
    }

    public void handleWhiteBishop1(){
        moves(whiteBishop1, 1);
    }

    public void handleWhiteQueen(){
        moves(whiteQueen, 1);
    }

    public void handleWhiteKing(){
        moves(whiteKing, 1);
    }

    public void handleWhiteBishop2(){
        moves(whiteBishop2, 1);
    }

    public void handleWhiteKnight2(){
        moves(whiteKnight2, 1);
    }

    // Black Chess Piece Handlers
    public void handleBlackPawn1() {
        moves(blackPawn1, 2);
    }

    public void handleBlackPawn2() {
        moves(blackPawn2, 2);
    }

    public void handleBlackPawn3() {
        moves(blackPawn3, 2);
    }

    public void handleBlackPawn4() {
        moves(blackPawn4, 2);
    }

    public void handleBlackPawn5() {
        moves(blackPawn5, 2);
    }

    public void handleBlackPawn6() {
        moves(blackPawn6, 2);
    }

    public void handleBlackKnight1() {
        moves(blackKnight1, 2);
    }

    public void handleBlackBishop1() {
        moves(blackBishop1, 2);
    }

    public void handleBlackQueen() {
        moves(blackQueen, 2);
    }

    public void handleBlackKing() {
        moves(blackKing, 2);
    }

    public void handleBlackBishop2() {
        moves(blackBishop2, 2);
    }

    public void handleBlackKnight2() {
        moves(blackKnight2, 2);
    }

    private void moves(ImageView image, int player){
        if(mChess.CheckForBothKings()){
            if(mChess.GetCurrentPlayer() == player) {
                if(mChess.IsCheck(mChess.GetPossibleMoves(), player)){
                    System.out.println("King is in check, cannot move that piece");
                } else if(mChess.GetPieceAtPosition(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image))).getPieceType() == ChessPieceType.pawn){
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image)));
                    if(moves.size() > 0) {
                        for (ChessMove move : moves) {
                            Region region = new Region();
                            region.setStyle("-fx-background-color: rgba(204, 255, 0, 0.3)");
                            region.setOnMouseClicked(e -> {
                                System.out.println("MOVE SELECTED.");
                                newRowPosition = move.EndPosition.getRow();
                                newColPosition = move.EndPosition.getCol();

                                System.out.println("row: "  + newRowPosition + ", col: " + newColPosition);

                                // updates chess move
                                GridPane.setRowIndex(image, newRowPosition);
                                GridPane.setColumnIndex(image, newColPosition);
                            });
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }

                        // why is this empty?
                        if (GridPane.getRowIndex(image) == 0 && mChess.GetPieceAtPosition(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image))).getPieceType() == ChessPieceType.pawn) {
                        }

                        mChess.SwitchPlayers();
                    } else{
                        System.out.println("That piece has no possible moves!");
                    }
                } else if(mChess.GetPieceAtPosition(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image))).getPieceType() == ChessPieceType.knight) {
                    List<ChessMove> moves = mChess.KnightMoves(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image)));
                    if (moves.size() > 0) {
                        for (ChessMove move : moves) {
                            Region region = new Region();
                            region.setStyle("-fx-background-color: rgba(204, 255, 0, 0.3)");
                            region.setOnMouseClicked(e -> {
                                System.out.println("MOVE SELECTED.");
                                newRowPosition = move.EndPosition.getRow();
                                newColPosition = move.EndPosition.getCol();

                                System.out.println("row: "  + newRowPosition + ", col: " + newColPosition);

                                // updates chess move
                                GridPane.setRowIndex(image, newRowPosition);
                                GridPane.setColumnIndex(image, newColPosition);
                            });
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }

                        mChess.SwitchPlayers();
                    } else {
                        System.out.println("That piece has no possible moves!");
                    }
                } else if(mChess.GetPieceAtPosition(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image))).getPieceType() == ChessPieceType.bishop) {
                    List<ChessMove> moves = mChess.BishopMoves(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image)));
                    if (moves.size() > 0) {
                        for (ChessMove move : moves) {
                            Region region = new Region();
                            region.setStyle("-fx-background-color: rgba(204, 255, 0, 0.3);");
                            region.setOnMouseClicked(e -> {
                                System.out.println("MOVE SELECTED.");
                                newRowPosition = move.EndPosition.getRow();
                                newColPosition = move.EndPosition.getCol();

                                System.out.println("row: "  + newRowPosition + ", col: " + newColPosition);

                                // updates chess move
                                GridPane.setRowIndex(image, newRowPosition);
                                GridPane.setColumnIndex(image, newColPosition);
                            });
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }

                        mChess.SwitchPlayers();
                    } else {
                        System.out.println("That piece has no possible moves!");
                    }
                } else if(mChess.GetPieceAtPosition(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image))).getPieceType() == ChessPieceType.queen) {
                    List<ChessMove> moves = mChess.QueenMoves(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image)));
                    if (moves.size() > 0) {
                        for (ChessMove move : moves) {
                            Region region = new Region();
                            region.setStyle("-fx-background-color: rgba(204, 255, 0, 0.3)");
                            region.setOnMouseClicked(e -> {
                                System.out.println("MOVE SELECTED.");
                                newRowPosition = move.EndPosition.getRow();
                                newColPosition = move.EndPosition.getCol();

                                System.out.println("row: "  + newRowPosition + ", col: " + newColPosition);

                                // updates chess move
                                GridPane.setRowIndex(image, newRowPosition);
                                GridPane.setColumnIndex(image, newColPosition);
                            });
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }

                        mChess.SwitchPlayers();
                    } else {
                        System.out.println("That piece has no possible moves!");
                    }
                } else if(mChess.GetPieceAtPosition(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image))).getPieceType() == ChessPieceType.king) {
                    List<ChessMove> moves = mChess.QueenMoves(new BoardPosition(GridPane.getRowIndex(image), GridPane.getColumnIndex(image)));
                    if (moves.size() > 0) {
                        for (ChessMove move : moves) {
                            Region region = new Region();
                            region.setStyle("-fx-background-color: rgba(204, 255, 0, 0.3)");
                            region.setOnMouseClicked(e -> {
                                System.out.println("MOVE SELECTED.");
                                newRowPosition = move.EndPosition.getRow();
                                newColPosition = move.EndPosition.getCol();

                                System.out.println("row: "  + newRowPosition + ", col: " + newColPosition);

                                // updates chess move
                                GridPane.setRowIndex(image, newRowPosition);
                                GridPane.setColumnIndex(image, newColPosition);
                            });
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }


                        mChess.SwitchPlayers();
                    } else {
                        System.out.println("That piece has no possible moves!");
                    }
                }
            } else if(player == 1){
                System.out.println("It's Blacks Turn!");
            } else if (player == 2){
                System.out.println("It's Whites Turn!");
            }
        } else{
            System.out.println("Game is over");
        }
    }
}