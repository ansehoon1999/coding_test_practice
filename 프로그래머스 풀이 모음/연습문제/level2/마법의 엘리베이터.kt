class Solution {

    var answer: Int = Integer.MAX_VALUE

    fun solution(storey: Int): Int {

        dfs(storey, 0)

        return answer
    }

    fun dfs(storey: Int, cnt: Int) {

        val div = storey / 10
        val leftEls = storey % 10
        val rightEls = 10 - (storey % 10)

        if(storey == 0) {
            answer = minOf(answer, cnt)
            return
        }

        if(storey == 1) {
            dfs(0, cnt + 1)
        } else {
            dfs(div, cnt + leftEls)
            dfs(div + 1, cnt + rightEls)
        }

    }
}