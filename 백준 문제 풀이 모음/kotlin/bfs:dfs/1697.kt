
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, K) = br.readLine().split(" ").map { it.toInt() }

    val visited = MutableList<Boolean>(1000001) { false }

    val deque = ArrayDeque<MutableSet<Int>>()
    deque.add(mutableSetOf(N))
    visited[N] = true
    var total = 0
    var flag = false

    while(deque.isNotEmpty()) {
//        println(deque)
        val curSet = deque.removeFirst()

        val tmpSet = mutableSetOf<Int>()

        curSet.forEach { cur ->
            if(cur == K) {
                println(total)
                return
            }

            val next1 = cur + 1
            if(isInside(next1) && !visited[next1]) {
                visited[next1] = true
                tmpSet.add(next1)
            }

            val next2 = cur - 1
            if(isInside(next2) && !visited[next2]) {
                visited[next2] = true
                tmpSet.add(next2)
            }

            val next3 = cur * 2
            if(isInside(next3) && !visited[next3]) {
                visited[next3] = true
                tmpSet.add(next3)
            }
        }

        total ++
        deque.add(tmpSet)

    }
}

fun isInside(cur: Int): Boolean {
    return (cur in 0 .. 1000000)
}