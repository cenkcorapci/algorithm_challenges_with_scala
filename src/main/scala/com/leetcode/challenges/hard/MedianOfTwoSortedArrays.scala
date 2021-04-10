package com.leetcode.challenges.hard

import scala.annotation.tailrec

object MedianOfTwoSortedArrays extends App {
  def findMedian(arr: Array[Int]): Option[Double] = if (arr.nonEmpty && arr.length % 2 == 0) {
    for {
      first <- arr.drop(arr.length / 2).headOption
      second <- arr.take(arr.length / 2).lastOption
    } yield first + second
  }.map(_.toDouble / 2.0)
  else if (arr.nonEmpty && arr.length % 2 == 1) arr.drop(arr.length / 2).headOption.map(_.toDouble)
  else None

  @tailrec
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int], acc: Array[Int] = Array.empty[Int]): Double = {
    if (nums1.isEmpty && nums2.isEmpty)
      findMedian(acc).getOrElse(0.0)
    else if (nums1.isEmpty && nums2.nonEmpty)
      findMedianSortedArrays(nums1, nums2.tail, acc :+ nums2.head)
    else if (nums1.nonEmpty && nums2.isEmpty)
      findMedianSortedArrays(nums1.tail, nums2, acc :+ nums1.head)
    else {
      val num2 = nums2.head
      val num1 = nums1.head
      val tail1 = nums1.tail.headOption
      val tail2 = nums2.tail.headOption
      if (tail2.exists(num1 >= _))
        findMedianSortedArrays(nums1, nums2.tail, acc ++ nums2.headOption.toList)
      else if (tail1.exists(num2 >= _))
        findMedianSortedArrays(nums1.tail, nums2, acc ++ nums1.headOption.toList)
      else {
        if (nums1.head > nums2.head)
          findMedianSortedArrays(nums1.tail, nums2.tail, acc :+ nums2.head :+ nums1.head)
        else
          findMedianSortedArrays(nums1.tail, nums2.tail, acc :+ nums1.head :+ nums2.head)
      }

    }
  }

  println(findMedianSortedArrays(Array(3), Array(-2, -1)) == -1.0)
  println(findMedianSortedArrays(Array(2), Array(1, 3)) == 2.0)
  println(findMedianSortedArrays(Array(1, 3), Array(2)) == 2.0)
  println(findMedianSortedArrays(Array(1, 2), Array(3, 4)) == 2.5)
  println(findMedianSortedArrays(Array(0, 0), Array(0, 0)) == 0.0)
}
