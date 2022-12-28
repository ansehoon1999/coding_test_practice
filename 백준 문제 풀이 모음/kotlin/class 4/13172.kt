

val S : Long = 1000000007

fun main() = with(System.`in`.bufferedReader()){
    val m = readLine().toInt()

    var sum :Long = 0
    repeat(m) {
        val (n, s) = readLine().split(' ').map { it.toInt() }

        val n1 = n.toLong()
        val s1 = s.toLong()
        sum += ans(n1, s1)

        sum %= S

    }
    print(sum)

}

fun ans(n: Long, s: Long): Long {
    return s * mul(n, S-2)  % S

}

fun mul(b: Long, t: Long): Long {
    if (t == 1L) return b % S
    if ( t % 2 == 0L) {
        val tmp = mul(b, t/2L) % S
        return (tmp * tmp) % S
    } else {
        return b * mul(b,t-1) % S
    }
}
