class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n:Int):Int {
        return solve(n)
    }
    
    fun solve(x: Int): Int {
        var temp = x
        var res = 0
        for (i in 0..31) {
            // shift result to left always in loop
            res=(res shl 1)
            // println(res)

            // add 1 to result if end of number is 1
            res+=(temp and 1)
            // println(res)

            // shift right number by 1
            temp =temp shr 1
            // println(temp)

            // println()

        }
        return res
    }
}