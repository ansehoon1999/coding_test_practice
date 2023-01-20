class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        
        
        val result = IntArray(2) { 0 }

        var state = false
        for (i in 0 until nums.size) {
            for (j in i+1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i
                    result[1] = j
                    state = true
                    break
                }
            }
            
            if (state) break
        }

        return result
    }
}