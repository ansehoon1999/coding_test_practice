

private lateinit var board : MutableList<MutableList<Char>>
private lateinit var visited : MutableList<MutableList<Boolean>>
private lateinit var parent : MutableList<MutableList<Pair<Int, Int>>>
var n = -1
var m = -1

var result = 0


fun main() = with(System.`in`.bufferedReader()){
    val (row, col) = readLine().split(' ').map { it.toInt() }
    n = row
    m = col

    board= MutableList<MutableList<Char>>(row) { MutableList<Char>(col) { 's' } }
    visited = MutableList<MutableList<Boolean>>(row) { MutableList<Boolean>(col) { false } }
    parent = MutableList<MutableList<Pair<Int, Int>>>(row) { MutableList<Pair<Int, Int>>(col) { Pair(0,0) } }
    for (i in 0 until row) {
        val input = readLine().toCharArray()
        for (j in 0 until col) {
            board[i][j] = input[j]
            parent[i][j] = Pair(i, j)
        }
    }

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (visited[i][j]) continue
            visited[i][j] = true
            dfs(i,j)
        }
    }

    print(result)
}

fun dfs(row: Int, col: Int) {
//    visited.forEach {
//        println(it)
//    }
//    parent.forEach {
//        println(it)
//    }
//    println()

    if (board[row][col] == 'D' && row +1 < n) {
        if(!visited[row+1][col]) {
            visited[row+1][col] = true
            union(Pair(row,col),Pair(row+1, col))
            dfs(row+1, col)
        } else {
            if (find(row, col) == find(row+1,col)) result+= 1
        }
    }
    else if (board[row][col] == 'U' && row > 0 ) {
        if(!visited[row-1][col]) {
            visited[row-1][col] = true
            union(Pair(row,col),Pair(row-1, col))
            dfs(row-1, col)
        } else {
            if (find(row, col) == find(row-1,col)) result+= 1
        }

    }

    else if (board[row][col] == 'L' && col > 0 ) {
        if(!visited[row][col-1]) {
            visited[row][col-1] = true
            union(Pair(row,col),Pair(row, col-1))
            dfs(row, col-1)
        } else {
            if (find(row, col) == find(row, col-1)) result+= 1
        }

    }

    else if (board[row][col] == 'R' && col+1 < m ) {
        if(!visited[row][col+1]) {
            visited[row][col+1] = true
            union(Pair(row,col),Pair(row, col+1))
            dfs(row, col+1)
        } else {
            if (find(row, col) == find(row, col+1)) result+= 1
        }

    }
    else {
        result++
    }
}

fun find(nrow: Int, ncol: Int): Pair<Int, Int> {
    if (parent[nrow][ncol].equals(Pair(nrow, ncol))) {
        return Pair(nrow, ncol)
    }

    parent[nrow][ncol] =  find (parent[nrow][ncol].first, parent[nrow][ncol].second)

    return parent[nrow][ncol]
}

fun union(nxt : Pair<Int, Int>, cur: Pair<Int, Int>) {
    val nxt1 = find(nxt.first, nxt.second)
    val nxt2 = find(cur.first, cur.second)

    parent[nxt2.first][nxt2.second] = nxt1

}
