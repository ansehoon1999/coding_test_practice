class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()

        val sList = s.substring(1, s.length-1).split("},{")

        val newList = mutableListOf<List<Int>>()

        sList.forEach { str ->
            val newStr = str.replace("{", "").replace("}", "")
            newList.add(newStr.split(",").map { it.toInt() })
        }

        newList.sortBy { it.size }

        val result = mutableSetOf<Int>()

        newList.forEach { subList ->
            subList.forEach {
                result.add(it)
            }
        }

        return result.toIntArray()
    }
}