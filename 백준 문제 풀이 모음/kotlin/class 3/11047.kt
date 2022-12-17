
fun main() = with(System.`in`.bufferedReader()){
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val k = str[1].toInt()

    val list = mutableListOf<Int>()
    repeat(n) {
        val input = readLine().toInt()
        list.add(input)
    }

    var count = 0
    var value = k
    for (i in n-1 downTo 0) {
        if (value / list[i] == 0) continue

        count += value / list[i]
        value = value % list[i]
    }

    println(count)
}
