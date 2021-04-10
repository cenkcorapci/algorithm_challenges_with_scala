package com.leetcode.challenges.medium

object ZigZagConversion extends App {

  def convert(s: String, numRows: Int): String = {
    val zagLength = numRows - 1
    LazyList.continually((0 to zagLength) ++ (zagLength - 1 to 1 by -1)).flatten
      .zip(s).sortBy(_._1).map(_._2).mkString
  }

  println(convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
  println(convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
  println(convert("A", 1) == "A")
  println(convert("A", 3) == "A")
}

