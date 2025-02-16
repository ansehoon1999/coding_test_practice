import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val n = br.readLine().toInt()

    val nList = MutableList<Long>(46) { 0 }
    nList[1] = 1
    nList[2] = 1

    for(i in 3 until 46) {
        nList[i] = nList[i-1] + nList[i-2]
    }

    println(nList[n])
}














