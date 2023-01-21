class Solution {
    private lateinit var arr : IntArray
    var count = Integer.MIN_VALUE


    fun maxProduct(nums: IntArray): Int {
        arr = nums
        for (i in 0 until nums.size) {
            backtracking(i, nums[i])
        }

        return count
    }

    
    fun backtracking(num: Int, result : Int) {

        count = Math.max(count, result)

        if (num == arr.size-1) {
            return
        } else {

            backtracking(num+1, result * arr[num+1])
        }
    }
}