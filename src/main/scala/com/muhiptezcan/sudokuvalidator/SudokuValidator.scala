package com.muhiptezcan.sudokuvalidator

object SudokuValidator {

  /**
    * Validate a Sudoku board.
    * A valid Sudoku board has no duplicate numbers in any rows, any columns or any 3x3 cells
    *
    * @param board A 2D array of Ints representing the Sudoku board
    * @return True if board is valid, false otherwise
    */
  def validate(board: Array[Array[Int]]): Boolean = {
    lazy val rowsValid = board.forall(hasNoDuplicates)
    lazy val columnsValid = board.transpose.forall(hasNoDuplicates)
    lazy val cellsValid = squaresHaveNoDuplicates(board)

    rowsValid && columnsValid && cellsValid
  }

  private def hasNoDuplicates(line: Array[Int]) = line.distinct.count(1 to 9 contains _) == line.count(_ != 0)

  private def squaresHaveNoDuplicates(matrix: Array[Array[Int]]) = {
    val rowBlocks = matrix.grouped(3).toArray
    val transposed = rowBlocks.map(_.transpose)
    val squares = transposed.map(_.grouped(3).toArray)
    val squaresFlattened = squares.map(_.map(_.flatten))

    squaresFlattened.forall(_.forall(hasNoDuplicates))
  }

}
