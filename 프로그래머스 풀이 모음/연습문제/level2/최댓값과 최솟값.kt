class Solution {
    fun solution(s: String): String {
        var answer = ""

        val sList = s.split(" ").map { it.toInt() }

        return "${sList.minOf { it }} ${sList.maxOf { it }}"
    }
}