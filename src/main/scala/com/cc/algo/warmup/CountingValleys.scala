package com.cc.algo.warmup

import scala.annotation.tailrec

/**
  * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike he took exactly  steps. For every step he took, he noted if it was an uphill, , or a downhill,  step. Gary's hikes start and end at sea level and each step up or down represents a  unit change in altitude. We define the following terms:
  *
  * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
  * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
  * Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
  *
  * For example, if Gary's path is , he first enters a valley  units deep. Then he climbs out an up onto a mountain  units high. Finally, he returns to sea level and ends his hike.
  */
object CountingValleys {


  def countingValleys(s: String): Int = {
    var total = 0
    val path = s.toCharArray.map {
      case 'D' => -1
      case 'U' => 1
    }.foldLeft(0) { case (acc, next) =>
      val inVal = acc < 0
      val a = acc + next
      if (!inVal && a < 0) total = total + 1
      a
    }
    total
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val _ = stdin.readLine.trim.toInt

    val s = stdin.readLine

    val result = countingValleys(s)

    println(result)

  }
}
