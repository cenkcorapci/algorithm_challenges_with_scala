package com.cc.algo.search

import java.io.PrintWriter

import scala.annotation.tailrec

object MinTimeRequired {
  // Complete the minTime function below.
  @tailrec
  def minTime(machines: Array[Long], goal: Long, days: Long = 1, step: Long = 1): Long = {
    if (machines.map(days / _).sum >= goal) days
    else minTime(machines, goal, days + step)
  }

  def check(machines: Array[Long], goal: Long): Long = {
    val minDay = machines.reduce(lcm)
    val minProduct = machines.map(minDay / _).sum
    if (minProduct > goal) minTime(machines, goal, step = machines.reduce(gcd))
    else {
      val daysReq = goal / minProduct * minDay
      daysReq + minTime(machines, goal % minProduct, step = machines.reduce(gcd))
    }

  }

  def gcd(a: Long, b: Long): Long = if (b == 0) a.abs else gcd(b, a % b)

  def lcm(a: Long, b: Long): Long = (a * b).abs / gcd(a, b)


  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nGoal = stdin.readLine.split(" ")

    val n = nGoal(0).trim.toInt

    val goal = nGoal(1).trim.toLong

    val machines = stdin.readLine.split(" ").map(_.trim.toLong)
    val result = check(machines, goal)

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
