import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

private lateinit var result : ArrayDeque<Pair<Int, Int>>
private lateinit var arr : MutableList<Pair<Int, Int>>
private var cost : Double = 0.0
private lateinit var visited : BooleanArray

fun main() = with(System.`in`.bufferedReader()){
    val T = readLine().toInt()

    repeat(T) {
        val n = readLine().toInt()
        arr = MutableList<Pair<Int, Int>>(n) { Pair(0,0)}
        cost = Double.MAX_VALUE
        visited = BooleanArray(n)

        for (i in 0 until n) {
            val (a,b) = readLine().split(' ').map { it.toInt() }
            arr[i] = Pair(a,b)
        }

        combination(0,n/2)
        println(cost)

//        dfs(0, n/2)

    }

}

fun combination(index: Int, count : Int) {
    if (count == 0) {
        cost = Math.min(cost, getVector())
//        println(cost)

    } else {
        for (i in index until arr.size) {
            visited[i] = true
            combination(i + 1, count - 1)
            visited[i] = false
        }
    }
}

fun getVector(): Double {
//    println(arr)
//    visited.forEach {
//        print(it)
//        print(' ')
//    }
//    println()
    var x: Double = 0.0
    var y: Double = 0.0

    for (i in 0 until arr.size) {
        if (visited[i]) {
            x += arr[i].first
            y += arr[i].second
        } else {
            x -= arr[i].first
            y -= arr[i].second
        }

    }
    return Math.sqrt(x * x + y * y)
}



