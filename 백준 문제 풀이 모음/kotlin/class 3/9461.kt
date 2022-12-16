

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    repeat(T) {
        val n = readLine().toInt()
        val list = MutableList<Long>(n+10) { 0 }
        list[1] = 1
        list[2] = 1
        list[3] = 1
        list[4] = 2
        list[5] = 2

        for (i in 6 .. n) {
            list[i] = list[i-1] + list[i-5]
        }
//        println(list)

        println(list[n])

    }


}