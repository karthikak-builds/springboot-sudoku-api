package com.karthika.sudokuapi.service;
import com.karthika.sudokuapi.exception.InvalidSudokuException;
import org.springframework.stereotype.Service;

@Service
public class SudokuSolverService {
    public int[][] solve(int[][] board) {

        if(board == null || board.length != 9){
            throw new InvalidSudokuException(
                    "Board must contain 9 rows");
        }
        for (int[] row : board) {
            if (row.length != 9) {
                throw new InvalidSudokuException(
                        "Each row must contain 9 columns");
            }
        }
        for (int[] row : board) {
            for (int num : row) {
                if (num < 0 || num > 9) {
                    throw new InvalidSudokuException(
                            "Sudoku values must be between 0 and 9");
                }
            }
        }
        if (!isValidSudoku(board)) {
            throw new InvalidSudokuException(
                    "Invalid Sudoku board");
        }
        if (!solveBoard(board)) {
            throw new InvalidSudokuException(
                    "Sudoku puzzle cannot be solved");
        }

        return board;
    }
    private boolean solveBoard(int[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == 0) {

                    for (int num = 1; num <= 9; num++) {

                        if (isValid(board, row, col, num)) {

                            board[row][col] = num;

                            if (solveBoard(board)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int[][] board,
                            int row,
                            int col,
                            int num) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == num) {
                return false;
            }

            if (board[i][col] == num) {
                return false;
            }
        }

        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {

            for (int j = boxCol; j < boxCol + 3; j++) {

                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidSudoku(int[][] board) {

        // Row Validation
        for (int row = 0; row < 9; row++) {

            boolean[] seen = new boolean[10];

            for (int col = 0; col < 9; col++) {

                int num = board[row][col];

                if (num != 0) {

                    if (seen[num]) {
                        return false;
                    }

                    seen[num] = true;
                }
            }
        }

        // Column Validation
        for (int col = 0; col < 9; col++) {

            boolean[] seen = new boolean[10];

            for (int row = 0; row < 9; row++) {

                int num = board[row][col];

                if (num != 0) {

                    if (seen[num]) {
                        return false;
                    }

                    seen[num] = true;
                }
            }
        }

        // 3x3 Box Validation
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {

            for (int boxCol = 0; boxCol < 9; boxCol += 3) {

                boolean[] seen = new boolean[10];

                for (int row = boxRow; row < boxRow + 3; row++) {

                    for (int col = boxCol; col < boxCol + 3; col++) {

                        int num = board[row][col];

                        if (num != 0) {

                            if (seen[num]) {
                                return false;
                            }

                            seen[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}