import java.util.StringTokenizer

fun main () = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val list1 : MutableList<Int> = mutableListOf()

    val tokenN = StringTokenizer(readLine())
    for (i in 0 until N) {
        list1.add(tokenN.nextToken().toInt())
    }

    list1.sort()
//    println(list1)
    val M = readLine().toInt()
    val input = StringTokenizer(readLine())
    for (i in 0 until M) {
        if (isIn(list1, input.nextToken().toLong())) println(1)
        else println(0)
    }


}

fun isIn(list1 : MutableList<Int>, cnt : Long): Boolean {
    var start : Long = 0
    var end : Long = list1.size.toLong()-1

    while (start <= end) {
        val mid = (start + end) / 2

//        println(String.format("{%d} {%d} {%d}", start, end, mid))

        if (list1.get(mid.toInt()) >= cnt) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

//    println(String.format("{%d} {%d}", start, cnt))
    if(start.toInt() >= list1.size){
        start = start -1
    }

    if (list1.get(start.toInt()).toLong() == cnt) {
        return true
    } else {
        return false
    }
}
