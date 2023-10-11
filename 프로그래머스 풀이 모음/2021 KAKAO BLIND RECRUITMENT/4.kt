class Solution {

    private lateinit var graph: Array<IntArray>


    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        graph = Array(n + 1) {
            IntArray(n + 1) {
                20000001
            }
        }

        fares.forEach { fare ->
            val point1 = fare[0]
            val point2 = fare[1]
            val cost = fare[2]

            graph[point1][point2] = cost
            graph[point2][point1] = cost
        }

        for(i in 1 .. n) {
            graph[i][i] = 0
        }

        for(k in 1 .. n) {
            for(i in 1 .. n) {
                for(j in 1 .. n) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j]
                        graph[j][i] = graph[i][j]
                    }
                }
            }
        }

        var answer = 20000001
        for( i in 1 .. n) {
            answer = minOf(answer, graph[i][s] + graph[i][a] + graph[i][b])
        }

        return answer
    }




}