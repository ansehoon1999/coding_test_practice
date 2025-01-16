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

    val plusPQ = PriorityQueue<Long>(Collections.reverseOrder())
    val minusPQ = PriorityQueue<Long>()
    var isZero = false

    repeat(n) {
        st = StringTokenizer(br.readLine())
        val num = st.nextToken().toLong()

        if(num > 0) {
            plusPQ.add(num)
        } else if(num < 0) {
            minusPQ.add(num)
        } else {
            isZero = true
        }
    }

    var sum = 0L

//    println(plusPQ)
    while(plusPQ.size > 1) {

        val data1 = plusPQ.poll()!!
        val data2 = plusPQ.poll()!!

        if(data1 == 1L || data2 == 1L) {
            sum += (data1 + data2)
        } else {
            sum += (data1 * data2)
        }

//        println(sum)
    }

    if(plusPQ.isNotEmpty()) {
        sum += plusPQ.poll()!!
    }

//    println(sum)

    if(minusPQ.size % 2 == 0) {

        while (minusPQ.size > 1) {
            val data1 = minusPQ.poll()!!
            val data2 = minusPQ.poll()!!

            sum += (data1 * data2)
//            println(sum)
        }
    } else {

        while (minusPQ.size > 1) {
            val data1 = minusPQ.poll()!!
            val data2 = minusPQ.poll()!!

            sum += (data1 * data2)
//            println(sum)
        }

        if(minusPQ.isNotEmpty()) {
            if(!isZero) {
               sum += minusPQ.poll()!!
            }
        }
//        println(sum)
    }

    println(sum)


    bw.flush()
    bw.close()
}


