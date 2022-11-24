import java.util.StringTokenizer



fun main () = with(System.`in`.bufferedReader()) {
    val str = StringTokenizer(readLine())

    val k = str.nextToken().toInt()
    val n = str.nextToken().toInt()

    val list = mutableListOf<Long>()
    var high :Long = -1

    for (i in 0 until k) {
        val input = readLine().toLong()
        list.add(input)
        high = Math.max(high, input)
    }

    var start : Long = 1L
    var end : Long = high

    while (start <= end) {
        var mid : Long = (start + end) / 2
        var count :Long = 0L

        for (i in 0 until k) {
            count += (list.get(i) / mid)
        }

        if (count >= n) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    print(end.toInt())
}