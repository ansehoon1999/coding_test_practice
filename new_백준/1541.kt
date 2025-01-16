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
    val mathLine = st.nextToken().toString().toList()

    val deque = ArrayDeque<String>()

    var idx = 0
    var tmp = ""
    while(mathLine.size > idx) {

        val temp = mathLine[idx].toString()

        if(temp == "-") {
            deque.add(tmp)
            tmp = ""
        } else {
            tmp += temp
        }

        idx ++
    }

    deque.add(tmp)



    val first = deque.removeFirst().split("+")
    var sum = 0
    first.forEach {
        sum += it.toInt()
    }

    while(deque.isNotEmpty()) {
        val first = deque.removeFirst().split("+")

        var tmpSum = 0
        first.forEach {
            tmpSum += it.toInt()
        }

        sum -= tmpSum

    }


    println(sum)


    bw.flush()
    bw.close()
}


