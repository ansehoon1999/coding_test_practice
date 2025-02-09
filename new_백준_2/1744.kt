import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val plusList = PriorityQueue<Int>(Collections.reverseOrder())
    val minusList = PriorityQueue<Int>()

    repeat(n) {
        val tmp = br.readLine().toInt()

        if(tmp > 0) {
            plusList.add(tmp)
        } else {
            minusList.add(tmp)
        }
    }

    var sum = 0L
    while (plusList.size >= 2) {
        val p1 = plusList.poll()
        val p2 = plusList.poll()

        if(p1 == 1 || p2 == 1) {
            sum += (p1.toLong() + p2.toLong())
        } else {
            sum += (p1.toLong() * p2.toLong())
        }

    }

    if(plusList.isNotEmpty()) {
        sum += plusList.poll().toLong()
    }

    while(minusList.size >= 2) {
        val p1 = minusList.poll()
        val p2 = minusList.poll()

        sum += (p1.toLong() * p2.toLong())

    }

    if(minusList.isNotEmpty()) {
        sum += minusList.poll().toLong()
    }



    println(sum)

    writer.flush()
    writer.close()
}

