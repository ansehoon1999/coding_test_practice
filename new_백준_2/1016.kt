import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * numList
     */

    val (min, max) = br.readLine().split(" ").map { it.toLong() }
    val diff = max - min
    val numList = MutableList<Boolean>(1000001) { false }
    val sqrtMax = kotlin.math.sqrt(max.toFloat()).toInt()
    for(i in 2 .. sqrtMax) {

        val square = i * i.toLong()
        var temp = (min / square) * square
        if(temp < min) temp += square

        while(temp <= max) {

            numList[(temp - min).toInt()] = true
            temp += square
        }
    }

    var total = 0L
    for(num in min .. max) {
        if(!numList[(num - min).toInt()]) {
            total ++
        }
    }

    writer.write("${total}")


    writer.flush()
    writer.close()
}