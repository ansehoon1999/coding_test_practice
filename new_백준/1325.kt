import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

data class Node(
    val num: Int,
    val weight: Int
)

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()


    val hashMap = hashMapOf<Int, MutableList<Int>>()
    repeat(n) {
        hashMap[it + 1] = mutableListOf()
    }

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        hashMap[b]?.add(a)
    }

    val resultList = IntArray(n + 1) { 0 }
    var max = Integer.MIN_VALUE

    for (i in 1..n) {

        val visited = BooleanArray(n + 1) { false }

        val deque = ArrayDeque<Int>()
        deque.add(i)
        visited[i] = true

        while (deque.isNotEmpty()) {
            val first = deque.removeFirst()


            hashMap[first]?.forEach { next ->
                if (!visited[next]) {
                    visited[next] = true
                    resultList[i] += 1
                    deque.add(next)
                }
            }
        }


        max = maxOf(max, resultList[i])
    }


    resultList.forEachIndexed { index, i ->
        if(max == i) {
            bw.write("$index ")
        }
    }

    bw.flush()
    bw.close()

}