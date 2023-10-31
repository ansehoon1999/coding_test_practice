class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()

        val returnList = mutableListOf<Int>()

        arr.forEach { element ->
            if((element % divisor) == 0) {
                returnList.add(element)
            }
        }

        returnList.sort()

        if(returnList.isEmpty()) return intArrayOf(-1)
        else return returnList.toIntArray()
    }
}