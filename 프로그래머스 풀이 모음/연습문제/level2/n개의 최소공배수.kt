

class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 0

        var target = arr[0]

        for(i in 1 until arr.size) {

            target = target * arr[i] / gcd(target, arr[i])

            println(target)
        }

        return target
    }

    fun gcd(a: Int, b: Int): Int {
        var big = 0
        var small = 0

        if(a >= b) {
            big = a
            small = b
        } else {
            big = b
            small = a
        }

        val r = big % small
        if(r == 0) return small
        else return gcd(small, r)

    }
}