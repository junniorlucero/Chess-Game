// Written by Junnior Lucero (lucer045) and Jesus Romero-Rivera (romer309)
public class Queen {
    /**
     * Constructor
     * @param row   The current row of the Queen.
     * @param col   The current column of the queen.
     * @param isBlack   The color of the Queen.
     */
    public Queen(int row, int col, boolean isBlack) {
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
    public boolean isMoveLegal(Board board, int endRow, int endCol){  // Queens can only move:
        return(board.verifyVertical(this.row, this.col, endRow, endCol) || // Vertically
                board.verifyDiagonal(this.row, this.col, endRow, endCol) || // Diagonally
                board.verifyHorizontal(this.row, this.col, endRow, endCol) || // Horizontally
                board.getPiece(endRow,endCol) == null); // or if the space is empty
    }

    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;

}
