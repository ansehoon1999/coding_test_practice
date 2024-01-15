class Solution {

    lateinit var parents: MutableList<Int>

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        parents = MutableList<Int>(n) { it }

        for(i in 0 until n) {
            for(j in 0 until n) {
                if(i != j && computers[i][j] == 1) {
                    union(i, j)
                }
            }
        }

        return parents.toSet().size
    }

    fun union(n1: Int, n2: Int) {
        val num1 = find(n1)
        val num2 = find(n2)

        if(n1 < n2) parents[n2] = parents[n1]
        else parents[n1] = parents[n2]
    }

    fun find(num: Int): Int {
        if(parents[num] == num) {
            return num
        }

        parents[num] = find(parents[num])
        return parents[num]
    }
}