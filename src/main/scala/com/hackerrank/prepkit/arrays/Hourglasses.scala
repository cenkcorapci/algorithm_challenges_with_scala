package com.hackerrank.prepkit.arrays

import java.io._

object Hourglasses {

  // Complete the hourglassSum function below.
  def hourglassSum(arr: Array[Array[Int]], coord: (Int, Int)): Int = {
    val (row, column) = coord
    ((-1 to 1).map(column + _)
      .flatMap(y => Array((row - 1, y), (row + 1, y))) :+ (row, column))
      .map {
        case (x, y) =>
          arr(x)(y)
      }
      .sum
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = (1 to 4).flatMap(x => (1 to 4).map(y => (x, y))).map(c => hourglassSum(arr, c)).max
    try {
      val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

      printWriter.println(result)

      printWriter.close()

    } catch {
      case exp: Exception =>
        println(result)
    }
  }
}
