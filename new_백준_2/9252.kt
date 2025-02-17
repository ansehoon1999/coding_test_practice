import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * dp[i][j] = 부분 수열 개수
     */

    val chList1 = br.readLine().toList()
    val chList2 = br.readLine().toList()

    val dp = MutableList<MutableList<Int>>(chList1.size + 1) {
        MutableList<Int>(chList2.size + 1) { 0 }
    }


    for(i in 1 until chList1.size + 1) {
        for(j in 1 until chList2.size + 1) {
            if(chList1[i-1] == chList2[j-1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                continue
            }

            dp[i][j] = maxOf(dp[i][j], dp[i-1][j], dp[i][j-1])
        }
    }


//    dp.forEach {
//        println(it)
//    }

    var result = ""


    var curI = chList1.size
    var curJ = chList2.size

    while(curI > 0 && curJ > 0 && dp[curI][curJ] != 0) {

        if(dp[curI][curJ] == dp[curI-1][curJ]) {
            curI --
            continue
        }

        if(dp[curI][curJ] == dp[curI][curJ - 1]) {
            curJ --
            continue
        }


        result = chList1[curI-1] + result
        curI --
        curJ --
    }

    if(dp[curI][curJ] != 0) {
        result = chList1[curI - 1] + result
    }

    println(dp[chList1.size][chList2.size])
    println(result)

}














