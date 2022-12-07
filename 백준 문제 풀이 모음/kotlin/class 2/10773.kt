import java.util.*

fun main () = with(System.`in`.bufferedReader()) {
    val stack = Stack<Int>()

    val n = readLine().toInt()
    repeat(n) {
        val input = readLine().toInt()
        if (0 == input) {
            stack.pop()
        } else {
            stack.add(input)
        }
    }

    println(stack.sum())




}