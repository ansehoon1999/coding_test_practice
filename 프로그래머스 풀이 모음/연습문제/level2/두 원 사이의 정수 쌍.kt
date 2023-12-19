class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        var r2Point = 0L

        for(x in r2 * (-1) .. r2) {
            r2Point += (findR2Point(x, r2) * 2L)
            r2Point += 1L
        }

        var r1Point = 0L

        for(x in (r1 * (-1) + 1) .. (r1 - 1)) {
            r1Point += (findR1Point(x, r1) * 2L)
            r1Point += 1L
        }



        return r2Point - r1Point
    }

    fun findR2Point(r2_x: Int, r2: Int): Long {

        val r2_y = Math.sqrt(Math.pow(r2.toDouble(), 2.0) - Math.pow(r2_x.toDouble(), 2.0))

        return r2_y.toLong()
    }

    fun findR1Point(r1_x: Int, r1: Int): Long {

        val r1_y = Math.sqrt(Math.pow(r1.toDouble(), 2.0) - Math.pow(r1_x.toDouble(), 2.0))


        if(r1_y.toInt().toDouble() != r1_y) {
            return r1_y.toLong()
        } else {
            return r1_y.toLong() - 1L
        }


    }
}