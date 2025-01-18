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
    val T = st.nextToken().toInt()

    val list = mutableListOf<Pair<Int, Int>>()

    repeat(T) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        list.add(
            if (a < b) {
                Pair(a, b)
            } else {
                Pair(b, a)
            }
        )
    }

    list.forEach {

        gcd(it.first, it.second)

        println((it.first / gcdResult) * (it.second / gcdResult) * gcdResult)
    }

    bw.flush()
    bw.close()
}

fun gcd(small: Int, big: Int) {
//    println("$small $big")

    val els = big % small
    if(els == 0) {
        gcdResult = small
        return
    }

    gcd(els, small)
}