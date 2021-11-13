package com.leetcode.challenges.easy.arrays

import scala.annotation.tailrec

object SingleNumber extends App {
  @tailrec
  def singleNumber(nums: Array[Int], set: Set[Int] = Set.empty): Int =
    if (nums.isEmpty) set.head
    else if (set.contains(nums.head)) singleNumber(nums.tail, set - nums.head)
    else singleNumber(nums.tail, set + nums.head)
  
}
