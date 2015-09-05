package algorithms.warmup.extralongfactorial

/**
 * Created by madhatter on 04/09/15.
 */
object Solution {

  def main(args: Array[String]) {
    try {

      val number: Int = io.Source.stdin.getLines().take(1).next().toInt
      var fac: BigInt = 1
      for (i <- 1 to number) {
        fac = fac * i
      }
      println(fac)

    } catch {
      case exp: Exception => {
        println(exp)
      }
    }

  }
}
