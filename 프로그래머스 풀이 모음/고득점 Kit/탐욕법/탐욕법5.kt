class Solution {
    private lateinit var parent: MutableList<Int>

    fun solution(n: Int, costs: Array<IntArray>): Int {

        var result = 0
        parent = MutableList(n) { it }

        //    println(parent)

        costs.sortBy { it[2] }
        costs.forEach { cost ->
            val firstParent = findParent(parent, cost[0])
            val secondParent = findParent(parent, cost[1])

            if(firstParent != secondParent) {
                union(parent, firstParent, secondParent)
                result += cost[2]
            }
        }

        //    println(costs.toMutableList().map { it.toMutableList() })

        return result
    }

    fun findParent(parent: MutableList<Int>, x: Int): Int {
        if(parent[x] != x) {
            parent[x] = findParent(parent, parent[x])
        }

        return parent[x]
    }

    fun union(parent: MutableList<Int>, a: Int, b: Int) {
        val first = findParent(parent, a)
        val second = findParent(parent, b)

        if(first < second) {
            parent[second] = first
        } else {
            parent[first] = second
        }
    }
}