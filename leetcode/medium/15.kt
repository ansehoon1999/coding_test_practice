class Solution {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val ans = mutableSetOf<List<Int>>()
        nums.sort()


        for (i in 0 until nums.size - 2) {
            if (nums[i] > 0) break 
        
            var start = i+1
            var end = nums.size -1
            var sum = -nums[i]

            while (start < end) {
                if (nums[start] + nums[end] == sum) {
                    ans.add(listOf(nums[i], nums[start], nums[end]))
                    start ++
                    end --
                } else if(nums[start] + nums[end] < sum) start++
                else end --
            }
        }
        return ans.toList()

    }
}