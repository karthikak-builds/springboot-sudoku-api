# springboot-sudoku-api
Sudoku Solver REST API built with Spring Boot using Backtracking Algorithm, Input Validation, and Global Exception Handling.

# Sudoku Solver API

A REST API built using Spring Boot that solves Sudoku puzzles using the Backtracking Algorithm.

## Features

- Solve Sudoku puzzles
- Input validation
- Row validation
- Column validation
- 3x3 box validation
- Custom exception handling
- Global exception handling
- Detect unsolvable puzzles
- RESTful API design

## Technologies Used

- Java 21
- Spring Boot
- Maven
- REST API
- Postman

## Project Structure

src
├── controller
├── dto
├── service
├── exception
└── SudokuApiApplication

## API Endpoint

### Solve Sudoku

POST /solve

### Request

```json
{
  "board": [
    [5,3,0,0,7,0,0,0,0],
    [6,0,0,1,9,5,0,0,0],
    [0,9,8,0,0,0,0,6,0],
    [8,0,0,0,6,0,0,0,3],
    [4,0,0,8,0,3,0,0,1],
    [7,0,0,0,2,0,0,0,6],
    [0,6,0,0,0,0,2,8,0],
    [0,0,0,4,1,9,0,0,5],
    [0,0,0,0,8,0,0,7,9]
  ]
}
```

### Response

```json
{
  "solvedBoard": [
    [5,3,4,6,7,8,9,1,2],
    [6,7,2,1,9,5,3,4,8],
    [1,9,8,3,4,2,5,6,7],
    [8,5,9,7,6,1,4,2,3],
    [4,2,6,8,5,3,7,9,1],
    [7,1,3,9,2,4,8,5,6],
    [9,6,1,5,3,7,2,8,4],
    [2,8,7,4,1,9,6,3,5],
    [3,4,5,2,8,6,1,7,9]
  ]
}
```

## Validation

The API validates:

- Board must contain 9 rows
- Each row must contain 9 columns
- Values must be between 0 and 9
- Duplicate values are not allowed in rows
- Duplicate values are not allowed in columns
- Duplicate values are not allowed in 3x3 boxes
- Detects unsolvable puzzles

## Algorithm

The Sudoku solver uses a Backtracking Algorithm.

For each empty cell:

1. Try numbers 1–9
2. Check whether the number is valid
3. Continue recursively
4. Backtrack if no solution exists

## Author

Karthika K
MCA Student | Aspiring Java Backend Developer
