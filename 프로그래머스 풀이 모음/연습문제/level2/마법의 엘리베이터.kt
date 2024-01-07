class Solution {
    var answer: Int = Integer.MAX_VALUE

    fun solution(storey: Int): Int {


        dfs(storey, 1, 0)

        return answer
    }

    fun dfs(num: Int, cnt: Int, total: Int) {

        if(cnt > 12) return

        if(num == 0)  {
            answer = minOf(answer, total)
            return
        }

        val els = num % (Math.pow(10.0, cnt.toDouble()).toInt()) // 2554 % 10 = 4
        val cost = els / Math.pow(10.0, cnt.toDouble()-1.0).toInt() // 4 / 1 = 4

        dfs(num - els, cnt + 1, total + cost)
        dfs(num + Math.pow(10.0, cnt.toDouble()).toInt() - els, cnt + 1, total + (10 - cost))
    }
}