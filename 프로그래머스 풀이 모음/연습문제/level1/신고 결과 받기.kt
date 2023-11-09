class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = IntArray(id_list.size)

        val reportCountHashMap = hashMapOf<String, Int>()

        // report 당한 count를 담은 hashMap 초기화

        id_list.forEach {
            reportCountHashMap[it] = 0
        }

        val newReport = report.toList().toSet()

        val reportHashMap = hashMapOf<String, MutableList<String>>()

        newReport.forEach { element ->
            val spl = element.split(" ")
            val from = spl[0]
            val to = spl[1]

            if(reportHashMap[from] == null) {
                reportHashMap[from] = mutableListOf<String>(to)
            } else {
                reportHashMap[from]!!.add(to)
            }

            reportCountHashMap[to] = reportCountHashMap[to]!! + 1
        }


        val targetList = mutableListOf<String>()

        for((key, value) in reportCountHashMap) {
            if(value >= k) {
                targetList.add(key)
            }
        }

        // println(reportCountHashMap)
        // println(reportHashMap)
        // println(targetList)

        id_list.forEachIndexed { idx, id ->
            var count = 0

            reportHashMap[id]?.forEach {
                if(it in targetList) {
                    count ++
                }
            }

            answer[idx] = count

            // println("${id}: ${count}")
        }



        return answer
    }
}