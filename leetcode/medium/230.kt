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
    var list = mutableListOf<Int>() 
    
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        fun countTree(root : TreeNode?) {
            
            if (root == null) return

            // println(list)
            countTree(root?.left)
            list.add(root?.`val`)
            countTree(root?.right)
        }

        countTree(root)


        // list.sort()
        
        // 1. 루트 부터 시작
        // 2. k의 수를 
        return list[k-1]



    }
}