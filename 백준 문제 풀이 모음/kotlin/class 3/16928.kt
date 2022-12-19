

var game = MutableList<Int>(101) { 0 }
var count = 0
fun main() = with(System.`in`.bufferedReader()) {

    val str = readLine().split(' ').toList().map { it.toInt() }
    val n = str[0]
    val m = str[1]

    repeat(n) {
        val input = readLine().split(' ').toList().map { it.toInt() }
        game[input[0]] = input[1]
    }

    repeat(m) {
        val input = readLine().split(' ').toList().map { it.toInt() }
        game[input[0]] = input[1]
    }

//    println(game)
    BFS(1)

}

fun BFS(num: Int) {
    val deque = ArrayDeque<MutableSet<Int>>()
    deque.add(mutableSetOf(num))

    while (deque[0].size != 0) {
//        println(deque)
        val node = deque.removeFirst()
        if (node.contains(100)) {
            println(count)
            break
        }
        val new_list = mutableSetOf<Int>()

        node.forEach {
            for (i in 1..6) {
                if (it + i > 100) continue

                if (game[it + i] == 0) {
                    new_list.add(it + i)
                } else {
                    new_list.add(game[it + i])
                }
            }
        }

        deque.add(new_list)
        count++
    }

}
