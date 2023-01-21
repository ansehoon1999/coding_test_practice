class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val list = mutableListOf<Int>()
        list.add(0)

        var num = 0
        for (i in 0 until nums.size) {
            num += nums[i]
            list.add(num)
        }



        var min = 100000000
        var max = -100000000
        var cost = -100000000
        for (i in 0 until list.size) {
            if (min > list[i]) {
                min = list[i]
                max = -100000000
            } else {
                max = Math.max(max, list[i])
                cost = Math.max(cost, max - min)
                
            }
        }

        if (cost == -100000000) {
            var max = -100000000
            for (i in 0 until nums.size) {
                max = Math.max(nums[i], max)
            }
            return max
        }
        else return cost
    }
}