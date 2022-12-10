import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(' ').toList()

    val arr = Array<Boolean>(1001) {false}
    arr[0] = true
    arr[1] = true

    for (i in 2.. (Math.sqrt(1001.toDouble())).toInt()) {
        if (arr[i]) continue

        for (j in i*i until 1001 step i) {
            arr[j] = true
        }
    }

    var sum = 0
    list.forEach {
        if (!arr[it.toInt()]) sum ++
    }
    print(sum)
}