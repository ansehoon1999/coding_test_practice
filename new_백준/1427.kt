import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

data class Node(
    val idx: Int,
    val value: Int
)

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val list = st.nextToken().toString().map { it.toString().toInt() }.toMutableList()

    for(i in 0 until list.size - 1) {
        var maxValue = Integer.MIN_VALUE
        var maxIdx = -1

        for(j in i+1 until list.size) {
            if(maxValue < list[j]) {
                maxValue = list[j]
                maxIdx = j
            }
        }

        if(maxIdx == -1) continue

        if(list[i] < maxValue) {
            val tmp = list[i]
            list[i] = maxValue
            list[maxIdx] = tmp
        }

    }



    list.forEach {
        bw.write("$it")
    }

    bw.flush()
    bw.close()
}

