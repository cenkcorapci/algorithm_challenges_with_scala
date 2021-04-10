package com.leetcode.challenges.hard

import scala.annotation.tailrec

// TODO dynamic programming
object CountingBits extends App {
  @tailrec
  def getBinary(num: Int, count: Int = 0): Int =
    if (num == 0) count
    else {
      val i = num % 2
      getBinary(num / 2, count + i)
    }

  def countBits(num: Int): Array[Int] =
    (0 to num).toArray.map(getBinary(_))

  println(countBits(2).mkString(","))
  println(countBits(2).mkString("").equals("011"))
  println(countBits(5).mkString(",").equals("0,1,1,2,1,2"))
  println(countBits(20).mkString(","))

}
