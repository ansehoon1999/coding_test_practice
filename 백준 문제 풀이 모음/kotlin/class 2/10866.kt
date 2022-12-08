fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()
    repeat(n) {
        val input = readLine().split(' ').toList()
        if (input.size == 2) {
            if (input[0].equals("push_back")) {
                deque.addLast(input[1].toInt())
            } else if (input[0].equals("push_front")) {
                deque.addFirst(input[1].toInt())
            }
        } else {
            if (input[0].equals("size")) {
                sb.append(deque.size)
                sb.append('\n')
            } else if(input[0].equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1)
                } else {
                    sb.append(0)
                }
                sb.append('\n')
            } else if(input[0].equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1)
                } else {
                    sb.append(deque.first())
                }
                sb.append('\n')
            } else if (input[0].equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1)
                } else {
                    sb.append(deque.last())
                }
                sb.append('\n')
            } else if (input[0].equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1)
                } else {
                    sb.append(deque.removeFirst())
                }
                sb.append('\n')
            } else if (input[0].equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1)
                } else {
                    sb.append(deque.removeLast())
                }
                sb.append('\n')
            }
        }
    }
    println(sb.toString())
}