package Recursion;

import java.util.ArrayList;
import java.util.List;

public class nQueen {

    // Save one board configuration
    public void saveBoard(char[][] board, List<List<String>> allBoard) {

        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String row = "";

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }

            newBoard.add(row);
        }

        allBoard.add(newBoard);
    }

    // Check if queen placement is safe
    public boolean isSafe(int row, int col, char[][] board) {

        // check left side of row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // check upper-left diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // check lower-left diagonal
        for (int r = row, c = col; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Backtracking helper
    public void helper(char[][] board, List<List<String>> allBoard, int col) {

        // base case
        if (col == board.length) {
            saveBoard(board, allBoard);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {

                board[row][col] = 'Q';
                helper(board, allBoard, col + 1);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    // Main function to solve N Queen
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];

        // initialize board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(board, allBoard, 0);
        return allBoard;
    }

    // Driver code
    public static void main(String[] args) {

        nQueen NQueen = new nQueen();
        int n = 4;

        List<List<String>> solution = NQueen.solveNQueens(n);

        for (List<String> board : solution) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
