package org.cenkcorapci.challenges
package com.leetcode.challenges.medium

import scala.annotation.tailrec

object NthNodeOfTheList extends App {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  @tailrec
  def toList(next: ListNode, list: List[Int] = List.empty): List[Int] =
    if (next != null) toList(next.next, list :+ next.x)
    else list

  @tailrec
  def toLinkedList(list: List[Int], node: ListNode): ListNode =
    if (list.isEmpty) node
    else toLinkedList(list.tail, new ListNode(_x = list.head, _next = node))

  def removeNthFromEnd(head: ListNode, n: Int, next: Option[ListNode] = None): ListNode =
    if (head == null) null
    else if (head.next == null && n > 0) null
    else {
      val l = toList(head).zipWithIndex.filterNot(_._2 == n - 1).map(_._1).reverse
      toLinkedList(l.tail, new ListNode(l.head))
    }


  @tailrec
  def printNodes(n: ListNode): Unit =
    if (n != null) {
      println(n.x)
      printNodes(n.next)
    }

  println(printNodes(removeNthFromEnd(new ListNode(1, new ListNode(2)), 1)))

  println(printNodes(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3))), 1)))
  println(printNodes(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3))), 0)))
  println(printNodes(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3))), 2)))
  println(printNodes(removeNthFromEnd(null, 2)))
  println(printNodes(removeNthFromEnd(new ListNode(1), 0)))

}
