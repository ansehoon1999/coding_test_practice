import java.util.StringTokenizer

var max_height : Long= -1
var min_height : Long = 1
var M : Long = 0
fun main () = with(System.`in`.bufferedReader()) {
    val str1 = StringTokenizer(readLine())
    val N = str1.nextToken().toLong()
    M = str1.nextToken().toLong()

    val list : MutableList<Long> =  mutableListOf()
    val str2 = StringTokenizer(readLine())

    repeat(N.toInt()) {
        val input = str2.nextToken().toLong()
        list.add(input)
        max_height = Math.max(max_height, input)
    }

    binary_search(list)
}

fun binary_search(list: MutableList<Long>) {
    while (min_height <= max_height) {
        var sum : Long = 0
        val mid : Long = (min_height + max_height) / 2

        list.forEach {
            if (it >= mid) {
                sum += it - mid
            }
        }
        if (sum >= M) {
            min_height = mid + 1
        } else {
            max_height = mid -1
        }
//        println("${min_height} ${max_height}")
    }
    println(max_height)
}


