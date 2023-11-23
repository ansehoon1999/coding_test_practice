class Solution {

    var answer = 0

    lateinit var visited: MutableList<Boolean>

    lateinit var numList: MutableList<String>

    val resultSet = mutableSetOf<Int>()

    fun solution(numbers: String): Int {

        visited = MutableList<Boolean>(numbers.length) { false }

        numList = mutableListOf<String>()

        numbers.forEach {
            numList.add(it.toString())
        }

        dfs(listOf())

        return resultSet.size
    }

    fun dfs(list: List<String>) {

        if(list.isNotEmpty()) {
            val num = list.joinToString("").toInt()
            if(isPrime(num)) {
                resultSet.add(num)
            }
        }

        for(idx in 0 until visited.size) {

            if(!visited[idx]) {
                visited[idx] = true
                dfs(list + listOf(numList[idx]))
                visited[idx] = false
            }
        }

    }

    fun isPrime(num: Int): Boolean {

        if(num == 1 || num == 0) return false

        var i = 2

        while(i * i <= num) {
            if(num % i == 0) return false

            i ++
        }

        return true

    }
}