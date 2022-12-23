import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val str = readLine()

    val stk = Stack<Char>()

    val sb  = StringBuilder()
    str.forEach { ch ->
        if (ch.isLetter()) {
            sb.append(ch)
        } else if (ch.equals('(')) {
            stk.push(ch)
        } else if (ch.equals(')')) {
            while (stk.isNotEmpty() && stk.peek() != '(') {
                sb.append(stk.pop())
            }
            if (stk.isNotEmpty() && stk.peek() == '(') {
                stk.pop()
            }
        } else {
            if (ch.equals('+') || ch.equals('-')) {
                while (stk.isNotEmpty() && stk.peek() != '(') {
                    sb.append(stk.pop())
                }
            } else {
                while(stk.isNotEmpty() && stk.peek() != '(' && stk.peek() != '-' && stk.peek() != '+') {
                    sb.append(stk.pop())
                }
            }

            stk.push(ch)
        }
    }
    while (stk.isNotEmpty()) {
        sb.append(stk.pop())
    }

    print(sb.toString())
}

