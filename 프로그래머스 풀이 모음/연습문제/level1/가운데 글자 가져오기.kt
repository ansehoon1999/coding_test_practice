class Solution {
    fun solution(s: String): String {
        var answer = ""

        if(s.length % 2 == 0) {
            return s.substring(s.length / 2 - 1, s.length / 2 + 1)
        } else {
            return s[s.length / 2].toString()
        }
    }
}