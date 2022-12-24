import java.math.BigInteger


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(' ').toList().map { it.toInt() }

    var up = BigInteger("1")
    var down = BigInteger("1")

    for (i in 1.. m) {
        up = up.multiply(BigInteger((n-i+1).toString()))
        down = down.multiply(BigInteger(i.toString()))
    }
    print(up.divide(down))



}

