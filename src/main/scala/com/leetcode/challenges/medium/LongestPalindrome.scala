package com.leetcode.challenges.medium

import scala.annotation.tailrec

/**
 * Todo has better options
 */
object LongestPalindrome extends App {

  @tailrec
  def getPalindrome(l: Int, r: Int, s: String, longest: String = ""): String =
    if (l >= 0 && r < s.length && s.charAt(l) == s.charAt(r)) getPalindrome(l - 1, r + 1, s, s.substring(l, r + 1))
    else longest


  @tailrec
  def longestPalindrome(s: String, longest: String = "", idx: Int = 0): String =
    if (longest.length > ((s.length - idx) * 2) + 1) longest
    else if (idx >= s.length) longest
    else {
      val odd = getPalindrome(idx, idx, s)
      val even = if (idx + 1 < s.length) getPalindrome(idx, idx + 1, s) else ""
      var currentLongest: String = if (odd.length > even.length) odd else even
      currentLongest = if (currentLongest.length > longest.length) currentLongest else longest
      longestPalindrome(s, currentLongest, idx + 1)
    }

  println(longestPalindrome("babad") == "bab")
  println(longestPalindrome("cbbd") == "bb")
  println(longestPalindrome("kajhdlkasjhbdlaaabaaaaskjhdgaskjhd") == "aaabaaa")
  println(longestPalindrome("kajhdlkasjhbdlaaabaaaaskjhdgasdfghgfdsaaskjhd") == "asdfghgfdsa")
  println(longestPalindrome("asdfdghjklşdaajaad") == "daajaad")
  println(longestPalindrome("daajaadasdfdghjklş") == "daajaad")

}
