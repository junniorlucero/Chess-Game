// Written by Junnior Lucero (lucer045) and Jesus Romero-Rivera (romer309)
public class Knight {
    private int row;
    private int col;
    private boolean isBlack;

    /**
     * Constructor.
     *
     * @param row     The current row of the Knight.
     * @param col     The current column of the Knight.
     * @param isBlack The color of the Knight.
     */

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            if (endRow == this.row + 1 && endCol == this.col - 2) { //check + 1 vertical, -2 horizontal
                return true;
            }
            if (endRow == this.row + 2 && endCol == this.col - 1) { // check + 2 vertical, - 1 horizontal
                return true;
            }
            if (endRow == this.row + 2 && endCol == this.col + 1) { //check + 2 vertical, + 1 horizontal
                return true;
            }
            if (endRow == this.row + 1 && endCol == this.col + 2) { //check + 1 vertical, +2 horizontal
                return true;
            }
            if (endRow == this.row - 1 && endCol == this.col - 2) { //check - 1 vertical, - 2 horizontal
                return true;
            }
            if (endRow == this.row - 2 && endCol == this.col - 1) { //check - 2 vertical, - 1 horizontal
                return true;
            }
            if (endRow == this.row - 2 && endCol == this.col + 1) { //check -2 vertical, +1 horizontal
                return true;
            }
            if (endRow == this.row - 1 && endCol == this.col + 2) { //check - 1 vertical, +2 horizontal
                return true;
            }

        } else {
            return false;
        }
        return false;
    }
}
