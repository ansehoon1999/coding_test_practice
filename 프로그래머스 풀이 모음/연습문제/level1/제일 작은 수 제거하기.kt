class Solution {
    fun solution(arr: IntArray): IntArray {

        var minIdx = 0
        var minValue = 100000000

        arr.forEachIndexed { idx, num ->
            if(minValue > num) {
                minValue = num
                minIdx = idx
            }

        }

        val arrList = arr.toMutableList()
        arrList.removeAt(minIdx)

        if(arrList.isEmpty()) return intArrayOf(-1)
        else return arrList.toIntArray()

    
}