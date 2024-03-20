// Written by Junnior Lucero (lucer045) and Jesus Romero-Rivera (romer309)

import java.util.Scanner;

public class Piece {
    // Create Instance Variables
    private char character;
    private int row;
    private int col;
    private boolean isBlack;

    /**
     * Constructor.
     *
     * @param character The character representing the piece.
     * @param row       The row on the board the piece occupies.
     * @param col       The column on the board the piece occupies.
     * @param isBlack   The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) { //constructor
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public char getPiece(){
        return this.character;
    } //getter method to return the character of a piece

    public int getCol(){
        return this.col;
    } //getter method to return the column of a piece
    public int getRow(){
        return this.row;
    } //getter method to return the row of a piece

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     *
     * @param row The row to move the piece to.
     * @param col The column to move the piece to.
     */
    public void setPosition(int row, int col) { //set position to the row and col
        this.row = row;
        this.col = col;
    }

    /**
     * Return the color of the piece.
     *
     * @return The color of the piece.
     */
    public boolean getIsBlack() {
        return isBlack;

    }

    /**
     * Handle promotion of a pawn.
     *
     * @param row     Current row of the pawn
     * @param isBlack Color of the pawn
     */
    public void promotePawn() {
        if (this.character == '\u2659'){ //check if the character is a white pawn
            if(row == 0) { //once this pawn reaches row 0 it will prompt the user to promot their pawn
                Scanner myScanner = new Scanner(System.in);
                System.out.println("Your pawn has reached the opposite side of the board. Input the piece you wish to promote it to (excluding King)");
                String input = myScanner.nextLine(); //user will then be prompted to input any of these valid inputs
                if(input.equalsIgnoreCase("Queen")){
                    this.character = '\u2655'; //piece unicode character will be set to this char unicode
                }
                if(input.equalsIgnoreCase("Rook")){
                    this.character = '\u2656'; //piece unicode character will be set to this char unicode
                }
                if(input.equalsIgnoreCase("Bishop")){
                    this.character = '\u2657'; //piece unicode character will be set to this char unicode
                }
                if(input.equalsIgnoreCase("Knight")){
                    this.character = '\u2658'; //piece unicode character will be set to this char unicode
                }
            }
        }
        if(this.character == '\u265f'){ //check if the character is a black pawn
            if(row == 7){ //once this pawn reaches row 7 it will prompt the user to promot their pawn
                Scanner myScanner = new Scanner(System.in);
                System.out.println("Your pawn has reached the opposite side of the board. Input the piece you wish to promote it to (excluding King)");
                String input = myScanner.nextLine(); //user will then be prompted to input any of these valid inputs
                if(input.equalsIgnoreCase("Queen")){
                    this.character = '\u265b'; //piece unicode character will be set to this char unicode
                }
                if(input.equalsIgnoreCase("Rook")){
                    this.character = '\u265c'; //piece unicode character will be set to this char unicode
                }
                if(input.equalsIgnoreCase("Bishop")){
                    this.character = '\u265d'; //piece unicode character will be set to this char unicode
                }
                if(input.equalsIgnoreCase("Knight")){
                    this.character = '\u265e'; //piece unicode character will be set to this char unicode
                }
            }

        }

    }

    /**
     * Returns a string representation of the piece.
     *
     * @return A string representation of the piece.
     */

    public String toString() {
        return "" + this.getPiece();
    }

}