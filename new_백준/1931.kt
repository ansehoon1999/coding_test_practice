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

    val deque = ArrayDeque<Pair<Int, Int>>()

    repeat(n) {
        st = StringTokenizer(br.readLine())
        val startTime = st.nextToken().toInt()
        val endTime = st.nextToken().toInt()

        deque.add(Pair(startTime, endTime))
    }

    deque.sortBy { it.first }
    deque.sortBy { it.second }

//    println(deque)


    var curTime = deque.removeFirst()
    var result = 1

    while(deque.isNotEmpty()) {

        val tmpTime = deque.removeFirst()

        if(curTime.second <= tmpTime.first) {
            curTime = tmpTime
            result ++
        }
    }

    println(result)

    bw.flush()
    bw.close()
}


