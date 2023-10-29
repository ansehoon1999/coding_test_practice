import kotlin.math.sqrt

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        val numberList = IntArray(number + 1)

        // 각 number의 약수 개수를 구한다

        for(num in 1 .. number) {
            numberList[num] = findDivisior(num)

        }

        for(num in 1 .. number) {
            if(numberList[num] > limit) {
                numberList[num] = power
            }
        }
        // numberList를 한 바퀴 돌면서 <= limit인지 파악한다.
        // 만약 limit 보다 크다면 power로 대체


        return numberList.sum()!!
    }

    fun findDivisior(num: Int): Int {
        val result = arrayListOf<Int>()
        val sqrt = sqrt(num.toDouble()).toInt()

        for(i in 1 .. sqrt) {
            if(num % i == 0) {
                result.add(i)

                if(num / i != i) {
                    result.add(num/i)
                }
            }

        }

        return result.size
    }
}