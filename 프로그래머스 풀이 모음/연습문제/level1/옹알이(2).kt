class Solution {

    val word = arrayOf("aya", "ye", "woo", "ma")

    fun solution(babbling: Array<String>): Int {

        var answer: Int = 0

        babbling.forEach { bab ->
            var curPos = 0
            var beforeBab = -1

            while(curPos < bab.length) {
                if(curPos + 3 <= bab.length && bab.substring(curPos, curPos + 3) == "aya" && beforeBab != 0) {
                    curPos = curPos + 3
                    beforeBab = 0
                } else if(curPos + 2 <= bab.length && bab.substring(curPos, curPos + 2) == "ye" && beforeBab != 1) {
                    curPos = curPos + 2
                    beforeBab = 1
                } else if(curPos + 3 <= bab.length && bab.substring(curPos, curPos + 3) == "woo" && beforeBab != 2) {
                    curPos = curPos + 3
                    beforeBab = 2
                } else if(curPos + 2 <= bab.length && bab.substring(curPos, curPos + 2) == "ma" && beforeBab != 3) {
                    curPos = curPos + 2
                    beforeBab = 3
                } else {
                    break
                }
            }

            if(curPos == bab.length) {
                answer ++
            }
        }


        return answer
    }
}