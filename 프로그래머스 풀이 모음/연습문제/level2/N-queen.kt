class Solution {

    lateinit var rowList: MutableList<Int>

    var answer = 0

    fun solution(n: Int): Int {


        rowList = MutableList<Int>(n) { -1 }

        dfs(0, n)

        return answer
    }

    fun dfs(rCnt: Int, n: Int) {

        if(rCnt == n) {
            answer ++
            return
        }

        for(col in 0 until n) {
            if(check(rCnt, col, n)) {
                rowList[rCnt] = col
                dfs(rCnt+1, n)
                rowList[rCnt] = -1
            }
        }
    }

    fun check(rCnt: Int, col: Int, n: Int): Boolean {
        for(r in 0 until rCnt) {
            if(rowList[r] == col || Math.abs(rowList[r] - col) == Math.abs(r - rCnt)) return false
        }

        return true
    }

}