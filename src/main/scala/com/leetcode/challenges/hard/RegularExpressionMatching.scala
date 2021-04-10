package com.leetcode.challenges.hard

import scala.annotation.tailrec

/**
 * TODO change to dp
 */
object RegularExpressionMatching extends App {

  sealed trait RegexPattern

  case class AnyCharacter(repeat: Boolean = false) extends RegexPattern

  case class ACharacter(character: Char, repeat: Boolean = false) extends RegexPattern

  @tailrec
  def parseRegex(p: String, pattern: Array[RegexPattern] = Array.empty): Array[RegexPattern] =
    if (p.isEmpty) pattern
    else {
      val char = p.head
      val repetition = p.tail.headOption.contains('*')
      if (char.equals('*')) parseRegex(p.tail, pattern)
      else if (char.equals('.')) parseRegex(p.tail, pattern.lastOption match {
        case Some(AnyCharacter(true)) => pattern
        case _ =>
          val arr: Array[RegexPattern] = pattern :+ AnyCharacter(repetition)
          arr
      })
      else pattern.lastOption match {
        case Some(ACharacter(lc, true)) if lc == char =>
          parseRegex(p.tail, pattern)
        case _ => parseRegex(p.tail, pattern :+ ACharacter(char, repetition))
      }
    }

  @tailrec
  def matchAll(string: String, pattern: Array[RegexPattern]): Boolean =
    if (string.isEmpty && pattern.isEmpty) true
    else if (string.isEmpty) pattern match {
      case Array(AnyCharacter(true)) | Array(ACharacter(_, true)) => true
      case _ =>
        false
    }
    else {
      pattern.headOption match {
        case Some(ACharacter(char, true)) if char != string.head =>
          matchAll(string, pattern.tail)
        case Some(ACharacter(char, true)) if char == string.head =>
          matchAll(string.tail, pattern)
        case Some(ACharacter(char, false)) if char == string.head =>
          matchAll(string.tail, pattern.tail)
        case Some(AnyCharacter(false)) =>
          matchAll(string.tail, pattern.tail)
        case Some(AnyCharacter(true)) =>
          val willNextBeAMatch = for {
            nextPattern <- pattern.tail.headOption
            nextChar <- string.tail.headOption
          } yield (nextPattern, nextChar)
          willNextBeAMatch match {
            case Some((ACharacter(np, _), nc)) if nc == np => matchAll(string.tail, pattern.tail)
            case _ => matchAll(string.tail, pattern)
          }
        case None => false
      }
    }


  def isMatch(s: String, p: String): Boolean = matchAll(s, parseRegex(p))

  println(parseRegex("ab*a*c*a"))
  println("aaa", "ab*a*c*a")
  println(isMatch("aaa", "a*a"))
  println(isMatch(s = "mississippi", p = "mis*is*ip*."))
  println(isMatch(s = "aab", p = "c*a*b"))
  println(!isMatch(s = "aa", p = "a"))
  println(isMatch(s = "aa", p = "a*"))
  println(isMatch(s = "ab", p = ".*"))
  println(!isMatch(s = "mississippi", p = "mis*is*p*."))
}
