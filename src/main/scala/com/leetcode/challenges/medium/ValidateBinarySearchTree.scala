package com.leetcode.challenges.medium

/**
 * TODO make it functional
 */
object ValidateBinarySearchTree extends App {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def isValidBST(root: TreeNode): Boolean = {
    val stack = scala.collection.mutable.Stack[TreeNode]()
    var maxValue = Long.MinValue
    var node = root
    while (node != null || stack.isEmpty) {
      while (node != null) {
        stack.push(node)
        node = node.left
      }
      val nd = stack.pop
      if (nd.value <= maxValue) {
        return false
      }
      maxValue = nd.value
      node = nd.right
    }
    true
  }

}
