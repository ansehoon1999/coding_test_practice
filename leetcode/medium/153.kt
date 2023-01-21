class Solution {
    fun findMin(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1

    if (nums[start] < nums[end]) {
        return nums[start]
    }

    while (start < end) {
        println("${start} ${end}")
        var mid = (start + end) / 2
        val next = (mid + 1)
        val prev = (mid - 1)

        if(nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
            return nums[mid]
        } else if (nums[mid] < nums[end]) {
            end = mid -1
        } else {
            start = mid + 1
        }


    }

    return nums[end]
    }   

}