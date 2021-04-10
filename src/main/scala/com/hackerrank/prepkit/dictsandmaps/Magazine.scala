package com.other.dictsandmaps

object Magazine {
  // Complete the checkMagazine function below.
  def checkMagazine(magazine: Array[String], note: Array[String]): Boolean = {
    val mMap = magazine.groupBy(identity).mapValues(_.length)
    val nMap = note.groupBy(identity).mapValues(_.length)
    nMap.forall { case (word, count) => mMap.getOrElse(word, 0) >= count }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val mn = stdin.readLine.split(" ")

    val m = mn(0).trim.toInt

    val n = mn(1).trim.toInt

    val magazine = stdin.readLine.split(" ")

    val note = stdin.readLine.split(" ")
    if (checkMagazine(magazine, note))
      println("Yes")
    else
      println("No")
  }
}
