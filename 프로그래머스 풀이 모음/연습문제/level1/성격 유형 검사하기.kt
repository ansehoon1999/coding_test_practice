class Solution {

    val hashMap = hashMapOf<Char, Int>(
            'R' to 0,
            'T' to 0,
            'C' to 0,
            'F' to 0,
            'J' to 0,
            'M' to 0,
            'A' to 0,
            'N' to 0
    )


    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""

        var R = 0
        var T = 0

        var C = 0
        var F = 0

        var J = 0
        var M = 0

        var A = 0
        var N = 0

        for(idx in 0 until survey.size) {
            val curSurvey = survey[idx]
            val curChoice = choices[idx]

            val left = curSurvey[0]
            val right = curSurvey[1]

            if(curChoice == 1) {
                hashMap[left] = hashMap[left]!! + 3
            } else if(curChoice == 2) {
                hashMap[left] = hashMap[left]!! + 2
            } else if(curChoice == 3) {
                hashMap[left] = hashMap[left]!! + 1
            } else if(curChoice == 5) {
                hashMap[right] = hashMap[right]!! + 1
            } else if(curChoice == 6) {
                hashMap[right] = hashMap[right]!! + 2
            } else if(curChoice == 7) {
                hashMap[right] = hashMap[right]!! + 3
            }

        }

        val Rcnt = hashMap['R']!!
        val Tcnt = hashMap['T']!!

        if(Rcnt >= Tcnt) answer += "R"
        else answer += "T"

        val Ccnt = hashMap['C']!!
        val Fcnt = hashMap['F']!!

        if(Ccnt >= Fcnt) answer += "C"
        else answer += "F"

        //

        val Jcnt = hashMap['J']!!
        val Mcnt = hashMap['M']!!

        if(Jcnt >= Mcnt) answer += "J"
        else answer += "M"

        //

        val Acnt = hashMap['A']!!
        val Ncnt = hashMap['N']!!

        if(Acnt >= Ncnt) answer += "A"
        else answer += "N"


        return answer
    }
}