



data class TreeNode <T> (
    var data : Int,
    var left : TreeNode <T>? = null,
    var right : TreeNode <T>? = null
)

class Tree {
    var root : TreeNode<Int>? = null

    fun add (data : Int) {
        if (root == null) {
            root = TreeNode(data)
        } else {
            search(root!!, data)
        }
    }

    private fun search(root: TreeNode<Int>, data: Int) {
        if (root.data > data) {
            if (root.left == null) root.left = TreeNode(data)
            else search(root.left!!, data)
        } else {
            if (root.right == null) root.right = TreeNode(data)
            else search(root.right!!, data)
        }
    }

}

fun postOrder (root : TreeNode<Int>) {
    if (root.left != null) postOrder(root.left!!)
    if (root.right != null) postOrder(root.right!!)
    println(root.data)
}
fun main() {
    val sb = System.`in`.bufferedReader()
    val tree = Tree()
    while (true) {
        val n = sb.readLine()
        if (n == null) break
        else {
            tree.add(n.toInt())
        }
    }

    postOrder(tree.root!!)
}

