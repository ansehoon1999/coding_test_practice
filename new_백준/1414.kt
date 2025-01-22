import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var parent: MutableList<Int>

data class Edge(
    val start: Int,
    val end: Int,
    val cost: Int
)

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    parent = MutableList<Int>(n) { it }
    val matrix = mutableListOf<List<Int>>()

    repeat(n) {
        val tempList = br.readLine().toList().map {

            if(it.isLowerCase()) {
                it - 'a' + 1
            } else if(it.isUpperCase()) {
                (it - 'A' + 27)
            } else {
                0
            }
        }
        matrix.add(tempList)
    }

    val edges = mutableListOf<Edge>()

    var total = 0L
    for(i in 0 until n) {
        for(j in 0 until n) {
            total += matrix[i][j]
            if(i != j && matrix[i][j] > 0) {
                edges.add(Edge(i, j, matrix[i][j].toInt()))
            }
        }
    }

    edges.sortBy { it.cost }

    var result = 0L

    edges.forEach { edge ->
        if(find(edge.start) != find(edge.end)) {
            union(edge.start, edge.end)
            result += edge.cost
        }

    }


//    matrix.forEach {
//        println(it)
//    }



    var isSame = true
    var value = find(parent[0])
    for(i in 1 until parent.size) {
        if(value != find(parent[i])) {
            isSame =false
            break
        }
    }

    if(isSame) {
        println(total - result)
    } else {
        println(-1)
    }



    bw.flush()
    bw.close()
}

fun find(a: Int): Int {
    if(a == parent[a]) {
        return a
    }

    parent[a] = find(parent[a])
    return parent[a]
}

fun union(a: Int, b: Int) {
    val a1 = find(a)
    val b1 = find(b)

    if(a1 < b1) {
        parent[b1] = a1
    } else {
        parent[a1] = b1
    }
}

