package algorithms.warmup.plusminus

/**
 * Created by madhatter on 04/09/15.
 */

object Solution {

  def main(args: Array[String]) {
    try {

      val inputIterator: Iterator[String] = io.Source.stdin.getLines()
      val numberCount: Float = inputIterator.next().trim().toInt.toFloat
      val input: Array[Int] = inputIterator.next().split(" ").map(_.toInt)

      var pos: Float = 0f
      var neg: Float = 0f
      var zero: Float = 0f
      for (num <- input) {
        if (num == 0) {
          zero = zero + 1f
        } else {
          if (num > 0) {
            pos = pos + 1f
          } else {
            neg = neg + 1f
          }
        }
      }
      println(pos / numberCount)
      println(neg / numberCount)
      println(zero / numberCount)
    } catch {
      case exp: Exception => {
        println(exp)
      }
    }

  }
}


