import java.io.BufferedReader
import java.io.InputStreamReader


data class Node(
    val num: Int,
    val weight: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    fun isPrime(num: Int): Boolean {
        if(num == 0) return false
        if(num == 1) return false
        if(num == 2) return true

        for(i in 2 .. Math.sqrt(num.toDouble()).toInt()) {
            if(num % i == 0) {
                return false
            }
        }

        return true

    }

    var result = mutableListOf<Int>()

    fun dfs(num: Int) {

        if(num.toString().length == n) {

            if(isPrime(num)) {
                result.add(num)
            }

            return
        }

        if(!isPrime(num.toInt())) {
            return
        }

        for(i in 0 .. 9) {
            dfs(num * 10 + i)
        }
    }


    dfs(2)
    dfs(3)
    dfs(5)
    dfs(7)

    result.sort()

    result.forEach {
        println(it)
    }

}










