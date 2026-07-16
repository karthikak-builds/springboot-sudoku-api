package com.karthika.sudokuapi.controller;

import com.karthika.sudokuapi.dto.SudokuRequest;
import com.karthika.sudokuapi.dto.SudokuResponse;
import com.karthika.sudokuapi.service.SudokuSolverService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SudokuController {

    private final SudokuSolverService solverService;

    public SudokuController(SudokuSolverService solverService) {
        this.solverService = solverService;
    }

    @GetMapping("/")
    public String home() {
        return "Sudoku API Running";
    }

    @PostMapping("/solve")
    public SudokuResponse solve(@RequestBody SudokuRequest request) {

        int[][] solvedBoard =
                solverService.solve(request.getBoard());

        return new SudokuResponse(solvedBoard);
    }
}