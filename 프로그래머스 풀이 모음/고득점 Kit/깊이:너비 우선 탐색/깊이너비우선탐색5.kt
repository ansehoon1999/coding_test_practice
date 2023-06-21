import java.util.*

class Solution {
    lateinit var Tickets: Array<Array<String>>
    lateinit var visited: MutableList<Boolean>

    var TicketSize = 0
    lateinit var result: MutableList<MutableList<String>>

    fun solution(tickets: Array<Array<String>>): Array<String> {

        Tickets = tickets
        TicketSize = Tickets.size
        result = mutableListOf()

        visited = MutableList<Boolean>(TicketSize) { false }

        Tickets.sortWith { x, y ->
            if(x[0] == y[0]) {
                x[1].compareTo(y[1])
            } else {
                x[0].compareTo(y[0])
            }
        }

        dfs("ICN", listOf<String>("ICN"), 0)


        return result[0].toTypedArray()
    }

    fun dfs(start: String, routeList: List<String>, depth: Int) {
        if(TicketSize == depth) {
            result.add(routeList.toMutableList())

            return
        }

        for(i in 0 until TicketSize) {
            if(visited[i]) continue

            if(Tickets[i][0] == start) {
                val end = Tickets[i][1]
                visited[i] = true
                dfs(end, routeList + listOf(end), depth + 1)
                visited[i] = false
            }
        }

    }



}