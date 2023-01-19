class Solution {

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        val today_count = calculate_days(today)
        
        val terms_map = hashMapOf<String, Int>()
        terms.forEach { term ->
            val (type, duration) = term.split(' ')
            terms_map[type] = today_count - duration.toInt() * 28
        }

        val result = mutableListOf<Int>()

        for (i in 0 until privacies.size) {
            val (date, type) = privacies[i].split(' ')
            if (terms_map[type]!! >= calculate_days(date)) {
                result.add(i+1)
            }
        }
        
        
        return result.toIntArray()
    }
    
    
    fun calculate_days(date : String) : Int {
        val (year, month, day) = date.split('.').map { it.toInt() }

        return (year * 12 + month) * 28 + day
    }
}