class Solution {
    
        fun search(nums: IntArray, target: Int): Int {

        val n = nums.size

        var start = 0
        var end = n-1

        while(start <= end) {
            val mid = (start + end) / 2

            if (nums[mid] == target) return mid

                if (nums[mid] <= nums[end]) {
                    if (nums[mid] <= target && target <= nums[end]) {
                        start = mid + 1
                    } else {
                        end = mid - 1
                    }
                } else  {
                    if (nums[start] <= target && target <= nums[mid]) {
                        end = mid - 1
                    } else {
                        start = mid + 1
                    }
                }

        }

        return -1
    
    }
}