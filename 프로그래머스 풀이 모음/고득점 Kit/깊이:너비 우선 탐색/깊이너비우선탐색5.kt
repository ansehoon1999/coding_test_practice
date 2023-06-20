class Solution {

    lateinit var hashMap: HashMap<String, ArrayDeque<String>>
    lateinit var result: MutableList<String>

    fun solution(tickets: Array<Array<String>>): Array<String> {

        hashMap = hashMapOf()
        val ticketSize = tickets.size

        for(i in 0 until ticketSize) {
            val start = tickets[i][0]
            val end = tickets[i][1]

            if(hashMap[start] == null) {
                hashMap[start] = ArrayDeque()
            }
            hashMap[start]!!.add(end)
        }

        hashMap.forEach {
            it.value.sort()
        }

        dfs("ICN", listOf("ICN"))

        return result.toTypedArray()
    }

    fun dfs(start: String, list: List<String>) {
        // println(list)
        // println(hashMap)
        // println()

        var isEmpty = true
        hashMap.forEach {
            if(it.value.isNotEmpty()) {
                isEmpty = false
            }
        }

        if(isEmpty) {
            result = list.toMutableList()
            return
        }

        if(hashMap[start] == null) {
            return
        } else {
            val end = hashMap[start]!!.removeFirst()

            dfs(end, list + listOf(end))
        }

    }
}