import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val list = br.readLine().split(" ").map { it.toInt() }.sorted()

    var low = 0
    var high = list.lastIndex

    var cnt = 0

    while (low < high) {
        val tmpSum = list[low] + list[high]

        if(tmpSum == m) {
            cnt ++
            low ++
        } else if(tmpSum < m) {
            low ++
        } else if(tmpSum > m) {
            high --
        }
    }

    println(cnt)
}










