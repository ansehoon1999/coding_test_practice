class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        val nList = n.toString().toList()

        nList.forEach { nChar ->
            val nInt = nChar.toString().toInt()
            answer += nInt
        }



        return answer
    }
}