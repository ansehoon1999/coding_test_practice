package class3




fun main() = with(System.`in`.bufferedReader()) {
    val test = readLine().toInt()

    val arr = Array<Pair<Int, Int>> (41) { Pair(0,0)}
    arr[0] = Pair(1, 0)
    arr[1] = Pair(0, 1)

    for (i in 2.. 40) {
        arr[i] = Pair(arr[i-1].first + arr[i-2].first, arr[i-1].second + arr[i-2].second)
    }

    val sb = StringBuilder()
    repeat(test) {
        val input = readLine().toInt()
        sb.append(arr[input].first)
        sb.append(' ')
        sb.append(arr[input].second)
        sb.append('\n')
    }
    print(sb.toString())

}