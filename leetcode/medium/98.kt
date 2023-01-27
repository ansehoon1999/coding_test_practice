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
    fun isValidBST(root: TreeNode?, start: Long = Long.MIN_VALUE, end : Long = Long.MAX_VALUE ): Boolean {
        var root = root
        
        if (root == null) return true

        if (end < start ) {
            return false
        }

        if (start > root?.`val`.toLong() || root?.`val`.toLong() > end) {
            return false
        }

        // if (start <= root.`val` && root.`val` <= end)

        // var leftStart = Integer.MIN_VALUE
        // var leftEnd = root.`val` -1

        // var rightStart = root.`val` + 1
        // var rightEnd = Integer.MAX_VALUE


        var leftState = isValidBST(root?.left, start, root?.`val`.toLong() -1)
        var rightState = isValidBST(root?.right, root?.`val`.toLong() + 1, end)

        // 1. 첫 루트 노드부터 시작
        // 2. 왼쪽과 오른쪽 크기 탐색
        // 
        return leftState && rightState
    }
}