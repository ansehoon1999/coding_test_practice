import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableSetOf<String>()

    repeat(n) {
        list.add(readLine())
    }

    val new = list.sortedWith(Comparator<String> { a, b ->
       when {
           a.length < b.length -> -1
           a.length > b.length -> 1
            else -> {
               when {
               a < b -> -1
               else -> 1
               }
           }
       }
    })

    new.forEach {
        println(it)
    }

}