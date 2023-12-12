class Solution {

    lateinit var arrayCost: MutableList<Double>
    lateinit var arraySize: MutableList<Double>

    lateinit var answer: MutableList<Double>

    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {

        val result: DoubleArray = DoubleArray(ranges.size)

        answer = mutableListOf<Double>()

        arrayCost = mutableListOf<Double>()
        arrayCost.add(k.toDouble())

        arraySize = mutableListOf<Double>()
        arraySize.add(0.0)

        var cur = k.toDouble()
        while(true) {
            if(cur == 1.0) {
                break
            }

            if(cur % 2.0 == 0.0) {
                cur = cur / 2.0
            } else {
                cur = cur * 3.0 + 1.0
            }

            arrayCost.add(cur)
        }

        for(idx in 1 until arrayCost.size) {
            val size = (arrayCost[idx - 1] + arrayCost[idx]) / 2.0
            arraySize.add(size + arraySize[idx-1])
        }

        println(arrayCost)
        println(arraySize)

        ranges.forEachIndexed { idx, cost ->
            val start = cost[0]
            val end = reRangeEnd(cost[1])

            if(start > end) result[idx] = -1.0
            else {
                result[idx] = (arraySize[end] - arraySize[start])
            }
        }


        return result
    }

    fun reRangeEnd(end: Int): Int {
        return arrayCost.size - 1 + end
    }
}