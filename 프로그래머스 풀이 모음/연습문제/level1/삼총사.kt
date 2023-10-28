class Solution {

    var numberSize = 0
    var answer = 0

    fun solution(number: IntArray): Int {

        numberSize = number.size

        combination(mutableListOf<Int>(), 0, numberSize, number)

        return answer
    }

    fun combination(list: MutableList<Int>, index: Int, count: Int, number: IntArray) {
        if(list.size == 3) {
            // println(list)

            if(list.sum() == 0) {
                answer ++
                // println(list)
            }

            return
        }

        for(i in index until numberSize) {
            list.add(number[i])
            combination(list, i+1, count - 1, number)
            list.removeLast()
        }
    }

}