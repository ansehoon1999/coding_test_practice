import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()

        val pq = PriorityQueue<Int>()

        operations.forEach { operation ->
            val op = operation.split(" ")[0].toString()
            val num = operation.split(" ")[1].toInt()


            when(op) {
                "I" -> {
                    pq.offer(num)
                }
                "D" -> {
                    if(pq.isNotEmpty()) {

                        if(num == -1) {
                            pq.poll()
                        } else if(num == 1) {
                            val last = pq.last()
                            pq.remove(last)
                        }
                    }
                }
            }


        }

        val pqList = pq.toList().sorted()

        return if(pq.isEmpty()) intArrayOf(0, 0) else intArrayOf(pqList.last(), pqList.first())
    }
}