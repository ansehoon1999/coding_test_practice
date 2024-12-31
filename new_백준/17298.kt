fun main() {

    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }

    val stk = ArrayDeque<Int>()

    val deque = ArrayDeque<Int>()
    deque.add(list.last())
    stk.add(-1)

    for (idx in n - 2 downTo 0) {
        val curValue = list[idx]

        while (deque.isNotEmpty() && curValue >= deque.last()) {

            deque.removeLast()
        }

        if (deque.size == 0) {
            stk.add(-1)
        } else {
            stk.add(deque.last())
        }
        deque.add(curValue)
    }

    val sb = StringBuilder()
    while(stk.isNotEmpty()) {

        sb.append("${stk.last()} ")
        stk.removeLast()
    }

    println(sb.trim().toString())
}

