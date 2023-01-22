class Solution {
    fun rob(nums: IntArray): Int {
        val list = MutableList(nums.size) { 0 }
        if (nums.size == 1) {
            list[0] = nums[0]
        } else {
            list[0] = nums[0]
            list[1] = nums[1]
        }
        for (i in 2 until nums.size) {
            var tmp = 0
            for (j in 0 .. i-2) {
                tmp = Math.max(tmp, list[j])
            }

            list[i] += (nums[i] + tmp)
        }
        return list.max()!!

    }
}