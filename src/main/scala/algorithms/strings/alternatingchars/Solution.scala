package algorithms.strings.alternatingchars

/**
  * Created by madhatter on 9/18/2016.
  */
object Solution extends App {
  def check(n: Int, str: String): Int = {
    if (str.isEmpty) n
    else {
      if (str.length >= 2) {
        if (str.head == str.charAt(1)) check(n + 1, str.tail)
        else check(n, str.tail)
      }
      else check(n, str.tail)
    }
  }

  val n = readLine().toInt
  for (i <- 0 until n) {
    val s = readLine().trim
    if (s.isEmpty) println(0)
    else println(check(0, s))
  }
}

