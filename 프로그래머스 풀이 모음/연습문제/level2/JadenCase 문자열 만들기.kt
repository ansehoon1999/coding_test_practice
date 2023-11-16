class Solution {
    fun solution(s: String): String {
        var answer = ""

        if(!s[0].isDigit()) answer += s[0].toUpperCase()
        else answer += s[0]

        for(idx in 1 until s.length) {

            val curChar = s[idx]
            val befChar = s[idx-1]

            if(befChar == ' ') {
                if(!curChar.isDigit()) answer += curChar.toUpperCase()
                else answer += curChar.toLowerCase()
            } else {
                answer += curChar.toLowerCase()
            }
        }

        return answer
    }
}