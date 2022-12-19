


var matrix = MutableList<MutableList<Int>>(0) { MutableList<Int>(0) { 0 } }
var visited = MutableList<MutableList<Boolean>>(0) { MutableList<Boolean>(0) { false } }
var count = 0
var result = 0
var dr = listOf<Int>(1,-1,0,0)
var dc = listOf<Int>(0,0,1,-1)


fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(' ').toList()
    val rol = input[0].toInt()
    val col = input[1].toInt()

    matrix = MutableList<MutableList<Int>>(rol) { MutableList<Int>(col) { 0 } }

    for (i in 0 until rol) {
        val str = readLine().split(' ').toList()
        for (j in 0 until col) {
            matrix[i][j] = str[j].toInt()
        }
    }

    visited = MutableList<MutableList<Boolean>>(rol) { MutableList<Boolean>(col) { false } }

    for (i in 0 until rol) {
        for (j in 0 until col) {
            visited[i][j] = true
            var idx = 0
            DFS(idx, i, j, rol, col, 0)
            BLOCK(i, j, rol, col)

            visited[i][j] = false
        }
    }



    println(result)
}

fun DFS(idx: Int, i: Int, j:Int, rol: Int, col: Int, count:Int) {
    if (idx == 4) {
        result = Math.max(result, count)
        return
    }

    for (x in 0 until 4) {
        val new_r = i + dr[x]
        val new_c = j + dc[x]
        if (new_r < 0 || new_r >= rol || new_c < 0 || new_c >= col) {continue}
            if (visited[new_r][new_c] == false) {
                visited[new_r][new_c] = true
                DFS(idx + 1, new_r, new_c, rol, col, count + matrix[i][j])
                visited[new_r][new_c] = false
            }
    }
}

fun BLOCK(i: Int, j: Int, rol: Int, col: Int) {
    val coord = mutableListOf<Pair<Int, Int>>()

    for (x in 0 until 4) {
        val new_r = i + dr[x]
        val new_c = j + dc[x]
        if (new_r < 0 || new_r >= rol || new_c < 0 || new_c >= col) {continue}

        coord.add(Pair(new_r, new_c))
    }


    if (coord.size == 3) {
        result = Math.max(result, matrix[coord[0].first][coord[0].second] + matrix[coord[1].first][coord[1].second] + + matrix[coord[2].first][coord[2].second] + matrix[i][j])
    } else if (coord.size == 4) {
        result = Math.max(result, matrix[coord[0].first][coord[0].second] + matrix[coord[1].first][coord[1].second] + + matrix[coord[2].first][coord[2].second] + matrix[i][j])
        result = Math.max(result, matrix[coord[0].first][coord[0].second] + matrix[coord[1].first][coord[1].second] + + matrix[coord[3].first][coord[3].second] + matrix[i][j])
        result = Math.max(result, matrix[coord[0].first][coord[0].second] + matrix[coord[2].first][coord[2].second] + + matrix[coord[3].first][coord[3].second] + matrix[i][j])
        result = Math.max(result, matrix[coord[1].first][coord[1].second] + matrix[coord[2].first][coord[2].second] + + matrix[coord[3].first][coord[3].second] + matrix[i][j])
    }
}
