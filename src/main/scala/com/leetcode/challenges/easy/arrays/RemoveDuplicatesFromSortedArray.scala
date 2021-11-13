package com.leetcode.challenges.easy.arrays

import scala.annotation.tailrec

object RemoveDuplicatesFromSortedArray extends App {
  @tailrec
  def removeDuplicates(nums: Array[Int], acc: Array[Int] = Array.empty): Array[Int] =
    if (nums.isEmpty) acc
    else removeDuplicates(nums.tail, if (acc.headOption.contains(nums.head))
      acc else acc :+ nums.head)
}
