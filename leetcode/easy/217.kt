class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()

        nums.forEach { num ->
            set.add(num)
        }

        if (nums.size == set.size) return false
        else return true
    }
}