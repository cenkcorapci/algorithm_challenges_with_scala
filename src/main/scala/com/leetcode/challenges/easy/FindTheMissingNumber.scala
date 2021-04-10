package com.leetcode.challenges.easy

object FindTheMissingNumber extends App {
  def findMissing(nums: Array[Int]): Int = {
    var missing: Int = 0
    (0 to nums.length).foreach(x => missing = missing ^ x)
    nums.foreach(x => missing = missing ^ x)
    missing
  }

  println(findMissing((0 until 10).filter(_ != 5).toArray))
}
