import java.io.BufferedReader
import java.io.InputStreamReader


data class Node(
    val a: Int,
    val b: Int,
    val c: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

    val dp = MutableList<MutableList<MutableList<Boolean>>>(202) {
        MutableList<MutableList<Boolean>>(202) {
            MutableList<Boolean>(202) { false }
        }
    }


    dp[0][0][c] = true

    val deque = ArrayDeque<Node>()
    deque.add(Node(0, 0, c))

    fun pour(a: Int, b: Int, c: Int) {
        if(!dp[a][b][c]) {
            dp[a][b][c] = true
            deque.add(Node(a, b, c))
        }
    }


    val result = mutableListOf<Int>()
    while (deque.isNotEmpty()) {
        val cur = deque.removeFirst()
        if(cur.a == 0) {
            result.add(cur.c)
        }


        // a -> b
        val x1 = minOf(cur.a, b - cur.b)
        pour(cur.a - x1, cur.b + x1, cur.c)

        // a -> c
        val x2 = minOf(cur.a, c - cur.c)
        pour(cur.a - x2, cur.b, cur.c + x2)

        // b -> a
        val x3 = minOf(cur.b, a - cur.a)
        pour(cur.a + x3, cur.b - x3, cur.c)

        // b -> c
        val x4 = minOf(cur.b, c - cur.c)
        pour(cur.a, cur.b - x4, cur.c + x4)

        // c -> a
        val x5 = minOf(cur.c, a - cur.a)
        pour(cur.a + x5, cur.b, cur.c - x5)

        // c -> b
        val x6 = minOf(cur.c, b - cur.b)
        pour(cur.a, cur.b + x6, cur.c - x6)
    }

    result.sort()

    result.forEach {
        print("${it} ")
    }

}














