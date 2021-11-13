package com.leetcode.challenges.easy.arrays

import scala.annotation.tailrec

object PlusOne extends App {

  @tailrec
  def _plusOne(digits: Array[Int], result: Array[Int] = Array.empty, add: Int = 0): Array[Int] =
    if (digits.isEmpty && add == 0) result
    else if (digits.isEmpty && add > 0) result :+ 1
    else {
      if (digits.head + add >= 10) _plusOne(digits.tail, result :+ 0, add = 1)
      else _plusOne(digits.tail, result :+ (digits.head + add))
    }


  def plusOne(digits: Array[Int], result: Array[Int] = Array.empty): Array[Int] = _plusOne(digits.reverse, add = 1).reverse

  println(plusOne(Array(1, 2, 3)).mkString(", "))
}
