package algorithms.warmup.diagonaldifference

/**
 * Created by madhatter on 04/09/15.
 */
object Solution {

  def main(args: Array[String]) {
    try {

      val inputIterator: Iterator[String] = io.Source.stdin.getLines()
      val n: Int = inputIterator.next().trim().toInt
      val myArray = Array.ofDim[Int](n, n)
      var row: Int = 0
      for (x <- 0 until n) {
        val r: Array[Int] = inputIterator.next().split(" ").map(_.toInt)
        for (column <- 0 until r.length)
          myArray(row)(column) = r(column)

        row = row + 1
      }
      var left: Int = 0
      var right: Int = 0
      for (i <- 0 until n) {
        left = left + myArray(i)(i)
        right = right + myArray(i)((n - 1) - i)
      }
      println(Math.abs(left - right))

    } catch {
      case exp: Exception => {
        println(exp)
      }
    }

  }
}

