class Solution {
    fun rob(nums: IntArray): Int {
        
        if (nums.size == 1) return nums[0]

        val list1 = MutableList<Int>(nums.size+1) { 0 }
        list1[1] = nums[0]
        for (i in 1 until nums.size) {
            list1[i+1] = Math.max(list1[i-1] + nums[i], list1[i]) 
        }

        println(list1)
        
        val list2 = MutableList<Int>(nums.size+1) { 0 }
        list2[2] = nums[1]
        for (i in 2 until nums.size) {
            list2[i+1] = Math.max(list2[i-1] + nums[i], list2[i]) 
        }  
        println(list2)


        return maxOf(list1.last() - list1[1], list2.last(), list1[list1.size-2])
    }
}
    
