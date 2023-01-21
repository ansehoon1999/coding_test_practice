class Solution {


    fun lengthOfLIS(nums: IntArray): Int {
        val list = MutableList<Int>(nums.size) { 1 }

        for (i in 1 until nums.size) {
            var tmp = 0
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    tmp = Math.max(tmp, list[j])
                }
            }
            list[i] = tmp + 1
        }

        return list.max()!!

    }

}