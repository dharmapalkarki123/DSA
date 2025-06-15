package Recursion;

import java.util.ArrayList;
import java.util.List;

class NQueens {

    // Checking if placing a Queen at board[row][col] is safe
    public boolean isSafe(int row, int col, char[][] board) {
        // Checking horizontally across the row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // Checking vertically along the column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Checking upper-left diagonal
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') return false;
        }

        // Checking upper-right diagonal
        r = row;
        for (int c = col; c < board.length && r >= 0; c++, r--) {
            if (board[r][c] == 'Q') return false;
        }

        // Checking lower-left diagonal
        r = row;
        for (int c = col; c >= 0 && r < board.length; c--, r++) {
            if (board[r][c] == 'Q') return false;
        }

        // Reinitializing row index before checking lower-right diagonal
        r = row;

        // Checking lower-right diagonal
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') return false;
        }

        // Returning true if the position is safe for placing a Queen
        return true;
    }

    // Saving the current board configuration to the list of all valid boards
    public void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = "";
            for (int j = 0; j < board[0].length; j++) {
                // Appending 'Q' if Queen is present, else appending '.'
                row += board[i][j] == 'Q' ? 'Q' : '.';
            }
            // Adding the constructed row to the board
            newBoard.add(row);
        }
        // Adding the complete board to the list of solutions
        allBoards.add(newBoard);
    }

    // Using backtracking to try placing Queens column by column
    public void helper(char[][] board, List<List<String>> allBoards, int col) {
        // Checking if all columns are filled (base case)
        if (col == board.length) {
            // Saving the current board as a valid solution
            saveBoard(board, allBoards);
            return;
        }

        // Trying to place a Queen in each row of the current column
        for (int row = 0; row < board.length; row++) {
            // Checking if placing a Queen at [row][col] is safe
            if (isSafe(row, col, board)) {
                // Placing the Queen at the current position
                board[row][col] = 'Q';

                // Moving to the next column
                helper(board, allBoards, col + 1);

                // Backtracking by removing the Queen
                board[row][col] = '.';
            }
        }
    }

    // Starting the solving process for the N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initializing the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Starting to solve from the first column
        helper(board, allBoards, 0);
        return allBoards;
    }

    // Running the program and displaying the solutions
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();

        // Setting the board size (N)
        int n = 4;

        // Getting all possible solutions
        List<List<String>> solutions = nQueens.solveNQueens(n);

        // Printing each solution board
        int count = 1;
        for (List<String> board : solutions) {
            System.out.println("Solution " + count++);
            for (String row : board) {
                // Printing each row of the current solution
                System.out.println(row);
            }
            // Printing an empty line after each solution
            System.out.println();
        }
    }
}
