class Solution {
    var target = 0
    var result = 9

    fun solution(N: Int, number: Int): Int {

        target = number
        dfs(N, 0, 0)

        if(result == 9) return -1

        return result
    }



    fun dfs(n: Int, cnt: Int, current: Int) {

        if(cnt > 8) {
            return
        }

        if(current == target) {
            result = minOf(result, cnt)
            return
        }

        var nextNum = n
        for(i in 0 until 8-cnt) {
            dfs(n, cnt+1 + i, current + nextNum)
            dfs(n, cnt+1 + i, current - nextNum)
            dfs(n, cnt+1 + i, current * nextNum)
            dfs(n, cnt+1 + i, current / nextNum)
            nextNum += n * Math.pow(10.0, i+1.toDouble()).toInt()
        }

    }


}