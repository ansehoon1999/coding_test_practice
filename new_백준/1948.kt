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
    val weight: Int,
)

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val m = st.nextToken().toInt()

    var ar = Array(n+1,{ArrayList<Node>()}) // 도시 인접 리스트
    var arreverse =Array(n+1,{ArrayList<Node>()})
    var indegree = IntArray(n+1){0}

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val time = st.nextToken().toInt()

        ar[start].add(Node(end,time))
        arreverse[end].add(Node(start,time))
        indegree[end]++
    }

    st = StringTokenizer(br.readLine())

    var start = st.nextToken().toInt() // 출발하는 도시
    var end = st.nextToken().toInt()

    val deque = ArrayDeque<Int>()
    deque.add(start)
    val result = MutableList<Long>(n + 1) { 0L }

    while(deque.isNotEmpty()) {
        val now = deque.removeFirst()
        ar[now]?.forEach { next ->

            indegree[next.num] -= 1
            result[next.num] = maxOf(result[next.num], result[now] + next.weight)

            if(indegree[next.num] == 0) {
                deque.add(next.num)
            }
        }
    }

    var resultCount = 0
    val visited = MutableList<Boolean>(n+1) { false }

    val deque2 = ArrayDeque<Int>()
    deque2.add(end)
    visited[end] = true

    while(deque2.isNotEmpty()) {
        val now = deque2.removeFirst()
        arreverse[now]?.forEach { next ->

            if(result[next.num] + next.weight == result[now]) {
                resultCount ++
                if(!visited[next.num]) {
                    visited[next.num] = true
                    deque2.add(next.num)
                }
            }

        }
    }

    println(result[end])
    println(resultCount)
//    println(deque)
//
//    println(costList)
//    println(inDegree)
//    println(hashMap)


    bw.flush()
    bw.close()
}

