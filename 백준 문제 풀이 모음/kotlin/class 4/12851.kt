

var visited = Array<Boolean>(0) { false }
var count = 0
var num = 0
fun main () = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val k = str[1].toInt()
    visited = Array<Boolean> (200001) { false }

    if(n==k) {
        println(0)
        println(1)
    } else {
        visited[n] = true
        val x = BFS(n, k)
        x.forEach {
            if (it == k ) {
                num++
            }
        }

//        println(x)
        println(count)
        println(num)

    }
}

fun BFS(n: Int, k : Int) : MutableList<Int> {
    var final_node = mutableListOf<Int>()
    val deque = ArrayDeque<MutableList<Int>>()
    deque.add(mutableListOf(n))


    while (deque[0].isNotEmpty()) {
//        println(deque)
        val node = deque.removeFirst()
        node.forEach {
            visited[it] = true
        }


        if (node.contains(k)) {
            final_node= node
            break
        }

        val tmp = mutableListOf<Int>()
        node.forEach {node ->
            val list = listOf<Int>(node * 2, node -1, node + 1)

            list.forEach {
                if (0<= it && it < 200001 && !visited[it]) {
                    tmp.add(it)
                }
            }
        }

        count ++
        deque.add(tmp)

    }

    return final_node
}