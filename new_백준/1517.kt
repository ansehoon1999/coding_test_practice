import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

var cnt = 0L
fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()

    val list = br.readLine().split(" ").map { it.toInt() }

    var cnt1 = 0

    mergeSort(list.toIntArray())
//    for(i in 0 until n-1) {
//        for(j in 0 until n - i - 1) {
//            if(list[j] > list[j+1]) {
//                val temp = list[j]
//                list[j] = list[j+1]
//                list[j+1] = temp
//                cnt1 ++
//            }
//        }
//        println(list)
//    }

    println(cnt)


//    bw.write("$sum")
    bw.flush()
    bw.close()
}

fun mergeSort(
    array: IntArray,
    helper: IntArray = IntArray(array.size),
    low: Int = 0,
    high: Int = array.size - 1
) {
    if (low < high) {
        val middle = (low + high) / 2
        mergeSort(array, helper, low, middle)
        mergeSort(array, helper, middle + 1, high)
        merge(array, helper, low, middle, high)
    }
}

fun merge(array: IntArray, helper: IntArray, low: Int, middle: Int, high: Int) {

    var tmpCnt = 0

    for (i in low..high) helper[i] = array[i]

    var helperLeft = low
    var helperRight = middle + 1
    var current = low

    while (helperLeft <= middle && helperRight <= high) {
        if (helper[helperLeft] <= helper[helperRight]) {
            array[current] = helper[helperLeft]
            helperLeft++
        } else {
            array[current] = helper[helperRight]
            helperRight++
            cnt += middle - helperLeft + 1
        }
        current++
    }

    val remaining = middle - helperLeft
    for (i in 0..remaining) {
        array[current + i] = helper[helperLeft + i]
    }

}
