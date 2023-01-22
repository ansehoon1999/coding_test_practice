class Solution {
    fun numDecodings(s: String): Int {
        val n = s.length
        val dp = MutableList<Int>(n+1) { 0 }
        dp[0] = 1
        dp[1] = if (s[0] != '0') 1 else 0

        for (i in 2.. n) {

            val single = s.substring(i-1, i).toInt()
            if (single in 1..9) dp[i] += dp[i-1]

            val twice = s.substring(i-2, i).toInt()
            if (twice in 10 .. 26) dp[i] += dp[i-2]


            // println(single)
        }
        println(dp)
        return dp[n]
    }
}