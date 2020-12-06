package com.cc.algo.arrays

import scala.annotation.tailrec

object NewYearChaos extends App {

  // Complete the minimumBribes function below.
  @tailrec
  def minimumBribes(q: Array[Int], idx: Int = 0, acc: Int = 0): Unit =
    if (q.length <= idx) println(acc)
    else {
      val person = q(idx)
      if (person - idx > 3)
        println("Too chaotic")
      else {
        val bribedBy = q.take(idx).count(_ > person)
        minimumBribes(q, idx + 1, acc + bribedBy)
      }
    }

  val stdin = scala.io.StdIn

  val t = stdin.readLine.trim.toInt

  for (tItr <- 1 to t) {
    val n = stdin.readLine.trim.toInt

    val q = stdin.readLine.split(" ").map(_.trim.toInt)
    minimumBribes(q)
  }

}
