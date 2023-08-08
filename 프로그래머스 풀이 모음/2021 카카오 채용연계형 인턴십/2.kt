class Solution {

    private val dx = listOf<Int>(1, 0, -1, 0)
    private val dy = listOf<Int>(0, 1, 0, -1)

    private var state = true

    fun solution(places: Array<Array<String>>): IntArray {
        var answer = mutableListOf<Int>()

        places.forEach { plc ->
            println(plc.toMutableList())
            state = true

            val place = plc.map {
                it.toList()
            }

            val visited = arrayOf(
                arrayOf(false, false, false, false, false),
                arrayOf(false, false, false, false, false),
                arrayOf(false, false, false, false, false),
                arrayOf(false, false, false, false, false),
                arrayOf(false, false, false, false, false)
            )

            for (i in 0 until 5) {
                for (j in 0 until 5) {
                    if (place[i][j] == 'X') {
                        visited[i][j] = true
                    }
                }
            }

            // println(place)

            for (i in 0 until 5) {
                for (j in 0 until 5) {
                    if (place[i][j] == 'P') {
                        visited[i][j] = true
                        // println("y: ${i}, x: ${j}")
                        dfs(0, i, j, visited, place)
                        visited[i][j] = false
                    }
                }
            }

            if(state) {
                answer.add(1)
            } else {
                answer.add(0)
            }

            // println(state)
        }




        return answer.toIntArray()
    }

    fun dfs(count: Int, y: Int, x: Int, visited: Array<Array<Boolean>>, place: List<List<Char>>) {
        if(count == 2) {
            return
        }

        // visited.forEach {
        //     println(it.toList())
        // }
        // place.forEach {
        //     println(it.toList())
        // }

        // println()

        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue

            if(visited[ny][nx]) {
                //            println("this is block")
                continue
            }

            if(place[ny][nx] == 'P') {
                // println("this is p ${ny} ${nx}")
                state = false
                continue
            }



            visited[ny][nx] = true
            dfs(count+1, ny, nx, visited, place)
            visited[ny][nx] = false
        }
    }
}ㅎㅕㅇ