import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * 1. n, m, v
     * 2. 총 경우의 수 -> nCr 로 구하기
     * 3.
     *  aazz
     *  azaz
     *  azza
     *
     *  zzaa
     *  zaza
     *
     *  11C4
     *  10C4
     *  9C4
     *  8C4
     */

    val (n, m, k) =  br.readLine().split(" ").map { it.toInt() }

    val dp = MutableList<MutableList<Long>>(202) {
        MutableList<Long>(202) { 0L }
    }

    for(i in 0 until 201) {
        for(j in 0  .. i) {
            if(j == 0 || j == i) {
                dp[i][j] = 1
            } else {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
                if(dp[i][j] >1000000000 ) {
                    dp[i][j] = 1000000001
                }
            }
        }
    }

    val totalCase = dp[n+m][minOf(n, m)]
    if(k > totalCase) {
        println(-1)
        return
    }

    var aCnt = n
    var zCnt = m
    var tmpCase = k.toLong()

    var result = ""

    while(aCnt > 0 && zCnt > 0) {
//        println("aCnt: ${aCnt} zCnt: ${zCnt} tmpCase: ${tmpCase} result: ${result}")
//        println("dpValue:${dp[aCnt+zCnt][zCnt]}")

        // dp[aCnt+zCnt-1][zCnt] = a개의 경우의 수
        if(dp[aCnt+zCnt-1][zCnt] >= tmpCase) {
            aCnt -= 1
            result += "a"
        } else if(dp[aCnt+zCnt-1][zCnt] < tmpCase) {
            tmpCase -= dp[aCnt+zCnt-1][zCnt]
            zCnt -= 1
            result += "z"
        }

    }


//    println("aCnt: ${aCnt} zCnt: ${zCnt} tmpCase: ${tmpCase} result: ${result}")
//    println("dpValue:${dp[aCnt+zCnt][zCnt]}")

    if(aCnt != 0) {
        repeat(aCnt) {
            result += "a"
        }
    }

    if(zCnt != 0) {
        repeat(zCnt) {
            result += "z"
        }
    }

   println(result)

    dp.forEach {
        println(it)
    }



    writer.flush()
    writer.close()
}
