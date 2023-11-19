import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        val bridgeQueue = LinkedList<Int>()
        val waitQueue = LinkedList<Int>()

        repeat(bridge_length) {
            bridgeQueue.add(0)
        }

        truck_weights.forEach {
            waitQueue.add(it)
        }

        while(bridgeQueue.isNotEmpty()) {

            answer ++
            bridgeQueue.poll()

            if(waitQueue.isNotEmpty()) {
                if(bridgeQueue.sum() <= weight - waitQueue.peek()) {
                    bridgeQueue.add(waitQueue.poll())
                } else {
                    bridgeQueue.add(0)
                }
            }

        }


        return answer
    }
}