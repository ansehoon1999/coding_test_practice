class Solution {
    fun maxArea(height: IntArray): Int {
        var start = 0
        var end = height.size-1
        var max = 0

        while (start != end) {
            val size = Math.min(height[start], height[end]) * Math.abs(end - start)

            max = Math.max(max, size)
            if (height[start] < height[end]) start ++
            else end --
            
        } 

        return max

    }

}