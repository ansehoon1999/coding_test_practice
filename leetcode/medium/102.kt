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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val map = HashMap<Int, MutableList<Int>>()
        val result = mutableListOf<MutableList<Int>>()

        if (root == null) return result

        fun dfs (root :TreeNode?, count : Int) {
            if (root == null) return

            if(map[count] == null) map.put(count, mutableListOf<Int>(root.`val`))
            else {
                map[count]!!.add(root.`val`)
            }

            dfs(root?.left, count+1)
            dfs(root?.right, count+1)
        }

        dfs(root, 0)

        for (i in 0 until map.size) {
            result.add(map[i]!!)
        }

        // println(result)

        return result
    }
}