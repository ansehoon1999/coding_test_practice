import java.util.*

class Solution {
    fun solution(sequence: IntArray): Long {
        var answer: Long = Long.MIN_VALUE

        val seqList1 = mutableListOf<Long>()
        sequence.forEachIndexed { idx, seq ->
            if(idx % 2L == 0L) {
                seqList1.add(seq.toLong())
            } else {
                seqList1.add(seq.toLong() * (-1L))
            }
        }

        // println(seqList1)
        for(idx in 1 until seqList1.size) {
            seqList1[idx] = seqList1[idx - 1] + seqList1[idx]
        }

        // 최대값 찾기
        // println(seqList1)
        var answer1 = Long.MIN_VALUE
        var min = 100001.toLong()

        for(i in 0 until seqList1.size) {
            val curValue = seqList1[i].toLong()

            if(min > seqList1[i].toLong()) {
                min = seqList1[i].toLong()
            }

            answer1 = maxOf(answer1, curValue)
            answer1 = maxOf(answer1, curValue - min)

            // println("curValue: ${curValue} min: ${min} answer: ${curValue - min}")


        }

        val seqList2 = mutableListOf<Long>()
        sequence.forEachIndexed { idx, seq ->
            if(idx % 2L == 1L) {
                seqList2.add(seq.toLong())
            } else {
                seqList2.add(seq.toLong() * (-1L))
            }
        }

        for(idx in 1 until seqList2.size) {
            seqList2[idx] = seqList2[idx - 1] + seqList2[idx]
        }

        var answer2 = Long.MIN_VALUE
        var min2 = 100001.toLong()
        for(i in 0 until seqList2.size) {
            val curValue = seqList2[i].toLong()

            if(min2 > seqList2[i].toLong()) {
                min2 = seqList2[i].toLong()
            }

            // if(i == 0) {
            //     answer2 = maxOf(answer2, curValue)
            //     println("curValue: ${curValue} min: ${min} answer: ${curValue}")
            // } else {
            //     answer2 = maxOf(answer2, curValue - min)
            //     println("curValue: ${curValue} min: ${min} answer: ${curValue - min}")
            // }

            answer2 = maxOf(answer2, curValue)
            answer2 = maxOf(answer2, curValue - min2)
        }

        return maxOf(answer1, answer2)
    }
}