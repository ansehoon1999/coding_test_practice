package class3

fun main() =with(System.`in`.bufferedReader()) {
    val str = readLine().split('-').toList()


//    print(str)

    var result2 = 0
    var count = 0
    str.forEach {
        count ++
        var result = 0
        val cost = it.split('+').toList()
        cost.forEach {
            result += it.toInt()
        }
        if (count == 1) {
            result2 += result
        } else {
            result2 -= result
        }
    }


    println(result2)


}