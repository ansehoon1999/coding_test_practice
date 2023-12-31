class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer: LongArray = LongArray(numbers.size)

        numbers.forEachIndexed { idx, n ->
            var nList = n.toString(2).toMutableList()
            // println(nList)
            var flag = true

            for(idx in nList.size - 1 downTo 0) {
                if(nList[idx] == '0') {
                    if(idx != nList.size - 1) {
                        nList[idx + 1] = '0'
                    }

                    nList[idx] = '1'
                    flag = false
                    break
                }
            }

            if(flag) {
                nList[0] = '0'
                nList = (listOf('1') + nList.toList()).toMutableList()
            }

            answer[idx] = nList.joinToString("").toLong(2)
            // println(nList.joinToString("").toLong(2))
        }


        return answer
    }
}