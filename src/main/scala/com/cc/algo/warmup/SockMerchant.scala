package com.cc.algo.warmup


import java.io._

/**
  * John works at a clothing store.
  * He has a large pile of socks that he must pair by color for sale.
  * Given an array of integers representing the color of each sock,
  * determine how many pairs of socks with matching colors there are.
  *
  * For example, there are 7 socks with colors [1,2,1,2,3,2]  .
  * There is one pair of color 1 and one of color 2.
  * There are three odd socks left, one of each color. The number of pairs is 2.
  */
object SockMerchant extends App {

  def sockMerchant(n: Int, ar: Array[Int]): Int =
    ar.groupBy(identity).map(_._2.size / 2).sum


  override def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = sockMerchant(n, ar)

    printWriter.println(result)

    printWriter.close()
  }
}
