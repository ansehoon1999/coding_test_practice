fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(' ').toList()

    val n = input[0].toInt()
    val k = input[1].toInt()

    var total = 1
    for (i in n downTo((n-k)+1)) {
        total *= i
    }

    var div = 1
    for (i in k downTo 1) {
        div *= i
    }

    println(total / div)



}