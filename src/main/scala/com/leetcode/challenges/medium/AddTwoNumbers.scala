package com.leetcode.challenges.medium

import scala.annotation.tailrec

object AddTwoNumbers extends App {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x


  }

  object ListNode {
    @tailrec
    def printNodes(node: ListNode): Unit =
      Option(node.next) match {
        case Some(node) =>
          println(node.x)
          printNodes(node.next)
        case None =>
          println(node.x)
      }
  }

  @tailrec
  def reverseList(head: ListNode, pointer: ListNode = null): ListNode =
    Option(head) match {
      case Some(node) =>
        Option(node.next) match {
          case Some(node) =>
            reverseList(node, new ListNode(head.x, pointer))
          case None =>
            new ListNode(head.x, pointer)
        }
      case None => pointer
    }


  @tailrec
  def addTwoNumbersRec(l1: Option[ListNode], l2: Option[ListNode], sum: ListNode = null, acc: Int = 0): ListNode =
    (l1, l2) match {
      case (None, None) =>
        if (acc == 0) reverseList(sum)
        else reverseList(new ListNode(acc, sum))
      case (maybeX, maybeY) =>
        val xp: Int = maybeX.map(_.x).getOrElse(0)
        val yp: Int = maybeY.map(_.x).getOrElse(0)
        val add = xp + yp + acc
        addTwoNumbersRec(
          maybeX.flatMap(n => Option(n.next)),
          maybeY.flatMap(n => Option(n.next)),
          new ListNode(add % 10, sum),
          if (add >= 10) 1 else 0)

    }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = addTwoNumbersRec(Option(l1), Option(l2))

  val listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)))
  val listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)))
  val result = addTwoNumbers(listNode1, listNode2)

  ListNode.printNodes(result)
  reverseList(null)

}
