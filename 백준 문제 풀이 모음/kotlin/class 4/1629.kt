

fun main() = with(System.`in`.bufferedReader()){
    val (a, b, c) = readLine().split(' ').toList().map { it.toLong() }

    val x = pow(a, b, c)
    print(x)
}

fun pow(base: Long, expo: Long, c :Long) : Long {
    if (expo == 1L) return base % c

    else {
        val x = pow(base, expo / 2, c)
        if (expo % 2 == 0L) {
            return (x * x) % c
        } else {
            return (((x * x) % c) * base)% c
        }
    }

}
