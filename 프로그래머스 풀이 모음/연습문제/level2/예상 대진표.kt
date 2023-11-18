class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0

        var a = a
        var b = b

        var aPair = if(a % 2 == 0) a - 1 else a + 1
        var bPair = if(b % 2 == 0) b - 1 else b + 1

        // println(aPair)
        // println(bPair)

        var n = n

        var cnt = 1
        while(true) {

            if(aPair == bPair) {
                break
            }


            if(a % 2 == 0) {
                a = a / 2
            } else {
                a = (a + 1) / 2
            }


            if(b % 2 == 0) {
                b = b / 2
            } else {
                b = (b + 1) / 2
            }

            aPair = if(a % 2 == 0) a - 1 else a + 1
            bPair = if(b % 2 == 0) b - 1 else b + 1

            cnt ++
        }


        return cnt - 1
    }
}