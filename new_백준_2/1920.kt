import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toInt() }.sorted()


    fun binarySearch(target: Int): Int {
        var low = 0
        var high = nList.lastIndex

        while(low < high) {
            val mid = (low + high) / 2

            if(nList[mid] < target) {
                low = mid + 1
            } else {
                high = mid
            }
        }

        if(nList[high] == target) return 1
        else return 0
    }

    val m = br.readLine().toInt()
    val mList = br.readLine().split(" ").map { it.toInt() }
    mList.forEach {
        println(binarySearch(it))
    }
}










