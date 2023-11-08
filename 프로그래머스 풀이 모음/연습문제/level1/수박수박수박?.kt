class Solution {
    fun solution(n: Int): String {
        var answer = ""

        if(n % 2 == 0) {
            repeat(n/2) {
                answer += "수박"
            }
        } else {
            repeat(n/2) {
                answer += "수박"
            }

            answer += "수"
        }


        return answer
    }
}