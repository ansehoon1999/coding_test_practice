class Solution {
    fun canJump(nums: IntArray): Boolean {

        var boundary = 1
        nums.forEach {
            if (boundary == 0) return false

            boundary = Math.max(boundary-1, it)
        }
        return true

    }

    
}