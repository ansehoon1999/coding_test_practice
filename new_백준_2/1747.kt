import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * 1. 아리스토텔레스의 체
     * 2. 팰린드롬 판단
     */

    val n = br.readLine().toInt()

    val primeArr = MutableList<Boolean>(10000001) { true }
    primeArr[0] = false
    primeArr[1] = false

    for (i in 2..10000000) {
        if (!primeArr[i]) continue

        for (j in i * 2..10000000 step (i)) {
            primeArr[j] = false
        }
    }


    fun isFellindrom(num: Int): Boolean {
        val numList = num.toString().toList().map { it.toString() }

        var startIdx = 0
        var endIdx = numList.lastIndex

        while(startIdx < endIdx) {

            if(numList[startIdx] == numList[endIdx]) {
                startIdx ++
                endIdx --
            } else {
                return false
            }
        }

        return true
    }

    for (i in n .. 10000000) {
        if(primeArr[i] && isFellindrom(i)) {
            println(i)
            return
        }
    }


    writer.flush()
    writer.close()
}

