class Solution {
    
    lateinit var visited : MutableList<Boolean>
    var result = 1000000000

    fun solution(begin: String, target: String, words: Array<String>): Int {
        visited = MutableList<Boolean>(words.size) { false }

        if (target !in words) return 0

        dfs(begin, target, words, 0)


        return result
    }
    
    fun dfs(begin: String, target: String, words: Array<String>, count : Int) {
        println(begin)
        if (begin == target) {
            result = minOf(result, count)
            return
        }


        for (i in 0 until words.size) {
            var diffSum = 0
            for (j in 0 until begin.length) {
                if (begin[j] != words[i][j]) diffSum ++
            }

            if (diffSum == 1 && !visited[i]) {
                visited[i] = true
                dfs(words[i], target, words, count+1)
                visited[i] = false
            }
        }


    }
}