import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    var result = 0

    var sum = 1
    var start = 1
    var end = 1

    while(start != n && end != n) {

//        println("sum: ${sum} start: ${start} end: ${end}")

        if(sum == n) {
            result ++
            end ++
            sum += end
        } else if(sum < n) {

            end ++
            sum += end
        } else {
            sum -= start
            start ++

        }
    }

    println(result+1)
}










