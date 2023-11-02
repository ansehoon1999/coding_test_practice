class Solution {

    val xList = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val yList = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

    fun solution(X: String, Y: String): String {
        var answer = StringBuilder()

        X.forEach { xChar ->
            val xIdx = xChar.toString().toInt()
            xList[xIdx] = xList[xIdx] + 1
        }

        Y.forEach { yChar ->
            val yIdx = yChar.toString().toInt()
            yList[yIdx] = yList[yIdx] + 1
        }

        for (idx in 9 downTo 0) {
            if(xList[idx] == 0 || yList[idx] == 0) {
                continue
            }

            val minValue = minOf(xList[idx], yList[idx])

            repeat(minValue) {
                answer.append(idx.toString())
            }

        }


        if(answer.toString() == "") return "-1"

        else if(answer.toString().startsWith("0")) return "0"

        else return answer.toString()
    }
}