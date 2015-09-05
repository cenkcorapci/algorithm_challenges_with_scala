package algorithms.warmup.timeconvertion

/**
 * Created by madhatter on 04/09/15.
 */
object Solution {

  def main(args: Array[String]) {
    try {

      val input: String = io.Source.stdin.getLines().take(1).next()

      var hh: Int = 0
      var mm: String = "00"
      var ss: String = "00"

      var i: Int = 0
      for (inp <- input.split(":")) {
        if (i == 0) {
          hh = inp.toInt
        } else if (i == 1) {
          mm = inp
        } else if (i == 2) {
          ss = inp.substring(0, 2)
          if (inp.substring(2).equalsIgnoreCase("pm")) {
            if (hh != 12) {
              hh = hh + 12
            }

          } else {
            if (hh == 12) {
              hh = 0
            }
          }
        }
        i = i + 1
      }
      if (hh < 10) {
        println("0" + hh + ":" + mm + ":" + ss)

      } else {
        println(hh + ":" + mm + ":" + ss)

      }
    } catch {
      case exp: Exception => {
        println(exp)
      }
    }

  }
}


