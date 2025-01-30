import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val sequence = MutableList<Int>(n + 1) { 0 }
    val index = MutableList<Int>(n + 1) { 0 }

    var st = StringTokenizer(br.readLine())
    val list = mutableListOf<Int>(Integer.MIN_VALUE)

    for (i in 1..n) {
        val num = st.nextToken().toInt()
        sequence[i] = num

        if (list[list.lastIndex] < num) {
            list.add(num)
            index[i] = list.lastIndex
        } else {
            var start = 1
            var end = list.lastIndex

            while (start < end) {
                val median = (start + end) / 2

                if (list[median] < num) {
                    start = median + 1
                } else {
                    end = median
                }
            }

            list[end] = num
            index[i] = end
        }

    }

//    println(index)

    var length = list.lastIndex
    val deque = ArrayDeque<Int>()
    for(i in n downTo 1) {
        if(index[i] == length) {
            deque.add(sequence[i])
            length --
        }
    }

    println(deque.size)
    while(deque.isNotEmpty()) {
        print("${deque.removeLast()} ")
    }

    writer.flush()
    writer.close()
}

