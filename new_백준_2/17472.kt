import java.io.BufferedReader
import java.io.InputStreamReader


var result = 0

val rList = listOf(1, -1, 0, 0)
val cList = listOf(0, 0, 1, -1)

data class Node(
    val r: Int,
    val c: Int
)

data class Edge(
    val start: Int,
    val end: Int,
    val time: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val matrix = MutableList<MutableList<Int>>(n) {
        br.readLine().split(" ").map {
            if (it.toInt() == 1) {
                -1
            } else {
                0
            }
        }.toMutableList()
    }



    fun bfs(num: Int, i: Int, j: Int) {

        val deque = ArrayDeque<Node>()
        deque.add(Node(i, j))


        while (deque.isNotEmpty()) {
            val cur = deque.removeFirst()

            matrix[cur.r][cur.c] = num

            for (i in 0 until 4) {
                val nextR = cur.r + rList[i]
                val nextC = cur.c + cList[i]

                if (nextR !in 0..n - 1) continue

                if (nextC !in 0..m - 1) continue

                if (matrix[nextR][nextC] == -1) {
                    deque.add(Node(nextR, nextC))
                }
            }
        }
    }

    var num = 1

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (matrix[i][j] == -1) {
                bfs(num, i, j)
                num++
            }
        }
    }




    // 길이 구하기

    val edge = mutableListOf<Edge>()

    fun getAllEdge(curNum: Int, i: Int, j: Int) {

//        println("${curNum} ${i} ${j}")
        val curNode = Node(i, j)

        for (x in 0 until 4) {

            var nextR = curNode.r + rList[x]
            var nextC = curNode.c + cList[x]

            var isDistance = true
            var distanceCnt = 0

            while (true) {

                if (nextR !in 0..n - 1) {
                    isDistance = false
                    break
                }

                if (nextC !in 0..m - 1) {
                    isDistance = false
                    break
                }

                if (matrix[nextR][nextC] == curNum) {
                    isDistance = false
                    break
                }

                if(matrix[nextR][nextC] == 0) {
                    nextR += rList[x]
                    nextC += cList[x]
                    distanceCnt++
                    continue
                }

                if (matrix[nextR][nextC] != curNum) {
                    if (distanceCnt < 2) {
                        isDistance = false
                    }

//                    println("distanceCnt: ${nextR} ${nextC} ${distanceCnt}")

                   break
                }


            }

            if (isDistance) {
                edge.add(Edge(curNum, matrix[nextR][nextC], distanceCnt))
            }
        }


    }


    for (i in 0 until n) {
        for (j in 0 until m) {

            if (matrix[i][j] != 0) {

                val curNum = matrix[i][j]
                getAllEdge(curNum, i, j)
            }
        }
    }


//        matrix.forEach {
//        println(it)
//    }
//    println(edge)

    edge.sortBy { it.time }

    val parents = MutableList<Int>(num) { it }

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

    var result = 0
    for(i in 0 until edge.size) {
        val cur = edge[i]
        if(find(cur.start) != find(cur.end)) {
            union(cur.start, cur.end)
            result += cur.time
        }
    }

//    println(parents)

    var first = find(parents[1])


    for(i in 2 .. parents.lastIndex) {
        if(first != find(parents[i])) {
            println(-1)
            return
        }
    }

    writer.write("${result}")
    writer.flush()
    writer.close()
}














