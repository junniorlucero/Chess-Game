// Written by Junnior Lucero (lucer045) and Jesus Romero-Rivera (romer309)
public class Board {

    // Instance variables
    private Piece[][] board;

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
        board = new Piece[8][8];
    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. A constraint of a legal move is:
    // - there exists a Piece at (startRow, startCol) and the destination square is seizable.
    // Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move is legal,
    // and to execute the move if it is.
    // Your Game class should not directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        // Let's start by checking if the provided start points have a piece or if it is empty
        // Then lets check if the piece can move to that desired location
        // Then let's verify if that the points are within the board
        // Then let's verify the piece is the correct color
        if (board[startRow][startCol] != null && getPiece(startRow, startCol).isMoveLegal(this, endRow, endCol) && this.verifySourceAndDestination(startRow, startCol, endRow, endCol, this.getPiece(startRow, startCol).getIsBlack())) {
            Piece temp = board[startRow][startCol];    // let's save the piece we want to move
            this.board[endRow][endCol] = temp;         // let's move the piece to the desired end location
            this.board[startRow][startCol].setPosition(endRow, endCol);
            this.board[endRow][endCol].promotePawn();
            this.board[startRow][startCol] = null;         // lets make the square on the board empty (that way other pieces could move to it later on)
            return true;
        }
        return false;
    }


    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        boolean blackKing = false; // let's initialize each king and set them equal to false
        boolean whiteKing = false;
        for (int i = 0; i < board.length; i++) { // iterate through the board
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) { // Let's check each piece on the board
                    if (board[i][j].getPiece() == '\u2654') { // Let's try to find a White King
                        whiteKing = true; // change the variable to true
                    } else if (board[i][j].getPiece() == '\u265a') { // Let's try to find a Black King
                        blackKing = true; // change the variable to true
                    }
                }
            }
        }
        if (blackKing == true && whiteKing == true) { // When both kings are on the board, the game is not over
            return false;
        } else if ((blackKing == false && whiteKing == true) || (whiteKing == false && blackKing == true)) { // when one king is not on the board, the game is over
            return true;
        }
        return true;
    }
    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for (int i = 0; i < 8; i++) {
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for (int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for (int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() { // clears the board pieces
        for (int i = 0; i < board.length; i++) { // iterate through the board and change each position to null
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = null;
            }
        }
    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    // - where 'start' = (startRow, startCol) and 'end' = (endRow, endCol)
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        // Let's check if the provided input is within the bounds of our board
        if (startRow < board.length && startRow >= 0 // For both the start and end position, lets verify that provided info is within our array bounds.
                && startCol >= 0 && startCol < board[0].length &&
                endRow >= 0 && endRow < board.length &&
                endCol >= 0 && endCol < board[0].length &&
                board[startRow][startCol] != null ){ // Let's also check if the piece, within bounds, actually exists
            // Let's verify that each piece is only moved its corresponding user, the end location is free or if the end location is of the other color.
            if(board[startRow][startCol].getIsBlack()==(isBlack) && (board[endRow][endCol] == null || board[endRow][endCol].getIsBlack() != isBlack)){
                return true;
            }
        }
        return false;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        int rowDiff = Math.abs(endRow-startRow); // Let's check difference between the starting and ending positions.
        int colDiff = Math.abs(endCol-startCol);

        return (rowDiff == 0 && colDiff == 0 || // If there is no change...
                rowDiff == 0 && colDiff == 1 || // If there is one change in the column...
                rowDiff == 1 && colDiff == 1 || // If there is one change in rows and column...
                colDiff == 0 && rowDiff == 1); // If there is one change in the rows...
    } // return the outcome of each test case.
    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow) { //check if startrow and endrow are equal
            if (startCol < endCol) { //first check, if endcol is greater than startcol we will iterate
                                    //iterate until j is == to endCol and see if the board at [startRow][j] is null
                for (int j = startCol+1; j<endCol; j++) {
                    if (board[startRow][j] != null) {
                        return false; //return false if it isn't empty but true if it goes the entire way without hitting null
                    }
                }
            } else if (startCol > endCol) { //second check, if startcol is greater than endcol
                for (int j = startCol-1; j>endCol; j--) {//iterate until j is == to endCol and see if [startRow][j] is nul;
                    if (board[startRow][j] != null) {
                        return false;//return false if it isn't empty but true if it goes the entire way without hitting null
                    }
                }
            } else { //if startRow == endRow && startCol == endCol then will return true
                return true;
            }
        } else { //if startRow does not equal endRow it will return false
            return false;
        }
        return true; //will return true as a default
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        int rowDiff = Math.abs(startRow - endRow); // Let's find the difference between the starting and ending positions.
        int colDiff = Math.abs(startCol - endCol);

        if(startRow == endRow && startCol == endCol){ // Case 1: if there is no change, then return true.
            return true;
        }
        if (rowDiff != colDiff) { // If the difference between the rows and columns does not match, then we don't have to check any other cases, return false.
            return false;
        } else {
            for (int offset = 1; offset < rowDiff; offset++) { // Iterated through the difference in rows to check the following:
                if (startRow < endRow && startCol < endCol &&  // moving from the top left to the bottom right
                        board[startRow + offset][startCol + offset] != null) { // return false if there is piece on the board is not null
                    return false;
                } else if (startRow > endRow && startCol > endCol &&  // bottom right to top left
                        board[startRow - offset][startCol - offset] != null) { // return false if there is piece on the board is not null
                    return false;
                } else if (startRow > endRow && startCol < endCol &&  // bottom left to top right
                        board[startRow - offset][startCol + offset] != null) { // return false if there is piece on the board is not null
                    return false;
                } else if (startRow < endRow && startCol > endCol && // top right to bottom left
                        board[startRow + offset][startCol - offset] != null) { // return false if there is piece on the board is not null
                    return false;
                }
            }
            return true; // return true indicating we have a diagonal move.
        }
    }


    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol == endCol) { //check if startCol == endCol
            if (startRow < endRow) { //first check, if endRow is greater than startRow
                for (int j = startRow + 1; j < endRow; j++) { //iterate until j hits endRow
                    if (board[j][startCol] != null) {  //see if the board at [j][StartCol] is not null
                        return false; //will return false if it isnt' empty
                    }
                }
            } else if (startRow > endRow) {  //first check, if startRow is greater than endRow
                for (int j = startRow - 1; j > endRow; j--) { //iterate until j hits endRow
                    if (board[j][startCol] != null) { //see if the board at [j][StartCol] is not null
                        return false; //will return false if it isnt' empty
                    }
                }
            } else { //if startRow == endRow && startCol == endCol then will return true
                return true;
            }
        } else { //if startCol does not equal endCol it will return false
            return false;
        } //default fallback
        return true;
    }
}
