import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val str = StringTokenizer(readLine())

        val a = str.nextToken().toInt()
        val b = str.nextToken().toInt()
        val c = str.nextToken().toInt()

        if (a==0 && b==0 && c==0) {
            break
        }

        if (a*a + b*b == c*c) {
            println("right")
        } else if( a*a + c*c == b*b) {
            println("right")
        } else if (b*b + c*c == a*a) {
            println("right")
        } else {
            println("wrong")
        }


    }
}