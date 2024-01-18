class Solution {


    val ticketMap = hashMapOf<String, MutableList<String>>()
    val booleanMap = hashMapOf<String, MutableList<Boolean>>()

    var ticketSize = 0

    var flag = false

    var answer = arrayOf<String>()

    fun solution(tickets: Array<Array<String>>): Array<String> {


        ticketSize = tickets.size

        tickets.forEach { ticket ->
            val start = ticket[0]
            val end = ticket[1]

            if(ticketMap[start] == null) {
                ticketMap[start] = mutableListOf<String>(end)
                booleanMap[start] = mutableListOf<Boolean>(false)
            } else {
                ticketMap[start]?.add(end)
                booleanMap[start]?.add(false)
            }
        }

        for((key, value) in ticketMap) {
            value?.sort()
        }


        dfs("ICN", ticketMap, booleanMap, listOf("ICN"))
        return answer
    }

    fun dfs(start: String, ticketMap: HashMap<String, MutableList<String>>, booleanMap: HashMap<String, MutableList<Boolean>>, list: List<String>) {

        if(flag) return

        if(list.size == ticketSize + 1) {

            flag = true
            answer = list.toTypedArray()
            return
        }

        val curTicketList = ticketMap[start] ?: return
        val curBooleanList = booleanMap[start] ?: return
        val size = curTicketList.size

        for(idx in 0 until size) {

            if(!curBooleanList[idx]) {
                curBooleanList[idx] = true
                dfs(curTicketList[idx], ticketMap, booleanMap, list + listOf(curTicketList[idx]))
                curBooleanList[idx] = false
            }
        }


    }

}