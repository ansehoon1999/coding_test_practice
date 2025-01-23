import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer


data class Node(
    val value: String,
    var left: Node?,
    var right: Node?
)

var result1 = ""
var result2 = ""
var result3 = ""

var rootNode: Node? = null

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()



    repeat(n) {
        val (curValue, left, right) = br.readLine().split(" ").map { it }

        if (it == 0) {
            rootNode = Node(
                value = curValue,
                left = if (left == ".") null else Node(left, null, null),
                right = if (right == ".") null else Node(right, null, null),
            )
        } else {
            dfs(rootNode, curValue, left, right)

        }
    }

    order1(rootNode)
    order2(rootNode)
    order3(rootNode)

    println(result1)
    println(result2)
    println(result3)

//    println(rootNode)


    bw.flush()
    bw.close()

}

fun order1(curNode: Node?) {

    if(curNode == null) {
        return
    }

    result1 += curNode.value
    order1(curNode?.left)
    order1(curNode?.right)
}

fun order2(curNode: Node?) {

    if(curNode == null) {
        return
    }

    order2(curNode?.left)
    result2 += curNode.value
    order2(curNode?.right)
}

fun order3(curNode: Node?) {

    if(curNode == null) {
        return
    }

    order3(curNode?.left)
    order3(curNode?.right)
    result3 += curNode.value

}

fun dfs(curNode: Node?, cur: String, left: String, right: String) {

    if(curNode == null) return

    if (curNode.value == cur) {

        if (left != ".") {
            curNode.left = Node(
                value = left,
                left = null,
                right = null
            )
        }

        if (right != ".") {
            curNode.right = Node(
                value = right,
                left = null,
                right = null
            )
        }


        return
    }

    dfs(curNode.left, cur, left, right)
    dfs(curNode.right, cur, left, right)


}


