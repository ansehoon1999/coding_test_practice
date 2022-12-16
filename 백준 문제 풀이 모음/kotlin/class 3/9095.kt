

fun main () = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    repeat(T) {
        val n = readLine().toInt()
        val list = MutableList<Int>(n+10) {0}
        list[1] = 1
        list[2] = 2
        list[3] = 4

        for (i in 4 .. n) {
            list[i] = list[i-1] + list[i-2] + list[i-3]
        }

        println(list[n])
    }

}