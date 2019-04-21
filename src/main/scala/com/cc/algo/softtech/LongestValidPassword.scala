package com.cc.algo.softtech

import scala.annotation.tailrec

object LongestValidPassword extends App {
  def solution(s: String): Int = {
    @tailrec
    def solve(str: String, longest: Int = -1, acc: Int = 0, seenUpper: Boolean = false): Int = {
      if (str.isEmpty) {
        if (seenUpper && acc > longest) acc
        else longest
      }
      else {
        if (str.head.isDigit) {
          if (seenUpper) solve(str.tail, acc)
          else solve(str.tail, longest)
        }
        else if (str.head.isUpper) solve(str.tail, longest, acc + 1, true)
        else solve(str.tail, longest, acc + 1, seenUpper)

      }
    }

    solve(s)
  }

  println(solution("a0Ba"))
  println(solution("a0Ba0"))
  println(solution("1,2B3131230asasdqeq3a")) // 1
  println(solution("1,2B3131230asasdqUq3a")) // 9
  println(solution("asdsad23123"))
}
