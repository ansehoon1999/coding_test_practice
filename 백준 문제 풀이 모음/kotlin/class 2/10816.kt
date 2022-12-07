import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {

    val hashMap : HashMap<Int, Int> = hashMapOf()

    val n = readLine().toInt()
    val nStr = StringTokenizer(readLine())
    repeat(n) {
        val value = nStr.nextToken().toInt()
        if (hashMap[value] == null) {
            hashMap[value] = 1
        } else {
            hashMap[value] = hashMap[value]!! + 1
        }
    }

    val sb = StringBuilder()
    val m = readLine().toInt()
    val mStr = StringTokenizer(readLine())
    repeat(m) {
        val value = mStr.nextToken().toInt()
        if (hashMap[value] == null) {
            sb.append("${0} ")
        } else {
            sb.append("${hashMap[value]} ")
        }
    }
    println(sb.toString())
}