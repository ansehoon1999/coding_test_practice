
import java.util.ArrayDeque

fun main () = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var card = ArrayDeque<Int>()

    for (i in 1..N) {
        card.add(i)
    }

    while (true) {
        if (card.size == 1) {
            println(card.first)
            break
        }

        card.remove()
        card.add(card.remove())
    }

}


