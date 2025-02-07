import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }


    val parents = MutableList<Int>(n+1) { it }

    fun find(a: Int): Int {
        if(a == parents[a]) return a
        else {
            parents[a] = find(parents[a])
            return parents[a]
        }
    }

    fun union(a: Int, b: Int) {
        val a = find(a)
        val b = find(b)

        if(a != b) {
            parents[b] = a
        }
    }

    repeat(m) {
        val (op, a, b) = br.readLine().split(" ").map { it.toInt() }

        if(op == 0) {
            union(a, b)
        } else {
            if(find(a) == find(b)) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }



    writer.flush()
    writer.close()
}



