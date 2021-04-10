package com.hackerrank.prepkit.arrays

object BalancedArray extends App {
  /*
     * Complete the 'balancedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY sales as parameter.
     */

  def balancedSum(sales: Array[Int]): Int = {
    var summed = 0
    var left = sales.drop(1).sum
    var minimum: Option[Int] = None
    var minimumIndex = -1
    sales.drop(1).zipWithIndex.foreach {
      case (value, index) =>
        if (summed == (left - value)) {
          minimum match {
            case None =>
              minimumIndex = index
              minimum = Some(value)
            case Some(m) if m > value =>
              minimumIndex = index
              minimum = Some(value)
          }
        }

        summed = summed + value
        left = left - value

    }
    minimumIndex
  }


  println(balancedSum(Array(3, 1, 3, 1)) == 1)
  println(balancedSum(Array(5, 1, 2, 3, 4, 6)) == 3)
  println(balancedSum(Array(4, 1, 2, 3, 3)) == 2)
}
