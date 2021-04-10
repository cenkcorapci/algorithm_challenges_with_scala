package com.hackerrank.prepkit.arrays

import java.io.PrintWriter

object SparseArrays {
  // Complete the matchingStrings function below.
  def matchingStrings(strings: Array[String], queries: Array[String]):Unit = {
    val m = strings.groupBy(identity).mapValues(_.length)
    queries.foreach(q => println(m.getOrElse(q, 0)))

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val stringsCount = stdin.readLine.trim.toInt

    val strings = Array.ofDim[String](stringsCount)

    for (i <- 0 until stringsCount) {
      val stringsItem = stdin.readLine
      strings(i) = stringsItem
    }

    val queriesCount = stdin.readLine.trim.toInt

    val queries = Array.ofDim[String](queriesCount)

    for (i <- 0 until queriesCount) {
      val queriesItem = stdin.readLine
      queries(i) = queriesItem
    }


    matchingStrings(strings, queries)

  }
}
