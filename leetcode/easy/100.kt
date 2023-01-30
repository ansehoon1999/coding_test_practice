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
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        else if (p == null && q != null) return false
        else if (p != null && q == null) return false
        
        if (p?.`val` != q?.`val`) return false

        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)

    }
}