package com.cc.algo.st

import scala.annotation.tailrec

object ParticleVelocity extends App {

  def solution2(a: Array[Int]): Int = {
    @tailrec
    def solve(arr: Array[Int],
              lastSpeedChange: Option[Int] = None,
              speedUnchangedSince: Int = 0,
              acc: Int = 0): Int =
      arr.tail.headOption.map(_ - arr.head) match {
        case Some(speedChange) if lastSpeedChange.contains(speedChange) =>
          val sus = speedUnchangedSince + 1
          val total = if (sus == 2) acc + 1 else acc
          solve(arr.tail, Some(speedChange), sus, total)
        case maybeSpeedChange: Some[Int] =>
          solve(arr.tail, maybeSpeedChange, 0, acc)
        case None =>
          acc
      }

    solve(a)
  }

  def solution(a: Array[Int]): Int =
    (3 until a.length)
      .map(window => a.sliding(window).count(_.sliding(2).map(_.reduce(_ - _)).toSet.size == 1)).sum


  println(solution(Array(-1, 1, 3, 3, 3, 2, 3, 2, 1, 0)))
}
