package com.karthika.sudokuapi.dto;

public class SudokuResponse {

    private int[][] board;

    public SudokuResponse(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}