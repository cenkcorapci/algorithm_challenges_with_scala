package com.leetcode.challenges.medium

import scala.annotation.tailrec

object LongestSubStringWithOutRepetition extends App {
  @tailrec
  def lengthOfLongestSubstring(s: String,
                               subString: String = "",
                               maxLength: Int = 0): Int =
    if (s.isEmpty)
      math.max(subString.length, maxLength)
    else {
      val firstIndex = subString.indexOf(s.head)
      if (firstIndex == -1)
        lengthOfLongestSubstring(s.tail,
          subString + s.head,
          maxLength)
      else
        lengthOfLongestSubstring(s.tail,
          subString.substring(firstIndex + 1) + s.head,
          math.max(subString.length, maxLength))
    }

  println(lengthOfLongestSubstring("dvdf") == 3)
  println(lengthOfLongestSubstring("aabaab!bb") == 3)
  println(lengthOfLongestSubstring("abcabcbb") == 3)
  println(lengthOfLongestSubstring("bbbbb") == 1)
  println(lengthOfLongestSubstring("pwwkew") == 3)

}
