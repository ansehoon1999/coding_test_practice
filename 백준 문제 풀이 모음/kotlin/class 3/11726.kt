
fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val list = MutableList<Int>(1001) { 0 }
    list[1] = 1
    list[2] = 2

    for (i in 3..n) {
        list[i] = (list[i - 1] + list[i - 2]) % 10007
    }

    println(list[n])

}