package class3

import java.lang.Exception

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()

    val map1 = hashMapOf<Int, String>()
    val map2 = hashMapOf<String, Int>()

    for (i in 1 .. n) {
        val input = readLine().toString()
        map1[i] = input
        map2[input] = i
    }


    val sb = StringBuilder()
    repeat(m) {
        val input = readLine().toString()

        try {
            val index = input.toInt()
            sb.append(map1[index])
            sb.append('\n')
        } catch (e : Exception) {
            sb.append(map2[input])
            sb.append('\n')
        }
    }

    println(sb.toString())


}