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

    //<editor-fold Images>
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
    //</editor-fold>

    private Chess mChess = new Chess();
    private List<ChessMove> possiblemoves = null;
    private List<ImageView> Black = null;
    private List<ImageView> White;

    @Override
    public void initialize(URL url, ResourceBundle res) {
        /*
        Black.add(blackPawn1);
        Black.add(blackPawn2);
        Black.add(blackPawn3);
        Black.add(blackPawn4);
        Black.add(blackPawn5);
        Black.add(blackPawn6);
        Black.add(blackKnight1);
        Black.add(blackKnight2);
        Black.add(blackBishop1);
        Black.add(blackBishop2);
        Black.add(blackQueen);
        Black.add(blackKing);
        White.add(whitePawn1);
        White.add(whitePawn2);
        White.add(whitePawn3);
        White.add(whitePawn4);
        White.add(whitePawn5);
        White.add(whitePawn6);
        White.add(whiteKnight1);
        White.add(whiteKnight2);
        White.add(whiteBishop1);
        White.add(whiteBishop2);
        White.add(whiteQueen);
        White.add(whiteKing);
        */
    }
    //

    //<editor-fold>
    public void handleBlackPawn1() {
        if(false) {
            int row = GridPane.getRowIndex(blackPawn1);
            int col = GridPane.getColumnIndex(blackPawn1);
            BoardPosition position = new BoardPosition(row, col);
            List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
            for (ChessMove move : moves) {
                //highlight square
                move.getEndPosition();
            }
        }
        else {
            System.out.println("Hello");
            //Set all squares to unhighlighted
        }
    }

    public void handleBlackPawn2() {
        int row = GridPane.getRowIndex(blackPawn2);
        int col = GridPane.getColumnIndex(blackPawn2);

    }

    public void handleBlackPawn3() {
        int row = GridPane.getRowIndex(blackPawn3);
        int col = GridPane.getColumnIndex(blackPawn3);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackPawn4() {
        int row = GridPane.getRowIndex(blackPawn4);
        int col = GridPane.getColumnIndex(blackPawn4);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackPawn5() {
        int row = GridPane.getRowIndex(blackPawn5);
        int col = GridPane.getColumnIndex(blackPawn5);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackPawn6() {
        int row =GridPane.getRowIndex(blackPawn6);
        int col = GridPane.getColumnIndex(blackPawn6);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackKnight1() {
            System.out.println("Hello");
            GridPane.setRowIndex(blackKnight1, 2);
    }

    public void handleBlackBishop1() {
        int row =GridPane.getRowIndex(blackBishop1);
        int col = GridPane.getColumnIndex(blackBishop1);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackQueen() {
        int row =GridPane.getRowIndex(blackQueen);
        int col = GridPane.getColumnIndex(blackQueen);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves) {
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackKing() {
        int row = GridPane.getRowIndex(blackKing);
        int col = GridPane.getColumnIndex(blackKing);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackBishop2() {
        int row =GridPane.getRowIndex(blackBishop2);
        int col = GridPane.getColumnIndex(blackBishop2);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackKnight2() {
        int row =GridPane.getRowIndex(blackKnight2);
        int col = GridPane.getColumnIndex(blackKnight2);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }
    //</editor-fold>

        /*
        possiblemoves = mChess.GetPossibleMoves();
        possiblemoves = mChess.GetCurrentPlayerMoves(possiblemoves);
        possiblemoves = mChess.GetMovesForPosition(possiblemoves, new BoardPosition(row, col));
        */

    //<editor-fold>
    @FXML
    public void handleWhitePawn1(){
        int row = GridPane.getRowIndex(whitePawn1);
        int col = GridPane.getColumnIndex(whitePawn1);

        if (GridPane.getRowIndex(blackPawn3) == row - 1 && GridPane.getColumnIndex(blackPawn3) == col+1) {
            GridPane.setRowIndex(whitePawn2, row - 1);
            GridPane.setColumnIndex(whitePawn2, col + 1);
        } else if (GridPane.getRowIndex(blackPawn2) != row - 1 && GridPane.getColumnIndex(blackPawn2) == col) {
            GridPane.setRowIndex(whitePawn2, row - 1);
        }
    }

    public void handleWhitePawn2(){
        int row = GridPane.getRowIndex(whitePawn2);
        int col = GridPane.getColumnIndex(whitePawn2);
        /*
        if(GridPane.getRowIndex(blackPawn2) != row -1 && GridPane.getColumnIndex(blackPawn2) == col) {
            GridPane.setRowIndex(whitePawn2, row - 1);
        }
        */
        if (GridPane.getRowIndex(blackPawn3) == row - 1 && GridPane.getColumnIndex(blackPawn3) == col+1) {
            GridPane.setRowIndex(whitePawn2, row - 1);
            GridPane.setColumnIndex(whitePawn2, col + 1);
        } else if (GridPane.getRowIndex(blackPawn2) != row - 1 && GridPane.getColumnIndex(blackPawn2) == col) {
            GridPane.setRowIndex(whitePawn2, row - 1);
        }

    }

    public void handleWhitePawn3(){
        int row =GridPane.getRowIndex(whitePawn3);
        int col = GridPane.getColumnIndex(whitePawn3);
        if(GridPane.getRowIndex(blackPawn3) != row -1 && GridPane.getColumnIndex(blackPawn3) == col) {
            GridPane.setRowIndex(whitePawn3, row - 1);
        }
    }

    public void handleWhitePawn4(){
        int row =GridPane.getRowIndex(whitePawn4);
        int col = GridPane.getColumnIndex(whitePawn4);
        if(GridPane.getRowIndex(blackPawn4) != row -1 && GridPane.getColumnIndex(blackPawn4) == col) {
            GridPane.setRowIndex(whitePawn4, row - 1);
        }
    }

    public void handleWhitePawn5(){
        int row =GridPane.getRowIndex(whitePawn5);
        int col = GridPane.getColumnIndex(whitePawn5);
        if(GridPane.getRowIndex(blackPawn5) != row -1 && GridPane.getColumnIndex(blackPawn5) == col) {
            GridPane.setRowIndex(whitePawn5, row - 1);
        }
    }

    public void handleWhitePawn6(){
        int row =GridPane.getRowIndex(whitePawn6);
        int col = GridPane.getColumnIndex(whitePawn6);
        if(GridPane.getRowIndex(blackPawn6) != row -1 && GridPane.getColumnIndex(blackPawn6) == col) {
            GridPane.setRowIndex(whitePawn6, row - 1);
        }
    }

    public void handleWhiteKnight1(){
        int row =GridPane.getRowIndex(whiteKnight1);
        int col = GridPane.getColumnIndex(whiteKnight1);
        //GridPane.setRowIndex(whiteKnight1, row-2);
        GridPane.setColumnIndex(whiteKnight1,col+1);
    }

    public void handleWhiteBishop1(){
        int row = GridPane.getRowIndex(whiteBishop1);
        int col = GridPane.getColumnIndex(whiteBishop1);
        GridPane.setRowIndex(whiteBishop1, row-1);
        GridPane.setColumnIndex(whiteBishop1,col+1);
    }

    public void handleWhiteQueen(){
        int row = GridPane.getRowIndex(whiteQueen);
        int col = GridPane.getColumnIndex(whiteQueen);
        GridPane.setRowIndex(whiteQueen, row-2);
    }

    public void handleWhiteKing(){
        int row = GridPane.getRowIndex(whiteKing);
        int col = GridPane.getColumnIndex(whiteKing);
        GridPane.setRowIndex(whiteKing, row-1);
    }

    public void handleWhiteBishop2(){
        int row =GridPane.getRowIndex(whiteBishop2);
        int col = GridPane.getColumnIndex(whiteBishop2);
        GridPane.setRowIndex(whiteBishop2, row- 1);
        GridPane.setColumnIndex(whiteBishop2,col-1);
    }

    public void handleWhiteKnight2(){
        int row =GridPane.getRowIndex(whiteKnight2);
        int col = GridPane.getColumnIndex(whiteKnight2);
        GridPane.setRowIndex(whiteKnight2, row-2);
        GridPane.setColumnIndex(whiteKnight2,col-1);
    }

    //</editor-fold>

}