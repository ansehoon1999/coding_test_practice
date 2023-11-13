class Solution {

    val upperList = mutableListOf<String>("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")

    val lowerList = mutableListOf<String>("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")

    val charList = mutableListOf<String>("-", "_", ".")

    val numList = mutableListOf<String>("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")

    // val specialList = mutableListOf<String>("-", "_", ".", "~", "!", "@", "#", "$", "%", "^", "&*()=+[{]}:?,<>/")

    val specialStr = "~!@#$%^&*()=+[{]}:?,<>/"
    fun solution(new_id: String): String {
        var answer: String = ""

        var id = new_id

        // 1
        id = id.toLowerCase()
        // println(id)

        // 2

        var result2 = ""
        id.forEach {
            if(it !in specialStr) {
                result2 += it
            }
        }

        // println(result2)

        // 3

        var result3 = ""
        var idx = 0

        for(idx in 0 until result2.length) {
            if(idx == 0) {
                result3 += result2[idx]
            } else {
                val cur = result2[idx]
                val bef = result2[idx-1]

                if(bef == '.' && cur == '.') continue

                result3 += result2[idx]
            }
        }

        println(result3)

        //4

        var result4 = result3

        if(result4.isNotEmpty() && result4.first() == '.') result4 = result4.removeRange(0, 1)
        if(result4.isNotEmpty() && result4.last() == '.') result4 = result4.removeRange(result4.length - 1, result4.length)


        println(result4)

        // 5

        var result5 = ""
        if(result4.length == 0) result5 = "a"
        else result5 = result4

        // println(result5)

        // 6
        var result6 = ""
        if(result5.length >= 16) {
            result6 = result5.substring(0, 15)
            if(result6[result6.length - 1] == '.') result6 = result6.substring(0, 14)
        } else {
            result6 = result5
        }

        println(result6)

        // 7
        var result7 = ""
        if(result6.length == 1) {
            result7 = result6 + result6 + result6
        } else if(result6.length == 2) {
            result7 = result6 + result6[result6.length - 1].toString()
        } else {
            result7 = result6
        }

        return result7
    }
}