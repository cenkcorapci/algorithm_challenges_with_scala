package com.gr

import scala.annotation.tailrec
import scala.util.Try

object LinkedListJump extends App {
  def solution(a: Array[Int]): Int = {
    @tailrec
    def s(go: Int = 0, counter: Int = 0): Int =
      Try(a(go)).toOption match {
        case Some(nextIndex) =>
          if (nextIndex == -1) counter + 1
          else s(nextIndex, counter + 1)
        case None => counter
      }

    s()
  }

  print(solution(Array(1, 4, -1, 3, 2)))
}
