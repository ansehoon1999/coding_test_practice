

var matrix = MutableList(0) {MutableList<Int>(0) { 0 }  }
var dr = listOf<Int>(1,-1,0,0)
var dc = listOf<Int>(0,0,1,-1)
var count = 0
fun main () = with(System.`in`.bufferedReader()) {

    val str = readLine().split(' ').toList()
    val col = str[0].toInt()
    val row = str[1].toInt()

    matrix = MutableList(row) {MutableList<Int>(col) { 0 }  }

    for (i in 0 until row) {
        val input = readLine().split(' ').toList()
        for (j in 0 until col) {
            matrix[i][j] = input[j].toInt()
        }
    }

    val tmp_list = mutableListOf<MutableList<Int>>()

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (matrix[i][j] == 1) {
                tmp_list.add(mutableListOf(i, j))
            }
        }
    }

    BFS(tmp_list, col, row)
    var state = true

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (matrix[i][j] == 0) {
                state =false
            }
        }
    }

    if (state) {
        println(count - 1)
    } else {
        println(-1)
    }

}

fun BFS(tmpList: MutableList<MutableList<Int>>, col: Int, row: Int) {
    val deque = ArrayDeque<MutableList<MutableList<Int>>>()

    deque.add(tmpList)

    while (deque[0].size != 0 ) {
        val r_init2 = mutableListOf<MutableList<Int>>()

//        matrix.forEach {
//            println(it)
//        }
//        println()
        val node = deque.removeFirst()
        count ++
        node.forEach {
            var rc = 0
            var rr = 0

            for (i in 0 until 4) {
                rr = it[0] + dr[i]
                rc = it[1] + dc[i]

                if ( rr < 0 || rr >= row || rc < 0 || rc >= col) continue
                if (matrix[rr][rc] == -1 || matrix[rr][rc] == 1) continue

                else if(matrix[rr][rc] == 0) {
                    matrix[rr][rc] = 1
                }

                val init2 = mutableListOf<Int>()
                init2.add(rr)
                init2.add(rc)
                r_init2.add(init2)
            }
        }

        deque.add(r_init2)
    }

}
