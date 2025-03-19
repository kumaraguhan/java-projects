package sudoku;

import java.util.Scanner;

public class sudokusolver {

    // Size of the grid
    private static final int SIZE = 9;

    // Function to print the Sudoku grid
    public static void printBoard(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if it's safe to place a number at position (row, col)
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check the row
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Function to solve the Sudoku puzzle using Backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // If the current cell is empty (i.e., value is 0)
                if (board[row][col] == 0) {
                    // Try all numbers from 1 to 9
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num; // Place the number
                            
                            // Recursively attempt to solve the rest of the board
                            if (solveSudoku(board)) {
                                return true;
                            }
                            
                            // If placing num didn't work, backtrack by resetting the cell
                            board[row][col] = 0;
                        }
                    }
                    return false; // If no number fits, return false
                }
            }
        }
        return true; // If the whole board is filled, return true
    }

    // Function to take user input for the Sudoku puzzle
    public static void takeInput(int[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Sudoku puzzle (9x9 grid). Use 0 for empty cells:");

        // Reading the Sudoku grid from the user
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("Enter number for cell (" + (i+1) + "," + (j+1) + "): ");
                board[i][j] = scanner.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        // Create an empty 9x9 Sudoku board
        int[][] board = new int[SIZE][SIZE];

        // Take input from the user
        takeInput(board);

        // Print the original Sudoku puzzle
        System.out.println("\nOriginal Sudoku:");
        printBoard(board);

        // Solve the Sudoku puzzle
        if (solveSudoku(board)) {
            System.out.println("\nSolved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("\nNo solution exists for this Sudoku puzzle.");
        }
    }
}
