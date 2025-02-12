import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val parents = MutableList<Int>(202) { it }

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

    repeat(n) { i ->
        val tmpList = br.readLine().split(" ").map { it.toString() }

        for(j in 0 until tmpList.size) {
            if(tmpList[j] == "1") {
                union(i+1, j+1)
            }
        }
    }

    val list = br.readLine().split(" ").map { it.toInt() }
    var result = "YES"

    for(i in 0 until list.size) {
        for(j in 0 until list.size) {
            if(find(list[i]) != find(list[j])) {
                result = "NO"
            }
        }
    }

    println(result)
}










