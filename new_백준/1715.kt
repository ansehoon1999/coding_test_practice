import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Collections
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    val pq = PriorityQueue<Int>()

    repeat(n) {
        st = StringTokenizer(br.readLine())
        pq.add(st.nextToken().toInt())
    }

    var sum = 0

    while (pq.size > 1) {

        val data1 = pq.poll()!!
        val data2 = pq.poll()!!

        val tmpSum = data1 + data2
        sum += tmpSum
        pq.add(tmpSum)
    }

    println(sum)

    bw.flush()
    bw.close()
}


