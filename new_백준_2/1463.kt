import java.io.BufferedReader
import java.io.InputStreamReader

data class Edge(
    val from: Int,
    val to: Int,
    val cost: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val arr = MutableList<Int>(n+1) { Integer.MAX_VALUE }
    arr[n] = 0

    for(i in n downTo 1) {
        if(i % 3 == 0) {
            arr[i/3] = minOf(arr[i/3], arr[i] + 1)
        }

        if(i % 2 == 0) {
            arr[i/2] = minOf(arr[i/2], arr[i] + 1)
        }

        arr[i-1] = minOf(arr[i-1], arr[i] + 1)


    }

    println(arr[1])

    writer.flush()
    writer.close()
}


