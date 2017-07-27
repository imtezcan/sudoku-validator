package com.muhiptezcan.sudokuvalidator

import org.scalatest.FlatSpec

class BoardParserTest extends FlatSpec {

  behavior of "BoardParser"

  it should "return 2D board" in {
    val board: Seq[Array[Option[Any]]] = Seq(
      Array(Option(1), None, Option(1.toLong), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1)),
      Array(Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1)),
      Array(Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1)),
      Array(Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1)),
      Array(Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1)),
      Array(Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1)),
      Array(Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1)),
      Array(Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1)),
      Array(Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1), Option(1))
    )

    val parsedBoard = BoardParser.getValidBoard(board: _*)

    val result = Array(
      Array(1, 0, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1, 1, 1, 1, 1)
    )

    assertResult(result)(parsedBoard)
  }

  it should "throw exception if not 9x9" in {
    val board: Seq[Array[Option[Any]]] = Seq(
      Array(Option(AnyRef), Option(3), Option(5), Option(7)),
      Array(Option(8), None)
    )

    assertThrows[IllegalArgumentException] {
      BoardParser.getValidBoard(board: _*)
    }

  }

  it should "throw exception if not all numbers" in {
    val board: Seq[Array[Option[Any]]] = Seq(
      Array(Option(1), Option(""), None, None, None, None, None, None, None),
      Array(None, None, None, None, None, None, None, None, None),
      Array(None, None, None, None, None, None, None, None, None),
      Array(None, None, None, None, None, None, None, None, None),
      Array(None, None, None, None, None, None, None, None, None),
      Array(None, None, None, None, None, None, None, None, None),
      Array(None, None, None, None, None, None, None, None, None),
      Array(None, None, None, None, None, None, None, None, None),
      Array(None, None, None, None, None, None, None, None, None)
    )

    assertThrows[IllegalArgumentException] {
      BoardParser.getValidBoard(board: _*)
    }

  }

}
