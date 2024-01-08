class Solution {

    val dr = listOf(-1, 1, 0, 0)
    val dc = listOf(0, 0, -1, 1)

    var flag = false
    var curRow = 0
    var curCol = 0

    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()

        places.forEach { place ->

            val matrix = MutableList<MutableList<Char>>(5) {
                MutableList<Char>(5) { 'O' }
            }

            val visited = MutableList<MutableList<Boolean>>(5) {
                MutableList<Boolean>(5) { false }
            }

            flag = false

            for(row in 0 until 5) {
                val colList = place[row].toList()
                for(col in 0 until 5) {
                    matrix[row][col] = colList[col].toChar()

                    if(matrix[row][col] == 'X') visited[row][col] = true

                }
            }

//             matrix.forEach {
//                 println(it)
//             }

//             visited.forEach {
//                 println(it)
//             }

//             println()

            for(row in 0 until 5) {
                for(col in 0 until 5) {
                    if(matrix[row][col] == 'P') {
                        visited[row][col] = true
                        curRow = row
                        curCol = col
                        checkPosition(row, col, matrix, visited, 0)
                        visited[row][col] = false
                    }
                }
            }

            if(flag) answer += 0 else answer += 1

        }



        return answer
    }

    fun checkPosition(row: Int, col: Int, matrix: MutableList<MutableList<Char>>, visited: MutableList<MutableList<Boolean>>, cnt: Int) {

        if(cnt == 1) {
            val rowInterval = Math.abs(row - curRow)
            val colInterval = Math.abs(col - curCol)

            if(rowInterval == 1 && colInterval == 0 && matrix[row][col] == 'P') {
                // visited.forEach {
                //     println(it)
                // }
                // println()

                flag = true

                return
            }

            if(rowInterval == 0 && colInterval == 1 && matrix[row][col] == 'P') {
                // visited.forEach {
                //     println(it)
                // }
                // println()

                flag = true

                return
            }


        }

        if(cnt == 2) {

            val rowInterval = Math.abs(row - curRow)
            val colInterval = Math.abs(col - curCol)

            if((rowInterval + colInterval) <= 2 && matrix[row][col] == 'P') {

                // visited.forEach {
                //     println(it)
                // }
                // println()

                flag = true
            }

            return
        }

        val curRow = row
        val curCol = col

        for(idx in 0 until 4) {
            val newRow = curRow + dr[idx]
            val newCol = curCol + dc[idx]

            if(newRow < 0 || newRow >= 5 || newCol < 0 || newCol >= 5) continue

            if(!visited[newRow][newCol]) {
                visited[newRow][newCol] = true
                checkPosition(newRow, newCol, matrix, visited, cnt + 1)
                visited[newRow][newCol] = false
            }


        }

    }
}