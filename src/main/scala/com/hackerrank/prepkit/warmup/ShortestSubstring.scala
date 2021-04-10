package com.hackerrank.prepkit.warmup

import scala.annotation.tailrec

object ShortestSubstring extends App {
  def shortestSubstring(s: String): Int = {
    val charSet = s.toCharArray.toSet

    @tailrec
    def find(minLen: Int): Int = {
      if (minLen == s.length) s.length
      else {
        val maybeContains = (0 until s.length - minLen + 1).find {
          index =>
            val subSet = s.substring(index, index + minLen)
            subSet.toCharArray.toSet.size == charSet.size
        }
        maybeContains match {
          case Some(_) => minLen
          case _ => find(minLen + 1)
        }
      }
    }

    find(charSet.size)

  }

  println(shortestSubstring("aabcce"))
  println(shortestSubstring("aabcce") == 5)
  println(shortestSubstring("bab") == 2)

}
