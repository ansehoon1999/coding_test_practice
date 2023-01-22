class Solution {
    fun canJump(nums: IntArray): Boolean {
        val list = MutableList<Boolean>(nums.size) { false }
        list[0] = true

        for (i in 1 until nums.size) {
            for (j in i-1 downTo 0) {
                if (list[j] && (j+nums[j]) >= i) {
                    // println("nums ${nums[j]} j ${j}")
                    list[i] = true
                    break
                }      
            }

        }

        // println(list)
        
        return list.last()
    }

    
}