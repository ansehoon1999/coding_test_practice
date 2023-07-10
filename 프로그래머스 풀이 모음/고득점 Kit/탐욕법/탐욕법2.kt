class Solution {
    fun solution(name: String): Int {

        var answer = 0
        var len = name.length
        var move = len - 1

        for(i in 0 until len) {
            if(name[i].code < 'N'.code) {
                answer += name[i].code - 'A'.code
            } else {
                answer += 'Z'.code - name[i].code + 1
            }

            var conA = i+1
            while(conA < len && name[conA] == 'A') {
                conA ++
            }

            move = minOf(move, i+(len-conA)+ minOf(i,len-conA))
        }

        return move + answer
    }
}