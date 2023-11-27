class Solution {

    lateinit var visited: MutableList<Boolean>

    var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {

        visited = MutableList<Boolean>(numbers.size) { false }

        dfs(numbers, target, listOf<Int>(), 0)

        return answer
    }

    fun dfs(numbers: IntArray, target: Int, list: List<Int>, cnt: Int) {


        if(list.size == numbers.size) {

            if(list.sum()!! == target) {
                answer ++
            }

            return
        }

        dfs(numbers, target, list + listOf<Int>(numbers[cnt]), cnt + 1)

        dfs(numbers, target, list + listOf<Int>((-1) * numbers[cnt]), cnt + 1)

    }
}