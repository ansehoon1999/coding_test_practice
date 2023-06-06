class Solution {
    fun solution(answers: IntArray): IntArray {
        val math1 = mutableListOf(1, 2, 3, 4, 5)
        val math2 = mutableListOf(2, 1, 2, 3, 2, 4, 2, 5)
        val math3 = mutableListOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        var count1 = 0
        var count2 = 0
        var count3 = 0

        for(i in 0 until answers.size) {
            if(answers[i] == math1[i%5]) count1 ++
            if(answers[i] == math2[i%8]) count2 ++
            if(answers[i] == math3[i%10]) count3 ++
        }

        val max = maxOf(count1, count2, count3)

        var answer = mutableListOf<Int>()
        if(count1 == max) answer.add(1)
        if(count2 == max) answer.add(2)
        if(count3 == max) answer.add(3)

        return answer.toIntArray()
    }
}