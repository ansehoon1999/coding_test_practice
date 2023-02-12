 fun removeElement(nums: IntArray, `val`: Int): Int {
        val c = nums.filter { it != `val` }
        for ((a, b) in c.withIndex()) { nums[a] = b }
        return c.size
    }