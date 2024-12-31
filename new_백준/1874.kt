import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = readln().toInt()

    val inputDeque = ArrayDeque<Int>()

    repeat(n) {
        val num = readln().toInt()
        inputDeque.add(num)
    }

    val sb = StringBuilder()

    var tmpNum = 1

    val resultDeque = ArrayDeque<Int>()

    inputDeque.forEach { num ->

        if(tmpNum <= num) {

            while(resultDeque.isEmpty() || tmpNum <= num) {

                resultDeque.add(tmpNum)
                sb.append("+")
                sb.append("\n")
                tmpNum ++
            }

            resultDeque.removeLast()
            sb.append("-")
            sb.append("\n")
        } else {

            if(resultDeque.isNotEmpty() && resultDeque.last() == num) {

                resultDeque.removeLast()
                sb.append("-")
                sb.append("\n")
            }
        }
    }

    if(resultDeque.isEmpty()) {
        println(sb.toString())
    } else {
        println("NO")
    }
}

