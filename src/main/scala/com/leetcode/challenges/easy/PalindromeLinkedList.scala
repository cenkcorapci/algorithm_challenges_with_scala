package com.leetcode.challenges.easy

import scala.annotation.tailrec

object PalindromeLinkedList extends App {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  @tailrec
  def check(arr: Array[Int], middle: ListNode): Boolean =
    if (middle == null && arr.isEmpty) true
    else if (arr.lastOption.contains(middle.x))
      check(arr.dropRight(1), middle.next)
    else false

  @tailrec
  def findTheMiddlePositionAndCheck(slow: ListNode, fast: ListNode, acc: Array[Int] = Array.empty): Boolean =
    if (fast == null) check(acc :+ slow.x, slow.next)
    else if (fast.next == null) check(acc :+ slow.x, slow.next.next)
    else findTheMiddlePositionAndCheck(slow.next, fast.next.next, acc :+ slow.x)


  def isPalindrome(head: ListNode): Boolean =
    if (head == null || head.next == null) true
    else findTheMiddlePositionAndCheck(head, head.next.next)

  println(isPalindrome(new ListNode(1, new ListNode(1, null))))
  println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3,
    new ListNode(2, new ListNode(1, null)))))))
  println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))))))
}

