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
        
        var state = true
        fun same (p : TreeNode?, q : TreeNode?) {
            if (p == null && q == null) return
            
            val pValue = p?.`val` ?: 1000000
            val qValue = q?.`val` ?: 1000000
            
            // println("pValue ${pValue} qValue ${qValue}")

            if (pValue != qValue) {
                state = false
                return 
            }

            same(p?.left, q?.left)
            same(p?.right, q?.right)
        }
        
        same(p, q)

        return state
    }
}