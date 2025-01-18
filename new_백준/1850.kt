import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

var gcdResult = 0

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()

    val cnt = if(a < b) {
        gcd(a, b)
    } else {
        gcd (b, a)
    }

    val sb = StringBuilder()

    for(i in 0 until cnt) {
        sb.append("1")
    }

    println(sb.toString())

    bw.flush()
    bw.close()
}

fun gcd(small: Long, big: Long): Long {


    val els = big % small

    if(els == 0L) {
        return small
    }

    return gcd(els, small)
}
