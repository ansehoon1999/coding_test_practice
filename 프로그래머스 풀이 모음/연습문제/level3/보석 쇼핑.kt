class Solution {
    fun solution(gems: Array<String>): IntArray {
        var answer = intArrayOf(1, 200000)

        val hashMap = hashMapOf<String, Int>()

        gems.forEach { gem ->
            if(hashMap[gem] == null) {
                hashMap[gem] = 0
            }
        }

        var start = 0
        var end = 0
        var total = 0

        while(start <= end && end <= gems.size) {
            // println("start: ${start}, end: ${end}")

            if(total == hashMap.size) {
                // println("start: ${start+1}, end: ${end}")

                if(answer[1] - answer[0] > end - (start+1)) {
                    answer[0] = (start + 1)
                    answer[1] = end
                }

                val startCnt = hashMap[gems[start]]!!
                if(startCnt == 1) { total -- }
                hashMap[gems[start]] = startCnt - 1
                start ++
            } else {

                if(end == gems.size) break

                val endCnt = hashMap[gems[end]]!!
                if(endCnt == 0) { total ++ }
                hashMap[gems[end]] = endCnt + 1
                end ++
            }
        }


        // println(hashMap)


        return answer
    }

    fun isAllIncluded(hashMap: HashMap<String, Int>, total: Int): Boolean {
        if(total < hashMap.size) return false

        var flag = true
        for((key, value) in hashMap) {
            if(value == 0) {
                flag = false
            }
        }

        return flag
    }
}