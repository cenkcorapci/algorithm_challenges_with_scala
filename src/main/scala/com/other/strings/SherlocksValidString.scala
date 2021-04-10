package com.other.strings

import java.io.PrintWriter

object SherlocksValidString {

  // Complete the isValid function below.
  def isValid(s: String): Boolean = {
    val freqs = s.toCharArray.groupBy(identity)
      .mapValues(_.length)
      .values
      .toList
      .groupBy(identity)
      .mapValues(_.length)
      .toList

    freqs match {
      case x: List[(Int, Int)] if x.length == 1 => true
      case List((c1, f1), (c2, f2)) if c1 == 1 || c2 == 1 => (c1 == 1 && f1 == 1) || (c2 == 1 && f2 == 1)
      case List((c1, f1), (c2, f2)) => (f1 == 1 || f2 == 1) && math.abs(c1 - c2) == 1
      case _ => false
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val s = stdin.readLine

    val result = if (isValid(s)) "YES" else "NO"
    try {
      val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

      printWriter.println(result)

      printWriter.close()
    } catch {
      case _: Exception =>
        print(result)
    }

  }
}

