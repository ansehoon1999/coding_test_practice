import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()){
    val  n = readLine().toInt()
    val arr = mutableListOf<Int>()
    val input = StringTokenizer(readLine())
    repeat(n){
        arr.add(input.nextToken().toInt())
    }

    val count = MutableList<Int>(n) { 1 }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (arr[j] < arr[i]) {
                count[i] = maxOf(count[i], count[j] + 1)
            }
        }

//        println(count)
    }


    println(count.maxOrNull())



}
