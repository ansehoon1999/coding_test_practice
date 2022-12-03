import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list : MutableList<Boolean> = MutableList(1001) {true}
    list[0] = false
    list[1] = false

    for (i in 2 .. 1000) {
        if (list[i]) {
            for ( j in (2 * i) .. 1000 step i) {
                list[j] = false
            }
        }
    }

//    println(list)
    val str = StringTokenizer(readLine())
    var cnt = 0
    for (i in 0 until n) {
        if(list[str.nextToken().toInt()]) cnt ++
    }
    println(cnt)
}