package com.leetcode.challenges.medium

import scala.annotation.tailrec

object ContainerWithMostWater extends App {
  def maxArea(height: Array[Int]): Int = {
    var maxArea = 0
    var left = 0
    var right = height.length - 1;
    while (left < right) {
      maxArea = Math.max(maxArea, math.min(height(left), height(right)) * (right - left))
      if (height(left) < height(right))
        left = left + 1
      else
        right = right - 1
    }
    maxArea
  }

  println(maxArea(Array(2, 3, 10, 5, 7, 8, 9)) == 36)
  println(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
  println(maxArea(Array(1, 1)) == 1)
  println(maxArea(Array(4, 3, 2, 1, 4)) == 16)
  println(maxArea(Array(1, 2, 1)) == 2)
}
