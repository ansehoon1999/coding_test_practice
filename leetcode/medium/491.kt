class Solution {
    
    var result = mutableListOf<List<Int>>()
    var endpoint = 0
    var tmp = mutableListOf<Int>()

    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val subs = mutableSetOf<List<Int>>()

        fun backtrack(index : Int,  list : List<Int>) {
            if (index == n) {
                if (list.size >= 2) {
                    subs.add(list)
                }
            } else {
                if (list.isEmpty() || list[list.size -1] <= nums[index]) {
                    backtrack(index + 1, list + listOf(nums[index]))
                }
                backtrack(index+1, list)
            }
        }
        backtrack(0, listOf<Int>())
        return subs.toMutableList()

    }

   
}