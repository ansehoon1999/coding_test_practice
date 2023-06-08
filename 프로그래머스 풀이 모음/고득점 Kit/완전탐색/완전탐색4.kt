class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {

        var row = 1
        var column = 1

        val answer = mutableListOf<Int>()

        val total = brown + yellow

        for(i in 1 until yellow +1) {
            if (yellow % i == 0) {

                row = i
                column = yellow / i

                //            println("${row} ${column}")

                if ( (row + 2) * (column + 2) == total) {
                    answer.add(row + 2)
                    answer.add(column + 2)
                    break
                }
            }
        }

        answer.sortDescending()

        return answer.toIntArray()
    }
}