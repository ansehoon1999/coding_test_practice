

var matrix = MutableList<MutableList<MutableList<Int>>>(0) { MutableList(0) { MutableList<Int>(0) { 0 } } }


var dr = listOf<Int>(1,-1,0,0,0,0)
var dc = listOf<Int>(0,0,1,-1,0,0)
var dh = listOf<Int>(0,0,0,0,1,-1)



var count = 0
fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val m = str[0].toInt() //가로
    val n = str[1].toInt() //세로
    val h = str[2].toInt() //높이

    matrix = MutableList<MutableList<MutableList<Int>>>(h) { MutableList(n) { MutableList<Int>(m) { 0 } } }

    for (hei in 0 until h) { // n = 3 세로칸의 수
        for (row in 0 until n) { // h = 2 높이의 수
            val input = readLine().split(' ').toList()
            for (col in 0 until m) {
                matrix[hei][row][col] = input[col].toInt()
            }
        }
    }



    val tmp_list = mutableListOf<MutableList<Int>>()
    for (hei in 0 until h) { // n = 3 세로칸의 수
        for (row in 0 until n) { // h = 2 높이의 수
            for (col in 0 until m) {
                if (matrix[hei][row][col] == 1) {

                    tmp_list.add(mutableListOf(hei, row, col))
                }
            }
        }
    }

    BFS(tmp_list, h, n, m)

    var state = true

    for (hei in 0 until h) { // n = 3 세로칸의 수
        for (row in 0 until n) { // h = 2 높이의 수
            for (col in 0 until m) {
                if (matrix[hei][row][col] == 0 ) {
                    state = false
                }
            }
        }
    }
    if (state) {
        println(count - 1)
    } else {
        println(-1)
    }
//    matrix.forEach {
//        it.forEach {
//            println(it)
//        }
//        println()
//    }




}

fun BFS(tmp_list : MutableList<MutableList<Int>>, h : Int, n :Int, m :Int) {


    val deque = ArrayDeque<MutableList<MutableList<Int>>>()
    deque.add(tmp_list)

    while (deque[0].size != 0) {
        val r_init2 = mutableListOf<MutableList<Int>>()

//        matrix.forEach {
//            it.forEach {
//                println(it)
//            }
//            println()
//        }

        val node = deque.removeFirst() // [0,0,0]
//        println(node)
        count++
        node.forEach {
            var rr = 0
            var rc = 0
            var rh = 0
            for (i in 0 until 6) {
                rh = it[0] + dh[i]
                rr = it[1] + dr[i]
                rc = it[2] + dc[i]

                if (rh < 0 || rh >= h || rr < 0 || rr >= n || rc < 0 || rc >= m) continue
                if (matrix[rh][rr][rc] == -1 || matrix[rh][rr][rc] == 1) continue
                else if (matrix[rh][rr][rc] == 0) {
                    matrix[rh][rr][rc] = 1

                    val init2 = mutableListOf<Int>()
                    init2.add(rh)
                    init2.add(rr)
                    init2.add(rc)
                    r_init2.add(init2)
                }
            }
        }

        deque.add(r_init2)
    }
}
