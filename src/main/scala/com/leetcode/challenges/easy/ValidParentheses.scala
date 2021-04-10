package org.cenkcorapci.challenges
package com.leetcode.challenges.easy

import scala.annotation.tailrec

object ValidParentheses extends App {

  @tailrec
  def isValid(s: String, stack: Array[Char] = Array.empty): Boolean =
    if (s.isEmpty && stack.isEmpty) true
    else s.headOption match {
      case Some(c) if c == '(' => isValid(s.tail, stack :+ c)
      case Some(c) if c == '[' => isValid(s.tail, stack :+ c)
      case Some(c) if c == '{' => isValid(s.tail, stack :+ c)

      case Some(c) if c == ')' && stack.lastOption.contains('(') => isValid(s.tail, stack.dropRight(1))
      case Some(c) if c == ']' && stack.lastOption.contains('[') => isValid(s.tail, stack.dropRight(1))
      case Some(c) if c == '}' && stack.lastOption.contains('{') => isValid(s.tail, stack.dropRight(1))
      case _ => false
    }

  println(isValid("()"))
  println(isValid("()[]{}"))
  println(!isValid("(]"))
  println(!isValid("([)]"))
  println(isValid("{[]}"))
}
