class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0

        if(a == b) return a.toLong()
        else if(a < b) {
            for(num in a .. b) {
                answer += num
            }

            return answer
        } else {
            for(num in b .. a) {
                answer += num
            }

            return answer
        }


        return answer
    }
}