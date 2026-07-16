## Screenshots

- Valid Sudoku Solution
  - Demonstrates a successful API request and the solved Sudoku board returned with HTTP 200 OK.

- Invalid Row Validation
  - Shows validation when the board does not contain exactly 9 rows.
  - Error Message: "Board must contain 9 rows"

- Invalid Column Validation
  - Shows validation when one or more rows do not contain exactly 9 columns.
  - Error Message: "Each row must contain 9 columns"

- Invalid Value Validation
  - Shows validation when a Sudoku cell contains a value outside the allowed range (0–9).
  - Error Message: "Sudoku values must be between 0 and 9"

- Invalid Sudoku Board Validation
  - Shows validation when the Sudoku board violates Sudoku rules by containing duplicate values in a row, column, or 3×3 subgrid.
  - Error Message: "Invalid Sudoku board"
