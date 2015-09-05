package algorithms.warmup.solvemesecond

/**
 * Created by madhatter on 04/09/15.
 */
object Solution extends App {
  val n = readInt
  //recommended
  (1 to n).map(i => readLine.split(" ").map(_.toInt).sum).foreach(println)

  /*
    another way
    for (i <- 1 to n) {
    val Array(a, b) = readLine.split(" ").map(_.toInt)
    println(a + b)
  }
  */
}
