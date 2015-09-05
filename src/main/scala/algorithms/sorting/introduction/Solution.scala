package algorithms.sorting.introduction

/**
 * Created by madhatter on 04/09/15.
 */
object Solution {

  def main(args: Array[String]) {
    try {

      val inputIterator: Iterator[String] = io.Source.stdin.getLines().take(3)
      val search: Int = inputIterator.next().trim().toInt
      val size: Int = inputIterator.next().trim().toInt
      val index: Int = inputIterator.next().split(" ").map(_.toInt).toList.indexOf(search)
      println(index)


    } catch {
      case exp: Exception => {
        println(exp)
      }
    }

  }
}
