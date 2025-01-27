import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


data class Node(
    val num: Int,
    val depth: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val probabilities = DoubleArray(51) { 1.0 }

    val M = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val K = br.readLine().toInt()

    val sum = list.sum()
    var res = 0.0

    list.forEach {

        if(it >= K) {
            probabilities[it] = 1.0
            for(k in 0 until K) {
                probabilities[it] *= (it - k).toDouble() / (sum - k).toDouble()
            }
            res += probabilities[it]
        }
    }



//    println(probabilities.toList())
    println(res)



    writer.flush()
    writer.close()

}
