import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val deque = ArrayDeque<Int>()

    for(i in 1 .. n) {
        deque.add(i)
    }

    while(deque.size != 1) {

        deque.removeFirst()
        val tmp = deque.removeFirst()
        deque.add(tmp)
    }

    println(deque.first())

}














