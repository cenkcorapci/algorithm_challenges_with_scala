package com.leetcode.challenges.easy.arrays

object MoveZeroes extends App {
  def moveZeroes(nums: Array[Int]): Array[Int] = {
    val filtered = nums.filter(_ != 0)
    filtered ++ Array.fill[Int](nums.length - filtered.length)(0)
  }

}
