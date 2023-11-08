class Solution {
    fun solution(s: String): String {
        var answer = ""


        val sList = s.split(" ")

        for(i in 0 until sList.size) {
            for(j in 0 until sList[i].length) {
                if(j % 2 == 0) {
                    answer += sList[i][j].toUpperCase()
                } else {
                    answer += sList[i][j].toLowerCase()
                }
            }

            if(i != sList.size - 1) {
                answer += " "
            }


        }


        return answer
    }
}