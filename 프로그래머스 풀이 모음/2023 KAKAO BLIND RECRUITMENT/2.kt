class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0


        var position = checkPosition(deliveries.size-1, deliveries, pickups)

        while(position >= 0) {

            var deliveryCapability = cap
            var pickupCapability = cap

            for(cur in position downTo 0) {
                if(deliveryCapability <= deliveries[cur]) {
                    deliveries[cur] -= deliveryCapability
                    deliveryCapability = 0
                    break
                } else  {
                    deliveryCapability -= deliveries[cur]
                    deliveries[cur] = 0
                }
            }

            for(cur in position downTo 0) {
                if(pickupCapability <= pickups[cur]) {
                    pickups[cur] -= pickupCapability
                    pickupCapability = 0
                    break
                } else  {
                    pickupCapability -= pickups[cur]
                    pickups[cur] = 0
                }
            }

            answer += ((position + 1)* 2)
            position = checkPosition(position, deliveries, pickups)

        }

        return answer
    }

    fun checkPosition(size: Int, deliveryList: IntArray, pickupList: IntArray): Int {

        for(cur in size downTo 0) {
            if(deliveryList[cur] != 0 || pickupList[cur] != 0) {
                return cur
            }
        }
        return -1
    }
}
