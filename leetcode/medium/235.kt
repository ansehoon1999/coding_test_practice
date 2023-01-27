/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    


    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            val curValue = root!!.`val`
            val pValue = p!!.`val`
            val qValue = q!!.`val`

            if (pValue < curValue && qValue < curValue) return lowestCommonAncestor(root?.left, p, q)

            else if(pValue > curValue && qValue > curValue) return lowestCommonAncestor(root?.right, p, q)

            else return root

        
    }
}