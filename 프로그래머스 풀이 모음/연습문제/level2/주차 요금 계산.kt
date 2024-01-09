class Solution {

    val hashMap = hashMapOf<String, List<Pair<Int, String>>>() // <totalTime, inout>

    fun solution(fees: IntArray, records: Array<String>): IntArray {


        // 각 데이터 네이밍 초기화

        var baseTime = fees[0].toInt()
        var basePay = fees[1].toInt()

        var unitTime = fees[2].toInt()
        var unitPay = fees[3].toInt()

        records.forEach { record ->
            val rec = record.split(" ")
            val hour = rec[0].split(":")[0].toInt() * 60
            val minute = rec[0].split(":")[1].toInt()

            val carNum = rec[1].toString()

            val inout = rec[2].toString()

            if(hashMap[carNum] == null) {
                hashMap[carNum] = listOf(Pair(hour+minute, inout))
            } else {
                hashMap[carNum] = hashMap[carNum]!! + listOf(Pair(hour+minute, inout))
            }
        }

        var answer: IntArray = IntArray(hashMap.size)

        // println(hashMap)
        // println(answer.toList())

        // hashMap 순회하면서 주차 요금 계산

        val list = mutableListOf<Pair<String, Int>>()

        for((key, value) in hashMap) {

            val record = value
            val recordSize = value.size

            var timeInterval = 0

            if(recordSize % 2 == 0) {

                for(idx in 0 until recordSize step(2)) {
                    timeInterval += record[idx+1].first - record[idx].first
                }


            } else {

                for(idx in 0 until recordSize - 1 step(2)) {
                    timeInterval += record[idx+1].first - record[idx].first
                }

                timeInterval += (1439 - record[recordSize-1].first)

            }

            // 주차 요금 = 기본 요금 + 올림((누적 주차 시간 - 기본 시간) / 단위 시간) * 단위 요금

            // println(baseTime)
            val parkPay = if(timeInterval <= baseTime) {
                basePay
            } else {
                basePay + Math.ceil((timeInterval - baseTime).toDouble() / unitTime.toDouble()) * unitPay
            }.toInt()

            list.add(Pair(key, parkPay))
            // println("key: ${key}, interval: ${timeInterval} parkPay: ${parkPay}")
        }

        // 차량 번호 순으로 sort
        list.sortBy { it.first }
        // println(list)

        list.forEachIndexed { idx, pay ->
            answer[idx] = pay.second
        }

        // 차량 번호로 조회 -> 해당 value answer에 추가


        return answer
    }
}