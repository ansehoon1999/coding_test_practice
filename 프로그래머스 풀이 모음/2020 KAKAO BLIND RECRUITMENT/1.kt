class Solution {
    fun solution(s: String): Int {
        val sSize = s.length

        var minSize = sSize

        for (curSplitSize in 1..sSize) {

            val tokenList = mutableListOf<String>()
            var start = 0

            while (start < sSize) {

                tokenList.add(s.substring(start, sSize.coerceAtMost(start + curSplitSize)))
                start += curSplitSize
            }

            tokenList.add("")

            var result = ""
            var curCnt = 1
            var idx = 1

            while (idx < tokenList.size) {

                val curToken = tokenList[idx]
                if (curToken == tokenList[idx - 1]) {
                    curCnt++
                } else {

                    result += if (curCnt == 1) tokenList[idx - 1] else "${curCnt}${tokenList[idx - 1]}"

                    curCnt = 1
                }

                idx++
            }

            minSize = minOf(minSize, result.length)
        }

        return minSize
    }
}