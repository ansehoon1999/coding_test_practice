class Solution {
    val list = mutableSetOf<Pair<Long, Long>>()

    var minR = Long.MAX_VALUE
    var maxR = Long.MIN_VALUE

    var minC = Long.MAX_VALUE
    var maxC = Long.MIN_VALUE

    fun solution(line: Array<IntArray>): Array<String> {


        for(i in 0 until line.size) {
            for(j in i+1 until line.size) {
                calculate(line[i], line[j])

            }
        }


        var answer = MutableList<MutableList<String>>((maxC - minC + 1).toInt()) {
            MutableList<String>((maxR - minR + 1).toInt()) { "." }
        }

        list.forEach {
            val row = maxC - it.second
            val col = it.first - minR

            answer[row.toInt()][col.toInt()] = "*"
        }

        val result = mutableListOf<String>()

        answer.forEach {
            result.add(it.joinToString(""))
        }

        return result.toTypedArray()
    }

    fun calculate(array1: IntArray, array2: IntArray) {
        val a = array1[0].toDouble()
        val b = array1[1].toDouble()
        val e = array1[2].toDouble()

        val c = array2[0].toDouble()
        val d = array2[1].toDouble()
        val f = array2[2].toDouble()

        val under = a * d - b * c
        if(under == 0.0) {
            if(e == f) {
                minR = minOf(minR, 0L)
                maxR = maxOf(maxR, 0L)

                minC = minOf(minC, 0L)
                maxC = maxOf(maxC, 0L)

                list.add(Pair(0L, 0L))
            }
        } else {
            val x: Double = ((b * f) - (e * d)) / ((a * d) - (b * c))
            val y: Double = ((e * c) - (a * f)) / ((a * d) - (b * c))

            if(x.toLong().toDouble() == x && y.toLong().toDouble() == y) {
                minR = minOf(minR, x.toLong())
                maxR = maxOf(maxR, x.toLong())

                minC = minOf(minC, y.toLong())
                maxC = maxOf(maxC, y.toLong())


                list.add(Pair(x.toLong(), y.toLong()))
            }
        }

    }
}