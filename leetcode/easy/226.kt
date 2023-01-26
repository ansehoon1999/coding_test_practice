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
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        else {
            val root = root

            fun invert(node : TreeNode?) {
                if (node == null) return
                
                val left = node?.left
                val right = node?.right
                // println("left ${left?.`val`} right ${right?.`val`}")
                node?.left = right
                node?.right = left
                
                invert(node?.left)
                invert(node?.right)
            }

            invert(root)

            return root

        }
    }
}