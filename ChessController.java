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

    //<editor-folder Global Variables>
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
    //</editor-folder>

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

    //<editor-fold White Chess Piece Handlers>
    public void handleWhitePawn1(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(whitePawn1), GridPane.getColumnIndex(whitePawn1)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhitePawn2(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(whitePawn2), GridPane.getColumnIndex(whitePawn2)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
        /*
        if(mChess.getCurrentPlayer() == 1) {
            int row = GridPane.getRowIndex(whitePawn2);
            int col = GridPane.getColumnIndex(whitePawn2);
            List<ChessMove> allmoves = mChess.GetPossibleMoves();
            possiblemoves = mChess.GetMovesForPosition(allmoves, new BoardPosition(row, col));
            for(ChessMove moves: possiblemoves){
                Region region = new Region();
                region.setStyle("-fx-background-color: black;");
                chessGrid.add(region, moves.EndPosition.getCol(), moves.EndPosition.getRow());
            }
            //Decide which move to make
            // GridPane.setRowIndex(whitePawn1, row - 1);

        }
        Region region = new Region();
        region.setStyle("-fx-background-color: black;");
        chessGrid.add(region, 3, 4);
        chessGrid.add(region, 2,3);
        if(mChess.getCurrentPlayer() == 1) {
            int row = GridPane.getRowIndex(whitePawn3);
            int col = GridPane.getColumnIndex(whitePawn3);
            List<ChessMove> allmoves = mChess.GetPossibleMoves();
            possiblemoves = mChess.GetMovesForPosition(allmoves, new BoardPosition(row, col));
        }
        if(mChess.CheckForBothKings()){
            if(mChess.GetCurrentPlayer() == 1){
                System.out.println("Player 1");
                mChess.SwitchPlayers();
            }
            else{
                System.out.println("Player 2");
                mChess.SwitchPlayers();
            }
        }
        */
    }

    public void handleWhitePawn3(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(whitePawn3), GridPane.getColumnIndex(whitePawn3)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhitePawn4(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(whitePawn4), GridPane.getColumnIndex(whitePawn4)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhitePawn5(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(whitePawn5), GridPane.getColumnIndex(whitePawn5)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhitePawn6(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(whitePawn6), GridPane.getColumnIndex(whitePawn6)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhiteKnight1(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.KnightMoves(new BoardPosition(GridPane.getRowIndex(whiteKnight1), GridPane.getColumnIndex(whiteKnight1)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhiteBishop1(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.BishopMoves(new BoardPosition(GridPane.getRowIndex(whiteBishop1), GridPane.getColumnIndex(whiteBishop1)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhiteQueen(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.QueenMoves(new BoardPosition(GridPane.getRowIndex(whiteQueen), GridPane.getColumnIndex(whiteQueen)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhiteKing(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                List<ChessMove> moves = mChess.KingMoves(new BoardPosition(GridPane.getRowIndex(whiteKing), GridPane.getColumnIndex(whiteKing)));
                if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                    for(ChessMove move: moves){
                        Region region = new Region();
                        region.setStyle("-fx-background-color: black;");
                        chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                    }
                    // select move
                    // Apply to Gui
                    // Apply to Chess model
                    // Reset board colors
                    mChess.SwitchPlayers();
                }
                else{
                    System.out.println("That piece has no possible moves!");
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhiteBishop2(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.BishopMoves(new BoardPosition(GridPane.getRowIndex(whiteBishop2), GridPane.getColumnIndex(whiteBishop2)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleWhiteKnight2(){
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 1) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 1)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.KnightMoves(new BoardPosition(GridPane.getRowIndex(whiteKnight2), GridPane.getColumnIndex(whiteKnight2)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Blacks Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }
    //</editor-fold>

    //<editor-folder Black Chess Piece Handlers>
    public void handleBlackPawn1() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(blackPawn1), GridPane.getColumnIndex(blackPawn1)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackPawn2() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(blackPawn2), GridPane.getColumnIndex(blackPawn2)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackPawn3() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(blackPawn3), GridPane.getColumnIndex(blackPawn3)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackPawn4() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(blackPawn4), GridPane.getColumnIndex(blackPawn4)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackPawn5() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(blackPawn5), GridPane.getColumnIndex(blackPawn5)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackPawn6() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.PawnMoves(new BoardPosition(GridPane.getRowIndex(blackPawn6), GridPane.getColumnIndex(blackPawn6)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackKnight1() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.KnightMoves(new BoardPosition(GridPane.getRowIndex(blackKnight1), GridPane.getColumnIndex(blackKnight1)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackBishop1() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.BishopMoves(new BoardPosition(GridPane.getRowIndex(blackBishop1), GridPane.getColumnIndex(blackBishop1)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackQueen() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.QueenMoves(new BoardPosition(GridPane.getRowIndex(blackQueen), GridPane.getColumnIndex(blackQueen)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackKing() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                List<ChessMove> moves = mChess.KingMoves(new BoardPosition(GridPane.getRowIndex(blackKing), GridPane.getColumnIndex(blackKing)));
                if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                    for(ChessMove move: moves){
                        Region region = new Region();
                        region.setStyle("-fx-background-color: black;");
                        chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                    }
                    // select move
                    // Apply to Gui
                    // Apply to Chess model
                    // Reset board colors
                    mChess.SwitchPlayers();
                }
                else{
                    System.out.println("That piece has no possible moves!");
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackBishop2() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.BishopMoves(new BoardPosition(GridPane.getRowIndex(blackBishop2), GridPane.getColumnIndex(blackBishop2)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }

    public void handleBlackKnight2() {
        if(mChess.CheckForBothKings()){                                                     // Check if game is ongoing
            if(mChess.GetCurrentPlayer() == 2) {                                            // Checks if it's the players turn
                if(mChess.IsCheck(mChess.GetPossibleMoves(), 2)){                   // Checks if king is in check
                    System.out.println("King is in check, cannot move that piece");
                }
                else{
                    List<ChessMove> moves = mChess.KnightMoves(new BoardPosition(GridPane.getRowIndex(blackKnight2), GridPane.getColumnIndex(blackKnight2)));
                    if(moves.size() > 0){                                                   // Checks if piece has any moves, otherwise does nothing
                        for(ChessMove move: moves){
                            Region region = new Region();
                            region.setStyle("-fx-background-color: black;");
                            chessGrid.add(region, move.EndPosition.getCol(), move.EndPosition.getRow());
                        }
                        // select move
                        // Apply to Gui
                        // Apply to Chess model
                        // Reset board colors
                        mChess.SwitchPlayers();
                    }
                    else{
                        System.out.println("That piece has no possible moves!");
                    }
                }
            }
            else {
                System.out.println("It's Whites Turn!");
            }
        }
        else{
            System.out.println("Game is over");
        }
    }
    //</editor-folder>
}