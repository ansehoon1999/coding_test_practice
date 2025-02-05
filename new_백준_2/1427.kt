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


    val a = br.readLine().toList().map { it.toString().toInt() }.toMutableList()
    for(i in 0 until a.size) {
        var max = i
        for(j in i+1 until a.size) {
            if(a[j] > a[max]) {
                max = j
            }
        }

        if(a[i] < a[max]) {
            val temp  =a[i]
            a[i] = a[max]
            a[max] = temp
        }
    }

    a.forEach {
        print(it)
    }

    writer.flush()
    writer.close()
}


