package com.leetcode.challenges.easy

import scala.util.Try

object ReverseInteger extends App {
  def reverse(x: Int): Int =
    Try(if (x > 0) x.toString.reverse.toInt
    else if (x < 0) -math.abs(x).toString.reverse.toInt
    else 0).toOption.getOrElse(0)


  println(reverse(123) == 321)
  println(reverse(-123) == -321)
  println(reverse(0) == 0)
}
