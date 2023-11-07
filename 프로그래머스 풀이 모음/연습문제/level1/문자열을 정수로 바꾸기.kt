class Solution {
    fun solution(s: String): Int {
        var answer = 0

        if(s[0].toString() == "-") {
            return s.substring(1, s.length).toInt() * (-1)
        } else {
            return s.toInt()
        }
    }
}