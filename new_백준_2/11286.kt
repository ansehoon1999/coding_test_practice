import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs

data class Node(
    val r: Int,
    val c: Int,
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * dp[i][j] = i * j 행렬 곱셈 연산의 최소값
     * dp[i][j] = dp[i][k] * dp[k][j] -> i * k * j
     */


    val n = br.readLine().toInt()

    val pq = PriorityQueue<Long>({ a, b ->
        if(abs(a) != abs(b)) {
            (abs(a) - abs(b)).toInt()
        } else {
            (a - b).toInt()
        }
    })



    repeat(n) {
       val op = br.readLine().toLong()

        if(op == 0L) {
            if(pq.isEmpty()) println(0)
            else println(pq.poll())
        } else {
            pq.add(op)
        }

//        println(pq)
    }


    writer.flush()
    writer.close()
}















