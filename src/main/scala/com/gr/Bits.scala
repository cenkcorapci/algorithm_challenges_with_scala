package com.gr

object Bits extends App {


  def solution(a: Array[Int], b: Array[Int]): Array[Int] = {

    if (a.isEmpty) return b
    if (b.isEmpty) return a

    val arr1 = a.reverse
    val arr2 = b.reverse

    val len1 = arr1.length
    val len2 = arr2.length
    val maxLen = (if (len1 > len2) len1
    else len2) + 2
    val result = new Array[Int](maxLen)
    var carry = 0
    var i = 0
    // deal with the common part where both the arrays has numbers
    while (len1 - 1 - i >= 0 && len2 - 1 - i >= 0) {
      val sum = arr1(len1 - 1 - i) + arr2(len2 - 1 - i) + carry
      result(maxLen - 1 - i) = getBit(sum)
      carry = getCarry(sum)
      i += 1
    }
    // deal with the rest part
    while (len1 - 1 - i >= 0 && maxLen - 1 - i >= 0) {
      val sum = arr1(len1 - 1 - i) + carry
      result(maxLen - 1 - i) = getBit(sum)
      carry = getCarry(sum)
      i += 1
    }
    while (len2 - 1 - i >= 0 && maxLen - 1 - i >= 0) {
      val sum = arr2(len2 - 1 - i) + carry
      result(maxLen - 1 - i) = getBit(sum)
      carry = getCarry(sum)
      i += 1
    }
    // deal with the remaining carry
    while (maxLen - 1 - i >= 0 && carry != 0) {
      result(maxLen - 1 - i) = getBit(carry)
      carry = getCarry(carry)
      i += 1
    }
    // remove the lead zeros
    var zeroLeadCount = 0
    while (zeroLeadCount < maxLen && result(zeroLeadCount) == 0) zeroLeadCount += 1
    if (zeroLeadCount == maxLen) return Array[Int](0)
    val res = new Array[Int](maxLen - zeroLeadCount)
    var k = 0
    while (k + zeroLeadCount < maxLen) {
      res(k) = result(k + zeroLeadCount)

      k += 1
    }
    res.reverse
  }

  // get carry according to the addition result number
  private def getCarry(num: Int): Int =
    if (num == 2 || num == 3) -1
    else if (num == -1) 1
    else 0


  // get bit according to the addition result number
  private def getBit(num: Int): Int =
    if (num == 2) 0
    else if (num == 3 || num == -1 || num == 1) 1
    else 0


  val a = Array(0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1)
  val b = Array(0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1)
  solution(a, b).foreach(println)
}
