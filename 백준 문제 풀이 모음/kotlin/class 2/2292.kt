fun main () = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()

    var bef = 1
    var cur = 1

    var count = 1
    while (true) {
        if (bef <= N && N <= cur) {
            println(count)
            break
        }

        bef = cur
        cur = bef + (6 * count)
        count ++
    }
}