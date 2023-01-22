class Solution {
    
    
    var map = mutableMapOf<Int, Int>()

    fun combinationSum4(nums: IntArray, target: Int): Int {
        return backtrack(nums, 0, target)
    }

    fun backtrack(nums:  IntArray, current : Int, target : Int) : Int {
        if (current == target) return 1
        else if (current > target) return 0
        if (map[current] != null) return map[current]!!

        var count = 0
        nums.forEach { n ->
            val num = current + n
            val combo = backtrack(nums, num, target)
            map[num] = combo
            count += combo
        }

        return count

    }
}
