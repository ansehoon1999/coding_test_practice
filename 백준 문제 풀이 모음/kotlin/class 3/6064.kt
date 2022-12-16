

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()

    repeat(T) {
        val str = readLine().split(' ').toList()
        val m = str[0].toInt()
        val n = str[1].toInt()
        val x = str[2].toInt()
        val y = str[3].toInt()

        println(num(m, n, x, y))



    }



}

fun num(m: Int, n: Int, x: Int, y: Int): Int {
    var xx = x
    while (xx <= m * n) {
        if ((xx-y) % n == 0) {
            return xx
        }
        xx += m
    }
    return  -1
}
