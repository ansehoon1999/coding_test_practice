class Solution {
    fun longestConsecutive(nums: IntArray): Int {

        if (nums.size == 0) return 0

        val set = nums.toMutableSet()
        
        val max = set.max()!!


        var count = 0
        var result = 0

        nums.forEach { num ->

            if (num-1 !in set) {
                var length = 1
                while (set.contains(num+length)) {
                    length ++
                }
                result = Math.max(result, length)

            }
        }


        return result
    }
}