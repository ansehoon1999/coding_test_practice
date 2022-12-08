import java.util.LinkedList
import java.util.Queue


val queue : Queue<Int> = LinkedList()

fun main () = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val input = readLine().split(' ').toList()
        if (input.size == 2) {
            if (input[0].equals("push")) {
                queue.add(input[1].toInt())
            }
        } else {
            if (input[0].equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1)
                } else {
                    sb.append(queue.first())
                    queue.remove(queue.first())
                }
                sb.append('\n')
            } else if(input[0].equals("size")) {
                sb.append(queue.size)
                sb.append('\n')
            } else if(input[0].equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1)
                } else {
                    sb.append(0)
                }
                sb.append('\n')
            } else if (input[0].equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1)
                } else {
                    sb.append(queue.first())
                }
                sb.append('\n')
            } else if(input[0].equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1)
                } else {
                    sb.append(queue.last())
                }
                sb.append('\n')
            }
        }
    }

    println(sb.toString())
}