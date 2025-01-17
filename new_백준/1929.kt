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
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val sb = StringBuilder()

    for(i in m .. n) {
        if(isPrime(i)) {
            sb.append(i)
            sb.append("\n")
        }
    }

    println(sb.toString())

    bw.flush()
    bw.close()
}

fun isPrime(num: Int): Boolean {

    if(num == 1) return false
    if(num == 2) return true

    for(i in 2 .. Math.sqrt(num.toDouble()).toInt()) {
        if(num % i == 0) {
            return false
        }
    }
    return true
}


