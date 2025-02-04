import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    /**
     * B[k] = k번째 값
     * B[k] = S
     * S 보다 작거나 같은 값의 개수가 최소 k개
     */

    val n = br.readLine().toLong()
    val k = br.readLine().toLong()

    var start = 1L
    var end = n * n.toLong()

    var answer = 0L

    while(start < end) {
        val mid = (start + end) / 2

        var cnt = 0L
        for(i in 1 .. n) {
            cnt += minOf(n, mid / i)
        }

        if(k <= cnt) {
            end = mid
        } else {
            start = mid.toLong() + 1L
        }
    }

    println(start)

    writer.flush()
    writer.close()
}


