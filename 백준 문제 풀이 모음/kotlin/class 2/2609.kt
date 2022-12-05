import java.util.*

fun main () = with(System.`in`.bufferedReader()) {
    val str = StringTokenizer(readLine())
    val a = str.nextToken().toInt()
    val b = str.nextToken().toInt()

    var min = Math.min(a, b)
    while(true) {
        if (a % min == 0 && b % min == 0) {
            println(min)
            break
        }
        min --
    }

    var i = 1
    while(true) {
        if (min * i < a  && min *i < b) {
            i ++
            continue
        }

        if ( (min * i) % a == 0 && (min * i)  % b == 0) {
            println(min*i)
            break
        }
        i++
    }
}