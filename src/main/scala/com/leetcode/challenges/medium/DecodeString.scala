package org.cenkcorapci.challenges
package com.leetcode.challenges.medium

import scala.annotation.tailrec

object DecodeString extends App {
  case class Repetition(times: Int, str: String)

  @tailrec
  def decodeString(s: String, acc: Array[Char] = Array.empty, stack: Array[Repetition] = Array.empty): String = {
    s.headOption match {
      case Some(digit) if digit.isDigit =>
        val times = s.takeWhile(_.isDigit).toInt
        val rest = s.dropWhile(_.isDigit)
        decodeString(rest.tail, acc, stack :+ Repetition(times, ""))
      case Some(c) if c.isLetter =>
        stack.lastOption match {
          case Some(Repetition(times, str)) =>
            decodeString(s.tail, acc, stack.dropRight(1) :+ Repetition(times, str + c))
          case None => decodeString(s.tail, acc :+ c, stack)
        }
      case Some(c) if c == ']' =>
        val last = stack.last
        val newStack = stack.dropRight(1)
        newStack.lastOption match {
          case Some(Repetition(times, str)) =>
            val nextInLine = Repetition(times, str + (0 until last.times).map(_ => last.str).mkString)
            decodeString(s.tail, acc, newStack.dropRight(1) :+ nextInLine)
          case None =>
            val next = (0 until last.times).map(_ => last.str).mkString
            decodeString(s.tail, acc ++ next.toCharArray, newStack)
        }
      case _ => acc.mkString
    }
  }

  println(decodeString("3[a]2[bc]") == "aaabcbc")
  println(decodeString("3[a2[c]]") == "accaccacc")
  println(decodeString("2[abc]3[cd]ef") == "abcabccdcdcdef")
  println(decodeString("abc3[cd]xyz") == "abccdcdcdxyz")
  println(decodeString("100[leetcode]") == "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode")
}
