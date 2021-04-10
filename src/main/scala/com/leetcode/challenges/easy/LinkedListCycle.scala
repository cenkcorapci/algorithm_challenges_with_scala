package com.leetcode.challenges.easy

import scala.annotation.tailrec

object LinkedListCycle extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  @tailrec
  def check(first: ListNode, second: ListNode): Boolean =
    if (first == null || second == null || second.next == null) false
    else if (first.equals(second)) true
    else check(first.next, second.next.next)


  def hasCycle(head: ListNode): Boolean =
    if (head == null) false
    else if (head.next == null) false
    else check(head, head.next.next)


}
