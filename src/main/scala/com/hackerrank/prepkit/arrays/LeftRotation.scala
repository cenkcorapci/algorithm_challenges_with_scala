package com.hackerrank.prepkit.arrays

object LeftRotation {
  def rotate(d: Int, a: Array[Int]): IndexedSeq[Int] =
    (d until a.length).map(i => a(i)) ++ (0 until d).map(i => a(i))


  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nd = stdin.readLine.split(" ")

    val n = nd(0).trim.toInt

    val d = nd(1).trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    println(rotate(d, a).mkString(" "))
  }

}




