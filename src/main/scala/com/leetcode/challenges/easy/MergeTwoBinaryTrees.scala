package com.leetcode.challenges.easy

import javax.swing.tree.TreeNode

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object MergeTwoBinaryTrees extends App {
  def mergeTrees(root1: TreeNode, root2: TreeNode): TreeNode = (root1, root2) match {
    case (null, null) => null
    case (null, root2) => root2
    case (root1, null) => root1
    case (root1, root2) => new TreeNode(root1.value + root2.value,
      mergeTrees(root1.left, root2.left),
      mergeTrees(root1.right, root2.right))

  }
}
