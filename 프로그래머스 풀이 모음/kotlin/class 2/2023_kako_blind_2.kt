class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        
        var answer: Long = 0


        
        var toGo = checkPosition(deliveries.size - 1, deliveries, pickups)
        
        
        while (toGo >= 0) {

            var deCap = cap
            var piCap = cap
            
            for (i in toGo downTo 0) {
                if (deliveries[i] >= deCap) {
                    deliveries[i] -= deCap
                    deCap = 0
                    break
                } else {
                    deCap -= deliveries[i]
                    deliveries[i] = 0
                }
            }

            for (i in toGo downTo 0) {
                if (pickups[i] >= piCap) {
                    pickups[i] -= piCap
                    piCap = 0
                    break
                } else {
                    piCap -= pickups[i]
                    pickups[i] = 0
                }
            }            
            
            answer += ((toGo+1) * 2) 
            // println(answer)
            toGo = checkPosition(toGo, deliveries, pickups)
        }
        
        
        return answer
    }
    
    fun checkPosition(size : Int, deliveries: IntArray, pickups: IntArray) : Int {
        
        for (i in size downTo 0) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                return i
            }    
        }
        
        return -1
    }
}