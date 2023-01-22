class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (i in 1 .. amount) {
            for (j in coins) {
                if (i == j) dp[i] = 1 
                else if (i > j) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i-j])

                }
            }
        }
    
        if (dp[amount] == amount + 1) return -1
        else return dp[amount]
    }

}