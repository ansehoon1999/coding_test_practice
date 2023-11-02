class Solution {
    fun solution(n: Int): Int {

        for(x in 1 .. n-1) {
            if(n % x == 1) {
                return x
            }
        }

        return n-1
    }
}