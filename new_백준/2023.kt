import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

var cnt = 0

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()

    dfs(2, 1, n)
    dfs(3, 1, n)
    dfs(5, 1, n)
    dfs(7, 1, n)

    //    bw.write("$sum")
    bw.flush()
    bw.close()
}

fun dfs(num: Int, cnt: Int, n: Int) {

    if (cnt == n) {
        println(num)
        return
    }

    for (i in 1 until 10) {
        if (i % 2 == 0) continue

        if (isPrime(num * 10 + i)) {
            dfs(num * 10 + i, cnt + 1, n)
        }
    }
}


fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}

