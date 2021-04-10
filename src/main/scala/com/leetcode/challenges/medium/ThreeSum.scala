package com.leetcode.challenges.medium

import scala.collection.Searching._

object ThreeSum extends App {

  def findK(s: Array[Int], i: Int, j: Int): Option[Int] = {
    val sum2 = s(i) + s(j)
    s.search(-sum2, j + 1, s.length) match {
      case Found(k) => Option(k)
      case _ => None
    }
  }

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val s = nums.sorted
    val result = for (
      i <- 0 to s.length - 3 if (i == 0 || s(i - 1) != s(i));
      j <- i + 1 to s.length - 2 if (j == i + 1 || s(j - 1) != s(j));
      k <- findK(s, i, j)
    ) yield {
      List(s(i), s(j), s(k))
    }
    result.toList
  }

  println(threeSum(Array(-1, 0, 1, 2, -1, -4)) == List(List(-1, -1, 2), List(-1, 0, 1)))
}
