package com.codility

import scala.annotation.tailrec

object Counter extends App {
  @tailrec
  def solution(n: Int, a: Array[Int], sparseMatrix: Map[Int, Int] = Map.empty, base: Int = 0): Array[Int] = {
    if (a.isEmpty)
      (0 until n)
        .map(sparseMatrix.get)
        .map {
          case Some(c) => c
          case None => base
        }.toArray
    else if (a.head > n) {
      val max = if (sparseMatrix.nonEmpty) sparseMatrix.values.max else base
      solution(n, a.tail, sparseMatrix.view.mapValues(_ => max).toMap, max)
    } else {
      val add = (a.head - 1) -> (sparseMatrix.getOrElse(a.head - 1, base) + 1)
      solution(n, a.tail, sparseMatrix + add, base)
    }
  }

  println(solution(5, Array(3, 4, 4, 6, 1, 4, 4)).mkString(", "))
  println(solution(1, Array(2, 1, 1, 2, 1)).mkString(", "))
}
