package org.cenkcorapci.challenges
package com.leetcode.challenges.medium

import scala.annotation.tailrec

object GenerateParentheses extends App {
  case class Syntax(left: Int, seq: String, toClose: Int)

  @tailrec
  def generateParenthesis(n: Int, list: List[Syntax] = List.empty): List[String] = {
    if (list.nonEmpty && list.map(s => s.left + s.toClose).sum == 0) list.map(_.seq)
    else if (list.isEmpty) generateParenthesis(n, List(Syntax(n - 1, "(", 1)))
    else generateParenthesis(n, list.flatMap {
      case Syntax(left, seq, toClose) if left > 0 && toClose > 0 =>
        List(Syntax(left - 1, seq + "(", toClose + 1), Syntax(left, seq + ")", toClose - 1))
      case Syntax(left, seq, toClose) if left == 0 && toClose > 0 =>
        val closed: String = seq + List.fill(toClose)(')').mkString
        List(Syntax(left, closed, 0))
      case Syntax(left, seq, toClose) if left > 0 && toClose == 0 =>
        List(Syntax(left - 1, seq + "(", toClose + 1))
      case syntax: Syntax =>
        List(syntax)
    })
  }

  println(generateParenthesis(3))
  println(generateParenthesis(3).equals(List("((()))", "(()())", "(())()", "()(())", "()()()")))
}
