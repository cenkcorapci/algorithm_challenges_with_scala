package algorithms.warmup.staircase

/**
 * Created by madhatter on 04/09/15.
 */
object Solution {

  def main(args: Array[String]) {
    try {

      val inputIterator: Iterator[String] = io.Source.stdin.getLines().take(1)
      val steps: Int = inputIterator.next().trim().toInt

      for (s <- 1 to steps) {
        var step = " " * (steps - s)
        step = step + "#" * s
        println(step)
      }
    } catch {
      case exp: Exception => {
        println(exp)
      }
    }

  }
}


