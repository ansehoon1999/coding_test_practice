import java.util.*





var stack = Stack<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        val str = readLine().split(' ').toList()
        if (str.size == 1) {
//            println(stack)
            if (str[0].equals("pop")) {
                if (stack.empty()) {
                    println(-1)
                } else {
                    println(stack.pop())
                }
            }  else if (str[0].equals("size")) {
                println(stack.size)
            } else if (str[0].equals("empty")) {
                if (stack.empty()) {
                    println(1)
                } else {
                    println(0)
                }
            } else if(str[0].equals("top")) {
                if(stack.empty()) {
                    println(-1)
                } else {
                    println(stack.get(stack.lastIndex))
                }
            }

        } else if (str.size == 2) {
            stack.add(str[1].toInt())
//            println(stack)
        }

    }



}