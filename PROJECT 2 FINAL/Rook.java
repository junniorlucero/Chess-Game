// Written by Junnior Lucero (lucer045) and Jesus Romero-Rivera (romer309)
public class Rook {
    private int row;
    private int col;
    private boolean isBlack;

    /**
     * Constructor.
     * @param row   The current row of the rook.
     * @param col   The current column of the rook.
     * @param isBlack   The color of the rook.
     */

    public Rook(int row, int col, boolean isBlack) {
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
    public boolean isMoveLegal(Board board, int endRow, int endCol){ //
        if(board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack) == true){ //utilize verifySourceandDestination to ensure we are giving a valid input
            return board.verifyVertical(this.row, this.col, endRow, endCol) || board.verifyHorizontal(this.row, this.col, endRow, endCol); //utilize horizontal or vertical to ensure that the piece is moving horizontally or vertically
        }
        else{
        return false;
        }
    }
}
