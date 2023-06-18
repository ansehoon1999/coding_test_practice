class Solution {
    var size = 0
    var result = 0

    fun solution(numbers: IntArray, target: Int): Int {

        size = numbers.size

        dfs(numbers, target, 0, mutableListOf<Int>())

        return result
    }

    fun dfs(numbers: IntArray, target: Int, count: Int, list: List<Int>) {

        if(count == size) {
            if(list.sum()!! == target) {
                result++
            }
            return
        }

        dfs(numbers, target, count+1, list + (-1) * numbers[count])

        dfs(numbers, target, count+1, list + numbers[count])

    }

}