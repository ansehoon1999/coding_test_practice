import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val str1 = StringTokenizer(readLine())
    val N = str1.nextToken().toInt()
    val M = str1.nextToken().toInt()

    val list :MutableList<Int> = mutableListOf()
    val str2 = StringTokenizer(readLine())
    repeat(N) {
        list.add(str2.nextToken().toInt())
    }
    var sum = -1
    val sb = StringBuilder()
    for (i in 0 until N-2) {
        for ( j in i+1 until N-1) {
            for (k in j+1 until N) {
                val add = list[i] + list[j] + list[k]
                if (add > M) {
                    continue
                }

                sum = Math.max(sum, add)
            }
        }
    }

    println(sum)


}