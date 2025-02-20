import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.cos



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val strList = mutableListOf<String>()

    repeat(n) {
        val str = br.readLine().toString()
        strList.add(str)
    }

    var cnt = 0

    repeat(m) {
        val tmp = br.readLine().toString()
        strList.forEach { str ->
            if(str == tmp) {
//                println(tmp)
                cnt ++
            }
        }
    }

    writer.write("${cnt}")

    writer.flush()
    writer.close()
}














