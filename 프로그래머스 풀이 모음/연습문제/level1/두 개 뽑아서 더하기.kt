class Solution {

    val sumSet = mutableSetOf<Int>()

    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        for(idx in 0 until numbers.size) {
            permutation(idx, numbers)
        }

        val sumList = sumSet.toList()


        return sumList.sorted().toIntArray()
    }

    fun permutation(i: Int, numbers: IntArray) {
        for(idx in i+1 until numbers.size) {
            sumSet.add(numbers[i] + numbers[idx])
        }
    }
}