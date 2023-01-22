class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1) { false }               
        dp[s.length] = true

        for(i in s.length downTo 0) {
            for (word in wordDict) {
                if (word.length + i > s.length) continue

                if (word == s.substring(i, i+word.length)) {
                    dp[i] = dp[i+word.length]
                }

                if (dp[i])break
            }
                
            
        }
        return dp[0]
    }

}