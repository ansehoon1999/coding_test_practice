class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer: Int = 0

        var tmpA = arrayA[0]
        for(i in 0 until arrayA.size) {
            var num = gcd(tmpA, arrayA[i])
            tmpA = num
        }

        var tmpB = arrayB[0]
        for(i in 0 until arrayB.size) {
            var numB = gcd(tmpB, arrayB[i])
            tmpB = numB
        }

        if(divisable(arrayB, tmpA)) {
            answer = Math.max(answer, tmpA)
        }

        if(divisable(arrayA, tmpB)) {
            answer = Math.max(answer, tmpB)
        }

        return answer
    }

    fun gcd(a: Int, b: Int): Int {
        var r = b % a
        if(r == 0) return a
        else return gcd(r, a)
    }

    fun divisable(array: IntArray, target: Int): Boolean {
        array.forEach {
            if(it % target == 0) return false
        }

        return true
    }
}