import java.io.BufferedReader
import java.io.InputStreamReader

var result = 0

val hashMap = hashMapOf<Int, Int>()

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val str = br.readLine().split(" ")

    val first = str[0].toInt()
    val mul = str[1].toInt()

    dfs(first, mul)

    var cnt = 0
    for((key, value) in hashMap) {
        if(value == 1) cnt ++
    }

    println(cnt)
}

fun dfs(first: Int, mul: Int) {
//    println(hashMap)

    if(hashMap[first] != null) {
        if(hashMap[first]!! >= 2) {

            return
        }
    }

    val numStr = first.toString().toList().map { it.toString().toInt() }
    var sum = 0

    numStr.forEach {
        sum += Math.pow(it.toDouble(), mul.toDouble()).toInt()
    }

    if(hashMap[first] == null) {
        hashMap[first] = 1
    } else {
        hashMap[first] = hashMap[first]!! + 1
    }

    dfs(sum, mul)
}