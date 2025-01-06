import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer


fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val rr = listOf(1, -1, 0, 0)
    val rc = listOf(0, 0, 1, -1)

    val matrix = mutableListOf<List<String>>()
    val visited = MutableList<MutableList<Boolean>>(n) {
        MutableList<Boolean>(m) { false }
    }

    repeat(n) {
        val tmpList = br.readLine().toList().map { it.toString() }
        matrix.add(tmpList)
    }
    
    val deque = ArrayDeque<MutableList<Pair<Int, Int>>>()
    deque.add(mutableListOf(Pair(0, 0)))
    visited[0][0] = true
    var result = 0

    while (deque[0].isNotEmpty()) {

        val nowList = deque.removeFirst()
        result ++
        val tmpList = mutableListOf<Pair<Int, Int>>()

        nowList.forEach { now ->
            val curRow = now.first
            val curCol = now.second

            for (idx in 0 until 4) {
                val nextRow = curRow + rr[idx]
                val nextCol = curCol + rc[idx]

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue

                if (visited[nextRow][nextCol]) continue

                if(nextRow == n -1 && nextCol == m - 1) {
                    println(result + 1)
                    return
                }

                if (matrix[nextRow][nextCol] == "1") {
                    visited[nextRow][nextCol] = true
                    tmpList.add(Pair(nextRow, nextCol))
                }
            }
        }

        deque.add(tmpList)
    }


    //    bw.write("$sum")
    bw.flush()
    bw.close()
}



