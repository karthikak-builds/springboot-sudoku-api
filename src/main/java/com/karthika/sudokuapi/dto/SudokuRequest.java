package com.karthika.sudokuapi.dto;

public class SudokuRequest {

    private int[][] board;

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}