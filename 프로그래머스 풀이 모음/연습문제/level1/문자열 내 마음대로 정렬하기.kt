class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var answer = arrayOf<String>()

        strings.sort()
        strings.sortBy { it[n] }

        return strings
    }
}