class Solution {
    fun solution(phone_number: String): String {
        var answer = ""

        val phoneNumberLen = phone_number.length

        var count = 0

        for(idx in phoneNumberLen - 1 downTo 0) {
            if(count < 4) {
                answer = phone_number[idx].toString() + answer
            } else {
                answer = "*" + answer
            }

            count++

            // println(answer)
        }


        return answer
    }
}