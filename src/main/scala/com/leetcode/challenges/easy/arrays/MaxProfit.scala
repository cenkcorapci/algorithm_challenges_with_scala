package com.leetcode.challenges.easy.arrays

object MaxProfit {
  def maxProfit(prices: Array[Int]): Int =
    prices.sliding(2).collect { case Array(yesterday, today) => math.max(today - yesterday, 0) }.sum
}
