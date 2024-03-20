// Written by Junnior Lucero (lucer045) and Jesus Romero-Rivera (romer309)
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board(); // Instantiates the board
        boolean isBlack = false; // Sets the first player's turn
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", myBoard);

        System.out.println("Let's play a chess game.");
        System.out.println("Game instructions:");
        System.out.println("Let's assume that player 1 uses the white pieces and player 2 uses the black pieces");
        System.out.println("player one will go first (white pieces)");
        System.out.println("------------------");

        while (!myBoard.isGameOver()) { // The game is only over, when one of the Two kings is taken down, so for every turn...
            if (!isBlack) { // Player one's turn
                System.out.println("Here is your board:");
                System.out.println(myBoard); // Board printed at the beginning of each player's turn.
                System.out.println("------------------");
                System.out.println("It is currently player 1's turn to play (white pieces).");

                // Ask the user for input
                Scanner myScanner = new Scanner(System.in);
                System.out.println("What is your move? (format: [start row] [start col] [end row] [end col]) \n");
                int startRow = myScanner.nextInt();
                int startCol = myScanner.nextInt();
                int endRow = myScanner.nextInt();
                int endCol = myScanner.nextInt();

                if (!myBoard.getPiece(startRow, startCol).getIsBlack()) { // Let's make sure that the player is picking the valid pieces
                    myBoard.movePiece(startRow, startCol, endRow, endCol); // Update the board
                    isBlack = true; // Switching turns;
                } else { // Test case of when the user attempts to move the opposite player's pieces
                    System.out.println("\nYou cannot move pieces that are not yours \n");
                }
            } else {
                System.out.println("Here is your board:");
                System.out.println(myBoard); // Board printed at the beginning of each player's turn.
                System.out.println("------------------");
                System.out.println("It is currently player 2's turn to play (black pieces).");

                // Let's ask the user for input
                Scanner myScanner = new Scanner(System.in);
                System.out.println("What is your move? (format: [start row] [start col] [end row] [end col]) \n");
                int startRow = myScanner.nextInt();
                int startCol = myScanner.nextInt();
                int endRow = myScanner.nextInt();
                int endCol = myScanner.nextInt();

                if(myBoard.getPiece(startRow, startCol).getIsBlack()){ // Let's make sure that the player is picking the valid pieces
                    myBoard.movePiece(startRow,startCol,endRow,endCol);  // Update the board
                    isBlack = false; // Switching turns;
                } else { // Test case of when the user attempts to move the opposite player's pieces
                    System.out.println("You cannot move pieces that are not yours");
                }
            }
        }  // Let's Determine who won
        if(!isBlack){
            System.out.println("Player 2 (Black pieces) won the game");
        } else {
            System.out.println("Player 1 (White pieces) won the game");
        }
    }
}