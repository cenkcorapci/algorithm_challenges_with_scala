package com.leetcode.challenges.medium

object PartitionLabels extends App {
  def partitionLabels(s: String): List[Int] = {
    // Keep track of last index of char
    val lastIndexMap = s.zipWithIndex.map { case (c, i) =>
      c -> i
    }.groupBy(_._1).map(_._2.maxBy(_._2))
    var p = 0
    var last = -1
    val res = scala.collection.mutable.ArrayBuffer[Int]()
    // Need to partition only when the last index for a char is visited.
    s.zipWithIndex.foreach { case (c, i) =>
      if (p < lastIndexMap(c)) p = lastIndexMap(c)
      if (p == i) {
        res += (i - last)
        last = p
      }
    }
    res.toList
  }
}
