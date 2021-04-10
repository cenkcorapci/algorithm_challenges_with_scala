package com.leetcode.challenges.medium

import scala.annotation.tailrec

object LinkedListCycleII extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  @tailrec
  def check(first: ListNode, second: ListNode): Option[ListNode] =
    if (first == null || second == null || second.next == null) None
    else if (first == second) Some(first)
    else check(first.next, second.next.next)

  @tailrec
  def checkSlow(head: ListNode, collision: ListNode): ListNode =
    if (head == collision) head
    else checkSlow(head.next, collision.next)

  def detectCycle(head: ListNode): ListNode =
    if (head == null) null
    else if (head.next == null) null
    else check(head, head.next) match {
      case Some(current) => checkSlow(head, current.next)
      case None => null
    }
}
