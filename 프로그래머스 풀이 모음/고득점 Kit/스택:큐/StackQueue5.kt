import java.util.*


class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        val bridgeQueue: Queue<Int> = LinkedList<Int>()
        val waitQueue: Queue<Int> = LinkedList<Int>()

        for(i in 0 until bridge_length) bridgeQueue.add(0)
        for(i in truck_weights) waitQueue.add(i)

        while(bridgeQueue.isNotEmpty()) {
            answer ++
            bridgeQueue.poll()
            if(waitQueue.isNotEmpty()) {
                if (bridgeQueue.sum() <= weight - waitQueue.peek()) {
                    bridgeQueue.add(waitQueue.poll())
                } else {
                    bridgeQueue.add(0)
                }
            }
        }

        return answer
    }
}
