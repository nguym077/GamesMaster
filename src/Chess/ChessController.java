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

    @Override
    public void initialize(URL url, ResourceBundle res) {

    }
    //

    //<editor-fold>
    public void handleBlackPawn1(ActionEvent e) {
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

    public void handleBlackPawn2(ActionEvent e) {
        int row = GridPane.getRowIndex(blackPawn2);
        int col = GridPane.getColumnIndex(blackPawn2);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackPawn3(ActionEvent e) {
        int row = GridPane.getRowIndex(blackPawn3);
        int col = GridPane.getColumnIndex(blackPawn3);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackPawn4(ActionEvent e) {
        int row = GridPane.getRowIndex(blackPawn4);
        int col = GridPane.getColumnIndex(blackPawn4);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackPawn5(ActionEvent e) {
        int row = GridPane.getRowIndex(blackPawn5);
        int col = GridPane.getColumnIndex(blackPawn5);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackPawn6(ActionEvent e) {
        int row =GridPane.getRowIndex(blackPawn6);
        int col = GridPane.getColumnIndex(blackPawn6);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackKnight1(ActionEvent e) {
            System.out.println("Hello");
            GridPane.setRowIndex(blackKnight1, 2);
    }

    public void handleBlackBishop1(ActionEvent e) {
        int row =GridPane.getRowIndex(blackBishop1);
        int col = GridPane.getColumnIndex(blackBishop1);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackQueen(ActionEvent e) {
        int row =GridPane.getRowIndex(blackQueen);
        int col = GridPane.getColumnIndex(blackQueen);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves) {
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackKing(ActionEvent e) {
        int row = GridPane.getRowIndex(blackKing);
        int col = GridPane.getColumnIndex(blackKing);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackBishop2(ActionEvent e) {
        int row =GridPane.getRowIndex(blackBishop2);
        int col = GridPane.getColumnIndex(blackBishop2);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleBlackKnight2(ActionEvent e) {
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



    //<editor-fold>
    @FXML
    public void handleWhitePawn1(ActionEvent e){
        System.out.println("Hello");
    }

    public void handleWhitePawn2(ActionEvent e){
        int row =GridPane.getRowIndex(whitePawn2);
        int col = GridPane.getColumnIndex(whitePawn2);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhitePawn3(ActionEvent e){
        int row =GridPane.getRowIndex(whitePawn3);
        int col = GridPane.getColumnIndex(whitePawn3);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhitePawn4(ActionEvent e){
        int row =GridPane.getRowIndex(whitePawn4);
        int col = GridPane.getColumnIndex(whitePawn4);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhitePawn5(ActionEvent e){
        int row =GridPane.getRowIndex(whitePawn5);
        int col = GridPane.getColumnIndex(whitePawn5);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhitePawn6(ActionEvent e){
        int row =GridPane.getRowIndex(whitePawn6);
        int col = GridPane.getColumnIndex(whitePawn6);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhiteKnight1(ActionEvent e){
        int row =GridPane.getRowIndex(whiteKnight1);
        int col = GridPane.getColumnIndex(whiteKnight1);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhiteBishop1(ActionEvent e){
        int row =GridPane.getRowIndex(whiteBishop1);
        int col = GridPane.getColumnIndex(whiteBishop1);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhiteQueen(ActionEvent e){
        int row =GridPane.getRowIndex(whiteQueen);
        int col = GridPane.getColumnIndex(whiteQueen);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhiteKing(ActionEvent e){
        int row =GridPane.getRowIndex(whiteKing);
        int col = GridPane.getColumnIndex(whiteKing);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhiteBishop2(ActionEvent e){
        int row =GridPane.getRowIndex(whiteBishop2);
        int col = GridPane.getColumnIndex(whiteBishop2);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();
        }
    }

    public void handleWhiteKnight2(ActionEvent e){
        int row =GridPane.getRowIndex(whiteKnight2);
        int col = GridPane.getColumnIndex(whiteKnight2);
        BoardPosition position = new BoardPosition(row, col);
        List<ChessMove> moves = mChess.GetMovesForPosition(possiblemoves, position);
        for(ChessMove move :moves){
            //highlight square
            move.getEndPosition();

        }
    }

    //</editor-fold>

}