class Solution {

    val upperHashMap = hashMapOf(
            "A" to 0,
            "B" to 1,
            "C" to 2,
            "D" to 3,
            "E" to 4,
            "F" to 5,
            "G" to 6,
            "H" to 7,
            "I" to 8,
            "J" to 9,
            "K" to 10,
            "L" to 11,
            "M" to 12,
            "N" to 13,
            "O" to 14,
            "P" to 15,
            "Q" to 16,
            "R" to 17,
            "S" to 18,
            "T" to 19,
            "U" to 20,
            "V" to 21,
            "W" to 22,
            "X" to 23,
            "Y" to 24,
            "Z" to 25,
    )

    val lowerHashMap = hashMapOf(
            "a" to 0,
            "b" to 1,
            "c" to 2,
            "d" to 3,
            "e" to 4,
            "f" to 5,
            "g" to 6,
            "h" to 7,
            "i" to 8,
            "j" to 9,
            "k" to 10,
            "l" to 11,
            "m" to 12,
            "n" to 13,
            "o" to 14,
            "p" to 15,
            "q" to 16,
            "r" to 17,
            "s" to 18,
            "t" to 19,
            "u" to 20,
            "v" to 21,
            "w" to 22,
            "x" to 23,
            "y" to 24,
            "z" to 25,
    )

    fun solution(s: String, n: Int): String {
        var answer = ""

        s.forEach { sChar ->
            if(upperHashMap[sChar.toString()] != null) {
                val sIdx = upperHashMap[sChar.toString()]!!
                val newSIdx = (sIdx + n) % 26

                for((key, value) in upperHashMap) {
                    if(value == newSIdx) {
                        answer += key
                    }
                }
            }

            if(lowerHashMap[sChar.toString()] != null) {
                val sIdx = lowerHashMap[sChar.toString()]!!
                val newSIdx = (sIdx + n) % 26

                for((key, value) in lowerHashMap) {
                    if(value == newSIdx) {
                        answer += key
                    }
                }
            }

            if(sChar.toString() == " ") {
                answer += " "
            }
        }


        return answer
    }
}