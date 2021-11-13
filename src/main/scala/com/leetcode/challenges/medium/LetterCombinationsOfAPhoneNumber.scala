package com.leetcode.challenges.medium

object LetterCombinationsOfAPhoneNumber extends App {
  val alphabet = "abc,def,ghi,jkl,mno,pqrs,tuv,wxyz".split(",").map(_.toCharArray)

  def letterCombinations(digits: String, combinations: Array[String] = Array.empty): List[String] =
    if (digits.isEmpty) combinations.toList
    else {
      val letters = alphabet(digits.head.toString.toInt - 2)
      if (combinations.isEmpty) letterCombinations(digits.tail, letters.map(_.toString))
      else letterCombinations(digits.tail,
        combinations.flatMap(previous => letters.map(next => previous + next)))
    }

  println(letterCombinations("23") == List("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
}
