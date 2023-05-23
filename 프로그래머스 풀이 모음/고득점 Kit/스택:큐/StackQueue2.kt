class Solution {
    val map = HashMap<String, MutableList<Int>>()
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val baseTime = fees[0]
        val baseMoney = fees[1]
        val unitTime = fees[2]
        val unitMoney = fees[3]
        
        for (i in 0 until records.size) {
            val (time, carNum, state) = records[i].split(' ')
            val timeSum = time.split(':')
            
            if (map[carNum] == null) map.put(carNum, mutableListOf<Int>()) 
            
            if (state == "IN") {
                map[carNum]!!.add ((-1) * ((timeSum[0].toInt() * 60) + timeSum[1].toInt()))
            } else if (state == "OUT") {
                map[carNum]!!.add ((timeSum[0].toInt() * 60) + timeSum[1].toInt())             
            }
        }
        
        println(map)
        var answer: IntArray = IntArray(map.size)
        var idx = 0
        map.toSortedMap().forEach { (carNum, addedTime) ->
            
            var sum = 0
            for (i in 0 until addedTime.size) {
                sum += addedTime[i]
            }
            
            if (sum <= 0) sum += 1439
            
            if (sum <= baseTime) answer[idx] = baseMoney
            else {
                // println("${baseMoney} ${((sum-baseTime)/unitTime).toDouble()} ${unitMoney}")
                 answer[idx] = (baseMoney + Math.ceil(((sum-baseTime).toDouble()/unitTime).toDouble()) * unitMoney).toInt()
            }
             
            // println(answer.toList())            
            idx ++
        }
        
        
        
        return answer
    }
}