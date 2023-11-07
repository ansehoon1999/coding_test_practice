class Solution {
    fun solution(s: String): String {
        var answer = ""

        val sList = s.toCharArray()
        sList.sortDescending()

        return String(sList)
    }
}