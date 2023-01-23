class Solution {
    val INF = 1000000007
    val MM = 100001
    val dp3 = LongArray(MM)
    val dp4 = LongArray(MM)

    fun countTexts(s: String): Int {
        //tribonacci
        dp3[1] = 1
        dp3[2] = 2
        dp3[3] = 4
        for (i in 4 until MM) dp3[i] = (dp3[i-1] + dp3[i-2] + dp3[i-3]) % INF
        //tetranacci
        dp4[1] = 1
        dp4[2] = 2
        dp4[3] = 4
        dp4[4] = 8
        for (i in 5 until MM) dp4[i] = (dp4[i-1] + dp4[i-2] + dp4[i-3] + dp4[i-4]) % INF

        var count = 1L
        var i = 0
        val n = s.length
        while (i < n) {
            var len = 1

            while (i+1 < n && s[i] == s[i+1]) {
                i++
                len ++
            }

            if (s[i] == '7' || s[i] == '9') count *= dp4[len]
            else count *= dp3[len]
            count %= INF

            i++
        }
    
        return count.toInt()
    }
}

        // val dp = MutableList<Int>(pressedKeys.length+1) { 0 }
        // dp[0] = 1
        // dp[1] = if (pressedKeys[0].toInt() > 1) 1 else 0

        // var start = 0
        // var result : Long = 1L
        // for (i in 2 .. pressedKeys.length) {
        //     if (pressedKeys[i-1] != pressedKeys[i-2]) {
        //         start = i-1 // 4
        //         dp[i] = 1
        //         // println(dp)
        //         // println(dp[i-1]%(1000000007))

        //         result *= (dp[i-1]%(1000000007))
        //         result %= 1000000007
        //         dp[i-1] = 1
        //     } else {
        //         if (i-1 - start >= 0) {
        //             val num1 = pressedKeys.substring(i-1, i).toInt()
        //              dp[i] += dp[i-1]
        //          } 
              
        //         if (i-2 - start >= 0) {
        //             val num2 = pressedKeys.substring(i-2, i).toInt()
        //             dp[i] += dp[i-2]
        //         }

        //         if (i-3 - start >= 0) {
        //             val num3 = pressedKeys.substring(i-3, i).toInt()
        //             dp[i] += dp[i-3]
        //         }
        //         if (i-4 - start >= 0) {
        //             val num4 = pressedKeys.substring(i-4, i).toInt()
        //             if (num4 == 9999 || num4 == 7777) {
        //                 dp[i] += dp[i-4]
        //             }
        //         }
        //     }

        //     // println(dp)
        //     // println(result)
        // }

            
    
    

        // println(dp)
        // return ((result * (dp[pressedKeys.length]%(1000000007))) %(1000000007)).toInt()

