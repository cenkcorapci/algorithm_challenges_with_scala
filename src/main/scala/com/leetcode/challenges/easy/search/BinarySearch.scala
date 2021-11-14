package com.leetcode.challenges.easy.search

import scala.annotation.tailrec

object BinarySearch extends App {
  @tailrec
  def binarySearch(arr: Array[Int],
                   target: Int,
                   low: Int, high: Int): Int = {
    if (low > high) return -1
    val middle = low + (high - low) / 2
    if (arr(middle) == target) middle
    else if (arr(middle) < target) binarySearch(arr, target, middle + 1, high)
    else binarySearch(arr, target, low, middle - 1)
  }

  def search(nums: Array[Int], target: Int, low: Int = 0): Int =
    binarySearch(nums, target, 0, nums.length - 1)
}
