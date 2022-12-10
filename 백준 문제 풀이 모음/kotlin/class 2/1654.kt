
fun main () = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()

    val n = str[0].toInt()
    val m = str[1].toInt()

    val list = mutableListOf<Long>()
    var max_length : Long = -1
    repeat(n) {
        val input = readLine()
        list.add(input.toLong())
        max_length = Math.max(max_length, input.toLong())
    }

//    var sum = 0
//    list.forEach{
//        sum += (it )
//    }
//
    var start : Long = 1L
    var end : Long= max_length

    while(start <= end) {
        val mid : Long = (start + end) / 2
        var sum : Long = 0
        list.forEach {
            sum += (it / mid)
        }

        if (sum >= m) {
            start = mid + 1
        } else {
            end = mid - 1
        }

//        println("${start} ${end}")

    }

    println(end)

}




//import java.util.*
//
//fun main () = with(System.`in`.bufferedReader()) {
//    val str = StringTokenizer(readLine())
//
//    val k = str.nextToken().toInt()
//    val n = str.nextToken().toInt()
//
//    val list = mutableListOf<Long>()
//    var high :Long = -1
//
//    for (i in 0 until k) {
//        val input = readLine().toLong()
//        list.add(input)
//        high = Math.max(high, input)
//    }
//
//    var start : Long = 1L
//    var end : Long = high
//
//    while (start <= end) {
//        var mid : Long = (start + end) / 2
//        var count :Long = 0L
//
//        for (i in 0 until k) {
//            count += (list.get(i) / mid)
//        }
//
//        if (count >= n) {
//            start = mid + 1
//        } else {
//            end = mid - 1
//        }
//    }
//
//    print(end.toInt())
//}