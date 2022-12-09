
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.*

fun main () = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    val arr = readLine().toCharArray()

    var sum = 0L
    var expo = 1L
    var go = 0
    arr.forEach {
        sum = (sum + (it.toInt() -96 ) * expo)  % 1234567891
        expo = (expo * 31) % 1234567891
//        println((it.toInt()) * ((31.toDouble()).pow(count)))
    }
    bw.write("${(sum%1234567891)}")
    bw.flush()
    bw.close()
}
