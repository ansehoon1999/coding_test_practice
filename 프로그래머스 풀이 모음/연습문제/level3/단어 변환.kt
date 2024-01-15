class Solution {

    var answer = Integer.MAX_VALUE

    fun solution(begin: String, target: String, words: Array<String>): Int {


        if(target !in words) return 0

        val visited = MutableList<Boolean>(words.size) { false }

        findWord(begin, target, visited, 0, words)

        return answer
    }

    fun findWord(begin: String, target: String, visited: MutableList<Boolean>, cnt: Int, words: Array<String>) {


        if(begin == target) {


            answer = minOf(answer, visited.filter { it == true }.size)

            // println(words.toList())
            // println(visited)
            // println()
            return
        }

        for(i in 0 until visited.size) {
            if(!visited[i]) {

                var sameCnt = 0
                for(j in 0 until begin.length) {
                    if(begin[j] == words[i][j]) sameCnt ++
                }

                if(sameCnt + 1 == begin.length) {

                    visited[i] = true
                    findWord(words[i], target, visited, cnt + 1, words)
                    visited[i] = false
                }

            }
        }

    }
}