

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val arr = readLine().split(' ').toMutableList()
    val list = mutableListOf<Int>()
    for (i in 0 until arr.size) {
        list.add(arr[i].toInt())
    }
    list.sort()

    var num = 0
    var temp  = 0
    for (i in 0 until list.size) {
        temp += list[i].toInt()
        num +=  temp
    }

    println(num)

}