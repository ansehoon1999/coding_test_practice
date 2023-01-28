class Solution {
    fun missingNumber(nums: IntArray): Int {
        
        var sum = 0
        var count = 0

        for (i in 0 until nums.size) {
            sum += (i+1)
            count += nums[i]
        }

        // println(sum)
        // println(count)

        return sum-count
    }
}