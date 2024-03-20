// Written by Junnior Lucero (lucer045) and Jesus Romero-Rivera (romer309)

public class King {
    /**
     * Constructor
     * @param row   The current row of the King.
     * @param col   The current column of the King.
     * @param isBlack   The color of the King.
     */
    public King(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Checks if a move to a destination square is legal
     * @param board     The game board.
     * @param endRow    The row of the destination square.
     * @param endCol    The column of the destination square.
     * @return True if the move to the destination square is legal, false otherwise.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)){ // Let's verify the color and end position
            return board.verifyAdjacent(this.row, this.col, endRow, endCol); // Let's return the outcome if the piece is adjacent
        } else{
            return false; // For any other case, return false.
        }
    }

    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;
}
