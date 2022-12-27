import java.util.StringTokenizer


lateinit var preOrder : MutableList<Int>
lateinit var inOrder : MutableList<Int>
lateinit var postOrder : MutableList<Int>

lateinit var position : MutableList<Int>
var n = 0

val sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()){
    n = readLine().toInt()

    inOrder = MutableList<Int>(100000) { 0 }
    postOrder = MutableList<Int>(100000) { 0 }
    position = MutableList<Int>(100001) { 0 }

    var input = StringTokenizer(readLine())
    repeat(n) {
        inOrder[it] = input.nextToken().toInt()
    }
    input = StringTokenizer(readLine())
    repeat(n) {
        postOrder[it] = input.nextToken().toInt()
    }
    repeat(n) {
        position[inOrder[it]] = it
    }

    solve (0, n-1, 0, n-1)
    println(sb)
}

fun solve(i1: Int, i2: Int, p1: Int, p2: Int) {
    if (i1 > i2 || p1 > p2) return
    val root = postOrder[p2]

    sb.append(root) // 1
    sb.append(' ')

    val inRoot = position[root]
    val left_count = inRoot - i1
    solve(i1,inRoot -1, p1, p1+left_count-1)
    solve(inRoot+1, i2, p1+left_count, p2-1)

}



