package algorithms.warmup.libraryfine

/**
 * Created by madhatter on 04/09/15.
 */
object Solution {

  def main(args: Array[String]) {
    try {

      val inputIterator: Iterator[String] = io.Source.stdin.getLines().take(2)
      var date1: Array[Int] = Array.ofDim[Int](3)
      var date2: Array[Int] = Array.ofDim[Int](3)
      var firstLine: Boolean = true
      for (line <- inputIterator) {
        if (firstLine) {
          firstLine = false
          date1 = line.split(" ").map(_.toInt)
        } else {
          date2 = line.split(" ").map(_.toInt)
        }
      }
      if (date2(2) < date1(2)) {
        println("10000")
        return
      } else if (date2(2) == date1(2)) {
        val months: Int = date1(1) - date2(1)
        if (months > 0) {
          println(months * 500)
          return
        } else if (months == 0) {
          val days: Int = date1(0) - date2(0)
          if (days > 0) {
            println(15 * days)
          } else {
            println(0)
          }

        } else {
          println(0)
        }
      } else {
        println(0)
      }

    } catch {
      case exp: Exception => {
        println(exp)
      }
    }

  }
}
