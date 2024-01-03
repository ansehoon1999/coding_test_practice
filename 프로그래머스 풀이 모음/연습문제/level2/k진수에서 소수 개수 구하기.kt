class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0

        var cur = n

        var str = ""

        if(n < k) { return 0 }

        while(cur / k != 0) {

            str = (cur % k).toString() + str
            cur = cur / k
            println(str)
        }

        str = cur.toString() + str
        println(str)

        str = "0" + str
        str = str + "0"
        val strList = str.split("0")
        println(strList)
        strList.forEach {

            val tmp = it.toLongOrNull()

            if(tmp != null) {
                if(isPrime(tmp))answer++
            }
        }


        return answer
    }


    fun isPrime(n: Long): Boolean {

        if(n==1L) return false
        if(n==2L) return true

        var i = 2L
        while(i * i<= n) {
            if(n % i++ == 0L) return false

        }


        return true
    }


}