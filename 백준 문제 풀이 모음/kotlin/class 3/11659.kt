import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()){
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()

    val list = mutableListOf<Long>()
    var count : Long = 0
    val str2 = StringTokenizer(readLine())
    repeat(n) {
        count += str2.nextToken().toLong()
        list.add(count)
    }
//    println(list)


    val sb = StringBuilder()

    repeat(m) {
        val input = readLine().split(' ')
        val a = input[0].toInt() - 1
        val b = input[1].toInt() - 1

        if (a == 0) {
            sb.append(list[b])
            sb.append('\n')
        } else {
            sb.append(list[b] - list[a-1])
            sb.append('\n')
        }

    }

    println(sb.toString())




}