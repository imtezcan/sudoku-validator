package com.muhiptezcan.sudokuvalidator

object BoardParser {

  /**
    * Parse a Sudoku board from varargs
    * Board needs to have 9 rows, 9 columns & all Int or Long values for non-empty cells, to be accepted
    *
    * @param board Variable number of optional arrays
    * @return A 2D Int array representing the basic Sudoku board
    */
  def getValidBoard(board: Array[Option[Any]]*): Array[Array[Int]] = {
    def validateBoard() = {
      if (board.length != 9 || board.transpose.length != 9) {
        throw new IllegalArgumentException("Board must be a 2D array of size 9x9")
      } else if (!board.forall(isAllNumbers)) {
        throw new IllegalArgumentException("Board must contain only Int or Long values")
      }
    }

    validateBoard()
    board.map(toNumbers).toArray
  }

  private def isAllNumbers(line: Array[Option[Any]]) = {
    line.forall {
      case Some(_: Int) => true
      case Some(_ : Long) => true
      case None => true
      case _ => false
    }
  }

  private def toNumbers(line: Array[Option[Any]]) = {
    line.map {
      case Some(x: Int) => x
      case Some(x: Long) => x.toInt
      case None => 0
      case _ => throw new IllegalArgumentException
    }
  }

}
