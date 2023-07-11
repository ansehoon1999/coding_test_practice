class Solution {

    private var termMap = hashMapOf<String, Int>()

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {

        val todayTotal= calculateTotal(today)
        val result = mutableListOf<Int>()

        terms.forEach { terms ->
            val (type, term) = terms.split(" ")
            termMap[type] = term.toInt() * 28
        }

        var count = 1
        privacies.forEach { privacy ->
            val (date, type) = privacy.split(" ")
            val totalDate = calculateTotal(date)

            val duration = totalDate + termMap[type]!!

            if(todayTotal >= duration) {
                result.add(count)
            }

            count ++
        }



        return result.toIntArray()
    }

    fun calculateTotal(yyyyMMdd: String): Int {
        val (yyyy, MM, dd) = yyyyMMdd.split(".").map { it.toInt() }
        return (yyyy * 12 + MM) * 28 + dd
    }
}