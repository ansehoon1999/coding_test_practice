class Solution {

    val dayMonth = mutableListOf<Int>(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    val date = mutableListOf<String>("FRI","SAT","SUN","MON","TUE","WED","THU")

    fun solution(a: Int, b: Int): String {

        var totalDay = 0
        for(i in 0 until a - 1) {
            totalDay += dayMonth[i]
        }

        totalDay += b

        if(totalDay % 7 == 0) return date.last()
        else return date[totalDay % 7 - 1]
    }
}