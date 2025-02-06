import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

data class Node(
    val idx: Int,
    val time: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val graph = hashMapOf<Int, MutableList<Int>>()

    repeat(n) {
        graph[it+1] = mutableListOf()
    }

    val timeList = MutableList<Int>(n+1) { 0 }
    val inDegrees = MutableList<Int>(n+1) { 0 }

    repeat(n) {
        val tmpList = br.readLine().split(" ").map { it.toInt() }
        val time = tmpList[0]

        timeList[it+1] = time
        for(i in 1 until tmpList.lastIndex) {
            graph[tmpList[i]]?.add(it+1)
            inDegrees[it+1] ++
        }
    }

    val result = MutableList<Long>(n+1) { Long.MAX_VALUE }

    val deque = PriorityQueue<Node>({ a, b ->
       ( a.time - b.time).toInt()
    })
    inDegrees.forEachIndexed { index, i ->
        if(index > 0) {
            if (i == 0) deque.add(Node(index, timeList[index].toLong()))
        }
    }

//    println(timeList)
//    println(graph)
//    println(inDegrees)


    while(deque.isNotEmpty()) {
//        println(deque)
        val cur = deque.poll()
        result[cur.idx] = minOf(result[cur.idx], cur.time)

        graph[cur.idx]?.forEach { next ->
            inDegrees[next] -= 1
            if(inDegrees[next] == 0) {
                deque.add(Node(next, cur.time + timeList[next]))
            }
        }


    }

    for(i in 1 until result.size) {
        println(result[i])
    }

    writer.flush()
    writer.close()
}


