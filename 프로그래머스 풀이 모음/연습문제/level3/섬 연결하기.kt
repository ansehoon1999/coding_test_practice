class Solution {

    private lateinit var parents: MutableList<Int>

    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0

        costs.sortBy { it[2] }

        parents = MutableList<Int>(n) { it }

        // println("parents: ${parents}")
        // println(costs.map { it.toList() }.toList())

        for(cost in costs) {

            if(find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1])
                answer += cost[2]
            }
        }

        return answer
    }

    fun union(num1: Int, num2: Int) {
        val num1 = find(num1)
        val num2 = find(num2)

        if(num1 < num2) parents[num2] = num1
        else parents[num1] = num2
    }

    fun find(num: Int): Int {

        if(parents[num] == num) {
            return num
        }

        parents[num] = find(parents[num])
        return parents[num]


    }
}