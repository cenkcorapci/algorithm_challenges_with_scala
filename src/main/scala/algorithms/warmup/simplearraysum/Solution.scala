package algorithms.warmup.simplearraysum

/**
 * Created by madhatter on 04/09/15.
 */
object Solution {

  def main(args: Array[String]) {
    try {

      val inputIterator: Iterator[String] = io.Source.stdin.getLines().take(2)
      var i: Int = 0
      for (line <- inputIterator) {
        if (i < 1) {
          i = i + 1
        } else {
          println(line.split(" ").map(_.toLong).reduceLeft(_ + _))
        }
      }

    } catch {
      case exp: Exception => {
        println(exp)
      }
    }

  }
}
