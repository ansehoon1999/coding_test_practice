import java.util.*

fun main(args: Array<String>) {

    var answer = 0

    val priorities = intArrayOf(2, 1, 3, 2)
    val size = priorities.size

    val location = 2
    val targetNum = priorities[location] // 3

    val deque = ArrayDeque<Int>()
    deque.addAll(priorities.toList())

    val currentList = MutableList<Int>(size) { 0 }
    currentList[location] = 1

    val currentDeque = ArrayDeque<Int>()
    currentDeque.addAll(currentList)

    var count = 0

    while(true) {

        val maxIndex = priorities.indexOf(priorities.maxOf { it })

        for(i in 0 until maxIndex) {
            val first = deque.removeFirst()
            deque.addLast(first)

            val cur = currentDeque.removeFirst()
            currentDeque.addLast(cur)
        }
//        println("deque: " + deque)
//        println("current: " + currentDeque)
        println("${priorities[0]} ${targetNum}")

        if (currentDeque.first == 1) {
            println(count)
            break
        } else {
            deque.removeFirst()
            currentDeque.removeFirst()
            count ++
        }
    }
}