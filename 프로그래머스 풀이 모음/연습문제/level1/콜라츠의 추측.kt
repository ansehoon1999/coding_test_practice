class Solution {
    fun solution(num: Int): Int {
        var answer = 0

        var count = 0
        var curNum = num.toLong()

        while(count <= 500) {

            if(curNum == 1L) return count

            if(curNum % 2L == 0L) {
                curNum = curNum / 2L
            } else {
                curNum = curNum * 3L + 1L
            }


            count ++

        }


        return -1
    }
}