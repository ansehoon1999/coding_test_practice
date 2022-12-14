package class3

var matrix = Array(0) { MutableList(0) { 0 } }
var count = 1
var drow = listOf<Int>(1,-1,0,0)
var dcol = listOf<Int>(0,0,1,-1)
fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()

    matrix = Array(n) { MutableList(m) { 0 } }
    for (i in 0 until n) {
        val tmp = readLine().toCharArray()
        for (j in 0 until m) {
            matrix[i][j] = Character.getNumericValue(tmp[j])
        }
    }

//    matrix.forEach {
//        it.forEach {
//            print(it)
//            print(' ')
//        }
//        println()
//    }

    BFS(n, m, Pair(0,0))
}

fun BFS(n :Int, m:Int, pair: Pair<Int, Int>) {

    val init = mutableListOf<Pair<Int, Int>>()
    init.add(pair) // [Pair(0,0]
    val deque = ArrayDeque<MutableList<Pair<Int, Int>>>() // [[Pair(0,0]]
    deque.add(init)

    while (deque[0].size != 0) {
        val node = deque.removeFirst() // [Pair(0,0]]
//        println(node)
        if (node.contains(Pair(n-1, m-1))) {
            println(count)
            break
        }

        val list = mutableListOf<Pair<Int, Int>>()
        node.forEach {
            matrix[it.first][it.second] = 0


            for (i in 0 until 4) {
                var new_rol = it.first + drow[i]
                var new_col = it.second + dcol[i]

//                println("(${new_rol},${new_col})")


                if (!((0 <= new_rol && new_rol < n) && (0 <= new_col && new_col < m))) continue
                if (matrix[new_rol][new_col] == 0) continue

//                println("${new_rol} ${new_col}")
                matrix[new_rol][new_col] = 0
                list.add(Pair(new_rol, new_col))
            }
        }

        deque.add(list)
        count ++

    }



}
