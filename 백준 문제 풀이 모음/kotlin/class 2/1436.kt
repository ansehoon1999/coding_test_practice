

fun main () = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var start = 665
    var count = 0

    while (true) {
        if ( n == count) {
            print(start-1)
            break
        }

        val tmp = start.toString()
        if (tmp.contains("666")) {
            count ++
        }
        start ++
    }
}