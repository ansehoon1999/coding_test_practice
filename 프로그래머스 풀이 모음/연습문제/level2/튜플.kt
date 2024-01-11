class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()

        val newStr = s.substring(1, s.length-1).split("},{").toList()
        // println(newStr)
        val tmpList = mutableListOf<String>()

        if(newStr.size == 1) {
            tmpList.add(newStr[0].substring(1, newStr[0].length-1))
        } else {
            for(idx in 0 until newStr.size) {
                if(idx == 0) {
                    tmpList.add(newStr[idx].substring(1, newStr[idx].length))
                } else if (idx == newStr.size - 1) {
                    tmpList.add(newStr[idx].substring(0, newStr[idx].length - 1))
                } else {
                    tmpList.add(newStr[idx])
                }
            }
        }
        val resultList = mutableListOf<List<String>>()
        tmpList.forEach {
            resultList.add(it.split(",").toList())
        }

        resultList.sortBy { it.size }
        // println(resultList)
        // println(resultList[0])

        answer += resultList[0][0].toInt()
        for(idx in 1 until resultList.size) {
            if(idx == 0) {
                answer += resultList[idx][0].toInt()
            } else {
                answer += (resultList[idx] - resultList[idx-1])[0].toInt()
            }
        }

        return answer
    }
}