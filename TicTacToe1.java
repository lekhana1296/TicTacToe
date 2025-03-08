import java.util.Scanner;

public class TicTacToe1 {
    private static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int move;
        boolean gameWon = false;

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (!gameWon) {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            move = scanner.nextInt();

            if (isValidMove(move)) {
                makeMove(move);
                printBoard();
                gameWon = checkWin();

                if (gameWon) {
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    // Print the current game board
    private static void printBoard() {
        System.out.println("\n-------------");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print("| " + cell + " ");
            }
            System.out.println("|\n-------------");
        }
    }

    // Check if the move is valid
    private static boolean isValidMove(int move) {
        if (move < 1 || move > 9) return false;
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        return board[row][col] != 'X' && board[row][col] != 'O';
    }

    // Make the move on the board
    private static void makeMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        board[row][col] = currentPlayer;
    }

    // Switch between players
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check for a winner
    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true; // Row check
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true; // Column check
        }
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2]) || // Main diagonal
               (board[0][2] == board[1][1] && board[1][1] == board[2][0]); // Opposite diagonal
    }

    // Check if the board is full
    private static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell != 'X' && cell != 'O') return false;
            }
        }
        return true;
    }
}


