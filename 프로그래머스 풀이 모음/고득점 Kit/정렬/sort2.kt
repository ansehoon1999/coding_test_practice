class Solution {

    fun solution(numbers: IntArray): String {

        val result  = numbers.map { it.toString() }.sortedWith(Comparator { o1, o2 ->
            return@Comparator (o2 + o1).compareTo(o1+o2)
        })


        if (result[0] == "0") return "0"

        val sb = StringBuilder()

        result.forEach {
            sb.append(it)
        }
        return sb.toString()
    }


}