/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    fun isIdentical(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true

        else if (root == null || subRoot == null || root?.`val` != subRoot?.`val`) return false

        if(!isIdentical(root?.left, subRoot?.left)) return false

        if(!isIdentical(root?.right, subRoot?.right)) return false


        return true
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false

        if(root?.`val` == subRoot?.`val`) {
            if (isIdentical(root, subRoot)) {
                return true
            }
        }

        return isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
    }
}