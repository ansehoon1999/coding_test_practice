import java.util.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()

        val dayList = LinkedList<Int>()

        for(i in 0 until speeds.size) {
            val workTime = 100 - progresses[i]

            val divide = workTime / speeds[i]
            val remain = workTime % speeds[i]

            if(remain != 0) {
                dayList.add(divide + 1)
            } else {
                dayList.add(divide)
            }
        }


        while(dayList.isNotEmpty()) {
            val curDay = dayList.poll()

            var result = 1

            while(dayList.isNotEmpty()) {
                val finalDay = dayList.peek()
                if(curDay >= finalDay) {
                    dayList.poll()
                    result ++
                } else {
                    break
                }
            }

            answer.add(result)
        }


        return answer.toIntArray()
    }
}