

data class TreeNode <T>(
    var data : T,
    var left : TreeNode<T>? = null,
    var right : TreeNode<T>? = null
)

class Tree {
    var root : TreeNode<String>? = null

    fun add (data : String, left : String, right : String) {
        if (root == null) {
            if ( data != ".") root = TreeNode(data)
            if ( left != ".") root!!.left = TreeNode(left)
            if ( right != ".") root!!.right = TreeNode(right)
        } else {
            search(root!!, data, left, right)
        }
    }

    fun search ( root : TreeNode<String>, data: String, left : String, right:String) {
        if ( root.data == data) {
            if (left != ".") root!!.left = TreeNode(left)
            if (right != ".") root!!.right = TreeNode(right)
        } else {
            if (root.left != null) search(root.left!!, data, left, right)
            if (root.right != null) search(root.right!!, data, left, right)
        }
    }

    fun preOrder(root : TreeNode<String>) {
        print(root.data)
        if (root.left != null) preOrder(root.left!!)
        if (root.right != null) preOrder(root.right!!)
    }

    fun inOrder(root: TreeNode<String>) {
        if (root.left != null) inOrder(root.left!!)
        print(root.data)
        if (root.right != null) inOrder(root.right!!)
    }

    fun postOrder(root : TreeNode<String>) {
        if (root.left != null) postOrder(root.left!!)
        if (root.right != null) postOrder(root.right!!)
        print(root.data)
    }

}

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt() // node count

    val tree = Tree()

    repeat(n) {
        val (a,b,c) = readLine().split(' ')
        tree.add(a, b, c)
    }

    tree.preOrder(tree.root!!)
    println()
    tree.inOrder(tree.root!!)
    println()
    tree.postOrder(tree.root!!)

}
