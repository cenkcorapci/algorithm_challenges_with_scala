package org.cenkcorapci.challenges
package com.leetcode.challenges.medium

import scala.annotation.tailrec

/**
 * TODO Use stack to speed up
 */
object DailyTemperatures extends App {
  @tailrec
  def dailyTemperatures(T: Array[Int], days: Array[Int] = Array.empty): Array[Int] = {
    T.headOption match {
      case Some(temp) =>
        val next = T.takeWhile(_ <= temp)
        dailyTemperatures(T.tail,
          if (next.length == T.length) days :+ 0 else days :+ next.length)
      case None => days
    }
  }

  println(dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)).mkString(", "))
  println(dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)).sameElements(Array(1, 1, 4, 2, 1, 1, 0, 0)))
}
