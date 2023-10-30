class Solution {
    fun solution(food: IntArray): String {
        var answer: String = ""

        var front = ""
        var end = ""

        for(idx in 1 until food.size) {

            val curCount = food[idx] / 2

            for(j in 0 until curCount) {
                front = front + "${idx}"
                end = "${idx}" + end
            }


        }

        return front + "0" + end
    }
}