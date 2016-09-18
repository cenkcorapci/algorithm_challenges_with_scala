package algorithms.strings.pangrams

/**
  * Created by madhatter on 9/18/2016.
  */
object Solution extends App {

  def check(left: Array[Char], string: String): Boolean = {
    if (string.isEmpty) return left.isEmpty
    else check(left.filterNot(_ == string.head), string.tail)
  }

  if (check(('a' to 'z').toArray, readLine().trim.toLowerCase)) println("pangram")
  else println("not pangram")
}
