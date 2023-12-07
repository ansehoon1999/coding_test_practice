class Solution {

    lateinit var matrix: MutableList<MutableList<Int>>

    fun solution(n: Int): IntArray {

        matrix = MutableList<MutableList<Int>>(n) {
            MutableList<Int>(n) { 0 }
        }

        var num = 0
        repeat(n+1) {
            num += it
        }

        var top = 0
        var bottom = n - 1
        var left = 0
        var right = n - 1

        var total = 1
        var point = Pair(0, 0)
        var curMove = Move.TO_BOTTOM

        while(total != num+1) {

            when(curMove) {
                Move.TO_BOTTOM -> {

                    val row = point.first
                    val col = point.second
                    matrix[row][col] = total

                    if(point.first == bottom) {
                        curMove = Move.TO_RIGHT
                        point = Pair(row, col+1)
                        top ++
                        left ++
                    } else {
                        point = Pair(row + 1, col)
                    }
                }
                Move.TO_RIGHT -> {
                    val row = point.first
                    val col = point.second
                    matrix[row][col] = total


                    if(point.second == right) {
                        curMove = Move.TO_TOP
                        point = Pair(row -1, col -1)
                        right -= 1
                        bottom -= 1
                    } else {
                        point = Pair(row, col + 1)
                    }
                }
                Move.TO_TOP -> {


                    val row = point.first
                    val col = point.second
                    matrix[row][col] = total


                    if(point.first == top && point.second == left) {
                        curMove = Move.TO_BOTTOM
                        point = Pair(point.first + 1, point.second)
                        top += 1
                        right -= 1
                    } else {
                        point = Pair(row-1, col-1)
                    }
                }
            }

            total ++
        }

        var answer = mutableListOf<Int>()

        for(row in 0 until n) {
            for(col in 0 .. row) {
                answer.add(matrix[row][col])
            }
        }

        return answer.toIntArray()
    }
}

enum class Move {
    TO_BOTTOM, TO_RIGHT, TO_TOP
}
