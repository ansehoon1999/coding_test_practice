
fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()

    for ( i in (N /5) downTo 0) {
        val bag = (N - i * 5)

        if (bag % 3 != 0) {
            continue
        }
        print(i + bag / 3)
        return
    }
    println(-1)
}