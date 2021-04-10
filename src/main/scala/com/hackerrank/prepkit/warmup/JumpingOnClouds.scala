package com.hackerrank.prepkit.warmup

import java.io._

import scala.annotation.tailrec

object JumpingOnClouds {

  @tailrec
  def jumpingOnClouds(path: Array[Int], acc: Int = 0): Int =
    if (path.length <= 1) acc
    else if (path.length == 2) acc + 1
    else {
      if (path.tail.tail.head == 1) jumpingOnClouds(path.tail, acc + 1)
      else jumpingOnClouds(path.tail.tail, acc + 1)
    }


  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    //println(jumpingOnClouds(Array(0, 0, 0, 1, 0, 0)))
    //println(jumpingOnClouds(Array(0, 0, 1, 0, 0, 1, 0)))
    val _ = stdin.readLine.trim.toInt
    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c)

    try {
      val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
      printWriter.println(result)
      printWriter.close()
    } catch {
      case _: Exception => println(result)
    }
  }
}