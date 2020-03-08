package com.cc.algo.grab

object Bits extends App {
  def solution(a: Array[Int], b: Array[Int]): Array[Int] = {
    a.zipAll(b, 0, 0).zipWithIndex.map {
      case ((first, second), i) =>
        val force = math.pow(-2, i).toInt
        first * force + second * force
    }

  }

  val a = Array(0, 1, 0)
  val b = Array(1, 0, 1)
  val s = solution(a, b)
  s.map(println)
  println(NegativeBase.intToStr(s.sum, -2))
}

object NegativeBase {
  val digits = ('0' to '9') ++ ('a' to 'z') ++ ('A' to 'Z')

  def intToStr(n: Int, b: Int): String = {
    def _fromInt(n: Int): List[Int] = {
      if (n == 0) {
        Nil
      } else {
        val r = n % b
        val rp = if (r < 0) r + b else r
        val m = -(n - rp) / b
        rp :: _fromInt(m)
      }
    }

    _fromInt(n).map(digits).reverse.mkString
  }

  def strToInt(s: String, b: Int): Int = {
    s.map(digits.indexOf).foldRight((0, 1)) { case (x, (sum, pow)) =>
      (sum + x * pow, pow * -b)
    }._1
  }
}