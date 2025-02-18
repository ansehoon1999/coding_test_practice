import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val parents = MutableList<Int>(n+1) { it }

    fun find(a: Int): Int {
        if(a == parents[a]) {
            return a
        } else {
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
        val (s, e) = br.readLine().split(" ").map { it.toInt() }
        if(find(s) != find(e)) {
            union(s, e)
        }
    }


    val hashMap = hashMapOf<Int, Int>()
    for(i in 1 until parents.size) {
        val x = find(parents[i])
        if(hashMap[x] == null) {
            hashMap[x] = 1
        } else {
            hashMap[x] = hashMap[x]!! + 1
        }
    }

    println(hashMap.size)

    writer.flush()
    writer.close()
}















