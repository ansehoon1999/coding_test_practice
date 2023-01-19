class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0
        var toGo = checkToGo(deliveries.size - 1, deliveries, pickups)
        while (toGo >=0) {
            var cap1 = cap
            var cap2 = cap
            for (i in toGo downTo(0)) {
                if (deliveries[i] <= cap1) {
                    cap1 -= deliveries[i]
                    deliveries[i] = 0
                } else {
                    deliveries[i] -= cap1
                    cap1 = 0
                    break
                }
            }
            for (i in toGo downTo(0)) {
                if (pickups[i] <= cap2) {
                    cap2 -= pickups[i]
                    pickups[i] = 0
                } else {
                    pickups[i] -= cap2
                    cap2 = 0
                    break
                }
            }
            answer += (toGo + 1) * 2
            toGo = checkToGo(toGo, deliveries, pickups)
        }

        return answer
    }

    fun checkToGo(lastIndex: Int, d: IntArray, p: IntArray) : Int {
        for (i in lastIndex downTo(0)) {
            if (d[i] != 0 || p[i] != 0) {
                return i
            }
        }
        return -1
    }

}