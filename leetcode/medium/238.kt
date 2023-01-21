class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val list = MutableList<Int>(nums.size) { 1 }

        var count = 1
        for (i in 1 until nums.size) {
            count *= nums[i-1]
            list[i] *= count
        }

        count = 1
        for (i in nums.size-2 downTo 0) {
            count *= nums[i+1]
            list[i] *= count
        }

        return list.toIntArray()
    }
}