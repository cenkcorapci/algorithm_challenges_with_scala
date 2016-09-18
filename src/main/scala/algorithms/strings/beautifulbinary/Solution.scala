package algorithms.strings.beautifulbinary

/**
  * Created by madhatter on 9/18/2016.
  */
object Solution extends App {
  readLine()
  val s = readLine().trim
  println((s.length - s.replaceAll("010", "").length) / 3)
}
