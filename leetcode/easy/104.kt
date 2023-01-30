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
    fun maxDepth(root: TreeNode?, count : Int = 0): Int {
        if (root == null) return count
        else {

            val x = maxDepth(root?.left, count+1)
            val y = maxDepth(root?.right, count+1)

            return maxOf(x, y)
        }

        
        
    }
}