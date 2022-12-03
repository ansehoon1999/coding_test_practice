import java.lang.StringBuilder
import java.util.StringTokenizer

fun main () = with(System.`in`.bufferedReader()) {
    val str = StringTokenizer(readLine())
    val m = str.nextToken().toInt()
    val n = str.nextToken().toInt()
    var cnt = 0

    for (i in m .. n) {
        if (i == 1) {
            continue
        }

        var j = 2
        while (j <= Math.sqrt(i.toDouble())) {
            if (i % j == 0) {
                cnt ++
                break
            }
            j ++
        }

        if (cnt == 0) {
            println(i)
        }

        cnt = 0
    }


}