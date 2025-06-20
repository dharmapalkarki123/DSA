package Recursion;

public class SudokuSolver {

    // Defining the size of the Sudoku grid
    static final int SIZE = 9;

    // Creating the main method to test the Sudoku solver
    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Calling the solver and printing the result
        if (solveSudoku(board)) {
            System.out.println("Sudoku is being solved successfully:");
            printBoard(board);
        } else {
            System.out.println("Sudoku cannot be solved.");
        }
    }

    // Defining the method to solve the Sudoku using recursion and backtracking
    public static boolean solveSudoku(int[][] board) {
        // Looping through each cell in the board
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // Checking if the current cell is empty (0 means empty)
                if (board[row][col] == 0) {
                    // Trying digits from 1 to 9 in the empty cell
                    for (int num = 1; num <= SIZE; num++) {
                        // Checking if placing the number is safe
                        if (isSafe(board, row, col, num)) {
                            // Placing the number in the cell
                            board[row][col] = num;

                            // Recursively solving the rest of the board
                            if (solveSudoku(board)) {
                                return true; // If it leads to a solution, returning true
                            }

                            // If placing num didn’t work, undoing the move (backtracking)
                            board[row][col] = 0;
                        }
                    }
                    // If no number can be placed, returning false to backtrack
                    return false;
                }
            }
        }

        // If all cells are filled, returning true (puzzle is solved)
        return true;
    }

    // Defining a method to check if it's safe to place a number at a given position
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Checking if the number is already existing in the row
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Checking if the number is already existing in the column
        for (int x = 0; x < SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Finding the top-left corner of the 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        // Checking if the number is already existing in the 3x3 subgrid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        // If number is not found in row, column or box, returning true
        return true;
    }

    // Defining a method to print the Sudoku board
    public static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}

