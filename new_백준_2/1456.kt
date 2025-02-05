import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger


data class Edge(
    val from: Int,
    val to: Int,
    val cost: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    // 10000000
    val (a, b) = br.readLine().split(" ").map { it.toLong() }

    val arr = LongArray(10000001) { 0L }

    for (i in 2 until arr.size) {
        arr[i] = i.toLong()
    }

    for(i in 2 until arr.size) {
        if(arr[i] == 0L) continue

        for(j in i * 2 until arr.size step i) {
            arr[j] = 0L
        }
    }

    var result = 0L
    for (i in 2..10000000) {

        if(arr[i] != 0L) {
            var temp = BigInteger.valueOf(arr[i]) * BigInteger.valueOf(arr[i])
            while(temp <= BigInteger.valueOf(b)) {
                if(temp < BigInteger.valueOf(a)) {
                    temp *= BigInteger.valueOf(arr[i])
                    continue
                }

                result ++
                temp *= BigInteger.valueOf(arr[i])
            }
        }

    }

    println(result)

    writer.flush()
    writer.close()
}


