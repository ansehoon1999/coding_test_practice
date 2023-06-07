class Solution {

    lateinit var numList: List<Char>

    var ax = 0

    lateinit var result: MutableList<Char>
    lateinit var visited: MutableList<Boolean>

    lateinit var candidates: MutableSet<Int>

    fun solution(numbers: String): Int {
        var count = 0

        numList = numbers.toList()
        ax = numList.size

        result = mutableListOf()
        visited = MutableList(ax) { false }
        candidates = mutableSetOf()

        for(i in 1 until ax+1){
            permutation(0, i)
        }

        candidates.forEach {
            if(isPrime(it)) {
                count++
            }
        }

        return count
    }

    fun isPrime(n: Int): Boolean {
        if (n == 0 || n == 1) return false
        var i = 2

        while(i*i <= n) {
            if(n % i++ == 0) return false
        }
        return true
    }

    fun permutation(count: Int, max: Int) {
        if(count == max) {
            val candidate = result.joinToString("").toInt()
            candidates.add(candidate)
            // println(candidates)
            return
        }

        for(i in 0 until ax) {
            if(!visited[i]) {
                result.add(numList[i])
                //            result[count] = numList[i]
                visited[i] = true
                permutation(count + 1, max)
                result.remove(numList[i])
                visited[i] = false
            }
        }
    }
}