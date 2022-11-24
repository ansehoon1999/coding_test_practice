import java.util.StringTokenizer

fun main () = with(System.`in`.bufferedReader()) {
    val tmp = StringTokenizer(readLine())

    val x = tmp.nextToken().toInt()
    val y = tmp.nextToken().toInt()
    val w = tmp.nextToken().toInt()
    val h = tmp.nextToken().toInt()

    var list = mutableListOf<Int>()
    list.add(x)
    list.add(y)
    list.add(w-x)
    list.add(h-y)

    print(list.minByOrNull { it })
}