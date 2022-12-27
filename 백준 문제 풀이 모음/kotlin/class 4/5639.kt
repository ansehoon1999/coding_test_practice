

data class Node (val root : Int, var left : Node?, var right : Node?) {
  fun addChildeNode(n :Int) {
      if (n > root) {
          if (right == null) right = Node(n, null, null)
          else right!!.addChildeNode(n)
      } else {
          if (left == null) left = Node(n,null, null)
          else left!!.addChildeNode(n)
      }
  }
}

val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()){

    val root = Node(readLine().toInt(), null, null)

    while (true) {
        val input = readLine()
        if (input == null) break
        else {
            root.addChildeNode(input.toInt())
        }
    }

    postOrder(root)
    println(sb)
}

fun postOrder(node: Node?) {
    if (node != null) {
        postOrder(node.left)
        postOrder(node.right)
        sb.append(node.root)
        sb.append('\n')
    }
}
