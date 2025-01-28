import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val N = br.readLine().toInt()

    val tileList = MutableList<Long>(1010) { 0L }
    tileList[1] = 1
    tileList[2] = 2

    for(idx in 3 .. N) {
        tileList[idx] = (tileList[idx - 1]  + tileList[idx - 2]) % 10007
    }



    print(tileList[N])
    writer.flush()
    writer.close()

}
