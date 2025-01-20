import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.cos

lateinit var parent: MutableList<Int>

data class Node(
    val num: Int,
    val weight: Int
)

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    val hashMap = hashMapOf<Int, MutableList<Int>>()
    val inDegree = MutableList<Int>(n + 1) { 0 }

    val costList = MutableList<Int>(n + 1) { 0 }

    repeat(n) {
        hashMap[it + 1] = mutableListOf()
    }

    repeat(n) {
        val tempList = br.readLine().split(" ").map { it.toInt() }

        costList[it + 1] = tempList[0]
        for (i in 1 until tempList.size - 1) {
            inDegree[it + 1]++
            hashMap[tempList[i]]?.add(it+ 1)
        }
    }

    val deque = PriorityQueue<Node>(Comparator { a, b ->
        a.weight - b.weight

    })

    for (i in 1 until inDegree.size) {
        if (inDegree[i] == 0) {
            deque.add(Node(i, costList[i]))
        }
    }

    while (deque.isNotEmpty()) {
        val cur = deque.poll()
        costList[cur.num] = cur.weight

        hashMap[cur.num]?.forEach { next ->

            inDegree[next] -= 1
            if (inDegree[next] == 0) {
                deque.add(Node(next, cur.weight + costList[next]))
            }
        }
    }

    for(idx in 1 until costList.size) {
        println(costList[idx])
    }
//    println(deque)
//
//    println(costList)
//    println(inDegree)
//    println(hashMap)






    bw.flush()
    bw.close()
}

