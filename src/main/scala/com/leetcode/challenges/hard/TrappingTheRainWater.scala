package org.cenkcorapci.challenges
package com.leetcode.challenges.hard

import scala.collection.mutable

object TrappingTheRainWater extends App {

  /**
   * TODO Make it recursive and fix
   *
   * @param height
   * @return
   */
  def trap(height: Array[Int]): Int = {
    val stack = new mutable.Stack[Int]()
    var waterTrapped = 0

    height.indices.foreach { i =>
      while (stack.nonEmpty && height(i) > height(stack.top)) { // With water trapped.
        val bottomHeight = height(stack.pop)
        if (stack.nonEmpty) {
          val leftHeight = height(stack.top)
          val width = i - stack.top - 1
          waterTrapped += width * (Math.min(leftHeight, height(i)) - bottomHeight)
        }
      }
      stack.push(i)
    }

    waterTrapped
  }


  println(trap(Array(4, 2, 0, 3, 2, 5)) == 9)
  println(trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) == 6)
  println(trap(Array(4, 2, 0, 3, 2, 5)) == 9)
}
