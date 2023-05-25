import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val size = priorities.size

        val deque = ArrayDeque<Int>()
        deque.addAll(priorities.toList())

        val currentList = MutableList<Int>(size) { 0 }
        currentList[location] = 1

        val currentDeque = ArrayDeque<Int>()
        currentDeque.addAll(currentList)

        var count = 1

        while(true) {

            val maxIndex = deque.indexOf(deque.maxOf { it })

            for(i in 0 until maxIndex) {
                val first = deque.removeFirst()
                deque.addLast(first)

                val cur = currentDeque.removeFirst()
                currentDeque.addLast(cur)
            }
            //        println(deque)
            //        println("${priorities[0]} ${targetNum}")

            if (currentDeque.first == 1) {
                // println(count)
                break
            } else {
                deque.removeFirst()
                currentDeque.removeFirst()

                count ++
            }
        }



        return count
    }
}