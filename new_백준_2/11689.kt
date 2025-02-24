import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(
    val num: Int,
    val depth: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    var N = br.readLine().toLong()

    var result = N

    for(p in 2 .. Math.sqrt(N.toDouble()).toLong()) {
        if(N % p == 0L) {
            result -= (result / p)
            while(N % p == 0L) {
                N /= p
            }
        }
    }

    if(N > 1) {
        result -= (result/ N)
    }

    writer.write("${result}")

    writer.flush()
    writer.close()
}


