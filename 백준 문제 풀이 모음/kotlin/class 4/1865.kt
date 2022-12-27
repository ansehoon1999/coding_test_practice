

data class Node (var start : Int, var end : Int, var weight : Int)
private lateinit var edge : MutableList<Node>
val INF = Integer.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()){
    val tc = readLine().toInt()


    val sb = StringBuilder()
    repeat(tc) {
        val (n, m, w) = readLine().split(' ').toList().map { it.toInt() }

        edge = MutableList<Node>(0) { Node(0, 0, 0) }

        repeat(m) {
            val (s, e, t) = readLine().split(' ').map { it.toInt() }
            edge.add(Node(s, e, t))
            edge.add(Node(e, s, t))
        }

        repeat(w) {
            val (s, e, t) = readLine().split(' ').map { it.toInt() }
            edge.add(Node(s, e, -t))
        }


        fun bellman_ford() : Boolean {
            val distance = IntArray(n+1) { 0 }

            for (i in 0 until n) {
                edge.forEach {
                    if (distance[it.end] > distance[it.start] + it.weight) {
                        distance[it.end] = distance[it.start] + it.weight
                        if (i == n-1) {
                            return true
                        }
                    }
                }
            }

            return false
        }

        if (bellman_ford()) {
            sb.append("YES\n")
        } else {
            sb.append("NO\n")
        }



    }

    println(sb)
}



