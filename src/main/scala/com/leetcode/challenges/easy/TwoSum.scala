package com.leetcode.challenges.easy

import scala.annotation.tailrec

object TwoSum extends App {
  @tailrec
  def twoSum(nums: Array[Int], target: Int,
             map: Map[Int, Int] = Map.empty,
             counter: Int = 0): Array[Int] = {
    if (nums.isEmpty) Array.emptyIntArray
    map.get(nums.head) match {
      case Some(index) =>
        Array(index, counter)
      case None =>
        val addition = target - nums.head -> counter
        twoSum(nums.tail, target, map + addition, counter + 1)
    }
  }

  println(twoSum(Array(2, 7, 11, 15), 9).sameElements(Array(0, 1)))
  println(twoSum(Array(3, 2, 4), 6).sameElements(Array(1, 2)))
}
