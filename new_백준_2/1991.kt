import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(
    val value: String,
    var left: Node?,
    var right: Node?
)

fun makeTree(node: Node?, a: String, b: String, c: String) {

    if (node == null) return

    if(node.value == a) {
        if(b != ".") node.left = Node(b, null, null)
        if(c != ".") node.right = Node(c, null, null)
    } else {
        makeTree(node.left, a, b, c)
        makeTree(node.right, a, b, c)
    }

}

var search1 = ""

fun search1(node: Node?) {

    if(node == null) return

    search1 += node?.value
    search1(node?.left)
    search1(node?.right)
}

var search2 = ""

fun search2(node: Node?) {

    if(node == null) return
    search2(node?.left)
    search2 += node?.value
    search2(node?.right)
}

var search3 = ""

fun search3(node: Node?) {

    if(node == null) return

    search3(node?.left)
    search3(node?.right)
    search3 += node?.value
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val rootNode = Node("A", null, null)

    repeat(n) {
        val (a, b, c) = br.readLine().split(" ").map { it.toString() }

        makeTree(rootNode, a, b, c)
    }

    search1(rootNode)
    search2(rootNode)
    search3(rootNode)

    println(search1)
    println(search2)
    println(search3)
}










