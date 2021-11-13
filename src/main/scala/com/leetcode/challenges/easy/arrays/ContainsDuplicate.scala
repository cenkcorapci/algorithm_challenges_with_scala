package com.leetcode.challenges.easy.arrays

import scala.annotation.tailrec

object ContainsDuplicate {
  @tailrec
  def containsDuplicate(nums: Array[Int], acc: Set[Int] = Set.empty): Boolean =
    if (nums.isEmpty) false
    else if (acc.contains(nums.head)) true
    else containsDuplicate(nums.tail, acc + nums.head)

}
