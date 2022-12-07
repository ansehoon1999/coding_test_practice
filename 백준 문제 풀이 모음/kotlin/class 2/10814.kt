import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array<Pair<Int, String>> (n) { Pair(0, "")}

    for (i in 0 until n) {
        val str = StringTokenizer(readLine())

        val age = str.nextToken().toInt()
        val name = str.nextToken().toString()

        arr[i] = Pair(age, name)
    }

    arr.sortBy {
        it.first
    }

    for (i in 0 until n) {
        println("${arr[i].first} ${arr[i].second}")
    }


}