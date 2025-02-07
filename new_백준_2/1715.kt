import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val pq = PriorityQueue<Long>()

    repeat(n) {
        pq.add(br.readLine().toLong())
    }

    var result = 0L

    while (pq.size > 1) {
        val cur1 = pq.poll()
        val cur2 = pq.poll()

        result += (cur1 + cur2)
        pq.add(cur1+ cur2)

    }

    println(result)


    writer.flush()
    writer.close()
}



