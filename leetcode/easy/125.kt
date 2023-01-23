class Solution {
    fun isPalindrome(s: String): Boolean {
        val list = mutableListOf<Char>()

        println('0'.toInt())
        println('9'.toInt())
        for (i in s) {
            if (i.toInt() in 65 .. 90) {
                list.add(i + 32)
            } else if (i.toInt() in 97 .. 122) {
                list.add(i)
            } else if(i.toInt() in 48 .. 57) {
                list.add(i)
            }
        }

        var start = 0
        var end = list.size - 1
        var state = true

        while (start < end) {
            // println("start ${list[start]} end ${list[end]}")
            if (list[start] != list[end]) {
                state =false
                break
            }
            start ++
            end --
        }


        // println(list)


        return state
    }
}