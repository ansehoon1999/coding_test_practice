class Solution {
    fun solution(x: Int): Boolean {
        var answer = true

        val xStr = x.toString()
        var total = 0

        xStr.forEach { xChar ->
            total += xChar.toString().toInt()
        }

        if(x % total == 0) return true
        else return false

    }
}