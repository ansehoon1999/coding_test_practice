class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        
        var count  = 0 
        var n = n
        for (i in 0 .. 31) {
            if (n and 1 == 1) count ++
            n = n shr 1
        }

        return count
    }
}