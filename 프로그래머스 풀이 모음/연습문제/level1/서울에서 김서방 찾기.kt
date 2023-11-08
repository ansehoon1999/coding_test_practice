class Solution {
    fun solution(seoul: Array<String>): String {
        var answer = ""

        var kimIdx = 0
        seoul.forEachIndexed { idx, kim ->
            if(kim == "Kim") {
                kimIdx = idx
            }
        }

        return "김서방은 ${kimIdx}에 있다"
    }
}