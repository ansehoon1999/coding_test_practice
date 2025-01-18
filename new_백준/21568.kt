import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    val gcd = gcd(a, b)
    if(c % gcd != 0) {
        println(-1)
    } else {
        val k = c / gcd
        val result = excute(a, b)
        println("${result[0] * k} ${result[1] * k}")
    }

    bw.flush()
    bw.close()
}

fun gcd(p: Int, q: Int): Int {
    if(q == 0) return p
    else return gcd(q, p % q)
}

fun excute(a: Int, b: Int): IntArray {

    val temp = IntArray(2)
    if(b == 0) {
        temp[0] = 1
        temp[1] = 0
        return temp
    }

    val mok = a / b
    val pre = excute(b, a % b)

    temp[0] = pre[1]
    temp[1] = pre[0] - pre[1] * mok
    return temp
}